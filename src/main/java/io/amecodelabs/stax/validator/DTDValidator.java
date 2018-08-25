package io.amecodelabs.stax.validator;

import org.xml.sax.ErrorHandler;

public class DTDValidator implements XMLSchemaValidator {
	
	protected DTDValidator() {
		
	}

	@Override
	public void setErrorHandler(ErrorHandler errorHandler) {

	}

	@Override
	public boolean validate(String schemaContent, String XMLContent) {
		return false;
	}

}
