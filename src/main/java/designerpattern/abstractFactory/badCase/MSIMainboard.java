package designerpattern.abstractFactory.badCase;

/**
 * 微星主板
 */
public class MSIMainboard implements MainboardApi {
    /**
     *
     */
    private int cpuHoles = 0;

    MSIMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void isntallCPU() {
        System.out.println("MSIMainboard has cpuholes=" + cpuHoles);
    }
}
