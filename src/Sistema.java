
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

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
	private List<Nave> listaNaves = new ArrayList<>();

	/**
	 *
	 */
	private Sistema() throws IOException {

		// Cargamos la lista de Usuarios
		List<Object> aux = gestorUsuarios.leerFichero("Usuarios.data");
		for (Object usuario : aux) {
			listaUsuarios.add((Usuario) usuario);
		}

		// Cargamos la lista de Suscripciones a Cargueros
		aux = gestorNotificaciones.leerFichero("SuscripcionesCargueros.data");
		for (Object nick : aux) {
			listaSusCargueros.add((Cliente) gestorUsuarios.buscarUsuario(listaUsuarios, (String) nick));
		}

		// Cargamos la lista de Suscripciones a Cazas
		aux = gestorNotificaciones.leerFichero("SuscripcionesCazas.data");
		for (Object nick : aux) {
			listaSusCazas.add((Cliente) gestorUsuarios.buscarUsuario(listaUsuarios, (String) nick));
		}

		// Cargamos la lista de Suscripciones a Destructores
		aux = gestorNotificaciones.leerFichero("SuscripcionesDestructores.data");
		for (Object nick : aux) {
			listaSusDestructores.add((Cliente) gestorUsuarios.buscarUsuario(listaUsuarios, (String) nick));
		}

		// Cargamos la lista de Suscripciones a Estaciones Espaciales
		aux = gestorNotificaciones.leerFichero("SuscripcionesEstacionesEspaciales.data");
		for (Object nick : aux) {
			listaSusEstacionesEspaciales.add((Cliente) gestorUsuarios.buscarUsuario(listaUsuarios, (String) nick));
		}

		// Cargamos la lista de Ofertas
		aux = gestorTransacciones.leerFichero("Ofertas.data");
		for (Object oferta : aux) {
			listaOfertas.add((Oferta) oferta);
		}

		// Cargamos la lista de Ofertas por Validar
		aux = gestorTransacciones.leerFichero("OfertasPorValidar.data");
		for (Object oferta : aux) {
			listaOfertasPorValidar.add((Oferta) oferta);
		}

		// Cargamos la lista de Ventas
		aux = gestorTransacciones.leefFichero("Ventas.data");
		for (Object venta : aux) {
			listaVentas.add((Venta) venta);
		}

		// Cargamos la lista de Naves
		aux = gestorNaves.leerFichero("Naves.data");
		for (Object nave : aux) {
			listaNaves.add((Nave) nave);
		}

	}

	public void valorarUsuario(Cliente cliente, Valoracion valoracion) {
		gestorUsuarios.valorarUsuario(cliente, valoracion);
	}

	/**
	 * @return Instancia de sistema
	 */
	public static Sistema getInstance() throws IOException {
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
		// TODO comprobar si es necesario el parámetro booleano de Oferta
		// gestorTransacciones.validarOferta(oferta);
		listaOfertas.add(oferta);
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

	public IGestorUsuarios getGestorUsuarios() {
		return gestorUsuarios;
	}

	public IGestorNotificaciones getGestorNotificaciones() {
		return gestorNotificaciones;
	}

	public IGestorTransacciones getGestorTransacciones() {
		return gestorTransacciones;
	}

	public IGestorNaves getGestorNaves() {
		return gestorNaves;
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
		if (listaSuscriptores != null) {
			gestorNotificaciones.eliminarSuscriptor(clienteActual, listaSuscriptores);
			return true;
		}
		return false;
	}


	public void publicarOferta(Oferta o) {
		listaOfertasPorValidar.add(o);
	}




}






