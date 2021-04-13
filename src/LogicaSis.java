
import java.io.IOException;
import java.util.*;

/**
 *
 */
public class LogicaSis {

    /**
     * Default constructor
     */
    public LogicaSis() {
    }

    private Usuario usuarioActual;

    /**
     *
     */
    private ControladorIO IO;

    /**
     *
     */
    private Sistema sistema;

    /**
     *
     */
    public void ejecutar() {
        // TODO implement here
    }

    public void pintarOpcionesCliente() {
        //TODO
        System.out.println("Opciones cliente:");
        System.out.println("1 - ...");
        System.out.println("2 - ...");

    }

    private void pintarOpcionesAdministrador() {
        //TODO
        IO.pintar("Opciones administrador:");
        IO.pintar("1 - ...");
        IO.pintar("2 - ...");
    }

    private void buscarOferta() throws IOException {
        String[] texto = new String[5];
        texto[0] = "Elija el tipo de nave de la que desea revisar las ofertas";
        texto[1] = "1- Estación Espacial";
        texto[2] = "2- Destructor";
        texto[3] = "3- Caza";
        texto[4] = "4- Carguero";
        IO.escribirTerminal(texto);
        String respuesta = IO.leerEntrada();

        String naveAux = null; //El string se pone al que decidamos para cada nave
        switch (respuesta) {
            case "1":
                naveAux = "EstacionEspacial";
                break;
            case "2":
                naveAux = "Destructor";
                break;
            case "3":
                naveAux = "Caza";
                break;
            case "4":
                naveAux = "Carguero";
                break;
            default:
                IO.pintar("No ha seleccionado una opción válida...");
        }

        //Llamar al buscador de ofertas del gestor de transacciones y pintarlas
        if (naveAux != null) {

            List<Oferta> listOfertaAux = this.sistema.getGestorTransacciones().buscarOferta(sistema.getListaNaves(), naveAux);
            int i = 1;
            Oferta[] arrayOfertasAux = new Oferta[listOfertaAux.size()];
            for (Oferta ofer : listOfertaAux) {
                IO.pintar(i + "-");
                mostrarOferta(ofer);
                arrayOfertasAux[i - 1] = ofer;
                i++;
            }
            IO.pintar("¿Desea realizar una compra? (escriba 1 para comprar, cualquier otra cosa para cancelar)");
            respuesta = IO.leerEntrada();
            if (respuesta.trim() == "1") {
                IO.pintar("Elija por número la oferta que desea comprar: ");
                respuesta = IO.leerEntrada();
                try {
                    int indiceUsuario = Integer.parseInt(respuesta);
                    sistema.getGestorTransacciones().crearVenta(arrayOfertasAux[indiceUsuario - 1], (Cliente) usuarioActual);
                    sistema.getGestorTransacciones().eliminarOferta(sistema.getOfertas(), arrayOfertasAux[indiceUsuario - 1]);
                    IO.pintar("Venta realizada correctamente");
                } catch (Exception e) {
                    IO.pintar("Entrada no válida...");
                }
            } else {
                IO.pintar("De acuerdo, saliendo de la compra...");
            }
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
        IO.escribirTerminal(datos);
    }

    private void mostrarUsuario(Usuario usuario) {
        IO.pintar("Nick: " + usuario.getNick());
    }

    private void mostrarNave(Nave nave) {
        String[] datosComunes = new String[2];
        datosComunes[0] = "Numero de  tripulantes: " + String.valueOf(nave.getNumeroTripulantes());
        datosComunes[1] = "Numero maximo de sistemas de defensa: " + String.valueOf(nave.getMaxSistemasDefensa());
//        String[] datosExtra = new String[0];
        if (nave instanceof Carguero) {
            IO.pintar("Carguero");
//            datosExtra = null;
        } else if (nave instanceof Caza) {
            IO.pintar("Caza");
        } else if (nave instanceof Destructor) {
            IO.pintar("Destructor");
        } else if (nave instanceof EstacionEspacial) {
            IO.pintar("Estacion Espacial");
        }
        mostrarSistemasPropulsion(nave);
        IO.escribirTerminal(datosComunes);
        mostrarSistemasDefensa(nave);
//        if(datosExtra != null) {
//            IO.escribirTerminal(datosExtra);
//        }
    }

    private void mostrarSistemasPropulsion(Nave nave) {
        SistemaPropulsion[] sisProp = nave.getSistemasPropulsion();
        IO.pintar("Sistemas de propulsion: ");
        IO.pintar(sisProp[0].getTipo());
        if (sisProp[1] != null)
            IO.pintar(sisProp[1].getTipo());
    }

    private void mostrarSistemasDefensa(Nave nave) {
        SistemaDefensa[] sisDef = nave.getSistemasDefensa();
        IO.pintar("Sistemas de defensa: ");
        IO.pintar(sisDef[0].getTipo());
        if (sisDef[1] != null)
            IO.pintar(sisDef[1].getTipo());
        if (sisDef[2] != null)
            IO.pintar(sisDef[2].getTipo());
    }

    public String[] pedirLogin() throws IOException {
        String[] login = new String[2];
        IO.pintar("Introduzca su usuario");
        login[0] = IO.leerEntrada();
        IO.pintar("Introduzca su contraseña");
        login[1] = IO.leerEntrada();
        return login;
    }

    public List<String> pedirSingupCliente() throws IOException {
        List<String> ls = new ArrayList<>();
        IO.pintar("Introduzca su email");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su nombre de usuario");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su contraseña");
        ls.add(IO.leerEntrada());
        return ls;
    }

    public String[] pedirSingupAdministrador() throws IOException {
        List<String> ls = new ArrayList<>();
        IO.pintar("Introduzca su email");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su nombre de usuario");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su contraseña");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su nombre");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su planeta de origen");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su especie");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su número de identificación intergaláctico");
        ls.add(IO.leerEntrada());
        return (String[]) ls.toArray();
    }


}