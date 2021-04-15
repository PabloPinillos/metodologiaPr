import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite gestionar los cargueros
 */
public class GestorCargueros extends IGestorNaves {

    public Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa) {
        return new Carguero(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0);
    }

    public void setCargaMaxima(Carguero carguero, float CargaMaxima) {
        carguero.setCargaMaxima(CargaMaxima);
    }

    @Override
    public void escribirFichero(String fileName, List<Object> data) throws IOException {

    }

    @Override
    public List<Object> leerFichero(String fileName) throws IOException {
        return new ArrayList<>();
    }
}