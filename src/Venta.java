
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venta)) return false;
        Venta venta = (Venta) o;
        return Float.compare(venta.precio, precio) == 0 && Objects.equals(vendedor, venta.vendedor) && Objects.equals(comprador, venta.comprador) && Objects.equals(fecha, venta.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendedor, comprador, precio, fecha);
    }
}