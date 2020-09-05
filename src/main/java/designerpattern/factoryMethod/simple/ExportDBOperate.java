package designerpattern.factoryMethod.simple;

import designerpattern.factoryMethod.ExportDB;
import designerpattern.factoryMethod.ExportFileApi;

public class ExportDBOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportDB();
    }
}
