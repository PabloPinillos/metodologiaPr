import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GestorNotificacionesTest {

    private List<Nave> listaNaves = new ArrayList<>();
    private List<Cliente> listaSuscriptores;
    private List<Oferta> ofertasnotificar  = new ArrayList<>();

    GestorNotificaciones gest = new GestorNotificaciones();
    Cliente client = new Cliente("xxxx", "aaaa", "bbbb", "iiii", "xxxe", "oooo", "2222");
    Cliente clientDos = new Cliente("xxxa", "aaav", "brbb", "eiii", "xrxe", "ooeo", "2322");
    Cliente clientTres = new Cliente("xxra", "waav", "brcb", "eivi", "xrxz", "woeo", "2324");
    Oferta ofert  = new Oferta(client, listaNaves, 77.0f, new GregorianCalendar(3002,10,03).getTime() );



    @Test
    void notificar() {
        //creamos una oferta
        //Creamos un cliente

        //llamamos a gestorNotificaciones.notificar
        //comprobamos que se ha guardado la oferta en la lista de ofertas notificar del cliente
        //devolvemos true si es así

        gest.notificar(this.ofert, this.listaSuscriptores);

    }

    @Disabled
    void añadirSuscriptor() {
        //creamos cliente

        //pasamos lista que corresponda

        //comprobamos si el cliente está

        Boolean resultado = false;

        GestorNotificaciones gest = new GestorNotificaciones();

        gest.añadirSuscriptor(client, listaSuscriptores);
        if (listaSuscriptores.size() < 1 ){
            fail("No se ha introducido el usuario en la lista correspondiente");
        }

        for (Cliente client : listaSuscriptores){
            if (this.client == client){
                resultado = true;
            }
        }
        assertTrue(resultado);



    }

    @Disabled
    void eliminarSuscriptor() {
        boolean resultado = false;


        //creamos cliente
        //pasamos lista que corresponda

        //metemos el cliente en la lista
        gest.añadirSuscriptor(clientDos, listaSuscriptores);

        //usamos el método para eliminar
        gest.eliminarSuscriptor(clientDos, listaSuscriptores);
        //comprobamos que no esté
        for (Cliente clientDos : listaSuscriptores){
            if (this.clientDos == clientDos){
                resultado = true;
            }
        }
        if (resultado==true) {
            fail("No se ha eliminado el cliente");
        }
    }
}