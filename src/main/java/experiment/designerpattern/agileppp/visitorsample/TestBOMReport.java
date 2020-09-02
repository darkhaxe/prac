package experiment.designerpattern.agileppp.visitorsample;

import junit.framework.TestCase;

import java.util.Iterator;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class TestBOMReport extends TestCase {
    public TestBOMReport(String name) {
        super(name);
    }

    private PiecePart p1;
    private PiecePart p2;
    private Assembly a;

    @Override
    public void setUp() {
        p1 = new PiecePart("997624", "MyPart", 3.20);
        p2 = new PiecePart("7734", "Hell", 666);
        a = new Assembly("5879", "MyAssembly");
    }

    public void testCreatePart() {
        assertEquals("997624", p1.getPartNumber());
        assertEquals("7734", "Hell", 666);
        a = new Assembly("5879", "MyAssembly");
    }

    public void testCreateAssembly() {
        assertEquals("5879", a.getPartNumber());
        assertEquals("MyAssembly", a.getDescription());
    }

    public void testAssembly() {
        a.add(p1);
        a.add(p2);

        Iterator i = a.getParts();
        PiecePart p = (PiecePart) i.next();
        assertEquals(p, p1);
        p = (PiecePart) i.next();
        assertEquals(p, p2);
        assert (i.hasNext() == false);
    }

    public void testAssemblyOfAssemblies() {
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(p1);
        a.add(subAssembly);

        Iterator i = a.getParts();
        assertEquals(subAssembly, i.next());
    }

    private boolean p1Found = false;
    private boolean p2Found = false;
    private boolean aFound = false;

    public void testVisitorCoverage() {
        a.add(p1);
        a.add(p2);
        a.accept(new PartVisitor() {
            @Override
            public void visit(PiecePart p) {
                if (p == p1) {
                    p1Found = true;
                }
            }

            @Override
            public void visit(Assembly assy) {
                if (assy == a) {
                    aFound = true;
                }
            }
        });
        assert (p1Found);
        assert (p2Found);
        assert (aFound);
    }

    private Assembly cellphone;

    void setUpReportDatabase() {
        //一部电话
        cellphone = new Assembly("CP-7734", "Cell Phone");
        //零件
        PiecePart display = new PiecePart("DS-1428", "LCD Display", 14.37);
        PiecePart speaker = new PiecePart("SP-92", "Speaker", 3.50);
        PiecePart microPhone = new PiecePart("MC-28", "Micorophone", 5.30);
        PiecePart cellRadio = new PiecePart("Cr-56", "Cell Radio", 30);
        PiecePart frontCover = new PiecePart("Fc-77", "Front Cover", 1.4);
        PiecePart backCover = new PiecePart("RC-77", "RearCover", 1.2);
        //子部件
        Assembly keypad = new Assembly("KP-62", "Keypad");
        Assembly button = new Assembly("B52", "Button");
        PiecePart buttonCover = new PiecePart("CV-15", "Cover", .5);
        PiecePart buttonContact = new PiecePart("CN-2", "Contact", 1.2);

        button.add(buttonCover);
        button.add(buttonContact);

        for (int i = 0; i < 15; i++) {
            keypad.add(button);
        }

        cellphone.add(display);
        cellphone.add(speaker);
        cellphone.add(microPhone);

        cellphone.add(cellRadio);
        cellphone.add(frontCover);
        cellphone.add(backCover);
        cellphone.add(keypad);
    }

    public void testExplodedCost() {
        setUpReportDatabase();
        //计算零部件的总成本
        ExplodedCostVisitor v = new ExplodedCostVisitor();
        cellphone.accept(v);
        assertEquals(81.27, v.coast(), .001);
    }

    public void testPartCount() {
        setUpReportDatabase();
        PartCountVisitor v = new PartCountVisitor();
        cellphone.accept(v);
        assertEquals(36, v.getPieceCount());
        assertEquals(8, v.getPartNumberCount());
        assertEquals("DS-1428", 1, v.getCountForPart("DS-1428"));
        assertEquals("SP-92", 1, v.getCountForPart("SP-92"));
        // 생략
    }
}
