package io.amecodelabs.stax.validator;

public interface XMLSchemaValidatorFactory {
	
	default XMLSchemaValidator getXMLSchemaValidator(XMLSchema xmlSchema) {
		switch(xmlSchema) {
			case DTD: 
				return new DTDValidatorAdapter();
			default:
				return new XSDValidatorAdapter();
		}
	}
	
	public static XMLSchemaValidatorFactory newInstance() {
		return new XMLSchemaValidatorFactory() {};
	}
	
}