package experiment.designerpattern.factoryMethod.simple;

import experiment.designerpattern.factoryMethod.ExportFileApi;
import experiment.designerpattern.factoryMethod.ExportTxtFile;

public class ExportTxtFileOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTxtFile();
    }
}
