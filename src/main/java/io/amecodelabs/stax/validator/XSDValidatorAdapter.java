package io.amecodelabs.stax.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import io.amecodelabs.stax.validator.internalerrorhandler.XMLError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLFatalError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLWarning;

public class XSDValidatorAdapter implements XMLSchemaValidator {
	private boolean is_valid_document_xml;
	private XMLError xmlError;
	private XMLWarning xmlWarning; 
	private XMLFatalError xmlFatalError;
	
	XSDValidatorAdapter() {
		
	}
	
	@Override
	public void setInternalErrorHandler(XMLError xmlError, XMLWarning xmlWarning, XMLFatalError xmlFatalError) {
		this.xmlError = xmlError;
		this.xmlWarning = xmlWarning;
		this.xmlFatalError = xmlFatalError;
	}
	
	private void changedState() {
		if(this.is_valid_document_xml != false)
			this.is_valid_document_xml = false;
	}

	@Override
	public boolean validate(File schemaFile, File xmlFile) throws XMLSchemaException {
		this.is_valid_document_xml = true;
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
			Schema schema = schemaFactory.newSchema(new StreamSource(schemaFile));
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new ErrorHandler() {
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					if (xmlWarning != null)
						xmlWarning.accept(exception);
				}
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					if (xmlFatalError != null)
						xmlFatalError.accept(exception);
					changedState();
				}
				@Override
				public void error(SAXParseException exception) throws SAXException {
					if (xmlError != null)
						xmlError.accept(exception);
					changedState();
				}
			});
			validator.validate(new StreamSource(xmlFile));
		} catch (SAXException | IOException e) {
			throw new XMLSchemaException(e.getMessage());
		}
		return this.is_valid_document_xml;
	}
	
}
