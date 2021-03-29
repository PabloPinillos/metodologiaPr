
import java.util.*;

/**
 *
 */
public class GestorUsuarios implements IGestorUsuarios {

    /**
     * Default constructor
     */
    public GestorUsuarios() {
    }

    @Override
    public Usuario crearUsuario(String[] params) throws RuntimeException {
        Usuario usuario = null;
        if (params.length == 3) {
            usuario = new Administrador(params[0], params[1], params[2]);
        } else if (params.length == 7)
            usuario = new Cliente(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        if (usuario == null)
            throw (new RuntimeException("El usuario no se ha podido crear"));

        return usuario;
    }

    @Override
    public void marcarPirataEspacial(Cliente cliente) {
        cliente.setEsPirataEspacial(true);
    }

    @Override
    public void marcarEstafador(Cliente cliente) {
        cliente.setEsEstafador(true);
    }

    @Override
    public void mandarAdvertencia(Cliente cliente) {
        cliente.sumarAdvertencia();
    }

    /**
     * @param listUsuarios
     * @param nick
     * @param contraseña
     * @return si en la lista de usuarios me coinciden en uno el nick y la contraseña con los que le paso, devuelve true; si no, false
     */
    @Override
    public boolean identificacionUsuario(List<Usuario> listUsuarios, String nick, String contraseña) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getNick().equals(nick) && usuario.getContraseña().equals(contraseña))
                return true;
        }
        return false;
    }

    @Override
    public boolean cambiarEmail(Usuario usuario, String email) {
        if (usuario.cambiarEmail(email))
            return true;
        else
            return false;
    }

    @Override
    public void cambiarNick(Usuario usuario, String nick) {
        usuario.cambiarNick(nick);
    }

    @Override
    public void cambiarContraseña(Usuario usuario, String newContraseña) {
        usuario.cambiarContraseña(newContraseña);
    }

    @Override
    public boolean esEstafador(Cliente cliente) {
        return cliente.getEsEstafador();
    }

    @Override
    public boolean esPirataEspacial(Cliente cliente) {
        return cliente.getEsPirataEspacial();
    }
}