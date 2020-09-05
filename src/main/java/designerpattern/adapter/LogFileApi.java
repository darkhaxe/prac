package designerpattern.adapter;

import java.util.List;

public interface LogFileApi {

    List<LogModel> readLogFile();

    void writeLogFile(List<LogModel> logs);

}
