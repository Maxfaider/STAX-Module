package io.amecodelabs.stax.validator;

import org.xml.sax.ErrorHandler;

public class XSDValidator implements XMLSchemaValidator {
	
	protected XSDValidator() {
		
	}

	@Override
	public void setErrorHandler(ErrorHandler errorHandler) {
	}

	@Override
	public boolean validate(String schemaContent, String XMLContent) {
		return false;
	}

}
