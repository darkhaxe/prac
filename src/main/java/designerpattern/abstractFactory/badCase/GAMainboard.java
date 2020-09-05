package designerpattern.abstractFactory.badCase;

/**
 * 技嘉主板
 */
public class GAMainboard implements MainboardApi {
    /**
     * 插槽数
     */
    private int cpuHoles = 0;

    GAMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void isntallCPU() {
        System.out.println("GAmainboard has cpuholes=" + cpuHoles);
    }
}
