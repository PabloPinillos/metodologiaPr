
import java.util.*;

/**
 * 
 */
public  class GestorCazas extends IGestorNaves {

    public  Nave  crearNave ( String  numeroRegistro , Cliente  propietario , SistemaPropulsion [] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return  new Caza(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }

    public void setArmas(Caza caza, Arma[2] Armas) {
        Caza.setArmas(Armas);
    }

    public void reemplazarArma(Caza caza, int index , void Arma) {
        Caza.reemplazarArma(index);
    }


}





