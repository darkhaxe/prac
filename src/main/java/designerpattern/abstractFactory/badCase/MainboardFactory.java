package designerpattern.abstractFactory.badCase;

public class MainboardFactory {
    /**
     *
     */
    public static MainboardApi createMainboardApi(int type) {
        MainboardApi mainboard = null;
        if (type == 1) {
            mainboard = new GAMainboard(1156);
        } else if (type == 2) {
            mainboard = new MSIMainboard(1156);
        }
        return mainboard;
    }
}
