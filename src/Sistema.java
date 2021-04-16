
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class Sistema {

	private static Sistema sistema;
	private IGestorUsuarios gestorUsuarios = new GestorUsuarios();
	private IGestorNotificaciones gestorNotificaciones = new GestorNotificaciones();
	private IGestorTransacciones gestorTransacciones = new GestorTransacciones();
	private IGestorNaves gestorNaves;
	private List<Usuario> listaUsuarios = new ArrayList<>();
	private List<Cliente> listaSusEstacionesEspaciales = new ArrayList<>();
	private List<Cliente> listaSusDestructores = new ArrayList<>();
	private List<Cliente> listaSusCazas = new ArrayList<>();
	private List<Cliente> listaSusCargueros = new ArrayList<>();
	private List<Oferta> listaOfertas = new ArrayList<>();
	private List<Oferta> listaOfertasPorValidar = new ArrayList<>();
	private List<Venta> listaVentas = new ArrayList<>();
	private Ficherizador ficherizador = new Ficherizador();

	/**
	 *
	 */
	private Sistema() throws IOException, ClassNotFoundException {
		cargarListasDeFicheros();
	}

	public void cargarListasDeFicheros() throws IOException, ClassNotFoundException {
		// Cargamos la lista de Usuarios
		List<Object> aux = ficherizador.leerFichero("Usuarios.data");
		for (Object usuario : aux) {
			listaUsuarios.add((Usuario) usuario);
		}

		// Cargamos la lista de Suscripciones a Cargueros
		aux = ficherizador.leerFichero("SuscripcionesCargueros.data");
		for (Object cliente : aux) {
			listaSusCargueros.add((Cliente) cliente);
		}

		// Cargamos la lista de Suscripciones a Cazas
		aux = ficherizador.leerFichero("SuscripcionesCazas.data");
		for (Object cliente : aux) {
			listaSusCazas.add((Cliente) cliente);
		}

		// Cargamos la lista de Suscripciones a Destructores
		aux = ficherizador.leerFichero("SuscripcionesDestructores.data");
		for (Object cliente : aux) {
			listaSusDestructores.add((Cliente) cliente);
		}

		// Cargamos la lista de Suscripciones a Estaciones Espaciales
		aux = ficherizador.leerFichero("SuscripcionesEstacionesEspaciales.data");
		for (Object cliente : aux) {
			listaSusEstacionesEspaciales.add((Cliente) cliente);
		}

		// Cargamos la lista de Ofertas
		aux = ficherizador.leerFichero("Ofertas.data");
		for (Object oferta : aux) {
			listaOfertas.add((Oferta) oferta);
		}

		// Cargamos la lista de Ofertas por Validar
		aux = ficherizador.leerFichero("OfertasPorValidar.data");
		for (Object oferta : aux) {
			listaOfertasPorValidar.add((Oferta) oferta);
		}

		// Cargamos la lista de Ventas
		aux = ficherizador.leerFichero("Ventas.data");
		for (Object venta : aux) {
			listaVentas.add((Venta) venta);
		}
	}

	;

	public void valorarUsuario(Cliente cliente, Valoracion valoracion) {
		gestorUsuarios.valorarUsuario(cliente, valoracion);
	}

	public void guardarListasFicheros() throws IOException {
		List<Object> lAux = new ArrayList<>(listaUsuarios);
		ficherizador.escribirFichero("Usuarios.data", lAux);

		lAux = new ArrayList<>(listaSusEstacionesEspaciales);
		ficherizador.escribirFichero("SuscripcionesEstacionesEspaciales.data", lAux);

		lAux = new ArrayList<>(listaSusDestructores);
		ficherizador.escribirFichero("SuscripcionesDestructores.data", lAux);

		lAux = new ArrayList<>(listaSusCazas);
		ficherizador.escribirFichero("SuscripcionesCazas.data", lAux);

		lAux = new ArrayList<>(listaSusCargueros);
		ficherizador.escribirFichero("SuscripcionesCargueros.data", lAux);

		lAux = new ArrayList<>(listaOfertas);
		ficherizador.escribirFichero("Ofertas.data", lAux);

		lAux = new ArrayList<>(listaOfertasPorValidar);
		ficherizador.escribirFichero("OfertasPorValidar.data", lAux);

		lAux = new ArrayList<>(listaVentas);
		ficherizador.escribirFichero("Ventas.data", lAux);
	}

	/**
	 * @return Instancia de sistema
	 */
	public static Sistema getInstance() throws IOException, ClassNotFoundException {
		if (sistema == null) {
			sistema = new Sistema();
		}
		return sistema;
	}


	public List<Oferta> buscarOferta(String tipoNave) {
		return gestorTransacciones.buscarOferta(listaOfertas, tipoNave);
	}


	public boolean mandarAdvertencia(Cliente cliente) {
		return gestorUsuarios.mandarAdvertencia(cliente);
	}

	public void validarOferta(Oferta oferta) {
		gestorTransacciones.validarOferta(oferta);
		listaOfertas.add(oferta);
		if (gestorTransacciones.tieneNaves(oferta, "Carguero")) {
			gestorNotificaciones.notificar(oferta, listaSusCargueros);
		}
		if (gestorTransacciones.tieneNaves(oferta, "Caza")) {
			gestorNotificaciones.notificar(oferta, listaSusCazas);
		}
		if (gestorTransacciones.tieneNaves(oferta, "Destructor")) {
			gestorNotificaciones.notificar(oferta, listaSusDestructores);
		}
		if (gestorTransacciones.tieneNaves(oferta, "EstacionEspacial")) {
			gestorNotificaciones.notificar(oferta, listaSusEstacionesEspaciales);
		}
	}

	/**
	 * Método que permite buscar un usuario por su nick
	 *
	 * @param nick del usuario a buscar
	 */
	public Usuario buscarUsuario(String nick) {
		return gestorUsuarios.buscarUsuario(listaUsuarios, nick);
	}

	/**
	 * Método que permite comprobar si existe algún usuario con el email dado
	 *
	 * @param email
	 * @return boolean: existencia del usuario
	 */
	public boolean existeEmail(String email) {
		return gestorUsuarios.existeEmail(listaUsuarios, email);
	}

	public void crearVenta(Oferta oferta, Cliente comprador) {
		listaVentas.add(gestorTransacciones.crearVenta(oferta, comprador));
	}

	public void eliminarOferta(Oferta oferta) {
		listaOfertas.remove(oferta);
	}

	/**
	 * Método que permite al sistema crear un usuario
	 */
	public Usuario registrarUsuario(String[] datosUsuario) throws RuntimeException {
		Usuario usuario = gestorUsuarios.crearUsuario(datosUsuario);
		listaUsuarios.add(usuario);
		return usuario;
	}

	/**
	 * Método de identificación del usuario
	 */
	public Usuario identificacionUsuario(String[] login) {
		return gestorUsuarios.identificacionUsuario(listaUsuarios, login[0], login[1]);
	}

	public void marcarEstafador(Cliente cliente) {
		gestorUsuarios.marcarEstafador(cliente);
	}

	public void marcarPirataEspacial(Cliente cliente) {
		gestorUsuarios.marcarPirataEspacial(cliente);
	}

	public Oferta getSiguienteOfertaValidar() {
		if (!listaOfertasPorValidar.isEmpty()) {
			Oferta oferta = listaOfertasPorValidar.get(0);
			gestorTransacciones.eliminarOferta(listaOfertasPorValidar, oferta);
			return oferta;
		}
		return null;
	}

	//Notifica al usuario cada vez que hay una oferta nueva del tipo de nave que ha elegido
	public boolean suscribirUsuarioSistema(String naveAux, Cliente clienteActual) {

		List<Cliente> listaSuscriptores = null;


		switch (naveAux) {
			case "EstacionEspacial":
				listaSuscriptores = listaSusEstacionesEspaciales;
				break;
			case "Destructor":
				listaSuscriptores = listaSusDestructores;
				break;
			case "Caza":
				listaSuscriptores = listaSusCazas;
				break;
			case "Carguero":
				listaSuscriptores = listaSusCargueros;
				break;
			default:
				return false;
		}
		if(listaSuscriptores!=null) {
			gestorNotificaciones.añadirSuscriptor(clienteActual, listaSuscriptores);
			return true;
		}
		return false;
	}

	public boolean bajaSuscripcionUsuarioSistema(String naveAux, Cliente clienteActual) {
		List<Cliente> listaSuscriptores = null;

		switch (naveAux) {
			case "EstacionEspacial":
				listaSuscriptores = listaSusEstacionesEspaciales;
				break;
			case "Destructor":
				listaSuscriptores = listaSusDestructores;
				break;
			case "Caza":
				listaSuscriptores = listaSusCazas;
				break;
			case "Carguero":
				listaSuscriptores = listaSusCargueros;
				break;
			default:
				return false;
		}
		if (listaSuscriptores != null && listaSuscriptores.contains(clienteActual)) {
			gestorNotificaciones.eliminarSuscriptor(clienteActual, listaSuscriptores);
			return true;
		}
		return false;
	}


	public Oferta publicarOferta(Cliente cliente, List<Nave> naves, float precio, Date date) {
		Oferta oferta = gestorTransacciones.crearOferta(cliente, naves, precio, date);
		listaOfertasPorValidar.add(oferta);
		return oferta;
	}


	public List<Oferta> getNotificaciones(Cliente cliente) {
		return gestorUsuarios.getNotificaciones(cliente);
	}

	private void seleccionarGestorNaves(String tipoNave) {
		switch (tipoNave) {
			case "Caza":
				gestorNaves = new GestorCazas();
				break;
			case "Carguero":
				gestorNaves = new GestorCargueros();
				break;
			case "Destructor":
				gestorNaves = new GestorDestructores();
				break;
			case "EstacionEspacial":
				gestorNaves = new GestorEstacionesEspaciales();
		}
	}

	public Nave crearNave(String tipoNave, String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa) {
		seleccionarGestorNaves(tipoNave);
		return gestorNaves.crearNave(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa);
	}

	public void setArmasCaza(Caza caza, Arma[] armas) {
		GestorCazas gestor = new GestorCazas();
		gestor.setArmas(caza, armas);
	}

	public void agregarArmaDestructor(Destructor destructor, Arma arma) {
		GestorDestructores gestor = new GestorDestructores();
		gestor.agregarArma(destructor, arma);
	}

	public void setCargaMax(Carguero carguero, float cargaMax) {
		GestorCargueros gestor = new GestorCargueros();
		gestor.setCargaMaxima(carguero, cargaMax);
	}

	public void setMaxPasajeros(EstacionEspacial estacionEspacial, int maxPasajeros) {
		GestorEstacionesEspaciales gestor = new GestorEstacionesEspaciales();
		gestor.setMaximoPasajeros(estacionEspacial, maxPasajeros);
	}

	public void agregarNaveAlHangar(EstacionEspacial estacionEspacial, Nave nave) {
		GestorEstacionesEspaciales gestor = new GestorEstacionesEspaciales();
		gestor.agregarNaveAlHangar(estacionEspacial, nave);
	}

}






