/**
 * 
 */
package com.designerpattern.agileppp.extensionObject;

/**
 * @author LiuJian
 *
 */
public class XmlDocument {

	public XmlElement createElement(String name) {
		return new XmlElement(name);
	}

	public XmlText createtextNode(String text) {
		return new XmlText(text);
	}

}
