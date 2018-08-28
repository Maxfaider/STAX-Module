package io.amecodelabs.stax.test;

import io.amecodelabs.stax.validator.XMLSchemaException;
import io.amecodelabs.stax.xsltransformation.XMLMappingException;

public class TestSTAX {
	
	public static void main(String[] args) {
		//Validate XSD
		try {
			boolean resultXSD = TestSchemaValidador.validateXSD(
					ClassLoader.getSystemResource("howto.xsd").getFile(), 
					ClassLoader.getSystemResource("howto.xml").getFile()
			);
			System.out.println(resultXSD);
		} catch (XMLSchemaException e) {
			System.out.println(e.getMessage());
		}
		
		//Validate DTD
		try {
			boolean resultDTD = TestSchemaValidador.validateDTD(
					null, 
					ClassLoader.getSystemResource("howto_dtd.xml").getFile()
			);
			System.out.println(resultDTD);
		} catch (XMLSchemaException e) {
			System.out.println(e.getMessage());
		}
		
		// Mapping XML to XMI/
		try {
			TestXSLTransformation.transformXML(
					ClassLoader.getSystemResource("estructura.xsl").getFile(),
					ClassLoader.getSystemResource("estructura.xml").getFile()
			);
		} catch (XMLMappingException e) {
			e.printStackTrace();
		}
	}
}
