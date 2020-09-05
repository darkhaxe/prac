package designerpattern.agileppp.extensionObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuJian
 *
 */
public class XmlElement {
	private String name;

	List<XmlElement> elements = new ArrayList<XmlElement>();

	public XmlElement(String name) {
		this.name = name;
	}

	public void appendChild(XmlElement xmlText) {
		elements.add(xmlText);
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 * 
	 */
	public XmlNodeList getElementsByTagName(String childName) {
		XmlNodeList list = new XmlNodeList();
		for (XmlElement e : elements) {
			if (e.getName().equals(childName)) {
				list.add(e);
			}
		}
		return list;
	}

	/**
	 * 模拟叶子节点的元素的TextNode的Text,不符合标准的XmlElement规约
	 * 
	 * @return 返回TextNode的Text
	 */
	public String getInnerText() {
		StringBuilder b = new StringBuilder();
		for (XmlElement e : elements) {
			b.append(e.toString());
		}
		return b.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		setEnclosure(builder);
		return builder.toString();
	}

	private void setEnclosure(StringBuilder builder) {
		builder.append("<" + name + ">");
		toChildString(builder);
		builder.append("</" + name + ">");
	}

	private void toChildString(final StringBuilder builder) {
		for (XmlElement e : elements) {
			builder.append(e.toString());
		}
	}

	public XmlNodeList getChildNodes() {
		XmlNodeList list = new XmlNodeList();
		for (XmlElement e : elements) {
			list.add(e);
		}
		return list;
	}
}
