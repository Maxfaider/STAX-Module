package io.amecodelabs.stax.xsltransformation;

import java.io.File;
import java.util.Hashtable;
import java.util.Properties;

import io.amecodelabs.stax.xsltransformation.internalerrorhandler.XMLTransformationError;
import io.amecodelabs.stax.xsltransformation.internalerrorhandler.XMLTransformationFatalError;
import io.amecodelabs.stax.xsltransformation.internalerrorhandler.XMLTransformationWarning;

public class XMLMappingBuilder {
	private String xmlFileDestination;
	private File xslFile;
	private Hashtable<String, String> propertiesFromMemory;
	private Properties propertiesFromFile;
	private XMLTransformationError xmlTransformationError; 
	private XMLTransformationWarning xmlTransformationWarning; 
	private XMLTransformationFatalError xmlTransformationFatalError;
	
	public XMLMappingBuilder(File xslFile) {
		this.xslFile = xslFile;
	}
	
	public XMLMappingBuilder setInternalErrorHandler(XMLTransformationError xmlTransformationError, 
			XMLTransformationWarning xmlTransformationWarning, XMLTransformationFatalError xmlTransformationFatalError) {
		this.xmlTransformationError = xmlTransformationError;
		this.xmlTransformationWarning = xmlTransformationWarning;
		this.xmlTransformationFatalError = xmlTransformationFatalError;
		return this;
	}
	
	public void setXmlFileDestination(String xmlFileDestination) {
		this.xmlFileDestination = xmlFileDestination;
	}
	
	public XMLMappingBuilder setOutputProperties(Properties properties) {
		this.propertiesFromFile = properties;
		return this;
	}
	
	public XMLMappingBuilder addOutputProperty(String name, String value) {
		if(this.propertiesFromMemory == null)
			this.propertiesFromMemory = new Hashtable<>();
		this.propertiesFromMemory.put(name, value);
		return this;
	}
	
	public XMLMapping build() {
		XMLMappingImpl xmlMappingImpl = new XMLMappingImpl(xslFile);
		xmlMappingImpl.setInternalErrorHandler(xmlTransformationError, xmlTransformationWarning, xmlTransformationFatalError);
		xmlMappingImpl.setPropertiesFromFile(this.propertiesFromFile);
		xmlMappingImpl.setPropertiesFromMemory(this.propertiesFromMemory);
		xmlMappingImpl.setXmlFileDestination(this.xmlFileDestination);
		return xmlMappingImpl;
	}
}
