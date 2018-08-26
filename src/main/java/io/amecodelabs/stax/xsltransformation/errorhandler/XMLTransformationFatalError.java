package io.amecodelabs.stax.xsltransformation.errorhandler;

import java.util.function.Consumer;

import javax.xml.transform.TransformerException;

public interface XMLTransformationFatalError extends Consumer<TransformerException> {

}
