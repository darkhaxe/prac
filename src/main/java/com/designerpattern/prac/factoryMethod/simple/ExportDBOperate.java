package com.designerpattern.prac.factoryMethod.simple;

import com.designerpattern.prac.factoryMethod.ExportDB;
import com.designerpattern.prac.factoryMethod.ExportFileApi;

public class ExportDBOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportDB();
    }
}
