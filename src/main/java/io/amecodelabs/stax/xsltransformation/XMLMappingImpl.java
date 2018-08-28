package io.amecodelabs.stax.xsltransformation;

import java.io.File;
import java.util.Hashtable;
import java.util.Properties;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import io.amecodelabs.stax.xsltransformation.internalerrorhandler.XMLTransformationError;
import io.amecodelabs.stax.xsltransformation.internalerrorhandler.XMLTransformationFatalError;
import io.amecodelabs.stax.xsltransformation.internalerrorhandler.XMLTransformationWarning;

public class XMLMappingImpl implements XMLMapping {
	private String xmlFileDestination;
	StreamSource xslStream;
	private ErrorListener errorListener;
	private Hashtable<String, String> propertiesFromMemory;
	private Properties propertiesFromFile;
	
	XMLMappingImpl(File xslFile) {
		this.errorListener = new DefaultErrorListener();
		this.xslStream = new StreamSource(xslFile);
	}
	
	public void setXmlFileDestination(String xmlFileDestination) {
		this.xmlFileDestination = xmlFileDestination;
	}
	
	public void setPropertiesFromFile(Properties propertiesFromFile) {
		this.propertiesFromFile = propertiesFromFile;
	}
	
	public void setPropertiesFromMemory(Hashtable<String, String> propertiesFromMemory) {
		this.propertiesFromMemory = propertiesFromMemory;
	}
	
	public void setInternalErrorHandler(XMLTransformationError xmlTransformationError, 
			XMLTransformationWarning xmlTransformationWarning, XMLTransformationFatalError xmlTransformationFatalError) {
		this.errorListener = new ErrorListener() {
			@Override
			public void warning(TransformerException exception) throws TransformerException {
				if(xmlTransformationWarning != null)
					xmlTransformationWarning.accept(exception);
			}
			@Override
			public void fatalError(TransformerException exception) throws TransformerException {
				if(xmlTransformationFatalError != null)
					xmlTransformationFatalError.accept(exception);
			}
			@Override
			public void error(TransformerException exception) throws TransformerException {
				if(xmlTransformationError != null)
					xmlTransformationError.accept(exception);
			}
		};
	}
	
	@Override
	public void transform(File xmlFile) throws XMLMappingException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer(xslStream);
			this.addPropertiesOptional(transformer);
			StreamSource inputXML = new StreamSource(xmlFile);
	        StreamResult outputXML = new StreamResult(this.xmlFileDestination);
	        transformer.transform(inputXML, outputXML);
		} catch (TransformerException e) {
			throw new XMLMappingException(e.getMessage());
		}
	}
	
	private void addPropertiesOptional(Transformer transformer) {
		if (this.propertiesFromFile != null)
			transformer.setOutputProperties(this.propertiesFromFile);
		if (this.propertiesFromMemory != null)
			this.propertiesFromMemory.forEach((key, value) -> transformer.setOutputProperty(key, value));
		if (this.errorListener != null)
			transformer.setErrorListener(this.errorListener);
		if (this.xmlFileDestination == null)
			this.xmlFileDestination = "./autogenerate.xmi";
	}
}
