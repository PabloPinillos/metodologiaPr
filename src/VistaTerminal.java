
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class VistaTerminal implements ControladorIO {

    /**
     *
     */
    private BufferedReader fromSystemBuffer;

    /**
     * Constructor
     */
    public VistaTerminal() {
        fromSystemBuffer = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String leerEntrada() throws IOException {
        String salida = fromSystemBuffer.readLine();
        return salida;
    }

    @Override
    public void pintarMenu() {

    }

    @Override
    public String[] pedirLogin() throws IOException {
        String[] login = new String[2];
        System.out.println("Introduzca su usuario");
        login[0] = fromSystemBuffer.readLine();
        System.out.println("Introduzca su contraseña");
        login[1] = fromSystemBuffer.readLine();
        return login;
    }

    @Override
    public List<String> pedirSingup() {
        //POR QUE DEVUELVE LIST EN VEZ DE STRING[3]?
        return null;
    }

    @Override
    public void pintarOpcionesCliente() {
        //TODO
        System.out.println("Opciones cliente:");
        System.out.println("1 - ...");
        System.out.println("2 - ...");

    }

    @Override
    public void pintarOpcionesAdministrador() {
        //TODO
        System.out.println("Opciones administrador:");
        System.out.println("1 - ...");
        System.out.println("2 - ...");
    }
}