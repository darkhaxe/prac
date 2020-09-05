package designerpattern.factoryMethod;

public class ExportTxtFile implements ExportFileApi {
    @Override
    public boolean export(String data) {
        System.out.println("export:" + data);
        return true;
    }
}
