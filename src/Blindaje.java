public class Blindaje extends SistemaDefensa {

    private String material;
    private float peso;

    /**
     * @param absorcionDano: float
     * @param material:      String
     * @param peso:          float
     */
    public Blindaje(float absorcionDano, String material, float peso) {
        super(absorcionDano);
        this.material = material;
        this.peso = peso;
    }

    public String getMaterial() {
        return material;
    }

    public float getPeso() {
        return peso;
    }
}