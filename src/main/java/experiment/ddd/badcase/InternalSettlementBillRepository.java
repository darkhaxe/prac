package experiment.ddd.badcase;

/**
 * @author haze
 * @date created at 2018/9/30 下午4:50
 */
public interface InternalSettlementBillRepository {
    InternalSettlementBill queryByBillNumber(String billNumber);
}
