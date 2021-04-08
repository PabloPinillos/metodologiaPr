
import java.util.*;

/**
 * 
 */
public abstract class GestorDestructores extends IGestorNaves {

    public Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return new Destructor(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }

    public void setArmas(Destructor destructor, List of Arma arma ) {
        destructor.setArmas(arma);
    }

    public void agregarArma(Destructor destructor,  Arma arma) {
        destructor.agregarArma(arma);
    }

    public void reemplazarArma(Destructor destructor , int , void Arma) {
        // TODO implement here
    }



}