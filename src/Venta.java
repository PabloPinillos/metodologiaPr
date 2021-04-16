
import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class Venta implements Serializable {


    private Cliente vendedor;
    private Cliente comprador;
    private float precio;
    private Date fecha;
    private Valoracion valoracion;



    public Venta(Cliente vendedor, Cliente comprador, float precio, Date fecha) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.precio = precio;
        this.fecha = fecha;
    }


    public Venta(Oferta ofert, Cliente comprador) {
       this.comprador = comprador;
       this.fecha = ofert.getFecha();
       this.vendedor = ofert.getVendedorOferta();
       this.precio = ofert.getPrecio();


    }

    /**
     * @return
     */
    public Cliente getComprador() {
        return comprador;
    }

    /**
     * @return
     */
    public Cliente getVendedor() {
        return vendedor;
    }

    /**
     * @return
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

}