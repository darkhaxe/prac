package com.unittest;

import com.PracApplication;
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
    }
}
