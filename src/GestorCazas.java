import java.io.IOException;
import java.util.List;

/**
 * 
 */
//holaa
public  class GestorCazas extends IGestorNaves {

    public  Nave  crearNave ( String  numeroRegistro , Cliente  propietario , SistemaPropulsion [] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return new Caza(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa);
    }

    public void setArmas(Caza caza, Arma[] arma) {
        caza.setArmas(arma);
    }

    public void reemplazarArma(Caza caza, int index, Arma arma) {
        caza.reemplazarArma(index, arma);
    }


    @Override
    public void escribirFichero(String fileName, List<Object> data) throws IOException {
        //TODO
    }

    @Override
    public List<Object> leerFichero(String fileName) throws IOException {
        //TODO
        return null;
    }
}





