package com.unittest;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author haze
 * @date created at 2019-08-14 10:34
 */
public class ArgsTest {
    /**
     * command解析
     */
    @Test
    public void testSchema() {
        Schema schema = new Schema("l:bool,d:str,p:int");
//        Assert.assertEquals(schema.getValue(),);
    }

    /**
     * schema解析
     */
    @Test
    public void test() {
        Command command = new Command("-l true -d /usr/local -p 8080");

    }

}
