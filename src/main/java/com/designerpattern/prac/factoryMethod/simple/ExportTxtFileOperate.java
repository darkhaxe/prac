package com.designerpattern.prac.factoryMethod.simple;

import com.designerpattern.prac.factoryMethod.ExportFileApi;
import com.designerpattern.prac.factoryMethod.ExportTxtFile;

public class ExportTxtFileOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTxtFile();
    }
}
