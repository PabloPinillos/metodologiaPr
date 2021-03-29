
import java.util.*;

/**
 * 
 */
public class Venta {


    private Cliente vendedor;
    private Cliente comprador;
    private float precio;
    private Date fecha;
    private Valoracion valoracion;




    public void Venta(Cliente vendedor, Cliente comprador, float precio, Date fecha) {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.precio = precio;
        this.fecha = fecha;
    }

    /**
     * @param Oferta 
     * @param Cliente 
     * @param Date
     */
    //public void Venta(void Oferta, void Cliente, void Date) {
    //    // TODO implement here
    //}

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