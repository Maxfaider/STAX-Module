package io.amecodelabs.stax.validator;

import org.xml.sax.ErrorHandler;

public interface XMLSchemaValidator {
	void setErrorHandler(ErrorHandler errorHandler);
	boolean validate(String schemaFile, String XMLFile);
}
