
import java.util.List;

/**
 *
 */
public interface IGestorNotificaciones extends GestorFicheros {


    /**
     * @param Oferta
     * @param List   of Cliente
     */
    public void notificar(Oferta oferta, List<Cliente> listaSuscriptores);

}
