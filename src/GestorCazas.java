
import java.util.*;

/**
 * 
 */
public  class GestorCazas extends IGestorNaves {

    public  Nave  crearNave ( String  numeroRegistro , Cliente  propietario , SistemaPropulsion [] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return  new Caza(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }

    public void setArmas(Caza caza, Arma[] arma) {
        Caza.setArmas(arma);
    }

    public void reemplazarArma(Caza caza, int index , Arma arma) {
        Caza.reemplazarArma(index);
    }


}





