
import java.io.IOException;
import java.util.*;

/**
 *
 */
public interface ControladorIO {

    public String leerEntrada() throws IOException;

    public void escribirTerminal(String[] s);

    public void pintar(String s);

}