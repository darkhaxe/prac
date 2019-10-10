package experiment.designerpattern.factoryMethod;

public class ExportDB implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.println("导出到数据库:" + data);
        return true;
    }
}
