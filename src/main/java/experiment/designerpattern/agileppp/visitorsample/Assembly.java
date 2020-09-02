package experiment.designerpattern.agileppp.visitorsample;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class Assembly implements Part {

    private List<Part> itsParts = new LinkedList<>();
    private String itsPartNumber;
    private String itsDescription;

    /**
     *
     * @param partNumber 部件编码
     * @param description 描述
     */
    public Assembly(String partNumber, String description) {
        itsPartNumber = partNumber;
        itsDescription = description;
    }

    @Override
    public void accept(PartVisitor v) {
        v.visit(this);
        Iterator<Part> i = getParts();
        while (i.hasNext()) {
            Part p = i.next();
            p.accept(v);
        }
    }

    public void add(Part part) {
        itsParts.add(part);
    }

    public Iterator<Part> getParts() {
        return itsParts.iterator();
    }


    @Override
    public String getPartNumber() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
