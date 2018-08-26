package io.amecodelabs.stax.xsltransformation;

import java.util.Hashtable;
import java.util.function.BiConsumer;

public class XMLMappingStorage {
	private Hashtable<String, XMLMapping> xmlMappings;
	private int sizeCurrent;
	
	public XMLMappingStorage() {
		this.xmlMappings = new Hashtable<>();
		this.sizeCurrent = 0;
	}
	
	public void add(String name, XMLMapping xmlMapping) {
		this.xmlMappings.getOrDefault(
				name, 	
				xmlContent -> {
					throw new UnsupportedOperationException(); 
				}
	    );
		++this.sizeCurrent;
	}
	
	public XMLMapping get(String name) {
		return this.xmlMappings.getOrDefault(
				name, 	
				xmlContent -> {
					throw new UnsupportedOperationException(); 
				}
	    );
	}
	
	public String[] getXMLMappingNames() {
		return (String[]) this.xmlMappings
				.keySet()
				.toArray();
	}
	
	public void forEach(BiConsumer<String, XMLMapping> biConsumer) {
		this.xmlMappings.forEach(biConsumer);
	}
	
	
	public int size() {
		return this.sizeCurrent;
	}
	
}
