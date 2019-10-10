/**
 *
 */
package com.designerpattern.agileppp.extensionObject;

/**
 *
 * @author LiuJian
 */
public class BadPartExtension implements PartExtension {
    private BadPartExtension() {

    }

    private static class ExtensionHolder {
        private static PartExtension extension = new BadPartExtension();
    }

    public static PartExtension instance() {
        return ExtensionHolder.extension;
    }
}
