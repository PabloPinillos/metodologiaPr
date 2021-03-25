
import java.util.*;

/**
 *
 */
public class GestorEstacionesEspaciales extends IGestorNaves {

    public Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa) {
        return new EstacionEspacial(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0);
    }

    public void setMaximoPasajeros(EstacionEspacial estacionEspacial, int maximoPasajeros) {
        estacionEspacial.setMaxPasajeros(maximoPasajeros);
    }

    public void agregarNaveAlHangar(EstacionEspacial estacionEspacial, Nave nave) {
        estacionEspacial.agregarNaveAlHangar(nave);
    }

    public void eliminarNaveDelHangar(EstacionEspacial estacionEspacial, int index) {
        estacionEspacial.eliminarNaveDelHangar(index);
    }

}