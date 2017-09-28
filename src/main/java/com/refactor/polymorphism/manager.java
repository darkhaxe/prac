package com.refactor.polymorphism;

import com.refactor.polymorphism.badcase.Employee;

public class manager extends EmployeeType {

    @Override
    int getType() {
        return 0;
    }
}
