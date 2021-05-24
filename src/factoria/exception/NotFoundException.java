package factoria.exception;

/**
 *Excepción que se dispara cuando no encuentra lo que está buscando
 * 
 * @author morgui
 */
public class NotFoundException extends Exception {

    public NotFoundException(String msg) {
        super(msg);
    }

}
