
import java.util.*;

/**
 * 
 */
public class GestorTransacciones {

    /**
     * Default constructor
     */
    public GestorTransacciones() {
    }

    /**
     * @param Cliente 
     * @param List of Nave 
     * @param float 
     * @return
     */
    public Oferta crearOferta(void Cliente, void List of Nave, void float) {
        // TODO implement here
        return null;
    }

    /**
     * @param Cliente 
     * @param Cliente 
     * @param float 
     * @return
     */
    public Venta crearVenta(void Cliente, void Cliente, void float) {
        // TODO implement here
        return null;
    }

    /**
     * @param Oferta
     * @param Cliente
     * @return
     */
    public Venta crearVenta(void Oferta, void Cliente) {
        // TODO implement here
        return null;
    }

    public List<Oferta> buscarOferta(List<Oferta> listaOfertas, String tipoNave) {
        List<Oferta> ofertasSeleccionadas = new ArrayList<>();
        for (Oferta oferta : listaOfertas) {
            for (Nave nave : oferta.getNaves()) {
                if ((tipoNave.equals("Carguero") && nave instanceof Carguero) || (tipoNave.equals("Caza") && nave instanceof Caza) || (tipoNave.equals("Destructor") && nave instanceof Destructor) || (tipoNave.equals("EstacionEspacial") && nave instanceof EstacionEspacial)) {
                    ofertasSeleccionadas.add(oferta);
                    break;
                }
            }
        }
        return ofertasSeleccionadas;
    }

}
