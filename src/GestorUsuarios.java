
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
            if (params[5].toLowerCase().equals("kromagg"))
                usuario = new Kromagg(params);
            else
                usuario = new Cliente(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        else
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
    public boolean mandarAdvertencia(Cliente cliente) {
        cliente.sumarAdvertencia();
        if (cliente.getAdvertencias() > 1) {
            cliente.setFechaBan();
            cliente.setAdvertenciasCero();
            return true;
        }
        return false;
    }


    /**
     * @param listUsuarios
     * @param nick
     * @param contraseña
     * @return si en la lista de usuarios me coinciden en uno el nick y la contraseña con los que le paso, devuelve true; si no, false
     */
    @Override
    public Usuario identificacionUsuario(List<Usuario> listUsuarios, String nick, String contraseña) {
        Usuario usuario = buscarUsuario(listUsuarios, nick);
        if (usuario != null && usuario.getContraseña().equals(contraseña)) {
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                if (cliente.getFechaBan().after(new Date())) {
                    return null;
                }
            }
            return usuario;
        }
        return null;
    }

    @Override
    public boolean cambiarEmail(Usuario usuario, String email) {
        return usuario.cambiarEmail(email);
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