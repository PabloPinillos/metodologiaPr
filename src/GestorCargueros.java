
import java.util.*;

/**
 * 
 */
public abstract class GestorCargueros extends IGestorNaves {

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
    public  Nave crearNave ( String  numeroRegistro , Cliente  propietario , SistemaPropulsion [] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return  new  EstacionEspacial (numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
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