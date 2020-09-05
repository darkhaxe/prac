/**
 * 
 */
package experiment.designerpattern.agileppp.extensionObject;

/**
 * @author LiuJian
 *
 */
public class CsvAssemblyExtension implements CsvPartExtension {
	private Assembly assembly;

	public CsvAssemblyExtension(Assembly assembly) {
		this.assembly = assembly;
	}

	public String getCsvText() {
		StringBuilder builder = new StringBuilder("Assembly,");
		builder.append(assembly.getPartNumber());
		builder.append(",");
		builder.append(assembly.getDescription());

		for (Part part : assembly.getParts()) {
			CsvPartExtension cpe = (CsvPartExtension) part.getExtension("CSV");
			builder.append(",{");
			builder.append(cpe.getCsvText());
			builder.append("}");
		}
		return builder.toString();
	}

}
