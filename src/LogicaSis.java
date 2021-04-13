
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
    private Sistema sistema;

    /**
     * 
     */
    private ControladorIO IO;

    /**
     * 
     */
    public void ejecutar() {
        // TODO implement here
    }


    public void suscribirUsuario() throws IOException {
        String opcionElegida;
        String[] opciones = new String[5];
        opciones[0] = "Elija una opción a la que suscribirse";
        opciones[1] = "A) Caza";
        opciones[2] = "B) Destructor";
        opciones[3] = "C) Carguero";
        opciones[4] = "D) Estación espacial";
        IO.escribirTerminal(opciones);
        opcionElegida = IO.leerEntrada();

        String naveAux = null;

        switch (opcionElegida){
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
        Cliente clienteActual =(Cliente) sistema.getGestorUsuarios().getUsuarioActual();
        sistema.suscribirUsuarioSistema(naveAux, clienteActual);

    }


    public void bajaSuscripcionUsuario() throws IOException {
        String opcionElegida;
        String[] opciones = new String[5];
        opciones[0] = "Elija una opción a la que desuscribirse";
        opciones[1] = "A) Caza";
        opciones[2] = "B) Destructor";
        opciones[3] = "C) Carguero";
        opciones[4] = "D) Estación espacial";
        IO.escribirTerminal(opciones);
        opcionElegida = IO.leerEntrada();

        String naveAux = null;

        switch (opcionElegida){
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
        Cliente clienteActual =(Cliente) sistema.getGestorUsuarios().getUsuarioActual();
        sistema.bajaSuscripcionUsuarioSistema(naveAux, clienteActual);
    }

    public void pintarOpcionesCliente(){

    }

}