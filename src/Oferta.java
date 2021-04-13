
import java.util.*;

/**
 * 
 */
public class Oferta {


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

}
