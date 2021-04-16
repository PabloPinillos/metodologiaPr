import java.io.Serializable;

public class SistemaPropulsion implements Serializable {

    private String tipo;
    private float velocidadSLMax;


    /**
     * @param tipo:           String
     * @param velocidadSLMax: float Velocidad sublumínica máxima
     */
    public SistemaPropulsion(String tipo, float velocidadSLMax) {
        this.tipo = tipo;
        this.velocidadSLMax = velocidadSLMax;
    }

    public String getTipo() {
        return tipo;
    }

    public float getVelocidadSLMax() {
        return velocidadSLMax;
    }

}