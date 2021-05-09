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
                "Juan García",
                "Tierra",
                "Humano",
                "48976574R",
                "Juan_G",
                "ju4n_6",
                "juan_g@gmail.com"
        };
        cliente = (Cliente) gestorUsuarios.crearUsuario(datos);

        datos = new String[]{
                "Teria Kgugan",
                "Mercurio",
                "Mercuriano",
                "2154685F",
                "ter342@a",
                "teria_kg",
                "teriaK@mmail.mer"
        };
        comprador = (Cliente) gestorUsuarios.crearUsuario(datos);


        IGestorNaves gestorNaves = new GestorDestructores();
        Nave nave = gestorNaves.crearNave("A1111AAA", cliente, ejemploSistemasPropulsion(), 12, ejemploSistemasDefensa());
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

        Nave naveAux = gestorNaves.crearNave("B1234ABC", cliente, ejemploSistemasPropulsion(), 30, ejemploSistemasDefensa());
        Arma[] armas = new Arma[2];
        armas[0] = new Arma("Cañones de plasma", 58.65f);
        armas[1] = new Arma("PEM", 25.32f);
        ((GestorCazas) gestorNaves).setArmas((Caza) naveAux, armas);

        gestorNaves = new GestorEstacionesEspaciales();
        Nave nave = gestorNaves.crearNave("A1234ABC", cliente, ejemploSistemasPropulsion(), 50, ejemploSistemasDefensa());
        ((GestorEstacionesEspaciales) gestorNaves).agregarNaveAlHangar((EstacionEspacial) nave, naveAux);

        listaNaves.add(nave);

        gestorNaves = new GestorCargueros();
        nave = gestorNaves.crearNave("F5421DGE", cliente, ejemploSistemasPropulsion(), 8, ejemploSistemasDefensa());
        ((GestorCargueros) gestorNaves).setCargaMaxima((Carguero) nave, 246.3f);
        listaNaves.add(nave);

        List<Oferta> salida = new ArrayList<>();
        salida.add(gestorTransacciones.crearOferta(cliente, listaNaves, 523.02f, new GregorianCalendar(2021, 4, 20).getTime()));

        listaNaves = new ArrayList<>();
        gestorNaves = new GestorCargueros();
        nave = gestorNaves.crearNave("S3546UEY", cliente, ejemploSistemasPropulsion(), 10, ejemploSistemasDefensa());
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
    void testCrearOferta() {
        Oferta expected = oferta;
        Oferta aux = gestorTransacciones.crearOferta(cliente, oferta.getNaves(), oferta.getPrecio(), oferta.getFecha());
        assertEquals(expected, aux);
    }

    @Test
    void testCrearVenta() {
        Venta expected = new Venta(oferta, comprador);
        Venta aux = gestorTransacciones.crearVenta(oferta, comprador);
        assertEquals(expected, aux);
    }

    @Test
    void testValidarOferta() {
        oferta.setValida(false);
        gestorTransacciones.validarOferta(oferta);
        assertTrue(oferta.isValida());
    }

    @Test
    void testBuscarOferta() {
        assertTrue(gestorTransacciones.buscarOferta(listaOfertas, "Carguero").size() == 2, "Se esperan 2 ofertas con Cargueros");
        List<Oferta> aux = gestorTransacciones.buscarOferta(listaOfertas, "Caza");
        if (aux.size() == 1) {
            assertEquals(aux.get(0), listaOfertas.get(0), "Se espera una oferta con una estacion espacial que contiene un caza");
        } else {
            fail();
        }
        assertTrue(gestorTransacciones.buscarOferta(listaOfertas, "Destructor").size() == 0, "Se espera lista vacia al no haber ofertas con naves del tipo Destructor");
        listaOfertas.add(oferta);
        aux = gestorTransacciones.buscarOferta(listaOfertas, "Destructor");
        if (aux.size() == 1) {
            assertEquals(gestorTransacciones.buscarOferta(listaOfertas, "Destructor").get(0), oferta);
        } else {
            fail();
        }
    }

    @Test
    void testEliminarOferta() {
        listaOfertas.add(oferta);
        gestorTransacciones.eliminarOferta(listaOfertas, oferta);
        assertFalse(listaOfertas.contains(oferta));
    }
}
