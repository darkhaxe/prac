package com.designerpattern.abstractFactory.badCase;

public class IntelCPU implements CPUApi {
    private int pins = 0;

    public IntelCPU(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        System.out.println("intel CPU has pins = " + pins);
    }
}
