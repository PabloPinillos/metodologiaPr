import java.io.IOException;

/**
 * Clase que se encarga de controlar a la clase Sistema y comunicarse con el usuario del programa
 */
public class LogicaSis {

	private ControladorIO IO;
	private Sistema sistema;
	private Usuario usuarioActual;

	/**
	 * Método que permite a la clase registrar a un Cliente
	 *
	 * @return null si no se puede crear el usuario
	 */
	private boolean registrarCliente() {
		try {
			String[] datosSignup = IO.pedirSingupCliente();
			if (!sistema.existeEmail(datosSignup[0]) && sistema.buscarUsuario(datosSignup[1]) == null) {
				usuarioActual = sistema.registrarUsuario(datosSignup);
				return true;
			}
			return false;
		} catch (RuntimeException e) {
			IO.pintar(e.getMessage());
			return false;
		}
	}

	/**
	 * Método que permite a la clase registrar a un Administrador
	 */
	private boolean registrarAdministrador() {
		try {
			String[] datosSignup = IO.pedirSingupCliente();
			if (sistema.buscarUsuario(datosSignup[1]) == null) {
				sistema.registrarUsuario(datosSignup);
				return true;
			}
			return false;
		} catch (RuntimeException e) {
			IO.pintar(e.getMessage());
			return false;
		}
	}

	/**
	 * Método que permite la identificación del usuario
	 */
	private boolean identificacionUsuario() throws IOException {
		String[] datosLogin = IO.pedirLogin();
		usuarioActual = sistema.identificacionUsuario(datosLogin);
		return usuarioActual != null;
	}

	/**
	 * Métiodo que permite que los administradores puedan validar una oferta
	 */
	private void verificarOferta() throws IOException {
		Oferta oferta = sistema.getSiguienteOfertaValidar();
		if (oferta != null) {
			mostrarOferta(oferta);
			IO.pintar("¿Desea validar esta oferta?(y/n):");
			char seleccion;
			do {
				seleccion = IO.leerEntrada().toLowerCase().charAt(0);
			} while (seleccion != 'y' && seleccion != 'n');
			if (seleccion == 'y') {
				sistema.validarOferta(oferta);
				IO.pintar("Oferta validada");
			} else {
				IO.pintar("Se mandara un aviso al cliente");
				if (sistema.mandarAdvertencia(oferta.getVendedorOferta())) {
					IO.pintar("El cliente ha sido baneado");
					mostrarUsuario(oferta.getVendedorOferta());
				}
			}
		} else {
			IO.pintar("No quedan ofertas por validar");
		}
	}

	/**
	 * Método para cerrar sesion
	 */
	private void cerrarSesion() {
		usuarioActual = null;
		IO.pintar("Hasta pronto");
	}

	private void marcarUsuario() throws IOException {
		IO.pintar("Introduzca el nick del cliente al que desea marcar");
		Usuario usuario = sistema.buscarUsuario(IO.leerEntrada());
		if (usuario instanceof Cliente) {
			Cliente cliente = (Cliente) usuario;
			String[] datos = new String[4];
			datos[0] = "Nick: " + cliente.getNick();
			datos[1] = "Email: " + cliente.getEmail();
			datos[2] = "Estafador: ";
			datos[3] = "Pirata espacial: ";
			if (cliente.getEsEstafador()) {
				datos[2] += "Si";
			} else {
				datos[2] += "No";
			}
			if (cliente.getEsPirataEspacial()) {
				datos[3] += "Si";
			} else {
				datos[3] += "No";
			}
			IO.pintar(datos);
			IO.pintar("Deseea cambiar el estado de alguna marca de este cliente (y/n):");
			if (IO.leerEntrada().toLowerCase().equals("y")) {
				IO.pintar("Escriba la marca que desea cambiar (Estafador: e, Pirata: p");
				String entrada = IO.leerEntrada().toLowerCase();
				char seleccion = entrada.charAt(0);
				if (seleccion == 'e') {
					sistema.marcarEstafador(cliente);
					IO.pintar("Marcado como estafador");
				} else if (seleccion == 'p') {
					sistema.marcarPirataEspacial(cliente);
					IO.pintar("Marcado como pirata espacial");
				}
			}
		} else {
			IO.pintar("No se puede marcar a un Administrador");
		}
	}

	/**
	 * Método que permite mostrar una oferta
	 */
	private void mostrarOferta(Oferta oferta) {
		mostrarUsuario(oferta.getVendedorOferta());
		for (Nave nave : oferta.getNaves()) {
			mostrarNave(nave);
		}
		String[] datos = new String[2];
		datos[0] = "Fecha limite: " + oferta.getFecha();
		datos[1] = "Precio: " + oferta.getPrecio();
		IO.pintar(datos);
	}

	/**
	 * Método que permite mostrar un usuario (solo nick)
	 */
	private void mostrarUsuario(Usuario usuario) {
		IO.pintar("Nick: " + usuario.getNick());
	}

	private void mostrarNave(Nave nave) {
		// TODO terminar la funcion y a las que llaman
		String[] datosComunes = new String[];
		datosComunes[0] = "Numero de  tripulantes: " + String.valueOf(nave.getNumeroTripulantes());
		datosComunes[1] = "Numero maximo de sistemas de defensa: " + String.valueOf(nave.getMaxSistemasDefensa());
		String[] datosExtra;
		if (nave instanceof Carguero) {
			IO.pintar("Carguero");
			datosExtra = null;
		} else if (nave instanceof Caza) {
			IO.pintar("Caza");
		} else if (nave instanceof Destructor) {
			IO.pintar("Destructor");
		} else if (nave instanceof EstacionEspacial) {
			IO.pintar("Estacion Espacial");
		}
		mostrarSistemasPropulsion(nave);
		IO.pintar(datosComunes);
		mostrarSistemasDefensa(nave);
		if (datosExtra != null) {
			IO.pintar(datosExtra);
		}
	}

	/**
	 * Bucle infinito que ejecuta la lógica general del programa
	 */
	public void ejecutar() {}

}
