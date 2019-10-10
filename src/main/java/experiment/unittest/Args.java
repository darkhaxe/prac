package com.unittest;


/**
 * @author haze
 * @date created at 2019-08-14 10:42
 */
public class Args {
    private Schema schema;
    private Command command;

    public Args(Schema schema, Command command) {
        this.schema = schema;
        this.command = command;
    }
}
