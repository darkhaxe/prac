package com.designerpattern.prac.factoryMethod.paramiterize;

import com.designerpattern.prac.factoryMethod.ExportFileApi;

/**
 * 拓展父类方法,添加XML导出的方法,无需修改原类
 */
public class ExportOperateV2 extends ExportOperate {
    /**
     * 重写父类方法
     *
     * @param type
     * @return
     */
    @Override
    protected ExportFileApi factoryMethod(int type) {
        ExportFileApi api = null;
        if (type == 3) {
            api = new ExportXml();
        } else {
            super.factoryMethod(type);
        }
        return api;
    }
}
