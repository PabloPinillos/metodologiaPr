
import java.util.*;

/**
 * 
 */
public abstract class IGestorNaves {

    /**
     * Default constructor
     */
    public IGestorNaves() {
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

    /**
     * @param Nave 
     * @param SistemaDefensa
     */
    public void agregarSistemaDefensa(void Nave, void SistemaDefensa) {
        // TODO implement here
    }

    /**
     * @param Nave 
     * @param int 
     * @param SistemaDefensa
     */
    public void reemplazarSistemaDefensa(void Nave, void int, void SistemaDefensa) {
        // TODO implement here
    }

    /**
     * @param Nave 
     * @param SistemaPropulsion
     */
    public void agregarSistemaPropulsion(void Nave, void SistemaPropulsion) {
        // TODO implement here
    }

    /**
     * @param Nave 
     * @param SistemaPropulsion
     */
    public void reemplazarSistemaPropulsion(void Nave, void SistemaPropulsion) {
        // TODO implement here
    }

}