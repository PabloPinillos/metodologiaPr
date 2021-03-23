public abstract class SistemaDefensa {

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

}