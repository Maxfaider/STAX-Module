package io.amecodelabs.stax.validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import io.amecodelabs.stax.validator.errorhandler.XMLError;
import io.amecodelabs.stax.validator.errorhandler.XMLFatalError;
import io.amecodelabs.stax.validator.errorhandler.XMLWarning;

public class XMLValidator {
	private static XMLValidator xmlValidator;
	private XMLSchemaValidator xmlSchemaValidator;
	private ErrorHandler errorHandle;
	
	private XMLValidator() {
		
	}
	
	public static XMLValidator getInstance() {
		if(xmlValidator == null)
			return xmlValidator = new XMLValidator();
		return xmlValidator;
	}
	
	public void setContextSchema(XMLSchemaValidator xmlSchemaValidator) {
		this.xmlSchemaValidator = xmlSchemaValidator;
	}
	
	public void setErrorHandler(XMLError xmlError, XMLWarning xmlWarning, XMLFatalError xmlFatalError) {
		this.errorHandle = new ErrorHandler() {
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				if(xmlError != null)
					xmlError.accept(exception);
			}
			@Override
			public void error(SAXParseException exception) throws SAXException {
				if(xmlWarning != null)
					xmlWarning.accept(exception);
			}
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				if(xmlFatalError != null)
					xmlFatalError.accept(exception);
			}
		};
	}
	
	public boolean validate(String schemaContent, String xmlContent) {
		this.xmlSchemaValidator.setErrorHandler(this.errorHandle);
		return this.xmlSchemaValidator.validate(schemaContent, xmlContent);
	}

}
