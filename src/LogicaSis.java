
import java.io.IOException;
import java.util.*;

/**
 * Clase que se encarga de controlar a la clase Sistema y comunicarse con el usuario del programa
 */
public class LogicaSis {

	private ControladorIO IO;
	private Sistema sistema;
	private Usuario usuarioActual;

	/**
	 * Método que muestra las operaciones disponibles para el administrador
	 */
	private void mostrarOpcionesAdministrador() {
		// TODO repasar que el administrador tenga todas sus funcionalidades
		String[] opciones = new String[5];
		opciones[0] = "Escoja una opcion:"
		opciones[1] = "A) Registrar Administrador";
		opciones[2] = "B) Validar Oferta";
		opciones[3] = "C) Marcar Usuario";
		opciones[4] = "X) Cerrar Sesion";
		IO.escribirTerminal(opciones);
	}

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
			IO.escribirTerminal(datos);
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
        mostrarUsuario(oferta.getOfertante());
        for (Nave nave : oferta.getNaves()) {
            mostrarNave(nave);
        }
        String[] datos = new String[2];
        datos[0] = "Fecha limite: " + oferta.getFecha();
        datos[1] = "Precio: " + oferta.getPrecio();
        IO.escribirTerminal(datos);
    }

    /**
     * Método que permite mostrar un usuario (solo nick)
     */
    private void mostrarUsuario(Usuario usuario) {
        IO.pintar("Nick: " + usuario.getNick());
    }

    private void mostrarNave(Nave nave) {
        String[] datosComunes = new String[2];
        datosComunes[0] = "Numero de  tripulantes: " + String.valueOf(nave.getNumeroTripulantes());
        datosComunes[1] = "Numero maximo de sistemas de defensa: " + String.valueOf(nave.getMaxSistemasDefensa());
//        String[] datosExtra = new String[0];
        if (nave instanceof Carguero) {
            IO.pintar("Carguero");
//            datosExtra = null;
        } else if (nave instanceof Caza) {
            IO.pintar("Caza");
        } else if (nave instanceof Destructor) {
            IO.pintar("Destructor");
        } else if (nave instanceof EstacionEspacial) {
            IO.pintar("Estacion Espacial");
        }
        mostrarSistemasPropulsion(nave);
        IO.escribirTerminal(datosComunes);
        mostrarSistemasDefensa(nave);
//        if(datosExtra != null) {
//            IO.escribirTerminal(datosExtra);
//        }
    }

    /**
     * Bucle infinito que ejecuta la lógica general del programa
     */
    public void ejecutar() {
    }

    public void pintarOpcionesCliente() {
        //TODO
        System.out.println("Opciones cliente:");
        System.out.println("1 - ...");
        System.out.println("2 - ...");

    }

    private void pintarOpcionesAdministrador() {
        //TODO
        IO.pintar("Opciones administrador:");
        IO.pintar("1 - ...");
        IO.pintar("2 - ...");
    }

    private void buscarOferta() throws IOException {
        String[] texto = new String[5];
        texto[0] = "Elija el tipo de nave de la que desea revisar las ofertas";
        texto[1] = "1- Estación Espacial";
        texto[2] = "2- Destructor";
        texto[3] = "3- Caza";
        texto[4] = "4- Carguero";
        IO.escribirTerminal(texto);
        String respuesta = IO.leerEntrada();

        String naveAux = null; //El string se pone al que decidamos para cada nave
        switch (respuesta) {
            case "1":
                naveAux = "EstacionEspacial";
                break;
            case "2":
                naveAux = "Destructor";
                break;
            case "3":
                naveAux = "Caza";
                break;
            case "4":
                naveAux = "Carguero";
                break;
            default:
                IO.pintar("No ha seleccionado una opción válida...");
        }

        //Llamar al buscador de ofertas del gestor de transacciones y pintarlas
        if (naveAux != null) {

            List<Oferta> listOfertaAux = this.sistema.getGestorTransacciones().buscarOferta(sistema.getListaNaves(), naveAux);
            int i = 1;
            Oferta[] arrayOfertasAux = new Oferta[listOfertaAux.size()];
            for (Oferta ofer : listOfertaAux) {
                IO.pintar(i + "-");
                mostrarOferta(ofer);
                arrayOfertasAux[i - 1] = ofer;
                i++;
            }
            IO.pintar("¿Desea realizar una compra? (escriba 1 para comprar, cualquier otra cosa para cancelar)");
            respuesta = IO.leerEntrada();
            if (respuesta.trim() == "1") {
                IO.pintar("Elija por número la oferta que desea comprar: ");
                respuesta = IO.leerEntrada();
                try {
                    int indiceUsuario = Integer.parseInt(respuesta);
                    sistema.getGestorTransacciones().crearVenta(arrayOfertasAux[indiceUsuario - 1], (Cliente) usuarioActual);
                    sistema.getGestorTransacciones().eliminarOferta(sistema.getOfertas(), arrayOfertasAux[indiceUsuario - 1]);
                    IO.pintar("Venta realizada correctamente");
                } catch (Exception e) {
                    IO.pintar("Entrada no válida...");
                }
            } else {
                IO.pintar("De acuerdo, saliendo de la compra...");
            }
        }

    }

    private void mostrarSistemasPropulsion(Nave nave) {
        SistemaPropulsion[] sisProp = nave.getSistemasPropulsion();
        IO.pintar("Sistemas de propulsion: ");
        IO.pintar(sisProp[0].getTipo());
        if (sisProp[1] != null)
            IO.pintar(sisProp[1].getTipo());
    }

    private void mostrarSistemasDefensa(Nave nave) {
        SistemaDefensa[] sisDef = nave.getSistemasDefensa();
        IO.pintar("Sistemas de defensa: ");
        IO.pintar(sisDef[0].getTipo());
        if (sisDef[1] != null)
            IO.pintar(sisDef[1].getTipo());
        if (sisDef[2] != null)
            IO.pintar(sisDef[2].getTipo());
    }

    public String[] pedirLogin() throws IOException {
        String[] login = new String[2];
        IO.pintar("Introduzca su usuario");
        login[0] = IO.leerEntrada();
        IO.pintar("Introduzca su contraseña");
        login[1] = IO.leerEntrada();
        return login;
    }

    public String[] pedirSingupCliente() throws IOException {
        List<String> ls = new ArrayList<>();
        IO.pintar("Introduzca su email");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su nombre de usuario");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su contraseña");
        ls.add(IO.leerEntrada());
        return (String[]) ls.toArray();
    }

    public String[] pedirSingupAdministrador() throws IOException {
        List<String> ls = new ArrayList<>();
        IO.pintar("Introduzca su email");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su nombre de usuario");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su contraseña");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su nombre");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su planeta de origen");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su especie");
        ls.add(IO.leerEntrada());
        IO.pintar("Introduzca su número de identificación intergaláctico");
        ls.add(IO.leerEntrada());
        return (String[]) ls.toArray();
    }


}
