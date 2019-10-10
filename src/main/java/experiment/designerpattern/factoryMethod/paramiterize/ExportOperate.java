package experiment.designerpattern.factoryMethod.paramiterize;

import experiment.designerpattern.factoryMethod.ExportDB;
import experiment.designerpattern.factoryMethod.ExportFileApi;
import experiment.designerpattern.factoryMethod.ExportTxtFile;

public class ExportOperate {

    public boolean export(int type, String data) {
        ExportFileApi api = factoryMethod(type);
        return api.export(data);
    }

    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;
        if (type == 1) {
            api = new ExportTxtFile();
        } else if (type == 2) {
            api = new ExportDB();
        }
        return api;
    }
}
