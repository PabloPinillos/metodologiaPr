
import java.util.*;

/**
 * 
 */
public class LogicaSis {
    private ControladorIO IO;
    private Sistema sistema;
    private Usuario usuarioActual;

    /**
     * Método que permite a la clase registrar a un Cliente
     *
     * @return null si no se puede crear el usuario
     */

    private boolean registrarCliente() {
        try {
            String[] datosSignup = IO.pedirSingupCliente();
            if (!sistema.existeEmail(datosSignup[0]) && sistema.buscarUsuario(datosSignup[1]) == null) {
                usuarioActual = sistema.registrarUsuario(datosSignup);
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            IO.pintar(e.getMessage());
            return false;
        }
    }

    /**
     * Método que permite a la clase registrar a un Administrador
     */
    private boolean registrarAdministrador() {
        try {
            String[] datosSignup = IO.pedirSingupCliente();
            if (sistema.buscarUsuario(datosSignup[1]) == null) {
                sistema.registrarUsuario(datosSignup);
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            IO.pintar(e.getMessage());
            return false;
        }
    }

    /**
     * Método que permite la identificación del usuario
     */
    private boolean identificionUsuario() {
        String[] datosLogin = IO.pedirLogin();
        usuarioActual = sistema.identificacionUsuario(datosLogin);
        return usuarioActual != null;
    }

    /**
     * Métiodo que permite que los administradores puedan validar una oferta
     */
    private void verificarOferta() {
        Oferta oferta = sistema.getSiguienteOfertaValidar();
    }

    /**
     * Método para cerrar sesion
     */
    private void cerrarSesion() {
        usuarioActual = null;
        IO.pintar("Hasta pronto");
    }

    /**
     * Bucle infinito que ejecuta la lógica general del programa
     */

    public void ejecutar() {
        // TODO implement here
    }

}