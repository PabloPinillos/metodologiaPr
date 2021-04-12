
import java.io.IOException;

/**
 *
 */
public class LogicaSis {

    private ControladorIO IO;
    private Sistema sistema;
    private Usuario usuarioActual;


    private void valorarUsuario() throws IOException {
        IO.pintar("Introduzca el nick del cliente al que desea valorar");
        Usuario usuario = sistema.buscarUsuario(IO.leerEntrada());
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            String[] datos = new String[4];
            datos[0] = "Nick: " + cliente.getNick();
            datos[1] = "Email: " + cliente.getEmail();
            IO.pintar(datos);

        } else {
            IO.pintar("No se puede valorar a un Administrador");
        }
    }
    private void publicarOferta() throws IOException {
        Oferta oferta = sistema.getSiguienteOfertaPublicar();
        mostrarOferta(oferta);
        IO.pintar("¿Desea publicar esta oferta?(y/n):");
        char seleccion;
        do {
            seleccion = IO.leerEntrada().toLowerCase().charAt(0);
        } while (seleccion != 'y' && seleccion != 'n');
        if (seleccion == 'y') {
            sistema.validarOferta(oferta);
            IO.pintar("Oferta publicada");
        } else {
            IO.pintar("Oferta no publicada");

        }
    }


    /**
     *
     */
    public void ejecutar() {
        // TODO implement here
    }

}