package io.amecodelabs.stax.validator.errorhandler;

import java.util.function.Consumer;
import org.xml.sax.SAXParseException;

public interface XMLError extends Consumer<SAXParseException> {

}
