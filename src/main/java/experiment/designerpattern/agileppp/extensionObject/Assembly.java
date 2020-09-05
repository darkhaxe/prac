/**
 * 
 */
package experiment.designerpattern.agileppp.extensionObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Assembly ,装配集合模式
 * 
 * @author LiuJian
 *
 */
public class Assembly extends Part {

	private List<Part> parts = new ArrayList<Part>();
	private String partNumber;
	private String description;

	public Assembly(String partNumber, String description) {
		this.partNumber = partNumber;
		this.description = description;

		addExtension("CSV", new CsvAssemblyExtension(this));
		addExtension("XML", new XmlAssemblyExtension(this));
	}

	public void add(Part part) {
		parts.add(part);
	}

	@Override
	public String getPartNumber() {
		return partNumber;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public List<Part> getParts() {
		return parts;
	}

}
