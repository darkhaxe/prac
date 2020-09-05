package designerpattern.factoryMethod.paramiterize;

import designerpattern.factoryMethod.ExportFileApi;

public class ExportXml implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.println("导出xml:" + data);
        return true;
    }

}
