
import java.io.IOException;
import java.util.*;

/**
 * 
 */
public interface GestorFicheros {

    /**
     * @param fileName: nombre del fichero
     * @param data: lista de objetos a escribir
     */
    void escribirFichero(String fileName, List<Object> data) throws IOException;

    /**
     * @param fileName: nombre del fichero
     * @return lista de objetos a recuperar
     */
    List<Object> leerFichero(String fileName) throws IOException;

}
