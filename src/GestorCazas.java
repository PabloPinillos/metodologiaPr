
import java.util.*;

/**
 * 
 */
public abstract class GestorCazas extends IGestorNaves {

    /**
     * Default constructor
     */
    public GestorCazas() {
    }

    /**
     * @param String 
     * @param Cliente 
     * @param SistemaPropulsion[2] 
     * @param int 
     * @param SistemaDefensa[3] 
     * @return
     */
    public Nave crearNave(void String, void Cliente, void SistemaPropulsion[2], void int, void... SistemaDefensa 3]) {
        // TODO implement here
        return null;
    }

    /**
     * @param Caza 
     * @param Arma[2]
     */
    public void setArmas(void Caza, void Arma[2]) {
        // TODO implement here
    }

    /**
     * @param Caza 
     * @param int 
     * @param Arma
     */
    public void reemplazarArma(void Caza, void int, void Arma) {
        // TODO implement here
    }

    /**
     * @param String 
     * @param Cliente 
     * @param SistemaPropulsion[2] 
     * @param int 
     * @param SistemaDefensa[3] 
     * @return
     */
    public abstract Nave crearNave(void String, void Cliente, void SistemaPropulsion[2], void int, void SistemaDefensa[3]);

}