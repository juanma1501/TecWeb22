package edu.uclm.esi.tys2122.chess;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class GestorAjedrez {
	private static GestorAjedrez yo; 
	
	private Hashtable<Integer, Tablero> partidas;
	private Hashtable<String, Jugador> jugadoresConectados;	// Jugadores que están conectados al sistema
	private Vector<Jugador> jugadoresDisponibles;			// Jugadores conectados y disponibles para jugar (no están jugando)
	private int idUltimaPartida = 1;
	
	private GestorAjedrez() {
		partidas = new Hashtable<Integer, Tablero>();
		jugadoresConectados = new Hashtable<String, Jugador>();
		jugadoresDisponibles = new Vector<Jugador>();
		idUltimaPartida = Metodos.getUltimoId()+1;
	} 
	
	public static GestorAjedrez get() {
		if (yo==null)
			yo=new GestorAjedrez();
		return yo;
	}
	
	public Vector<Jugador> getJugadoresConectados() {
		return jugadoresDisponibles;
	}
	
	public void add(Jugador jugador) throws Exception {
		if (this.jugadoresConectados.get(jugador.getName())!=null)
			throw new Exception("El jugador " + jugador.getName() + " ya tiene una sesión abierta");
		this.jugadoresConectados.put(jugador.getName(), jugador);
		this.jugadoresDisponibles.add(jugador);
	} 
	
	public int cerrarSesion(String login) {
		int nValor = -1;
		if (jugadoresConectados.containsKey(login)) {
			// Se desconecta al usuario del sistema
			jugadoresConectados.remove(login);
			jugadoresDisponibles.removeElement(login);
			nValor = 0;
			// Se informa al resto de jugadores de su salida
			Enumeration<Jugador> eJugadores = jugadoresConectados.elements();
			while (eJugadores.hasMoreElements()) {
				
			}
		}
		return nValor;
	}
		
	public void retar(Jugador retador, Jugador retado) {
		retado.retar(retador);
	} 
	
	public void contestarReto(Jugador retado, Jugador retador, boolean aceptacion) {
		if (aceptacion) {  // Reto aceptado
			Tablero partida;
			// Identificador de la partida
			int nId = idUltimaPartida;
			idUltimaPartida++;
			// Se quitan los jugadores de la lista de disponibles
			jugadoresDisponibles.removeElement(retado);
			jugadoresDisponibles.removeElement(retador);
			// Se informa de la nueva lista de jugadores disponibles
			for (int i=0; i<jugadoresDisponibles.size(); i++) {
			}
			// Sorteo de colores y creación de la partida
			if (Math.random() < 0.5) {  // Retador juega con blancas
				partida = new Tablero(nId, retador, retado);
			} else {  // Retador juega con negras
				partida = new Tablero(nId, retado, retador);
			}
			// Almacenamiento temporal de la partida
			partidas.put(nId, partida);
		}
		else {  // Reto rechazado
		}
	} 
	
	
	/**
	 * Gestiona la petición de un movimiento.
	 * @return   Clave indicativa del suceso producido. Puede ser:
	 *          0: el movimiento se ha realizado correctamente
	 *          1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 *          2: estado 0 y la pieza es un pe???n que ha llegado al final del tablero
	 *          3: estados 1 y 2
	 *          4: estado 0 y el movimiento realizado ha sido tomar al paso
	 *          5: estado 0 y el movimiento realizado ha sido el enroque corto
	 *          6: estado 0 y el movimiento realizado ha sido el enroque largo
	 *         1_: estado menor de 10 y se produce jaque al rey contrario
	 *         2_: estado menor de 10 y el jugador actual ha ganado la partida
	 *         3_: estado menor de 10 y se han producido tablas
	 *         -1: no es el turno del jugador actual
	 *         -2: no hay ninguna pieza en el origen
	 *         -3: la pieza de la casilla origen no es del jugador actual
	 *         -4: hay una pieza del jugador actual en la casilla destino
	 *         -5: el movimiento no se corresponde con la pieza del origen
	 *         -6: hay una pieza en medio que impide el movimiento solicitado
	 *         -7: el movimiento dejar???a al rey en jaque
	 */
	public int mover(int nId, char cColor, String sCasillaOrigen, String sCasillaDestino) {
		int [] anCoordenadas = convertirCoordenadas(sCasillaOrigen, sCasillaDestino);
				//[0]=filaOrigen, [1]=columnaOrigen, [2]=filaDestino, [3]=columnaDestino
		Tablero partida = findPartida(nId);
		int nCaso = partida.mover(cColor, anCoordenadas[0], anCoordenadas[1], anCoordenadas[2], anCoordenadas[3], sCasillaOrigen, sCasillaDestino);
		if (nCaso >= 0) {  // El movimiento es v???lido
			//Se almacena el movimiento realizado
			String sMovimiento = "";
			if (nCaso%10 == 0) {  // Movimiento normal
				sMovimiento = sCasillaOrigen+"-"+sCasillaDestino;
			}
			else if (nCaso%10 == 5) {  // Enroque corto
				sMovimiento = "O-O";
			}
			else if (nCaso%10 == 6) {  // Enroque largo
				sMovimiento = "O-O-O";
			}
			else {  // Se ha comido una pieza
				sMovimiento = sCasillaOrigen+"x"+sCasillaDestino;
			}
			if (nCaso/10 == 1) {  // Ha habido jaque
				sMovimiento += " +";
			}
			else if (nCaso/10 == 2) {  // Ha habido jaque mate
				sMovimiento += " ++";
			}
			else {  // Ha habido tablas
			}
			partida.almacenarMovimiento(sMovimiento);
			if ((nCaso/10) > 1) {  // La partida ha terminado
				partida.guardarEnBD();
				// Se actualiza la ventana del servidor
				if (nCaso/10 == 2) {
					if (cColor == Constantes.BLANCO) {
						//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "ha ganado el jugador " + partida.getJugador(Constantes.BLANCO) + " con las blancas");
					}
					else {
						//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "ha ganado el jugador " + partida.getJugador(Constantes.NEGRO) + " con las negras");
					}
				}
				else {  // (nCaso/10 == 3)
					//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "ha habido tablas");
				}
			}
			// Se informa al contrario del movimiento realizado
			Jugador contrario;
			if (cColor == Constantes.BLANCO) {
				contrario = partida.getJugador(Constantes.NEGRO);
			}
			else {
				contrario = partida.getJugador(Constantes.BLANCO);
			}
			Jugador jug = jugadoresConectados.get(contrario);
			//jug.actualizar(nCaso,sCasillaOrigen,sCasillaDestino);
			if ((nCaso/10) > 1) {  // Se devuelven los jugadores a la lista de disponibles
				// Se informa de la nueva lista de jugadores disponibles
				for (int i=0; i<jugadoresDisponibles.size(); i++) {
				//	htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.NEGRO));
				//	htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.BLANCO));
				}
				// Se añaden los jugadores a la lista de disponibles
				jugadoresDisponibles.addElement(partida.getJugador(Constantes.BLANCO));
				jugadoresDisponibles.addElement(partida.getJugador(Constantes.NEGRO));
			}
		}
		return nCaso;
	} /* Fin m???todo mover */
	
	
	/**
	 * Gestiona la conversi???n de un pe???n que ha llegado al final del tablero.
	 * @return   Clave indicativa del suceso producido. Puede ser:
	 *           0: conversi???n realizada sin incidencias
	 *           1: estado 0 y se produce jaque al rey contrario
	 *           2: estado 0 y el jugador actual ha ganado la partida
	 *           3: estado 0 y se han producido tablas
	 */
	public int convertirPeon(int nId, char cColor, char cTipo, int nFila, int nColumna) {
		Tablero partida = findPartida(nId);
		int nCaso = partida.convertirPeon(cTipo);
		if (nCaso > 1) {  // La partida ha terminado
			partida.guardarEnBD();
			// Se actualiza la ventana del servidor
			if (nCaso/10 == 2) {
				if (cColor == Constantes.BLANCO) {
					//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "ha ganado el jugador " + partida.getJugador(Constantes.BLANCO) + " con las blancas");
				}
				else {
					//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "ha ganado el jugador " + partida.getJugador(Constantes.NEGRO) + " con las negras");
				}
			}
			else {  // (nCaso/10 == 3)
				//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "ha habido tablas");
			}
		}
		// Se informa al contrario del cambio realizado
		Jugador contrario = null;
		if (cColor == Constantes.BLANCO) {
			contrario = partida.getJugador(Constantes.NEGRO);
		}
		else {
			contrario = partida.getJugador(Constantes.BLANCO);
		}
		Jugador jug = jugadoresConectados.get(contrario.getName());
		jug.rivalCorono(nFila, nColumna, cTipo);
		if (nCaso > 1) {  // Se devuelven los jugadores a la lista de disponibles
			// Se informa de la nueva lista de jugadores disponibles
			for (int i=0; i<jugadoresDisponibles.size(); i++) {
				//htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.NEGRO));
				//htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.BLANCO));
			}
			// Se a???aden los jugadores a la lista de disponibles
			jugadoresDisponibles.addElement(partida.getJugador(Constantes.BLANCO));
			jugadoresDisponibles.addElement(partida.getJugador(Constantes.NEGRO));
		}
		return nCaso;
	} /* Fin m???todo convertirPeon */
	
	
	/**
	 * Un jugador ha propuesto tablas.
	 * @param nId      Identificador de la partida.
	 * @param cColor   Color del jugador.
	 */
	public void proponerTablas(int nId, char cColor) {
		Tablero partida = findPartida(nId);
		Jugador contrario;
		if (cColor == Constantes.BLANCO) {
			contrario = partida.getJugador(Constantes.NEGRO);
		}
		else {
			contrario = partida.getJugador(Constantes.BLANCO);
		}
		// Se informa al otro jugador de la petición
		Jugador jug = jugadoresConectados.get(contrario);
		jug.proponerTablas();
	} /* Fin m???todo proponerTablas */
	
	
	/**
	 * Recibe la contestaci???n de la propuesta de tablas e informa al jugador,
	 * finalizando la partida si es preciso.
	 * @param nId      Identificador de la partida.
	 * @param cColor   Color del jugador.
	 */
	public void contestarTablas(int nId, char cColor, boolean bRespuesta) {
		Tablero partida = findPartida(nId);
		Jugador contrario;
		if (cColor == Constantes.BLANCO) {
			contrario = partida.getJugador(Constantes.NEGRO);
		}
		else {
			contrario = partida.getJugador(Constantes.BLANCO);
		}
		Jugador jug = jugadoresConectados.get(contrario.getName());
		
		if (bRespuesta) {  //Tablas aceptadas
			// Se almacena la partida
			partida.guardarEnBD();
			// Se actualiza la ventana del servidor
			//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "los jugadores han acordado tablas");
			// Se informa al otro jugador
			//jug.contestarTablas(true);
			// Se informa de la nueva lista de jugadores disponibles
			for (int i=0; i<jugadoresDisponibles.size(); i++) {
				//htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.NEGRO));
			//	htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.BLANCO));
			}
			// Se devuelven los jugadores a la lista de disponibles
			jugadoresDisponibles.addElement(partida.getJugador(Constantes.BLANCO));
			jugadoresDisponibles.addElement(partida.getJugador(Constantes.NEGRO));
		}
		else {  //Tablas rechazadas
			jug.contestarTablas(false);
		}
	} /* Fin m???todo contestarTablas */
	
	
	/**
	 * Un jugador ha solicitado abandonar.
	 * @param nId     Identificador de la partida.
	 * @param cColor  Color del jugador.
	 */
	public void abandonar(int nId, char cColor) {
		Tablero partida = findPartida(nId);
		Jugador contrario;
		if (cColor == Constantes.BLANCO) {
			contrario = partida.getJugador(Constantes.NEGRO);
		}
		else {
			contrario = partida.getJugador(Constantes.BLANCO);
		}
		Jugador jug = jugadoresConectados.get(contrario.getName());
		
		// Se almacena en y la partida
		partida.abandonar(cColor);
		partida.guardarEnBD();
		// Se actualiza la ventana del servidor
		//interfazGUI.a??adeMensaje("Finaliza la partida " + nId + ": " + "el jugador " + partida.getJugador(cColor) + " ha abandonado");
		// Se informa al otro jugador
		jug.mostrarInfoAbandono();
		// Se informa de la nueva lista de jugadores disponibles
		for (int i=0; i<jugadoresDisponibles.size(); i++) {
			//htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.NEGRO));
			//htJugadoresConectados.get(jugadoresDisponibles.get(i)).mostrarJugadorNuevo(partida.getJugador(Constantes.BLANCO));
		}
		// Se devuelven los jugadores a la lista de disponibles
		jugadoresDisponibles.addElement(partida.getJugador(Constantes.BLANCO));
		jugadoresDisponibles.addElement(partida.getJugador(Constantes.NEGRO));
	} /* Fin m???todo abandonar */
	
	
	/**
	 * Busca la partida que se solicita.
	 * @param nId   Identificador de la partida.
	 * @return      Partida correspondiente al identificador.
	 */
	protected Tablero findPartida(int nId) {
		return partidas.get(nId);
	} /* Fin m???todo findPartida */
	
	
	/**
	 * Convierte las coordenadas reales (letra-número) a sólo numéricas.
	 */
	protected static int[] convertirCoordenadas(String sCasilla1, String sCasilla2) {
		int [] anCoordenadas = new int[4];
		
		//[0]=filaOrigen, [1]=columnaOrigen, [2]=filaDestino, [3]=columnaDestino
		if (sCasilla1.substring(0,1).equals("a")) {
			anCoordenadas[1] = 8;
		}
		else if (sCasilla1.substring(0,1).equals("b")) {
			anCoordenadas[1] = 7;
		}
		else if (sCasilla1.substring(0,1).equals("c")) {
			anCoordenadas[1] = 6;
		}
		else if (sCasilla1.substring(0,1).equals("d")) {
			anCoordenadas[1] = 5;
		}
		else if (sCasilla1.substring(0,1).equals("e")) {
			anCoordenadas[1] = 4;
		}
		else if (sCasilla1.substring(0,1).equals("f")) {
			anCoordenadas[1] = 3;
		}
		else if (sCasilla1.substring(0,1).equals("g")) {
			anCoordenadas[1] = 2;
		}
		else if (sCasilla1.substring(0,1).equals("h")) {
			anCoordenadas[1] = 1;
		}
		anCoordenadas[0] = Integer.parseInt(sCasilla1.substring(1,2));
		if (sCasilla2.substring(0,1).equals("a")) {
			anCoordenadas[3] = 8;
		}
		else if (sCasilla2.substring(0,1).equals("b")) {
			anCoordenadas[3] = 7;
		}
		else if (sCasilla2.substring(0,1).equals("c")) {
			anCoordenadas[3] = 6;
		}
		else if (sCasilla2.substring(0,1).equals("d")) {
			anCoordenadas[3] = 5;
		}
		else if (sCasilla2.substring(0,1).equals("e")) {
			anCoordenadas[3] = 4;
		}
		else if (sCasilla2.substring(0,1).equals("f")) {
			anCoordenadas[3] = 3;
		}
		else if (sCasilla2.substring(0,1).equals("g")) {
			anCoordenadas[3] = 2;
		}
		else if (sCasilla2.substring(0,1).equals("h")) {
			anCoordenadas[3] = 1;
		}
		anCoordenadas[2] = Integer.parseInt(sCasilla2.substring(1,2));
		return anCoordenadas;
	}

	public Tablero getTablero(int id) {
		return this.partidas.get(id);
	}

	public void setJugador(int idTablero, Jugador jugador, char color) {
		Tablero t=this.partidas.get(idTablero);
		t.setJugador(color, jugador);
	} 
	
} 
