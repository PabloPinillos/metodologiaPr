import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GestorNotificacionesTest {

    private List<Nave> listaNaves = new ArrayList<>();
    private List<Oferta> ofertasnotificar  = new ArrayList<>();
    GestorNotificaciones gest = new GestorNotificaciones();

    @Test
    void notificar() {
        //Creamos un cliente
        Cliente client = new Cliente("xxxx", "aaaa", "bbbb", "iiii", "xxxe", "oooo", "2222");

        //creamos una oferta
        Oferta ofert  = new Oferta(client, listaNaves, 77.0f, new GregorianCalendar(3002,10,03).getTime() );
        ofert.setValida(true);
        //Creamos la lista
        List<Cliente> listaSuscriptores = new ArrayList<>();
        listaSuscriptores.add(client);

        //llamamos a gestorNotificaciones.notificar
        gest.notificar(ofert, listaSuscriptores);

        //comprobamos que se ha guardado la oferta en la lista de ofertasNotificar del cliente
        assertEquals(client.getNotificaciones().get(0), ofert);

    }

    @Test
    void añadirSuscriptor() {

        //creamos cliente
        Cliente client = new Cliente("xxxx", "aaaa", "bbbb", "iiii", "xxxe", "oooo", "2222");

        //pasamos lista que corresponda
         List<Cliente> listaSuscriptores = new ArrayList<>();

        //comprobamos si el cliente está

        Boolean resultado = false;

        GestorNotificaciones gest = new GestorNotificaciones();

        gest.añadirSuscriptor(client, listaSuscriptores);
        if (listaSuscriptores.size() < 1 ){
            fail("No se ha introducido el usuario en la lista correspondiente");
        }

        for (Cliente clients : listaSuscriptores){
            if (client == clients){
                resultado = true;
            }
        }
        assertTrue(resultado);



    }

    @Test
    void eliminarSuscriptor() {
        GestorNotificaciones gest = new GestorNotificaciones();

        boolean resultado = false;


        //creamos cliente
        Cliente client = new Cliente("xxxx", "aaaa", "bbbb", "iiii", "xxxe", "oooo", "2222");
        //pasamos lista que corresponda
        List<Cliente> listaSuscriptores = new ArrayList<>();

        //metemos el cliente en la lista
        gest.añadirSuscriptor(client, listaSuscriptores);

        //usamos el método para eliminar
        gest.eliminarSuscriptor(client, listaSuscriptores);
        //comprobamos que no esté
        for (Cliente clientDos : listaSuscriptores){
            if (client == clientDos){
                resultado = true;
            }
        }
        if (resultado==true) {
            fail("No se ha eliminado el cliente");
        }
    }
}