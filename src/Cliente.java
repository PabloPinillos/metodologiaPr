
import java.io.Serializable;
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
        this.nombre = nombre;
        this.planetaOrigen = planetaOrigen;
        this.especie = especie;
        this.numeroIdentificacion = numeroIdentificacion;
        this.esPirataEspacial = false;
        this.esEstafador = false;
        this.advertencias = 0;
        this.fechaBan = new Date();
        valoraciones = new ArrayList<>();
        ofertasNotificadas = new ArrayList<>();
    }

    /**
     * @return devuelve valoracion media de la lista de valoraciones
     */
    public float getValoracionMedia() {
        float aux = 0.0f;
        if (!valoraciones.isEmpty()) {
            for (Valoracion val : valoraciones) {
                aux += val.getValoracion();
            }
            aux /= valoraciones.size();
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

    public void addValoracion(Valoracion val) {
        valoraciones.add(val);
    }

    ;

    public int getAdvertencias() {
        return advertencias;
    }

    public void sumarAdvertencia() {
        this.advertencias++;
    }

    public void setAdvertenciasCero() {
        this.advertencias = 0;
    }

    public boolean getEsPirataEspacial() {
        return esPirataEspacial;
    }

    public void setEsPirataEspacial(boolean esPirataEspacial) {
        this.esPirataEspacial = esPirataEspacial;
    }

    public boolean getEsEstafador() {
        return esEstafador;
    }

    public void setEsEstafador(boolean esEstafador) {
        this.esEstafador = esEstafador;
    }

    public void setFechaBan() {
        Date aux = new Date();
        this.fechaBan = new Date(aux.getTime() + 432000000L); //suma 5 dias en milisegundos al dia de hoy
    }

    public Date getFechaBan() {
        return fechaBan;
    }

    public List<Oferta> getNotificaciones() {
        return ofertasNotificadas;
    }
}