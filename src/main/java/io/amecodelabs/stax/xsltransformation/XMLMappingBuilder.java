package io.amecodelabs.stax.xsltransformation;

import java.util.Hashtable;
import java.util.Properties;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import io.amecodelabs.stax.xsltransformation.errorhandler.XMLTransformationError;
import io.amecodelabs.stax.xsltransformation.errorhandler.XMLTransformationFatalError;
import io.amecodelabs.stax.xsltransformation.errorhandler.XMLTransformationWarning;

public class XMLMappingBuilder {
	private String xmlFileDestination;
	private String xslFile;
	private Hashtable<String, String> propertiesFromMemory;
	private Properties propertiesFromFile;
	private ErrorListener errorListener;
	
	public XMLMappingBuilder(String xslFile) {
		this.xslFile = xslFile;
	}
	
	public XMLMappingBuilder setErrorHandler(XMLTransformationError xmlTransformationError, 
			XMLTransformationWarning xmlTransformationWarning, XMLTransformationFatalError xmlTransformationFatalError) {
		this.errorListener = new ErrorListener() {
			@Override
			public void warning(TransformerException exception) throws TransformerException {
				if(xmlTransformationWarning != null)
					xmlTransformationWarning.accept(exception);
			}
			@Override
			public void error(TransformerException exception) throws TransformerException {
				if(xmlTransformationError != null)
					xmlTransformationError.accept(exception);
			}
			@Override
			public void fatalError(TransformerException exception) throws TransformerException {
				if(xmlTransformationFatalError != null)
					xmlTransformationFatalError.accept(exception);
			}
		};
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
		
		if(this.errorListener != null)
			xmlMappingImpl.setErrorListener(this.errorListener);
		if(this.propertiesFromFile != null)
			xmlMappingImpl.setPropertiesFromFile(this.propertiesFromFile);
		if(this.propertiesFromMemory != null)
			xmlMappingImpl.setPropertiesFromMemory(this.propertiesFromMemory);
		if(this.xmlFileDestination != null)
			xmlMappingImpl.setXmlFileDestination(this.xmlFileDestination);
		
		return xmlMappingImpl;
	}
}
