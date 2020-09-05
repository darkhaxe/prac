/**
 * 
 */
package experiment.designerpattern.agileppp.extensionObject;

/**
 * @author LiuJian
 *
 */
public class XmlAssemblyExtension extends XmlPartExtension implements PartExtension {

	private Assembly assembly;

	public XmlAssemblyExtension(Assembly assembly) {
		this.assembly = assembly;
	}

	@Override
	public XmlElement getXmlElement() {
		XmlElement e = newElement("Assembly");
		e.appendChild(newTextElement("PartNumber", assembly.getPartNumber()));
		e.appendChild(newTextElement("Description", assembly.getDescription()));
		XmlElement parts = newElement("Parts");
		for (Part part : assembly.getParts()) {
			XmlPartExtension xpe = (XmlPartExtension) part.getExtension("XML");
			parts.appendChild(xpe.getXmlElement());
		}
		e.appendChild(parts);
		return e;
	}

}
