package io.amecodelabs.stax.validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import io.amecodelabs.stax.validator.errorhandler.XMLValidationError;
import io.amecodelabs.stax.validator.errorhandler.XMLValidationFatalError;
import io.amecodelabs.stax.validator.errorhandler.XMLValidationWarning;

public class XMLValidator {
	private XMLSchemaValidator xmlSchemaValidator;
	private ErrorHandler errorHandle;
	
	private XMLValidator(XMLSchemaValidator xmlSchemaValidator) {
		this.xmlSchemaValidator = xmlSchemaValidator;
	}
	
	public static XMLValidator newInstance(XMLSchemaValidator xmlSchemaValidator) {
		return new XMLValidator(xmlSchemaValidator);
	}
	
	public void setContextScheme(XMLSchemaValidator xmlSchemaValidator) {
		this.xmlSchemaValidator = xmlSchemaValidator;
	}
	
	public void setErrorHandler(XMLValidationError xmlError, XMLValidationWarning xmlWarning, XMLValidationFatalError xmlFatalError) {
		this.errorHandle = new ErrorHandler() {
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				if(xmlWarning != null)
					xmlWarning.accept(exception);
			}
			@Override
			public void error(SAXParseException exception) throws SAXException {
				if(xmlError != null)
					xmlError.accept(exception);
			}
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				if(xmlFatalError != null)
					xmlFatalError.accept(exception);
			}
		};
	}
	
	public boolean validate(String schemaFile, String xmlFile) {
		this.xmlSchemaValidator.setErrorHandler(this.errorHandle);
		return this.xmlSchemaValidator.validate(schemaFile, xmlFile);
	}

}
