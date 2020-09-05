package designerpattern.agileppp.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface Part {
    String getPartNumber();

    String getDescription();

    void accept(PartVisitor v);
}
