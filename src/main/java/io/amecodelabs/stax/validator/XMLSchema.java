package io.amecodelabs.stax.validator;

public enum XMLSchema {
	
	DTD ("Document_Type_Definition"),
	XSD ("XML_Schema_Definition");
	
	private String nameSchema;
	
	private XMLSchema(String nameSchema) {
		this.nameSchema = nameSchema;
	}
	
	public String getNameSchema() {
		return nameSchema;
	}

}
