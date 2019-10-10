package experiment.refactor.polymorphism.badcase;

public class Engineer extends Employee {

    Engineer(int type) {
        super(type);
    }

    int getType() {
        return ENGINEER;
    }


}
