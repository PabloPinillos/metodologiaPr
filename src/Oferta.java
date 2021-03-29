
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



    /**
     * @param Cliente 
     * @param List of Nave 
     * @param float 
     * @param Date
     */
    public void Oferta(Cliente ofertante, List<Nave> naves, float precio, Date fechaLimite) {
        this.ofertante = ofertante;
        this.naves = naves;
        this.precio = precio;
        this.fechaLimite = fechaLimite;
    }

    /**
     * @return
     */
    public float getTotalAbsorcionDaño() {
        for (Nave iterator : naves)
           float hurt = iterator.getTotalAbsorcionDaño();
        return hurt;
    }

    /**
     * @return
     */
    public float getTotalPotenciaArmas() {
        for (Nave iterator : naves)
            float power = iterator.getTotalPotenciaArmas();
        return power;
    }

    /**
     * @return
     */
    public boolean isValida(){
        return sistema.validarOferta();
    }

}