
import java.util.*;

/**
 * 
 */
public abstract class GestorDestructores extends IGestorNaves {

    public Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return new Destructor(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }

    public void setArmas(Destructor destructor, List of Arma Destructor) {
        destructor.setArmas(Arma);
    }

    public void agregarArma(Destructor destructor,  Arma armas) {
        destructor.agregarArma(Arma);
    }

    public void reemplazarArma(void Destructor, void int, void Arma) {
        // TODO implement here
    }



}