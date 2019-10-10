package experiment.designerpattern.factoryMethod.simple;

import experiment.designerpattern.factoryMethod.ExportDB;
import experiment.designerpattern.factoryMethod.ExportFileApi;

public class ExportDBOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportDB();
    }
}
