package com.designerpattern.prac.factoryMethod.paramiterize;

import com.designerpattern.prac.factoryMethod.ExportDB;
import com.designerpattern.prac.factoryMethod.ExportFileApi;
import com.designerpattern.prac.factoryMethod.ExportTxtFile;

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
