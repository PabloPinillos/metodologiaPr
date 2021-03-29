
import java.util.*;

/**
 * 
 */
public abstract class GestorCargueros extends IGestorNaves {
//holaa
    /**
     * Default constructor
     */
    public GestorCargueros() {
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
     * @param Carguero 
     * @param float
     */
    public void setCargaMaxima(void Carguero, void float) {
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