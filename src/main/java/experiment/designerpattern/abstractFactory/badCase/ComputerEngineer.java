package experiment.designerpattern.abstractFactory.badCase;

public class ComputerEngineer {
    private CPUApi cpu = null;

    private MainboardApi mainboard = null;


    private void makeComputer(int cpuType, int boardType) {
        this.cpu = CPUFactory.createCPUApi(cpuType);
        this.mainboard = MainboardFactory.createMainboardApi(boardType);
        //没有维护cpu与主板(组件之间)的关系
        this.cpu.calculate();
        this.mainboard.isntallCPU();
    }
}
