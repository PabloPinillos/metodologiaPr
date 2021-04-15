
import java.io.IOException;
import java.util.*;
//hola
/**
 * 
 */
public class GestorDestructores extends IGestorNaves {

    public Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return new Destructor(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa);
    }
    public void setArma( Destructor destructor, List<Arma> armas){
        destructor.setArmas(armas);
    }

    public void agregarArma(Destructor destructor, Arma arma) {
        destructor.agregarArma(arma);
    }

    public void reemplazarArma(Destructor destructor, int index, Arma arma) {
        destructor.reemplazarArma(index, arma);
    }

    @Override
    public void escribirFichero(String fileName, List<Object> data) throws IOException {

    }

    @Override
    public List<Object> leerFichero(String fileName) throws IOException {
        return new ArrayList<>();
    }
}