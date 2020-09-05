package designerpattern.agileppp.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface PartVisitor {
    void visit(PiecePart pp);

    void visit(Assembly a);
}
