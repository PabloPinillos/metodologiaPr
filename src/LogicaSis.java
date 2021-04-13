
import java.io.IOException;
//holaa
/**
 *
 */
public class LogicaSis {

    private ControladorIO IO;
    private Sistema sistema;
    private Usuario usuarioActual;
    private Valoracion valoracion;

    private void valorarUsuario() throws IOException {
        IO.pintar("Introduzca el nick del cliente al que desea valorar");
        Usuario usuario = sistema.buscarUsuario(IO.leerEntrada());
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            String[] datos = new String[4];
            datos[0] = "Nick: " + cliente.getNick();
            datos[1] = "Email: " + cliente.getEmail();
            datos[2] = "Valoracion: ";
            datos[3] = "Comentario: ";
            IO.pintar(datos);
            IO.pintar("Escriba la valoracion y el comentario (Valoracion: v, Comentario: c");
            String entrada = IO.leerEntrada().toLowerCase();
            char seleccion = entrada.charAt(0);
            if (seleccion == 'v') {
                valoracion.setValoracion(cliente);
                IO.pintar("Valoracion completada");
            }
            if (seleccion == 'c') {
                valoracion.setComentario(cliente);
                IO.pintar("Comentario completado");
            }

        } else {
            IO.pintar("Un Administrador no puede ser valorado");
        }
    }

    private void publicarOferta() throws IOException {
        Oferta oferta = sistema.getSiguienteOfertaPublicar();
        mostrarOferta(oferta);
        IO.pintar("¿Desea publicar esta oferta?(s/n):");
        char seleccion;
        do {
            seleccion = IO.leerEntrada().toLowerCase().charAt(0);
        } while (seleccion != 's' && seleccion != 'n');
        if (seleccion == 's') {
            sistema.publicarOferta(oferta);
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
        // tengo que terminar la funcion y las funciones que llaman
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