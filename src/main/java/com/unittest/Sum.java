package com.unittest;

import com.designerpattern.PracApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
