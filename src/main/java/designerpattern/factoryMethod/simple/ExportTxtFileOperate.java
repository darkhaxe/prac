package designerpattern.factoryMethod.simple;

import designerpattern.factoryMethod.ExportFileApi;
import designerpattern.factoryMethod.ExportTxtFile;

public class ExportTxtFileOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTxtFile();
    }
}
