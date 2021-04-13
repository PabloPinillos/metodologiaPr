public class Escudo extends SistemaDefensa {

    private float energia;

    /**
     * @param absorcionDano float
     * @param energia       float
     */
    public Escudo(float absorcionDano, float energia) {
        super(absorcionDano);
        this.energia = energia;
    }

    public String getTipo() {
        return "Escudos";
    }

    /**
     * @return energía del escudo
     */
    public float getEnergia() {
        return energia;
    }

}