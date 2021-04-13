
import java.util.*;

/**
 *
 */
public interface IGestorUsuarios {


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
    void mandarAdvertencia(Cliente cliente);

    /**
     * @param listUsuarios
     * @param nick
     * @param newContraseña
     * @return
     */
    boolean identificacionUsuario(List<Usuario> listUsuarios, String nick, String newContraseña);

    /**
     * @param usuario
     * @param email
     */
    boolean cambiarEmail(Usuario usuario, String email);

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

    void valorarUsuario(Cliente cliente);



    void setComentario(Cliente comentario);

    void setValoracion(Cliente valoracion);

    Usuario buscarUsuario(List<Usuario> listaUsuarios, String nick);
}