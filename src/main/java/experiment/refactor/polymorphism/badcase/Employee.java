package experiment.refactor.polymorphism.badcase;

/**
 * 使用策略模式取代条件表达式
 */
public class Employee {
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;
    private int _type;
    //临时
    private int _monthlySalary;
    private int _commission;
    private int _bonus;

    Employee(int type) {
        _type = type;
    }

    static Employee create(int type) {
        switch (type) {
            case ENGINEER:
                return new Employee(type);
            case SALESMAN:
                return new Salesman(type);
            case MANAGER:
                return new manager(type);
            default:
                throw new IllegalArgumentException("非法类型码");
        }

    }

    int getType() {
        return _type;
    }

    //8.15节重构
    int payAmount() {
        switch (getType()) {
            case ENGINEER:
                return _monthlySalary;
            case SALESMAN:
                return _monthlySalary + _commission;
            case MANAGER:
                return _monthlySalary + _bonus;
            default:
                throw new IllegalArgumentException("非法类型码");
        }
    }
}
