package io.amecodelabs.stax.validator.internalerrorhandler;

import java.util.function.Consumer;

import org.xml.sax.SAXParseException;

public interface XMLFatalError extends Consumer<SAXParseException> {

}
