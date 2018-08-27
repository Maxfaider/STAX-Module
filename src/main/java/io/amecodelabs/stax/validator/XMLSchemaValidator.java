package io.amecodelabs.stax.validator;

import java.io.File;

import io.amecodelabs.stax.validator.internalerrorhandler.XMLError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLFatalError;
import io.amecodelabs.stax.validator.internalerrorhandler.XMLWarning;

public abstract class XMLSchemaValidator {
	private boolean is_valid_document_xml;
	private XMLError xmlError;
	private XMLWarning xmlWarning; 
	private XMLFatalError xmlFatalError;
	
	public void setInternalErrorHandler(XMLError xmlError, XMLWarning xmlWarning, XMLFatalError xmlFatalError) {
		this.xmlError = xmlError;
		this.xmlWarning = xmlWarning;
		this.xmlFatalError = xmlFatalError;
	}
	
	protected void markDocumentError() {
		if(this.is_valid_document_xml != false)
			this.is_valid_document_xml = false;
	}
	
	public abstract boolean validate(File schemaFile, File xmlFile) throws XMLSchemaException;

	protected boolean is_valid_document_xml() {
		return is_valid_document_xml;
	}

	protected void is_valid_document_xml(boolean is_valid_document_xml) {
		this.is_valid_document_xml = is_valid_document_xml;
	}

	protected XMLError getXmlError() {
		return xmlError;
	}

	protected XMLWarning getXmlWarning() {
		return xmlWarning;
	}

	protected XMLFatalError getXmlFatalError() {
		return xmlFatalError;
	}
	
}
