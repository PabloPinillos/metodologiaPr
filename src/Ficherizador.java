import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ficherizador {

    public Ficherizador() {
    }

    ;

    /**
     * @param fileName: nombre del fichero
     * @param data:     lista de objetos a escribir
     */
    void escribirFichero(String fileName, List<Object> data) throws IOException {
        ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(fileName, false));
        escribiendoFichero.writeObject(data);
        escribiendoFichero.close();
    }

    /**
     * @param fileName: nombre del fichero
     * @return lista de objetos a recuperar
     */
    List<Object> leerFichero(String fileName) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(fileName));
            List<Object> lista = (ArrayList<Object>) leyendoFichero.readObject();
            leyendoFichero.close();
            return lista;
        } catch (FileNotFoundException e) {
            File file = new File(fileName);
            return new ArrayList<>();
        }

    }

}