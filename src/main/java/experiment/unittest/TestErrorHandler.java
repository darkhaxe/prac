package experiment.unittest;

public class TestErrorHandler {
    public static void main(String[] args) {
        int num = 0;
        switch (num) {
            case 0:
                System.out.println("case=0");
            case 1:
                System.out.println("case=1");
            case 2:
                System.out.println("case=2");
            default:
                System.out.println("--default--");
        }
    }
}
