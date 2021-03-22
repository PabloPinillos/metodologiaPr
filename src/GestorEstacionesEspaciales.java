
import java.util.*;

/**
 * 
 */
public class GestorEstacionesEspaciales extends IGestorNaves {

    /**
     * Default constructor
     */
    public GestorEstacionesEspaciales() {
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
     * @param EstacionEspacial 
     * @param int
     */
    public void setMaximoPasajeros(void EstacionEspacial, void int) {
        // TODO implement here
    }

    /**
     * @param EstacionEspacial 
     * @param Nave
     */
    public void agregarNaveAlHangar(void EstacionEspacial, void Nave) {
        // TODO implement here
    }

    /**
     * @param EstacionEspacial 
     * @param int
     */
    public void eliminarNaveDelHangar(void EstacionEspacial, void int) {
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