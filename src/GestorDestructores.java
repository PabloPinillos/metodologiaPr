
import java.util.*;

/**
 * 
 */
public abstract class GestorDestructores extends IGestorNaves {

    /**
     * Default constructor
     */
    public GestorDestructores() {
    }

    /**
     * @param String 
     * @param Cliente 
     * @param SistemaPropulsion[2] 
     * @param int 
     * @param SistemaDefensa[3] 
     * @return
     */
    public Nave crearNave(void String, void Cliente, void SistemaPropulsion[2], void int, void SistemaDefensa[3]) {
        // TODO implement here
        return null;
    }

    /**
     * @param Destructor 
     * @param List of Arma
     */
    public void setArmas(void Destructor, void List of Arma) {
        // TODO implement here
    }

    /**
     * @param Destructor 
     * @param Arma
     */
    public void agregarArma(void Destructor, void Arma) {
        // TODO implement here
    }

    /**
     * @param Destructor 
     * @param int 
     * @param Arma
     */
    public void reemplazarArma(void Destructor, void int, void Arma) {
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