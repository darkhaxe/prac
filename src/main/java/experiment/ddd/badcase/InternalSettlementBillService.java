package experiment.ddd.badcase;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haze
 * @date created at 2018/9/30 下午4:52
 */

@Service
public class InternalSettlementBillService extends BaseBillReviewExportTemplate<InternalSettlementBill> {
    @Resource
    private InternalSettlementBillRepository internalSettlementBillRepository;

    @Override
    protected InternalSettlementBill queryFilledDataBy(String billNumber) {
        return internalSettlementBillRepository.queryByBillNumber(billNumber);
    }

    @Override
    protected List<TemplateReplacement> composeTemplateReplacements(InternalSettlementBill t) {
        List<TemplateReplacement> templateReplacements = new ArrayList<>();
        templateReplacements.add(new TemplateReplacement(0, 0, t.getNewAndOldBillNumber()));
        templateReplacements.add(new TemplateReplacement(1, 0, t.getFlightIdentity()));
        templateReplacements.add(new TemplateReplacement(1, 2, t.getFlightRoute()));
        return templateReplacements;
    }
}