import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class EstacionEspacial extends Nave implements Serializable {

    private int maxPasajeros;
    private List<Nave> hangar = new ArrayList<>();

    public EstacionEspacial(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa, int maxPasajeros) {
        super(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 3);
        this.maxPasajeros = maxPasajeros;
    }

    public float getTotalPotenciaArmas() {
        float total = 0;
        for (Nave nave : hangar) {
            total += nave.getTotalPotenciaArmas();
        }
        return total;
    }

    public int getMaxPasajeros() {
        return maxPasajeros;
    }

    public void setMaxPasajeros(int maxPasajeros) {
        this.maxPasajeros = maxPasajeros;
    }

    public List<Nave> getHangar() {
        return hangar;
    }

    /**
     * @param nave a añadir
     */
    public void agregarNaveAlHangar(Nave nave) {
        hangar.add(nave);
    }

    /**
     * @param index int
     */
    public void eliminarNaveDelHangar(int index) {
        if(index < hangar.size()) {
            hangar.remove(index);
        }
    }

}