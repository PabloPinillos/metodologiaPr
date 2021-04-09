
import java.util.*;
//hola
/**
 * 
 */
public class GestorDestructores extends IGestorNaves {

    public Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return new Destructor(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }
    public void setArma( Destructor destructor, List<Arma> armas){
        destructor.setArmas(armas);
    }

    public void agregarArma(Destructor destructor,  Arma arma) {
        destructor.agregarArma(arma);
    }

    public void reemplazarArma(Destructor destructor, int index , Arma arma) {
        Caza.reemplazarArma(index);
    }



}