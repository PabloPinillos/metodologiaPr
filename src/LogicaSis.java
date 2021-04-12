
import java.io.IOException;
//holaa
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
            IO.pintar("Un Administrador no puede ser valorado");
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


    private void mostrarOferta(Oferta oferta) {
        mostrarUsuario(oferta.getOfertante());
        for (Nave nave : oferta.getNaves()) {
            mostrarNave(nave);
        }
        String[] datos = new String[2];
        datos[0] = "Fecha limite: " + oferta.getFecha();
        datos[1] = "Precio: " + oferta.getPrecio();
        IO.pintar(datos);
    }


    private void mostrarUsuario(Usuario usuario) {
        IO.pintar("Nick: " + usuario.getNick());
    }
    private void mostrarNave(Nave nave) {
        // TODO terminar la funcion y a las que llaman
        String[] datosComunes = new String[];
        datosComunes[0] = "Numero de  tripulantes: " + String.valueOf(nave.getNumeroTripulantes());
        datosComunes[1] = "Numero maximo de sistemas de defensa: " + String.valueof(nave.getMaxSistemasDefensa());
        String[] datosExtra;
        if (nave instanceof Carguero) {
            IO.pintar("Carguero");
            datosExtra = null;
        } else if (nave instanceof Caza) {
            IO.pintar("Caza");
        } else if (nave instanceof Destructor) {
            IO.pintar("Destructor");
        } else if (nave instanceof EstacionEspacial) {
            IO.pintar("Estacion Espacial");
        }
        mostrarSistemasPropulsion(nave);
        IO.pintar(datosComunes);
        mostrarSistemasDefensa(nave);
        if (datosExtra != null) {
            IO.pintar(datosExtra);
        }
    }


    /**
     *
     */
    public void ejecutar() {
        // TODO implement here
    }

}