package io.amecodelabs.stax.test;

import io.amecodelabs.stax.validator.XMLSchemaException;

public abstract class TestSTAX {

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
	}

}
