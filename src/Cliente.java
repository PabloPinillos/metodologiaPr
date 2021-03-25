
import java.util.*;

/**
 * 
 */
public class Cliente extends Usuario {

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String planetaOrigen;

    /**
     * 
     */
    private String especie;

    /**
     * 
     */
    private String numeroIdentificacion;

    /**
     *
     */
    private List<Nave> naves;

    /**
     * 
     */
    private boolean esPirataEspacial;

    /**
     * 
     */
    private boolean esEstafador;

    /**
     * 
     */
    private int advertencias;

    /**
     * 
     */
    private Date fechaBan;

    /**
     *
     */
    private List<Valoracion> valoraciones;

    /**
     *
     */
    private List<Oferta> ofertasNotificadas;


    /**
     * Constructor
     */
    public Cliente(String email, String nick, String contraseña, String nombre, String planetaOrigen, String especie, String numeroIdentificacion) {
        super(email, nick, contraseña);
        this.esPirataEspacial = false;
        this.esEstafador = false;
        this.advertencias = 0;
    }

    /**
     * @return devuelve valoracion media de la lista de valoraciones
     */
    public float getValoracionMedia(List<Valoracion> listVal) {
        float aux = 0.0f;
        if (!listVal.isEmpty()) {
            for (Valoracion val : listVal) {
                aux += val.getValoracion();
            }
            aux /= listVal.size();
        }
        return aux;
    }

    /**
     * @param oferta mete la oferta a la lista de ofertas
     */
    public boolean actualizar(Oferta oferta) {
        if (oferta.isValida()) {
            this.ofertasNotificadas.add(oferta);
            return true;
        } else
            return false;
    }

    /**
     * @param indice posicion de la lista de la que se elimina la oferta
     */
    public void eliminarOfertaNotificada(int indice) {
        try {
            ofertasNotificadas.remove(indice);
        } catch (Exception e) {
            return;
        }
    }

}