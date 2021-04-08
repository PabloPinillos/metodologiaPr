
import java.util.*;

/**
 * 
 */
public abstract class GestorCargueros extends IGestorNaves {

    public  Nave crearNave ( String  numeroRegistro , Cliente  propietario , SistemaPropulsion [] sistemasPropulsion , int  numeroTripulantes , SistemaDefensa [] sistemasDefensa ) {
        return  new Carguero(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 0 );
    }

    public void setCargaMaxima( Carguero carguero, float CargaMaxima ) {
        Carguero.setCargaMaxima(CargaMaxima);
    }


    public abstract Nave crearNave(void String, void Cliente, void SistemaPropulsion[2], void int, void SistemaDefensa[3]);

}