
import java.util.*;

/**
 * 
 */
public class Sistema {

    /**
     * Default constructor
     */
    public Sistema() {
    }

    /**
     * 
     */
    private static Sistema sistema;

    /**
     * 
     */
    private IGestorUsuarios gestorUsuarios;

    /**
     * 
     */
    private IGestorNotificaciones gestorNotificaciones;

    /**
     * 
     */
    private IGestorTransacciones gestorTransacciones;

    /**
     * 
     */
    private IGestorNaves gestorNaves;

    /**
     * 
     */
    private List of Usuario listaUsuarios;

    /**
     * 
     */
    private List of Cliente listaSusEstacionesEspaciales;

    /**
     * 
     */
    private List of Cliente listaSusDestructores;

    /**
     * 
     */
    private List of Cliente listaSusCazas;

    /**
     * 
     */
    private List of Cliente listaSusCargueros;

    /**
     * 
     */
    private List of Oferta listaOfertas;

    /**
     * 
     */
    private List of Venta listaVentas;

    /**
     * 
     */
    private List of Nave listaNaves;

    /**
     * 
     */
    private Set<Nave> listaNaves;




    /**
     * 
     */
    private IGestorNotificaciones gestorNotificaciones;

    /**
     * 
     */
    private Set<Usuario> listaUsuarios;

    /**
     * 
     */
    private IGestorUsuarios gestorUsuarios;

    /**
     * 
     */
    private Set<Venta> listaVentas;

    /**
     * 
     */
    private IGestorTransacciones gestorTransacciones;


    /**
     * 
     */
    private void Sistema() {
        // TODO implement here
    }

    /**
     * @return
     */
    public static Sistema getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * @param String 
     * @return
     */
    public List of Oferta buscarOferta(void String) {
        // TODO implement here
        return null;
    }

    /**
     * @param String 
     * @param String 
     * @return
     */
    public boolean identificacionUsuario(void String, void String) {
        // TODO implement here
        return false;
    }

    /**
     * @param Cliente
     */
    public void mandarAdvertencia(void Cliente) {
        // TODO implement here
    }

    /**
     * @param Oferta 
     * @param boolean
     */
    public void validarOferta(void Oferta, void boolean) {
        // TODO implement here
    }

}