package io.amecodelabs.stax.xsltransformation;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

class XMLMappingImpl implements XMLMapping {
	private String xmlFileDestination = "./";
	StreamSource xslStream;
	
	private ErrorListener errorListener;
	private Hashtable<String, String> propertiesFromMemory;
	private Properties propertiesFromFile;
	
	protected XMLMappingImpl(String xslFile) {
		xslStream = new StreamSource(xslFile);
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
	
	public void setErrorListener(ErrorListener errorListener) {
		this.errorListener = errorListener;
	}
	
	@Override
	public void transform(String xmlFile) {
		Transformer transformer;
        
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer(this.xslStream);
			
			Set<String> keys = this.propertiesFromMemory.keySet();
	        for(String key: keys){
	            transformer.setOutputProperty(key, this.propertiesFromMemory.get(key));
	        }
			transformer.setOutputProperties(this.propertiesFromFile);
			transformer.setErrorListener(this.errorListener);
			transformer.transform(
	        		new StreamSource(xmlFile), 
	        		new StreamResult(this.xmlFileDestination)
	        );
		} catch (TransformerConfigurationException e) {
			try {
				errorListener.fatalError(e);
			} catch (TransformerException e1) {
				//e1.printStackTrace();
			}
		} catch (TransformerException e) {
			try {
				errorListener.fatalError(e);
			} catch (TransformerException e1) {
				//e1.printStackTrace();
			}
		}
	}

}
