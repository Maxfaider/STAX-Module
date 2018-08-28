package io.amecodelabs.stax.xsltransformation;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

class DefaultErrorListener implements ErrorListener {

	@Override
	public void warning(TransformerException exception) throws TransformerException {
		// do nothing
	}

	@Override
	public void error(TransformerException exception) throws TransformerException {
		// do nothing
	}

	@Override
	public void fatalError(TransformerException exception) throws TransformerException {
		// do nothing
	}
}
