import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Destructor extends Nave implements Serializable {

    private List<Arma> armas = new ArrayList<>();

    public Destructor(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa) {
        super(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 2);
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    /**
     * @return suma total de la potencia de las armas de la nave
     */
    public float getTotalPotenciaArmas() {
        float total = 0;
        for(Arma arma : armas) {
            total += arma.getPotencia();
        }
        return total;
    }

    /**
     * @param arma: arma a agregar al destructor
     */
    public void agregarArma(Arma arma) {
        armas.add(arma);
    }

    /**
     * @param index: int
     * @param arma: Arma
     */
    public void reemplazarArma(int index, Arma arma) {
        if(index < armas.size()) {
            armas.set(index, arma);
        }
    }

}