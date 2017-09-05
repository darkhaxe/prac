package com.designerpattern.prac.factoryMethod;

import com.designerpattern.prac.factoryMethod.simple.ExportDBOperate;

public class Client {
    public static void main(String[] args) {
        ExportDBOperate op = new ExportDBOperate();
        op.doExport("factory test~~~");
    }
}
