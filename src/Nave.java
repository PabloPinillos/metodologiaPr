
import java.util.*;

/**
 * 
 */
public abstract class Nave {

    /**
     * Default constructor
     */
    public Nave() {
    }

    /**
     * 
     */
    private String numeroRegistro;

    /**
     * 
     */
    private Cliente propietario;

    /**
     * 
     */
    private SistemaPropulsion[] sistemasPropulsion;

    /**
     * 
     */
    private int numeroTripulantes;

    /**
     * 
     */
    private SistemaDefensa[] sistemasDefensa;

    /**
     * 
     */
    private int maxSistemasDefensa;





    /**
     * 
     */
    private Cliente propietario;

    /**
     * 
     */
    private SistemaDefensa sistemaDefensa;

    /**
     * 
     */
    private SistemaPropulsion sistemasPropulsion;

    /**
     * @param String 
     * @param Cliente 
     * @param SistemaPropulsion[2] 
     * @param int 
     * @param SistemaDefensa[3] 
     * @param int
     */
    public void Nave(void String, void Cliente, void SistemaPropulsion[2], void int, void SistemaDefensa[3], void int) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float getTotalAbsorcionDaño() {
        // TODO implement here
        return 0.0f;
    }

}