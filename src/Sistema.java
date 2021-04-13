
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


    private static Sistema sistema;
    private IGestorUsuarios gestorUsuarios;
    private IGestorNotificaciones gestorNotificaciones;
    private IGestorTransacciones gestorTransacciones;
    private IGestorNaves gestorNaves;
    private List<Usuario> listaUsuarios;
    private List<Cliente> listaSusEstacionesEspaciales;
    private List<Cliente> listaSusDestructores;
    private List<Cliente> listaSusCazas;
    private List<Cliente> listaSusCargueros;
    private List<Oferta> listaOfertas;
    private List<Venta> listaVentas;
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



    //Notifica al usuario cada vez que hay una oferta nueva del tipo de nave que ha elegido
    public void suscribirUsuarioSistema(String naveAux, Cliente clienteActual) {

        List<Cliente> listaSuscriptores = null;

        switch (naveAux){
            case "EstacionEspacial":
                listaSuscriptores = listaSusEstacionesEspaciales;
                break;
            case "Destructor":
                listaSuscriptores = listaSusDestructores;
                break;
            case "Caza":
                listaSuscriptores = listaSusCazas;
                break;
            case "Carguero":
                listaSuscriptores = listaSusCargueros;
                break;
            default:
                IO.pintar("No ha seleccionado una opción válida...");
        }
        if(listaSuscriptores!=null) {
            GestorNotificaciones.añadirSuscriptor(clienteActual, listaSuscriptores);
            IO.pintar("Te has suscrito con éxito");
        }

    }

    public void bajaSuscripcionUsuarioSistema(String naveAux, Cliente clienteActual){
        List<Cliente> listaSuscriptores = null;

        switch (naveAux){
            case "EstacionEspacial":
                listaSuscriptores = listaSusEstacionesEspaciales;
                break;
            case "Destructor":
                listaSuscriptores = listaSusDestructores;
                break;
            case "Caza":
                listaSuscriptores = listaSusCazas;
                break;
            case "Carguero":
                listaSuscriptores = listaSusCargueros;
                break;
            default:
                IO.pintar("No ha seleccionado una opción válida...");
        }
        if(listaSuscriptores!=null) {
            GestorNotificaciones.eliminarSuscriptor(clienteActual, listaSuscriptores);
            IO.pintar("Te has desuscrito con éxito");
        }

    }
}