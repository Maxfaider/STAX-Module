package io.amecodelabs.stax.test;

import java.io.File;

import io.amecodelabs.stax.validator.XMLSchema;
import io.amecodelabs.stax.validator.XMLSchemaException;
import io.amecodelabs.stax.validator.XMLSchemaValidator;
import io.amecodelabs.stax.validator.XMLSchemaValidatorFactory;

public class TestSchemaValidador {
	
	public static boolean validateXSD(String pathXSD, String pathXML) throws XMLSchemaException {
		XMLSchemaValidatorFactory factory = XMLSchemaValidatorFactory.newInstance();
		XMLSchemaValidator xmlSchemaValidator = factory.getXMLSchemaValidator(XMLSchema.XSD);
		
		return xmlSchemaValidator.validate(new File(pathXSD), new File(pathXML));
	}
	
	public static boolean validateDTD(String pathDTD, String pathXML) throws XMLSchemaException {
		XMLSchemaValidatorFactory factory = XMLSchemaValidatorFactory.newInstance();
		XMLSchemaValidator xmlSchemaValidator = factory.getXMLSchemaValidator(XMLSchema.DTD);
		
		return xmlSchemaValidator.validate(null, new File(pathXML));
	}

}
