package io.amecodelabs.stax.validator;

import java.io.File;

import io.amecodelabs.stax.validator.internalerrorhandler.XMLError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLFatalError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLWarning;

public class DTDValidatorAdapter implements XMLSchemaValidator {

	@Override
	public void setInternalErrorHandler(XMLError xmlError, XMLWarning xmlWarning, XMLFatalError xmlFatalError) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validate(File schemaFile, File xmlFile) throws XMLSchemaException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
