package com.jdk8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author haze
 * @date created at 2018/1/19 上午10:40
 */
@FunctionalInterface
public interface BufferedReaderInterface {
    /**
     *
     * @param b
     * @return
     * @throws IOException
     */
    String process(BufferedReader b) throws IOException;
}
