
import java.util.*;

/**
 * 
 */
public abstract class GestorDestructores extends IGestorNaves {

    public Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return new Destructores(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }

    public void setArmas(Destructores destructores, List of Arma Destructores) {
        destructores.setArmas(Armas);
    }

    public void agregarArma(Destructores destructores,  Arma armas) {
        destructores.agregarArma(Arma);
    }

    public void reemplazarArma(void Destructor, void int, void Arma) {
        // TODO implement here
    }


    public abstract Nave crearNave(void String, void Cliente, void SistemaPropulsion[2], void int, void SistemaDefensa[3]);

}