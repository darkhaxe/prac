package com.designerpattern.adapter;

import java.util.List;

public class LogAdapter implements LogDBApi {
    /**
     * 被适配的接口对象:文件存储操作Api
     */
    private LogFileApi adaptee;

    public LogAdapter(LogFileApi adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int save(List<LogModel> list) {
        List<LogModel> logModels = adaptee.readLogFile();
        logModels.addAll(list);
        adaptee.writeLogFile(logModels);
        return logModels.size();
    }

    @Override
    public List<LogModel> queryAll() {
        return adaptee.readLogFile();
    }

    @Override
    public int update(List<LogModel> list) {
        return 0;
    }

    //对文件内容的删除操作
    @Override
    public int delete(List<LogModel> list) {
        List<LogModel> logModels = adaptee.readLogFile();
        //内存中删除相应的logModel
        logModels.remove(list);
        //删除文件重新写入
        adaptee.writeLogFile(logModels);
        return logModels.size();
    }
}
