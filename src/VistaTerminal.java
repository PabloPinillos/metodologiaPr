
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
    public void escribirTerminal(String[] s) {
        for (String str : s) {
            System.out.println(str);
        }
    }

    @Override
    public void pintar(String s) {
        System.out.println(s);
    }

}