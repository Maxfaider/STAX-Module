package io.amecodelabs.stax.test;

import java.io.File;

import io.amecodelabs.stax.xsltransformation.XMLMapping;
import io.amecodelabs.stax.xsltransformation.XMLMappingBuilder;
import io.amecodelabs.stax.xsltransformation.XMLMappingException;

public class TestXSLTransformation {

	public static void transformXML(String xslPath, String xmlPath) throws XMLMappingException {
		XMLMappingBuilder xmlMappingBuilder = new XMLMappingBuilder(new File(xslPath));
		xmlMappingBuilder.setInternalErrorHandler(
				exception -> System.out.println(exception), 
				exception -> System.out.println(exception), 
				exception -> System.out.println(exception)
		);
		XMLMapping xmlMapping = xmlMappingBuilder.build();
		xmlMapping.transform(new File(xmlPath));
	}
}
