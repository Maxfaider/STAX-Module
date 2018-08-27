package io.amecodelabs.stax.validator;

import java.io.File;

import io.amecodelabs.stax.validator.internalerrorhandler.XMLError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLFatalError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLWarning;

public interface XMLSchemaValidator {
	void setInternalErrorHandler(XMLError xmlError, XMLWarning xmlWarning, XMLFatalError xmlFatalError);
	boolean validate(File schemaFile, File xmlFile) throws XMLSchemaException;
}
