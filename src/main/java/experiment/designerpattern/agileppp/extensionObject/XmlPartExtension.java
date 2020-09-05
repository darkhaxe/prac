/**
 * 
 */
package experiment.designerpattern.agileppp.extensionObject;

/**
 * @author LiuJian
 *
 */
public abstract class XmlPartExtension implements PartExtension {
	private static XmlDocument document = new XmlDocument();

	public abstract XmlElement getXmlElement();

	protected XmlElement newElement(String name) {
		return document.createElement(name);
	}

	protected XmlElement newTextElement(String name, String text) {
		XmlElement element = document.createElement(name);
		XmlText xmlText = document.createtextNode(text);
		element.appendChild(xmlText);
		return element;
	}
}
