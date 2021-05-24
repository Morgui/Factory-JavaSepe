package factoria.exception;

/**
 *Excepción que se dispara cuando un trabajador no puede asignarse porque ya este presente
 * 
 * @author morgui
 */
public class OverrideException extends Exception {

    public OverrideException(String msg) {
        super(msg);
    }

}
