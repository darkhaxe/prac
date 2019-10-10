package experiment.ddd.badcase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author haze
 * @date created at 2018/9/30 下午4:54
 */
@RestController
@RequestMapping("/bill-review")
public class BillReviewController {
    @Resource
    private BillReviewService billReviewService;

//    @PostMapping("/export-template")
//    public void exportBillReviewByTemplate(HttpServletResponse response,
//                                           @RequestBody ExportBillReviewRequest request) {
//        billReviewService.exportBillReviewByTemplate(response, request.getBillNumber(), request.getTemplateName());
//    }
}