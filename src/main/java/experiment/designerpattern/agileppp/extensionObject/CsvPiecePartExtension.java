/**
 * 
 */
package experiment.designerpattern.agileppp.extensionObject;

/**
 * @author LiuJian
 *
 */
public class CsvPiecePartExtension implements CsvPartExtension {
	private PiecePart piecePart;

	public CsvPiecePartExtension(PiecePart part) {
		this.piecePart = part;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.design.patterns.demos.martin.agile.extensionObject.
	 * CsvPartExtension#getCsvText()
	 */
	@Override
	public String getCsvText() {
		StringBuilder b = new StringBuilder("PiecePart,");
		b.append(piecePart.getPartNumber());
		b.append(",");
		b.append(piecePart.getDescription());
		b.append(",");
		b.append(piecePart.getCost());
		return b.toString();
	}
}
