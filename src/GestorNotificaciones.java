
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GestorNotificaciones implements IGestorNotificaciones {

	public void notificar(Oferta oferta, List<Cliente> listaSuscriptores) {
		for (Cliente suscriptor : listaSuscriptores) {
			suscriptor.actualizar(oferta);
		}
	}


	public void añadirSuscriptor(Cliente suscriptor, List<Cliente> listaSuscriptores) {
		listaSuscriptores.add(suscriptor);
	}

	public void eliminarSuscriptor(Cliente suscriptor, List<Cliente> listaSuscriptores) {
		if (listaSuscriptores.contains(suscriptor)) {
			listaSuscriptores.remove(suscriptor);
		}
	}

	public List<Object> leerFichero(String fileName) throws IOException {
		List<Object> outputList = new ArrayList<>();
		BufferedReader fileBuffer = new BufferedReader(new FileReader(fileName));
		String aux = "";
		while ((aux = fileBuffer.readLine()) != null && aux.length() != 0) {
			outputList.add(aux);
		}
		fileBuffer.close();
		return outputList;
	}

	public void escribirFichero(String fileName, List<Object> list) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		for (Object suscriptor : list) {
			Cliente aux = (Cliente) suscriptor;
			fileWriter.write(aux.getNick() + "\n");
		}
		fileWriter.close();
	}

}

