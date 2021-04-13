
import java.util.List;

/**
 *
 */
public interface IGestorNotificaciones extends GestorFicheros {

    void notificar(Oferta ofert,List<Cliente> listaSuscriptores);

}
