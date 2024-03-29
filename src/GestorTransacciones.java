
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class GestorTransacciones implements IGestorTransacciones{

    /**
     * Default constructor
     */
    public GestorTransacciones() {
    }


    public Oferta crearOferta(Cliente ofertante, List<Nave> naves, float precio, Date fechaPuestaAlaVenta) {
        Oferta ofert = new Oferta(ofertante, naves, precio, fechaPuestaAlaVenta);
        //escribirFichero(listaOfertasPorValidar, this.ofert);
        return ofert;
    }


    public Venta crearVenta(Cliente ofertante, Cliente comprador, float precio, Date fechaCompra) {
        Venta vent = new Venta(ofertante, comprador, precio, fechaCompra);
        //Tenemos que eliminar la oferta que corresponde a la venta
        //Tenemos que añadir la venta al registro de naves vendidas
        return vent;
    }

    public Venta crearVenta(Oferta ofert, Cliente comprador){
        Venta vent = new Venta(ofert, comprador);
        return vent;
    }


    @Override //Debemos escribir en el fichero ofertasPorValidar la oferta creada para que un administrador la pueda checar
    public void escribirFichero(String fileName, List<Object> data) throws IOException {
//        FileWriter fileWriter = new FileWriter(fileName);
//        for(Object ofert: data) {
//            Oferta aux = (Oferta) ofert;
//            fileWriter.write(aux + "\n");
//        }
//        fileWriter.close();

    }

    @Override
    public List<Object> leerFichero(String fileName) throws IOException {
        // TODO
        return new ArrayList<>();
    }

    public void validarOferta(Oferta oferta) {
        oferta.setValida(true);
    }

    public boolean tieneNaves(Oferta oferta, String tipoNave) {
        GestorEstacionesEspaciales gestor = new GestorEstacionesEspaciales();
        for (Nave nave : oferta.getNaves()) {
            if ((tipoNave.equals("Carguero") && nave instanceof Carguero) || (tipoNave.equals("Caza") && nave instanceof Caza) || (tipoNave.equals("Destructor") && nave instanceof Destructor) || (tipoNave.equals("EstacionEspacial") && nave instanceof EstacionEspacial) || (nave instanceof EstacionEspacial && gestor.tieneNaves((EstacionEspacial) nave, tipoNave))) {
                return true;
            }
        }
        return false;
    }

    public List<Oferta> buscarOferta(List<Oferta> listaOfertas, String tipoNave) {
        List<Oferta> ofertasSeleccionadas = new ArrayList<>();
        for (Oferta oferta : listaOfertas) {
            if (tieneNaves(oferta, tipoNave)) {
                ofertasSeleccionadas.add(oferta);
            }
        }
        return ofertasSeleccionadas;
    }

    public void eliminarOferta(List<Oferta> lo, Oferta o){
        if (lo.contains(o)) {
            lo.remove(o);
        }
    }

}
