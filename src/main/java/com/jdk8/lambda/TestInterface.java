package com.jdk8.lambda;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author haze
 * @date created at 2018/1/19 上午10:42
 */
public class TestInterface {
    /**
     * 1 读取处理文件,仅可处理一行
     */
    private static String processFile() throws Exception {
        try (BufferedReader br = new BufferedReader(
                new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    /**
     * 2
     *
     * @param p 函数式接口 传递行为
     * @return
     * @throws IOException
     */
    private static String processFile(BufferedReaderInterface p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    /**
     * 3
     * 使用函数式接口,传递行为(函数)
     * 实现类似动态语言的方法传递
     */
    @Test
    public void testMain() throws Exception {
        // 读一行
        processFile((BufferedReader br) -> br.readLine());
        // 读两行
        processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

}
