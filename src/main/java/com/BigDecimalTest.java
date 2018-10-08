package com;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author haze
 * @date created at 2018/8/9 下午2:09
 */
public class BigDecimalTest {

    @Test
    public void dotest() {
        System.out.println(BigDecimal.ZERO.compareTo(new BigDecimal("-2")) < 0);


    }

    @Test
    public void testRound() {
        System.out.println(
                BigDecimal.ONE.divide(new BigDecimal(3),
                4,
                BigDecimal.ROUND_HALF_EVEN)
        );
//        System.out.println(
//                BigDecimal.ONE.divide(new BigDecimal(3))
//        );
    }

}

