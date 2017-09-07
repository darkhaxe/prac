package com.designerpattern.factoryMethod.simple;

import com.designerpattern.factoryMethod.ExportFileApi;
import com.designerpattern.factoryMethod.ExportTxtFile;

public class ExportTxtFileOperate extends ExportOperate {
    @Override
    protected ExportFileApi factoryMethod() {
        return new ExportTxtFile();
    }
}
