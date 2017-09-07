package com.designerpattern.abstractFactory.badCase;

public class ComputerEngineer {
    private CPUApi cpu = null;

    private MainboardApi mainboard = null;


    private void makeComputer(int cpuType, int boardType) {
        this.cpu = CPUFactory.createCPUApi(cpuType);
        this.mainboard = MainboardFactory.createMainboardApi(boardType);
        //
        this.cpu.calculate();
        this.mainboard.isntallCPU();
    }
}
