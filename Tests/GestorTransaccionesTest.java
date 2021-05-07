import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GestorTransaccionesTest {

    private IGestorTransacciones gestorTransacciones = new GestorTransacciones();
    private List<Oferta> listaOfertas;
    private Cliente cliente, comprador;
    private Oferta oferta;

    @BeforeAll
    void initialSetUp() {

        IGestorUsuarios gestorUsuarios = new GestorUsuarios();
        String[] datos = {
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        };
        cliente = (Cliente) gestorUsuarios.crearUsuario(datos);

        datos = new String[]{
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        };
        comprador = (Cliente) gestorUsuarios.crearUsuario(datos);


        IGestorNaves gestorNaves = new GestorDestructores();
        Nave nave = gestorNaves.crearNave("", cliente, ejemploSistemasPropulsion(), 12, ejemploSistemasDefensa());
        ((GestorDestructores) gestorNaves).agregarArma((Destructor) nave, new Arma("Cañones de plasma", 542.5f));
        ((GestorDestructores) gestorNaves).agregarArma((Destructor) nave, new Arma("Misiles termonucleares", 242.4f));
        ((GestorDestructores) gestorNaves).agregarArma((Destructor) nave, new Arma("Rayos láser", 320.2f));

        List<Nave> listaNaves = new ArrayList<>();
        listaNaves.add(nave);

        oferta = gestorTransacciones.crearOferta(cliente, listaNaves, 120.5f, new GregorianCalendar(2021, 5, 1).getTime());

    }

    private SistemaPropulsion[] ejemploSistemasPropulsion() {
        SistemaPropulsion[] lista = new SistemaPropulsion[2];
        lista[0] = new SistemaPropulsion("Motor de curvatura", 289);
        lista[1] = new SistemaPropulsion("Velas solares", 120);
        return lista;
    }

    private SistemaDefensa[] ejemploSistemasDefensa() {
        SistemaDefensa[] lista = new SistemaDefensa[2];
        lista[0] = new Escudo(25600, 420);
        lista[1] = new Blindaje(51200, "plomo", 10);
        return lista;
    }

    private List<Oferta> ejemploListaOfertas() {

        List<Nave> listaNaves = new ArrayList<>();

        IGestorNaves gestorNaves = new GestorCazas();

        Nave naveAux = gestorNaves.crearNave("", cliente, ejemploSistemasPropulsion(), 30, ejemploSistemasDefensa());
        Arma[] armas = new Arma[2];
        armas[0] = new Arma("Cañones de plasma", 58.65f);
        armas[1] = new Arma("PEM", 25.32f);
        ((GestorCazas) gestorNaves).setArmas((Caza) naveAux, armas);

        gestorNaves = new GestorEstacionesEspaciales();
        Nave nave = gestorNaves.crearNave("", cliente, ejemploSistemasPropulsion(), 50, ejemploSistemasDefensa());
        ((GestorEstacionesEspaciales) gestorNaves).agregarNaveAlHangar((EstacionEspacial) nave, naveAux);

        listaNaves.add(nave);

        gestorNaves = new GestorCargueros();
        nave = gestorNaves.crearNave("", cliente, ejemploSistemasPropulsion(), 8, ejemploSistemasDefensa());
        ((GestorCargueros) gestorNaves).setCargaMaxima((Carguero) nave, 246.3f);
        listaNaves.add(nave);

        List<Oferta> salida = new ArrayList<>();
        salida.add(gestorTransacciones.crearOferta(cliente, listaNaves, 523.02f, new GregorianCalendar(2021, 4, 20).getTime()));

        listaNaves = new ArrayList<>();
        gestorNaves = new GestorCargueros();
        nave = gestorNaves.crearNave("", cliente, ejemploSistemasPropulsion(), 10, ejemploSistemasDefensa());
        ((GestorCargueros) gestorNaves).setCargaMaxima((Carguero) nave, 500.2f);
        listaNaves.add(nave);

        salida.add(gestorTransacciones.crearOferta(cliente, listaNaves, 103.2f, new GregorianCalendar(2021, 3, 21).getTime()));

        return salida;

    }

    @BeforeEach
    void setUp() {
        listaOfertas = ejemploListaOfertas();
    }

    @Test
    void crearOferta() {
        Oferta expected = oferta;
        Oferta aux = gestorTransacciones.crearOferta(cliente, oferta.getNaves(), oferta.getPrecio(), oferta.getFecha());
        assertEquals(expected, aux);
    }

    @Test
    void crearVenta() {
        Venta expected = new Venta(oferta, comprador);
        Venta aux = gestorTransacciones.crearVenta(oferta, comprador);
        assertEquals(expected, aux);
    }

    @Test
    void validarOferta() {
        oferta.setValida(false);
        gestorTransacciones.validarOferta(oferta);
        assertTrue(oferta.isValida());
    }

    @Test
    void buscarOferta() {
        assertTrue(gestorTransacciones.buscarOferta(listaOfertas, "Carguero").size() == 2, "Se esperan 2 ofertas con Cargueros");
        assertTrue(gestorTransacciones.buscarOferta(listaOfertas, "Caza").size() == 1, "Se espera una oferta con una estacion espacial que contiene un caza");
        assertTrue(gestorTransacciones.buscarOferta(listaOfertas, "Destructor").size() == 0, "Se espera lista vacia al no haber ofertas con naves del tipo Destructor");
        listaOfertas.add(oferta);
        assertEquals(gestorTransacciones.buscarOferta(listaOfertas, "Destructor").get(0), oferta);
    }

    @Test
    void eliminarOferta() {
        listaOfertas.add(oferta);
        gestorTransacciones.eliminarOferta(listaOfertas, oferta);
        assertFalse(listaOfertas.contains(oferta));
    }
}