package experiment.designerpattern.agileppp.visitorsample;

import java.util.HashMap;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class PartCountVisitor implements PartVisitor {
    private int itsPieceCount = 0;
    private HashMap<String, Integer> itsPieceMap = new HashMap<>();

    public void init(PiecePart p) {

    }

    @Override
    public void visit(PiecePart pp) {
        itsPieceCount++;
        String partNumber = pp.getPartNumber();
        int partNumberCount = 0;
        if (itsPieceMap.containsKey(partNumber)) {
            partNumberCount = itsPieceMap.get(partNumber);
        }

        partNumberCount++;
        itsPieceMap.put(partNumber, partNumberCount);
    }

    @Override
    public void visit(Assembly a) {

    }

    public int getPieceCount() {
        return itsPieceCount;
    }

    public int getPartNumberCount() {
        return itsPieceMap.size();
    }

    public int getCountForPart(String partNumber) {
        int partNumberCount = 0;
        if (itsPieceMap.containsKey(partNumber)) {
            partNumberCount = itsPieceMap.get(partNumber);
        }
        return partNumberCount;
    }
}
