package designerpattern.agileppp.visitorsample;

import java.util.HashMap;

/**
 * Created by simjunbo on 2018-04-19.
 */
public class PieceCountVisitor implements PartVisitor {
    /**
     * 零件总数
     */
    private int pieceTotalCount = 0;

    private HashMap<String/*PartNumber*/, Integer/*统计数*/> piecePartSummaryMap = new HashMap<>();


    @Override
    public void visit(PiecePart piecePart) {

        pieceTotalCount++;

        String partNumber = piecePart.getPartNumber();
        int partNumberCount = 0;
        if (piecePartSummaryMap.containsKey(partNumber)) {
            partNumberCount = piecePartSummaryMap.get(partNumber);
        }
        partNumberCount++;
        //该种类的partNumber的汇总数+1
        piecePartSummaryMap.put(partNumber, partNumberCount);
    }

    @Override
    public void visit(Assembly a) {

    }

    /**
     * 零件总数
     */
    public int pieceTotalCount() {
        return pieceTotalCount;
    }

    /**
     * 计算不重复的零件种类数
     */
    public int pieceKindCount() {
        return piecePartSummaryMap.size();
    }

    /**
     * 查询指定partNumber的零件数
     */
    public int countOfPiecePart(String partNumber) {
        int partNumberCount = 0;
        if (piecePartSummaryMap.containsKey(partNumber)) {
            partNumberCount = piecePartSummaryMap.get(partNumber);
        }
        return partNumberCount;
    }
}
