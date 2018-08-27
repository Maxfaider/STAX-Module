package io.amecodelabs.stax.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class DTDValidatorAdapter extends XMLSchemaValidator {
	
	DTDValidatorAdapter() {
		
	}

	@Override
	public boolean validate(File schemaFile, File xmlFile) throws XMLSchemaException {
		this.is_valid_document_xml(true);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		try {
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(new ErrorHandler() {
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
			reader.parse(new InputSource(xmlFile.getAbsolutePath()));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new XMLSchemaException(e.getMessage());
		} 
		return this.is_valid_document_xml();
	}
	
}
