
import java.util.*;

/**
 * 
 */
public interface IGestorTransacciones extends GestorFicheros {

    Oferta crearOferta(Cliente vendedor, List<Nave> naves, float precio, Date fechaPuestaAlaVenta);

    Venta crearVenta(Cliente vendedor, Cliente comprador, float precio, Date fechaCompra);

    Venta crearVenta(Oferta ofert, Cliente comprador);

    void eliminarOferta(List<Oferta> lo, Oferta o);

    List<Oferta> buscarOferta(List<Oferta> listaOfertas, String tipoNave);

    void validarOferta(Oferta oferta);

    boolean tieneNaves(Oferta oferta, String tipoNave);

}