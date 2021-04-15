
import java.util.*;

/**
 *
 */
public interface IGestorUsuarios extends GestorFicheros {


    /**
     * @param params
     * @return
     */
    Usuario crearUsuario(String[] params);

    /**
     * @param cliente
     */
    void marcarPirataEspacial(Cliente cliente);

    /**
     * @param cliente
     */
    void marcarEstafador(Cliente cliente);

    /**
     * @param cliente
     */
    boolean mandarAdvertencia(Cliente cliente);

    /**
     * @param listUsuarios
     * @param nick
     * @param newContraseña
     * @return
     */
    Usuario identificacionUsuario(List<Usuario> listUsuarios, String nick, String newContraseña);

    /**
     * @param usuario
     * @param email
     */
    void cambiarEmail(Usuario usuario, String email);

    /**
     * @param usuario
     * @param nick
     */
    void cambiarNick(Usuario usuario, String nick);

    /**
     * @param usuario
     * @param contraseña
     */
    void cambiarContraseña(Usuario usuario, String contraseña);

    /**
     * @param cliente
     * @return boolean
     */
    boolean esEstafador(Cliente cliente);

    /**
     * @param cliente
     * @return boolean
     */
    boolean esPirataEspacial(Cliente cliente);

    boolean existeEmail(List<Usuario> listaUsuarios, String email);

    Usuario buscarUsuario(List<Usuario> listaUsuarios, String nick);

    void valorarUsuario(Cliente cliente, Valoracion val);

    List<Oferta> getNotificaciones(Cliente cliente);
}
