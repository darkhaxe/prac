package experiment.designerpattern.adapter;

import java.util.List;

public interface LogDBApi {

    List<LogModel> queryAll();

    int update(List<LogModel> list);

    int save(List<LogModel> list);

    int delete(List<LogModel> list);
}
