
import java.util.*;

/**
 * 
 */
public abstract class GestorCazas extends IGestorNaves {

    public  Nave  crearNave ( String  numeroRegistro , Cliente  propietario , SistemaPropulsion [] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return  new  Caza (numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }

    public void setArmas(Caza caza, Arma Armas) {
        Caza.setArmas(Armas);
    }

    public void reemplazarArma(void Caza, void int, void Arma) {
        // TODO implement here
    }


    public abstract Nave crearNave(void String, void Cliente, void SistemaPropulsion[2], void int, void SistemaDefensa[3]);

}