package experiment.unittest;

import experiment.PracApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PracApplication.class)
public class Sum {
    public int sum(int a, int b) {
        return a + b;
    }

    @Test
    public void testAOP() {
        System.out.println("----------");
    }

    @Test
    public void testBigDecimal() {
        System.out.println(new BigDecimal("0.03").compareTo(BigDecimal.ZERO) > 0);
        System.out.println(new BigDecimal("-0.03").compareTo(BigDecimal.ZERO) > 0);

//        System.out.println(res(-2147483648,-2147483649));

    }

    private boolean res(int x, int y) {
        return x > y == (0 - x) < (0 - y);
    }
//    @Test
//    public void testToString() {
//       Integer.toString(3);
//        String s = String.valueOf(3);
//    }

    @Test
    public void testLoop() {
        lable:
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("j=" + j);
                if (j == 1) {
                    continue lable;
                }
            }
        }
    }
}
