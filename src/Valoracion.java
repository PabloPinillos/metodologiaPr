

/**
 *
 */
public class Valoracion {


    private Cliente comprador;
    private int valoracion;
    private String comentario;
    private IGestorUsuarios gestorUsuarios = new GestorUsuarios();



    public void Valoracion(Cliente comprador, int valoracion, String comentario) {
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


    public void setValoracion(Cliente valoracion) {
        gestorUsuarios.setValoracion(valoracion);
    }

    public void setComentario(Cliente comentario) {
        gestorUsuarios.setComentario(comentario);
    }

}