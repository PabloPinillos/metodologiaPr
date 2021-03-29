
import java.io.IOException;
import java.util.*;

/**
 *
 */
public interface ControladorIO {

    public String leerEntrada() throws IOException;

    public void pintarMenu();

    public String[] pedirLogin() throws IOException;

    public List<String> pedirSingup();

    public void pintarOpcionesCliente();

    public void pintarOpcionesAdministrador();

}