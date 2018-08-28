package io.amecodelabs.stax.xsltransformation;

import java.io.File;

public interface XMLMapping {
	void transform(File xmlFile) throws XMLMappingException;
}
