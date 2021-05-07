
import java.io.Serializable;
import java.util.*;

/**
 *
 */
public class Oferta implements Serializable {


    private Cliente ofertante;
    private List<Nave> naves;
    private Date fechaLimite;
    private float precio;
    private boolean valida;


    public Oferta(Cliente ofertante, List<Nave> naves, float precio, Date fechaLimite) {
        this.ofertante = ofertante;
        this.naves = naves;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
        this.valida = false;
    }

    /**
     * @return
     */
    public float getTotalAbsorcionDaño() {
        float hurt = 0;
        for (Nave iterator : naves)
            hurt += iterator.getTotalAbsorcionDaño();
        return hurt;
    }

    /**
     * @return
     */
    public float getTotalPotenciaArmas() {
        float power = 0;
        for (Nave iterator : naves)
            power += iterator.getTotalPotenciaArmas();
        return power;
    }

    /**
     * @return
     */
    public boolean isValida() {
        return valida;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public Cliente getVendedorOferta() {
        return ofertante;
    }

    public float getPrecio() {
        return precio;
    }


    public Date getFecha() {
        return fechaLimite;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    /*@Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o instanceof Oferta) {
            Oferta oferta = (Oferta) o;
            return ofertante.equals(oferta.getVendedorOferta()) &&
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oferta)) return false;
        Oferta oferta = (Oferta) o;
        return Float.compare(oferta.precio, precio) == 0 && ofertante.equals(oferta.ofertante) && naves.equals(oferta.naves) && fechaLimite.equals(oferta.fechaLimite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ofertante, naves, fechaLimite, precio);
    }
}
