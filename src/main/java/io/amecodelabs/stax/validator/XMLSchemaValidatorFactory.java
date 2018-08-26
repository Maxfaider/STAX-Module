package io.amecodelabs.stax.validator;

public interface XMLSchemaValidatorFactory {
	
	default XMLSchemaValidator getXMLSchemaValidator(XMLSchema xmlSchema) {
		switch(xmlSchema) {
			case DTD: 
				return new DTDValidator();
			default:
				return new XSDValidator();
		}
	}
	
	public static XMLSchemaValidatorFactory newInstance() {
		return new XMLSchemaValidatorFactory() {
		};
	}
	
}