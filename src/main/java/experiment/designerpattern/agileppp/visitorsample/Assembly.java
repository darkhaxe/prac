package experiment.designerpattern.agileppp.visitorsample;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class Assembly implements Part {
    /**
     * 零件列表
     */
    private List<Part> partList = new LinkedList<>();

    private String partNumber;

    private String desc;

    /**
     * @param partNumber  部件编码
     * @param description 描述
     */
    public Assembly(String partNumber, String description) {
        this.partNumber = partNumber;
        desc = description;
    }

    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
        //递归子部件,调用PartVisitor.accept
        partList.forEach((Part part) -> part.accept(visitor));
    }

    public void add(Part part) {
        partList.add(part);
    }

    public List<Part> getParts() {
        return partList;
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
