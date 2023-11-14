
package Excepciones;


public class LecturaExcepcion extends TiaExcepciones{
    public LecturaExcepcion(String message, java.sql.SQLClientInfoException ex) {
        super(message);
    }
}
