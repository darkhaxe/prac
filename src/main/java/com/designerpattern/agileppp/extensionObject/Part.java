package com.designerpattern.agileppp.extensionObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuJian
 *
 */
public abstract class Part {
	Map<String, PartExtension> extensions = new HashMap<String, PartExtension>();

	public abstract String getPartNumber();

	public abstract String getDescription();

	public void addExtension(String extensionType, PartExtension extension) {
		extensions.put(extensionType, extension);
	}

	public PartExtension getExtension(String extensionType) {
		PartExtension pe = extensions.get(extensionType);
		if (pe == null) {
			return BadPartExtension.instance();
		}
		return pe;
	}
}
