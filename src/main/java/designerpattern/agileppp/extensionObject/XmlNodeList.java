/**
 * 
 */
package designerpattern.agileppp.extensionObject;

import java.util.ArrayList;

/**
 * @author LiuJian
 *
 */
public class XmlNodeList extends ArrayList<XmlElement> {
	private static final long serialVersionUID = -2953520437322235548L;

	public XmlElement getItem(int i) {
		return this.get(i);
	}

}
