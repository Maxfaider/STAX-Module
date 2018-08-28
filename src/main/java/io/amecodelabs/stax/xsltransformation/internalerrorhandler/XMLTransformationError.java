package io.amecodelabs.stax.xsltransformation.internalerrorhandler;

import java.util.function.Consumer;

import javax.xml.transform.TransformerException;

public interface XMLTransformationError extends Consumer<TransformerException> {

}
