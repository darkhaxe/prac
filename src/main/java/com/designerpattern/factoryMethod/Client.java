package com.designerpattern.factoryMethod;

import com.designerpattern.factoryMethod.simple.ExportDBOperate;

public class Client {
    public static void main(String[] args) {
        ExportDBOperate op = new ExportDBOperate();
        op.doExport("factory test~~~");
    }
}
