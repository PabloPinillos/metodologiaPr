import java.io.Serializable;

public abstract class SistemaDefensa implements Serializable {

    private float absorcionDano;

    /**
     * @param absorcionDano: float
     */
    public SistemaDefensa(float absorcionDano) {
        this.absorcionDano = absorcionDano;
    }

    public float getAbsorcionDano() {
        return absorcionDano;
    }

    public abstract String getTipo();

}