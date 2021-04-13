
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
    private List<Usuario> listaUsuarios;

    /**
     *
     */
    private List<Cliente> listaSusEstacionesEspaciales;

    /**
     *
     */
    private List<Cliente> listaSusDestructores;

    /**
     *
     */
    private List<Cliente> listaSusCazas;

    /**
     *
     */
    private List<Cliente> listaSusCargueros;

    /**
     *
     */
    private List<Oferta> listaOfertas;

    /**
     *
     */
    private List<Venta> listaVentas;

    /**
     *
     */
    private List<Nave> listaNaves;


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
     * @param s
     * @return
     */
    public List<Oferta> buscarOferta(String s) {
        // TODO implement here
        return null;
    }

    /**
     * @param String
     * @param String
     * @return
     */
    public boolean identificacionUsuario(String nick, String pass) {
        // TODO implement here
        return false;
    }

    /**
     * @param c
     */
    public void mandarAdvertencia(Cliente c) {
        // TODO implement here
    }

    /**
     * @param Oferta
     * @param boolean
     */
    public void validarOferta(Oferta of, boolean val) {
        of.setValida(val);
    }

    public IGestorUsuarios getGestorUsuarios() {
        return gestorUsuarios;
    }

    public IGestorNotificaciones getGestorNotificaciones() {
        return gestorNotificaciones;
    }

    public IGestorTransacciones getGestorTransacciones() {
        return gestorTransacciones;
    }

    public IGestorNaves getGestorNaves() {
        return gestorNaves;
    }

    public List<Oferta> getOfertas() {
        return listaOfertas;
    }
}