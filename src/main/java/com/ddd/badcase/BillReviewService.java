package com.ddd.badcase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author haze
 * @date created at 2018/9/30 下午4:53
 */
@Service
public class BillReviewService {
//    private static final String DEFAULT_REPLACE_PATTERN = "@replace";
//    private static final int DEFAULT_SHEET_INDEX = 0;
//
//    @Value("${file-path.bill-templates-dir}")
//    private String billTemplatesDirPath;
//
//    @Resource
//    private PoiUtils poiUtils;
//    @Resource
//    private FileDownloader fileDownloader;
//    @Resource
//    private InternalSettlementBillService internalSettlementBillService;
//    @Resource
//    private ExportBillReviewConfiguration configuration;
//    public void exportBillReviewByTemplate(HttpServletResponse response, String billNumber, String templateName) {
//        try {
//            String className = fetchClassNameFromConfigBy(templateName);
//            List<TemplateReplacement> replacements = templateReplacementsBy(billNumber, className);
//
//            HSSFWorkbook workbook = poiUtils.getHssfWorkbook(billTemplatesDirPath + templateName);
//            poiUtils.fillCells(workbook, DEFAULT_SHEET_INDEX, DEFAULT_REPLACE_PATTERN, replacements);
//
//            fileDownloader.downloadHSSFFile(response, workbook, templateName);
//        } catch (Exception e) {
//            logger.error("Export bill review by template failed, templateName: {}", templateName);
//            e.printStackTrace();
//        }
//    }
//
//    private List<TemplateReplacement> templateReplacementsBy(String billNumber, String className) {
//        switch (className) {
//            case "InternalSettlementBill":
//                return internalSettlementBillService.queryAndComposeTemplateReplacementsBy(billNumber);
//            default:
//                return null;
//        }
//    }
//
//    private String fetchClassNameFromConfigBy(String templateName) throws Exception {
//        for (ExportBillReviewConfiguration.Item item : configuration.getItems()) {
//            if (item.getTemplateName().equals(templateName)) {
//                return item.getClassName();
//            }
//        }
//        throw new Exception("can not found className by templateName in configuration file");
//    }

}
