/**
 * 
 */
package com.designerpattern.agileppp.extensionObject;

/**
 * @author LiuJian
 *
 */
public class XmlPiecePartExtension extends XmlPartExtension {
	private PiecePart piecePart;

	public XmlPiecePartExtension(PiecePart part) {
		this.piecePart = part;
	}

	@Override
	public XmlElement getXmlElement() {
		XmlElement e = new XmlElement("PiecePart");
		e.appendChild(newTextElement("PartNumber", piecePart.getPartNumber()));
		e.appendChild(newTextElement("Description", piecePart.getDescription()));
		e.appendChild(newTextElement("Cost", Double.toString(piecePart.getCost())));
		return e;
	}
}
