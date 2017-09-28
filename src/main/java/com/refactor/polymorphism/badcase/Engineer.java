package com.refactor.polymorphism.badcase;

public class Engineer extends Employee {

    Engineer(int type) {
        super(type);
    }

    int getType() {
        return Employee.ENGINEER;
    }


}
