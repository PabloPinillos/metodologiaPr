import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestorUsuariosTest {
    //Test del gestor de usuarios
    @Test
    public void testCrearAdmin(){
        //parametros para el admin
        GestorUsuarios gu = new GestorUsuarios();
        String[] params = new String[3];
        params[0] = "email";
        params[1] = "nick";
        params[2] = "contraseña";
        Usuario u = gu.crearUsuario(params);
        Usuario admin = new Administrador(params[0], params[1], params[2]);
        assertSame(u.getEmail(), admin.getEmail());
        assertSame(u.getContraseña(), admin.getContraseña());
        assertSame(u.getNick(), admin.getNick());
        assert(u instanceof Administrador);
    }

    @Test
    public void testCrearCliente(){
        //parametros para el cliente String email, String nick, String contraseña, String nombre, String planetaOrigen, String especie, String numeroIdentificacion
        GestorUsuarios gu = new GestorUsuarios();
        String[] params = new String[7];
        params[0] = "email";
        params[1] = "nick";
        params[2] = "contraseña";
        params[3] = "nombre";
        params[4] = "planeta";
        params[5] = "especie";
        params[6] = "numeroID";
        Usuario u = gu.crearUsuario(params);
        Usuario cliente = new Cliente(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        assertSame(u.getEmail(), cliente.getEmail());
        assertSame(u.getContraseña(), cliente.getContraseña());
        assertSame(u.getNick(), cliente.getNick());
        assert(u instanceof Cliente);
    }

    @Test
    public void testCrearKromag(){
        //parametros para el cliente String email, String nick, String contraseña, String nombre, String planetaOrigen, String especie, String numeroIdentificacion
        GestorUsuarios gu = new GestorUsuarios();
        String[] params = new String[7];
        params[0] = "email";
        params[1] = "nick";
        params[2] = "contraseña";
        params[3] = "nombre";
        params[4] = "planeta";
        params[5] = "KROMAGG";
        params[6] = "numeroID";
        Usuario u = gu.crearUsuario(params);
        Usuario krom = new Kromagg(params);
        assertSame(u.getEmail(), krom.getEmail());
        assertSame(u.getContraseña(), krom.getContraseña());
        assertSame(u.getNick(), krom.getNick());
        assert(u instanceof Kromagg);
    }

    @Test
    public void testUsuarioIncorrecto(){
        //parametros para el cliente String email, String nick, String contraseña, String nombre, String planetaOrigen, String especie, String numeroIdentificacion
        GestorUsuarios gu = new GestorUsuarios();
        String[] params = new String[5];
        params[0] = "email";
        params[1] = "nick";
        params[2] = "contraseña";
        params[3] = "nombre";
        params[4] = "planeta";
        try{
            Usuario u = gu.crearUsuario(params);
            assert((u instanceof Kromagg) || (u instanceof Administrador) || (u instanceof Cliente));
        }catch (Exception e){
            assert(true);
        }
    }

    @Test
    public void testMandarAdvertencia(){
        String[] params = new String[7];
        params[0] = "email";
        params[1] = "nick";
        params[2] = "contraseña";
        params[3] = "nombre";
        params[4] = "planeta";
        params[5] = "especie";
        params[6] = "numeroID";
        Cliente c = new Cliente(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        GestorUsuarios gu = new GestorUsuarios();
        gu.mandarAdvertencia(c);
        assertEquals(c.getAdvertencias(), 1);
        gu.mandarAdvertencia(c);
        assertEquals(c.getAdvertencias(), 0);
        System.out.println(c.getFechaBan());
    }

    @Test
    public void testValorarUsuario(){
        String[] params = new String[7];
        params[0] = "email";
        params[1] = "nick";
        params[2] = "contraseña";
        params[3] = "nombre";
        params[4] = "planeta";
        params[5] = "especie";
        params[6] = "numeroID";
        Cliente c = new Cliente(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        Cliente c2 = new Cliente(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        GestorUsuarios gu = new GestorUsuarios();
        gu.valorarUsuario(c, new Valoracion(c2, 2, "prueba"));
        gu.valorarUsuario(c, new Valoracion(c2, 3, "prueba"));
        gu.valorarUsuario(c, new Valoracion(c2, 4, "prueba"));
        assertEquals(c.getValoracionMedia(), 3.0f);
        assertNotEquals(c.getValoracionMedia(), "prueba");
    }

    @Test
    public void testIdentificarUsuarioYBuscarUsuario(){
        String[] params = new String[7];
        params[0] = "email";
        params[1] = "nick";
        params[2] = "contraseña";
        params[3] = "nombre";
        params[4] = "planeta";
        params[5] = "especie";
        params[6] = "numeroID";
        Usuario c = new Cliente(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        GestorUsuarios gu = new GestorUsuarios();
        List<Usuario> lu = null;
        //Lista vacía
        Usuario usSalida = gu.identificacionUsuario(lu, "nick", "contraseña");
        assert(usSalida == null);

        //Lista con un elemento
        lu = new ArrayList<>();
        lu.add(c);
        usSalida = gu.identificacionUsuario(lu, "nick", "contraseña");
        assert(usSalida == c);

        //Lista con un elemento que no tiene coincidencias
        lu = new ArrayList<>();
        lu.add(c);
        usSalida = gu.identificacionUsuario(lu, "nickQueNoEsta", "contraseñaQueNoEsta");
        assert(usSalida == null);
    }
}