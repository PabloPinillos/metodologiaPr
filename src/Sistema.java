
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
//Holaa
/**
 *
 */
public class Sistema {

    private static Sistema sistema;
    private IGestorUsuarios gestorUsuarios = new GestorUsuarios();
    private IGestorTransacciones gestorTransacciones = new IGestorTransacciones();
    private IGestorNaves gestorNaves;
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Oferta> listaOfertas = new ArrayList<>();
    private List<Oferta> listaOfertasPorPublicar = new ArrayList<>();
    private List<Venta> listaVentas = new ArrayList<>();


    /**
     *
     */
    private Sistema() throws IOException {

        // Cargamos la lista de Usuarios
        List<Object> aux = gestorUsuarios.leerFichero("Usuarios.data");
        for (Object usuario : aux) {
            listaUsuarios.add((Usuario) usuario);
        }

        // Cargamos la lista de Ofertas
        aux = gestorTransacciones.leerFichero("Ofertas.data");
        for (Object oferta : aux) {
            listaOfertas.add((Oferta) oferta);
        }

        // Cargamos la lista de Ofertas por Validar
        aux = gestorTransacciones.leerFichero("OfertasPorValidar.data");
        for (Object oferta : aux) {
            listaOfertasPorPublicar.add((Oferta) oferta);
        }

        // Cargamos la lista de Ventas
        aux = gestorTransacciones.leefFichero("Ventas.data");
        for (Object venta : aux) {
            listaVentas.add((Venta) venta);
        }



    }


    public void valorarUsuario(Cliente cliente) {
        gestorUsuarios.valorarUsuario(cliente);
    }



    public Oferta getSiguienteOfertaPublicar() {
        if (!listaOfertasPorPublicar.isEmpty()) {
            Oferta oferta = listaOfertasPorPublicar.get(0);
            gestorTransacciones.eliminarOferta(listaOfertasPorPublicar, oferta);
            return oferta;
        }
        return null;
    }


    public void publicarOferta(Oferta oferta) {
        //  hay que ver si se necesita el parámetro booleano de Oferta
        // gestorTransacciones.validarOferta(oferta);
        listaOfertas.add(oferta);
    }
}