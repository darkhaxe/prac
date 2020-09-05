package designerpattern.factoryMethod.simple;

import designerpattern.factoryMethod.ExportFileApi;

public abstract class ExportOperate {

    public boolean doExport(String data) {
        ExportFileApi api = this.factoryMethod();
        return api.export(data);
    }

    /**
     * 工厂方法:创建导出文件的工具类
     */
    protected abstract ExportFileApi factoryMethod();
}
