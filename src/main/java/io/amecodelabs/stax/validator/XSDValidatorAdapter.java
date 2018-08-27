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

public class XSDValidatorAdapter extends XMLSchemaValidator {
	
	XSDValidatorAdapter() {
		
	}
	
	@Override
	public boolean validate(File schemaFile, File xmlFile) throws XMLSchemaException {
		this.is_valid_document_xml(true);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
			Schema schema = schemaFactory.newSchema(new StreamSource(schemaFile));
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new ErrorHandler() {
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					if (getXmlWarning() != null)
						getXmlWarning().accept(exception);
				}
				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					if (getXmlFatalError() != null)
						getXmlFatalError().accept(exception);
					markDocumentError();
				}
				@Override
				public void error(SAXParseException exception) throws SAXException {
					if (getXmlError() != null)
						getXmlError().accept(exception);
					markDocumentError();
				}
			});
			validator.validate(new StreamSource(xmlFile));
		} catch (SAXException | IOException  e) {
			throw new XMLSchemaException(e.getMessage());
		} 
		return this.is_valid_document_xml();
	}
	
}
