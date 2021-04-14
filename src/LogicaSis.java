
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Clase que se encarga de controlar a la clase Sistema y comunicarse con el usuario del programa
 */
public class LogicaSis {

    private ControladorIO IO;
    private Sistema sistema;
    private Usuario usuarioActual;

    private void valorarUsuario() throws IOException {
        Valoracion valoracion;
        IO.pintar("Introduzca el nick del cliente al que desea valorar");
        Usuario usuario = sistema.buscarUsuario(IO.leerEntrada());
        if (usuario instanceof Cliente) {
            IO.pintar("Indica la valoración (1 - 5)");
            String entrada = IO.leerEntrada();
            try {
                int entradaInt = Integer.parseInt(entrada);
                if (entradaInt >= 1 && entradaInt <= 5)
                    IO.pintar("El valor introducido no cumple los requisitos");
                else {
                    IO.pintar("Introduzca ahora el comentario: ");
                    String coment = IO.leerEntrada();
                    valoracion = new Valoracion((Cliente) usuario, entradaInt, coment);
                    IO.pintar("Valoracion completada");
                }
            } catch (Exception e) {
                IO.pintar("El valor introducido no cumple los requisitos");
            }
        } else {
            IO.pintar("Ese usuario no existe");
        }
    }


    //publicarOferta es CrearOferta
    private void publicarOferta() throws IOException {
        IO.pintar("*** DATOS PERSONALES ***");

        //dueño = cliente loggeado

        IO.pintar("Introduzca precio de la oferta");
        String precioOferta = IO.leerEntrada();
        precioOferta = Float.toString(25.0f);

        IO.pintar("Introduzca la fecha de caducidad de la oferta");
        //Formato 'DD/MM/YYYY'
        String[] fechaOf = IO.leerEntrada().strip().split("/");
        Calendar gCal = new GregorianCalendar(Integer.valueOf(entrada[2]), Integer.valueOf(entrada[1]) - 1, Integer.valueOf(entrada[0]));
        Date date = gCal.getTime();


        IO.pintar("*** DATOS NAVES ***");

        IO.pintar("¿Cuantas naves va a tener la oferta?");
        String num = IO.leerEntrada();
        int numNaves = Integer.parseInt(num);
        List<Nave> listaNaves = new ArrayList<>();
        for (int i = 0; i<numNaves; i++){
            IO.pintar("Nave" + i);
            IO.pintar("Introduzca Nº de registro de la nave");
            String numNavesRegistro = IO.leerEntrada();

            //propietario = ofertante

            //Sistema de propulsion
                IO.pintar("¿Cuantos sistemas de propulsión tiene esta nave?");
                String SisProp = IO.leerEntrada();
                int numSisProp = Integer.parseInt(SisProp);
                if(numSisProp<1 || numSisProp>2){
                    IO.pintar("La nave solo puede tener entre 1 y 2 sistemas de propulsión" +
                            "Introduzca de nuevo el número");
                    SisProp = IO.leerEntrada();
                    numSisProp = Integer.parseInt(SisProp);
                }
                SistemaPropulsion[] sistemasPropulsion = new SistemaPropulsion[numSisProp];
                for (int j = 0; j<numSisProp; j++){
                    SistemaPropulsion propul = sistema.getGestorNaves().agregarSistemaPropulsion();
                    sistemasPropulsion[j] = propul;
                }

            //Numero de tripulantes
            String ntrip = IO.leerEntrada();
            int numtripulantes = Integer.parseInt(ntrip);

            //Sistemas de defensa


            //máximo sistemas de defensa
            String nsistdef = IO.leerEntrada();
            int numMaxSistDefensa = Integer.parseInt(nsistdef); /

            Nave nave = sistema.getGestorNaves().crearNave(numNavesRegistro, dueño, sistemasPropulsion, numtripulantes, sistemasdefensa, numMaxSistDefensa);
            //Meter nave en la lista listaNaves
        }

        Oferta ofert = sistema.getGestorTransacciones().crearOferta(ofertante, listaNaves, precioOferta, fechaOf);



    }


	/**
	 * Método que muestra las operaciones disponibles para el administrador
	 */
	private void mostrarOpcionesAdministrador() {
		// TODO repasar que el administrador tenga todas sus funcionalidades
		String[] opciones = new String[5];
		opciones[0] = "Escoja una opcion:";
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
    private boolean registrarCliente() throws IOException {
        try {
            String[] datosSignup = pedirSingupCliente();
            if (datosSignup != null && !sistema.existeEmail(datosSignup[0]) && sistema.buscarUsuario(datosSignup[1]) == null) {
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
    private boolean registrarAdministrador() throws IOException {
        try {
            String[] datosSignup = pedirSingupCliente();
            if (datosSignup != null && !sistema.existeEmail(datosSignup[0]) && sistema.buscarUsuario(datosSignup[1]) == null) {
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
        String[] datosLogin = pedirLogin();
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
        mostrarUsuario(oferta.getVendedorOferta());
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
        String[] datosExtra = null;
        if (nave instanceof Carguero) {
            IO.pintar("Carguero");
            Carguero c = (Carguero) nave;
            datosExtra = new String[1];
            datosExtra[0] = "Carga maxima: " + String.valueOf(c.getCargaMaxima());
        } else if (nave instanceof Caza) {
            IO.pintar("Caza");
            Caza c = (Caza) nave;
            datosExtra = new String[1];
            datosExtra[0] = "Potencia total de sus armas: " + String.valueOf(c.getTotalPotenciaArmas());
        } else if (nave instanceof Destructor) {
            IO.pintar("Destructor");
            Destructor c = (Destructor) nave;
            datosExtra = new String[1];
            datosExtra[0] = "Potencia total de sus armas: " + String.valueOf(c.getTotalPotenciaArmas());
        } else if (nave instanceof EstacionEspacial) {
            IO.pintar("Estacion Espacial");
            EstacionEspacial c = (EstacionEspacial) nave;
            datosExtra = new String[2];
            datosExtra[0] = "Número máximo de pasajeros: " + String.valueOf(c.getMaxPasajeros());
            datosExtra[1] = "Naves que tiene la estación: ";
            int i = 1;
            for (Nave nAux : c.getHangar()) {
                IO.pintar("Nave nº " + i + " del hangar:");
                mostrarNave(nAux);
            }

        }
        mostrarSistemasPropulsion(nave);
        IO.escribirTerminal(datosComunes);
        mostrarSistemasDefensa(nave);
        if (datosExtra != null) {
            IO.escribirTerminal(datosExtra);
        }
    }

    /**
     * Bucle infinito que ejecuta la lógica general del programa
     */
    public void ejecutar() throws IOException {
        char seleccion = 'L';
        do {
            mostrarMenuInicio();
            String aux = IO.leerEntrada().toUpperCase();
            if (aux.length() > 0) {
                seleccion = aux.charAt(0);
            }
            if ((seleccion == 'L' && identificacionUsuario()) || (seleccion == 'R' && registrarCliente())) {
                do {
                    if (usuarioActual instanceof Cliente) {
                        mostrarOpcionesCliente();
                        aux = IO.leerEntrada().toLowerCase();
                        if (aux.length() > 0) {
                            seleccion = aux.charAt(0);
                        }
                        switch (seleccion) {
                            case 'a':
                                buscarOferta();
                                break;
                            case 'b':
                                // Metodo comprobacion notificaciones
                                break;
                            case 'c':
                                publicarOferta();
                                break;
                            case 'd':
                                suscribirUsuario();
                                break;
                            case 'e':
                                bajaSuscripcionUsuario();
                                break;
                        }
                    } else if (usuarioActual instanceof Administrador) {
                        mostrarOpcionesAdministrador();
                        aux = IO.leerEntrada().toLowerCase();
                        if (aux.length() > 0) {
                            seleccion = aux.charAt(0);
                        }
                        switch (seleccion) {
                            case 'a':
                                registrarAdministrador();
                                break;
                            case 'b':
                                verificarOferta();
                                break;
                            case 'c':
                                marcarUsuario();
                                break;
                        }
                    }
                    if (seleccion != 'x') {
                        IO.pintar("¿Desea realizar mas operaciones?(x para salir)");
                        aux = IO.leerEntrada().toLowerCase();
                        if (aux.length() > 0) {
                            seleccion = aux.charAt(0);
                        }
                    }
                } while (seleccion != 'x');
            }
            if (seleccion == 'x') {
                cerrarSesion();
            }
        } while (seleccion != 'X');
    }

    private void mostrarMenuInicio() {
        IO.pintar("L -> LogIn");
        IO.pintar("R -> Registrarse");
        IO.pintar("X -> Cerrar Aplicacion");
        IO.pintar("Escoja una opcion:");
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

            List<Oferta> listOfertaAux = this.sistema.buscarOferta(naveAux);
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
            if (respuesta.trim().equals("1")) {
                IO.pintar("Elija por número la oferta que desea comprar: ");
                respuesta = IO.leerEntrada();
                try {
                    int indiceUsuario = Integer.parseInt(respuesta);
                    comprarOferta(arrayOfertasAux[indiceUsuario - 1]);
                } catch (Exception e) {
                    IO.pintar("Entrada no válida...");
                }
            } else {
                IO.pintar("De acuerdo, saliendo de la compra...");
            }
        }
    }

    private void comprarOferta(Oferta of) {
        sistema.getGestorTransacciones().crearVenta(of, (Cliente) usuarioActual);
        sistema.getGestorTransacciones().eliminarOferta(sistema.getOfertas(), of);
        IO.pintar("Venta realizada correctamente");
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
        String email = IO.leerEntrada();
        if (Pattern.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$", email)) {
            ls.add(email);
        } else {
            IO.pintar("Por favor, introduzca un email valido");
            return null;
        }
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


    public void suscribirUsuario() throws IOException {
        if (usuarioActual instanceof Cliente) {
            String opcionElegida;
            String[] opciones = new String[5];
            opciones[0] = "Elija una opción a la que suscribirse";
            opciones[1] = "A) Caza";
            opciones[2] = "B) Destructor";
            opciones[3] = "C) Carguero";
            opciones[4] = "D) Estación espacial";
            IO.escribirTerminal(opciones);
            opcionElegida = IO.leerEntrada();

            String naveAux = null;

            switch (opcionElegida) {
                case "D":
                    naveAux = "EstacionEspacial";
                    break;
                case "B":
                    naveAux = "Destructor";
                    break;
                case "A":
                    naveAux = "Caza";
                    break;
                case "C":
                    naveAux = "Carguero";
                    break;
                default:
                    IO.pintar("No ha seleccionado una opción válida...");
            }
            Cliente clienteActual = (Cliente) usuarioActual;
            if (sistema.suscribirUsuarioSistema(naveAux, clienteActual)) {
                IO.pintar("Te has suscrito con éxito");
            } else {
                IO.pintar("No ha seleccionado una opción válida...");
            }
        }

    }


    public void bajaSuscripcionUsuario() throws IOException {
        if (usuarioActual instanceof Cliente) {
            String opcionElegida;
            String[] opciones = new String[5];
            opciones[0] = "Elija una opción a la que desuscribirse";
            opciones[1] = "A) Caza";
            opciones[2] = "B) Destructor";
            opciones[3] = "C) Carguero";
            opciones[4] = "D) Estación espacial";
            IO.escribirTerminal(opciones);
            opcionElegida = IO.leerEntrada();

            String naveAux = null;

            switch (opcionElegida) {
                case "D":
                    naveAux = "EstacionEspacial";
                    break;
                case "B":
                    naveAux = "Destructor";
                    break;
                case "A":
                    naveAux = "Caza";
                    break;
                case "C":
                    naveAux = "Carguero";
                    break;
                default:
                    IO.pintar("No ha seleccionado una opción válida...");
            }
            Cliente clienteActual = (Cliente) usuarioActual;
            if (sistema.bajaSuscripcionUsuarioSistema(naveAux, clienteActual)) {
                IO.pintar("Te has desuscrito con éxito");
            } else {
                IO.pintar("No ha seleccionado una opción válida...");
            }
        }
    }

    public void mostrarOpcionesCliente(){
        String[] opciones = new String[7];
        opciones[0] = "Escoja una opción";
        opciones[1] = "A) Buscar Oferta";
        opciones[2] = "B) Mirar notificaciones";
        opciones[3] = "C) Subir oferta";
        opciones[4] = "D) Suscribirse a un tipo de nave";
        opciones[5] = "E) Desuscribirse a un tipo de nave";
        opciones[6] = "x) Cerrar sesión";
    }

}
