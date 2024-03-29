import java.io.Serializable;

/**
 *
 */
public class Valoracion implements Serializable {

    private Cliente comprador;
    private int valoracion;
    private String comentario;

    public Valoracion(Cliente comprador, int valoracion, String comentario) {
        this.comentario = comentario;
        this.valoracion = valoracion;
        this.comprador = comprador;
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
    public int getValoracion() {
        return valoracion;
    }


    public String getComentario() {
        return comentario;
    }


    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}