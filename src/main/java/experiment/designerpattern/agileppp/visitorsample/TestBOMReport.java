package experiment.designerpattern.agileppp.visitorsample;

import junit.framework.TestCase;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class TestBOMReport extends TestCase {
    public TestBOMReport(String name) {
        super(name);
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
        //keypad需要15个按钮
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

    public void testCalcTotalCost() {
        setUpReportDatabase();
        //计算电话所有零部件的总成本
        CalcTotalCostVisitor v = new CalcTotalCostVisitor();
        cellphone.accept(v);
        assertEquals(81.27, v.getTotalCost(), .001);
    }

    public void testPartCount() {
        setUpReportDatabase();
        PieceCountVisitor v = new PieceCountVisitor();
        cellphone.accept(v);
        assertEquals(36, v.pieceTotalCount());
        assertEquals(8, v.pieceKindCount());
        assertEquals("DS-1428", 1, v.countOfPiecePart("DS-1428"));
        assertEquals("SP-92", 1, v.countOfPiecePart("SP-92"));
    }

    // ----------------------------------------------测试不通过,先忽略--------------------------------------------------------------
    private PiecePart piecePart;
    private PiecePart piecePart2;
    private Assembly assembly;

    /**
     *
     */
    @Override
    public void setUp() {
        piecePart = new PiecePart("997624", "MyPart", 3.20);
        piecePart2 = new PiecePart("7734", "Hell", 666);
        assembly = new Assembly("5879", "MyAssembly");
    }

    /**
     *
     */
    public void testCreatePart() {
        assertEquals("997624", piecePart.getPartNumber());
        assertEquals("7734", "Hell", 666);
        assembly = new Assembly("5879", "MyAssembly");
    }

    /**
     *
     */
    public void testCreateAssembly() {
        assertEquals("5879", assembly.getPartNumber());
        assertEquals("MyAssembly", assembly.getDescription());
    }

    public void testAssembly() {
        assembly.add(piecePart);
        assembly.add(piecePart2);

        assertEquals(assembly.getParts().get(0), piecePart);
        assertEquals(assembly.getParts().get(1), piecePart2);
        assert (assembly.getParts().size() == 2);
    }

    public void testAssemblyOfAssemblies() {
        Assembly subAssembly = new Assembly("1324", "SubAssembly");
        subAssembly.add(piecePart);
        assembly.add(subAssembly);

        assertEquals(subAssembly, assembly.getParts().get(0));
    }


    /**
     *
     */
    private boolean p1Found = false;
    private boolean p2Found = false;
    private boolean aFound = false;

    public void testVisitorCoverage() {
        assembly.add(piecePart);
        assembly.add(piecePart2);
        assembly.accept(new PartVisitor() {
            @Override
            public void visit(PiecePart p) {
                if (p == piecePart) {
                    p1Found = true;
                }
            }

            @Override
            public void visit(Assembly assy) {
                if (assy == assembly) {
                    aFound = true;
                }
            }
        });
        assert (p1Found);
        assert (p2Found);
        assert (aFound);
    }


}
