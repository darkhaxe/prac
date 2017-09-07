package com.designerpattern.factoryMethod.simple;

import com.designerpattern.factoryMethod.ExportDB;
import com.designerpattern.factoryMethod.ExportFileApi;

public class ExportDBOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportDB();
    }
}
