public class Arma {

    private String tipo;
    private float potencia;

    /**
     * @param tipo     de arma
     * @param potencia del arma
     */
    public Arma(String tipo, float potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public float getPotencia() {
        return potencia;
    }

}