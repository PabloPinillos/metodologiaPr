
import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface IGestorNotificaciones extends GestorFicheros {

    void notificar(Oferta ofert, List<Cliente> listaSuscriptores);

    void añadirSuscriptor(Cliente suscriptor, List<Cliente> listaSuscriptores);

    void eliminarSuscriptor(Cliente suscriptor, List<Cliente> listaSuscriptores);

    List<Object> leerFichero(String fileName) throws IOException;

    void escribirFichero(String fileName, List<Object> list) throws IOException;

}
