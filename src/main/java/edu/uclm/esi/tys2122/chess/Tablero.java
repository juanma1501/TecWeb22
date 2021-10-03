package edu.uclm.esi.tys2122.chess;

import java.util.Vector;

public class Tablero {
	private Jugador jugadorBlancas;
	private Jugador jugadorNegras;
	private Jugador ganador;

	private Pieza [][] aapTablero = new Pieza[8][8];
	private Vector<String> movimientos = new Vector<String>();
	private char cTurnoJugador = Constantes.BLANCO;
	private Pieza [] apBlancas = new Pieza[16];
	private Pieza [] apNegras = new Pieza[16];

	// Ordenación de las piezas: primero la fila de los peones y después 
	// las demás piezas; por tanto, los peones van del 0 al 7, y el resto son:
	public static final int fnTorre1 = 8;
	public static final int fnTorre2 = 9;
	public static final int fnCaballo1 = 10;
	public static final int fnCaballo2 = 11;
	public static final int fnAlfil1 = 12;
	public static final int fnAlfil2 = 13;
	public static final int fnDama = 14;
	public static final int fnRey = 15;
	
	public Tablero(int nId, Jugador jugadorBlancas, Jugador jugadorNegras) {
		this.jugadorBlancas = jugadorBlancas;
		this.jugadorNegras = jugadorNegras;
		nuevaPartida();
	} 
	
	
	public Jugador getJugador(char cColor) {
		if (cColor == Constantes.BLANCO) {
			return jugadorBlancas;
		} else {
			return jugadorNegras;
		}
	}

	public Jugador getGanador() {
		return ganador;
	}
	
	protected void setGanador(char cColor) {
		if (cColor == Constantes.BLANCO) {
			ganador=jugadorBlancas;
		}
		else if (cColor == Constantes.NEGRO) {
			ganador=jugadorNegras;
		}
		else {  //Tablas
			ganador = null;
		}
	} 
	
	public void abandonar(char cColor) {
		if (cColor == Constantes.BLANCO) {
			setGanador(Constantes.BLANCO);
		}
		else if (cColor == Constantes.NEGRO) {
			setGanador(Constantes.NEGRO);
		}
	} 
	
	public Pieza[][] getTablero() {
		return aapTablero;
	}
	
	public Vector<String> getMovimientos() {
		return movimientos;
	} 
	
	
	/**
	 * Devuelve los movimientos realizados en forma de cadena.
	 */
	public String getMovimientosAsString() {
		String result="";
		for (String s : movimientos)
			result+=s + "\n";
		return result;
	}
		
	public char getColorDelJugadorConElTurno() {
		return cTurnoJugador;
	} 
	
	public void setColorDelJugadorConElTurno(char cTurno) {
		cTurnoJugador = cTurno;
	} 
	
	public char getColorDelJugadorSinElTurno() {
		if (getColorDelJugadorConElTurno() == Constantes.BLANCO) {
			return Constantes.NEGRO;
		}
		else {
			return Constantes.BLANCO;
		}
	}	
	
	/**
	 * Devuelve las piezas blancas.
	 */
	public Pieza[] getBlancas() {
		return apBlancas;
	}
		
	/**
	 * Devuelve las piezas negras.
	 */
	public Pieza[] getNegras() {
		return apNegras;
	}
	
	/**
	 * Devuelve la fila que ocupa el rey indicado.
	 */
	public int getFilaRey(char cColor) {
		if (cColor == Constantes.BLANCO) {
			return apBlancas[fnRey].getFila();
		}
		else {
			return apNegras[fnRey].getFila();
		}
	} 
	
	/**
	 * Devuelve la columna que ocupa el rey indicado.
	 */
	public int getColumnaRey(char cColor) {
		if (cColor==Constantes.BLANCO) {
			return apBlancas[fnRey].getColumna();
		}
		else {
			return apNegras[fnRey].getColumna();
		}
	} 
	
	/**
	 * Crea las piezas en sus posiciones originales.
	 */
	private void crearPiezas() {
		for (int i=0; i<8; i++) {
			apBlancas[i] = new Peon(i, Constantes.BLANCO, 1, i);
		}
		apBlancas[fnTorre1] = new Torre(fnTorre1, Constantes.BLANCO, 0, 0);
		apBlancas[fnCaballo1] = new Caballo(fnCaballo1, Constantes.BLANCO, 0, 1);
		apBlancas[fnAlfil1] = new Alfil(fnAlfil1, Constantes.BLANCO, 0, 2);
		apBlancas[fnRey] = new Rey(fnRey, Constantes.BLANCO, 0, 3);
		apBlancas[fnDama] = new Dama(fnDama, Constantes.BLANCO, 0, 4);
		apBlancas[fnAlfil2] = new Alfil(fnAlfil2, Constantes.BLANCO, 0, 5);
		apBlancas[fnCaballo2] = new Caballo(fnCaballo2, Constantes.BLANCO, 0, 6);
		apBlancas[fnTorre2] = new Torre(fnTorre2, Constantes.BLANCO, 0, 7);
		
		//Creación de las piezas negras
		for (int i=0; i<8; i++) {
			apNegras[i] = new Peon(i, Constantes.NEGRO, 6, i);
		}
		apNegras[fnTorre1] = new Torre(fnTorre1, Constantes.NEGRO, 7, 0);
		apNegras[fnCaballo1] = new Caballo(fnCaballo1, Constantes.NEGRO, 7, 1);
		apNegras[fnAlfil1] = new Alfil(fnAlfil1, Constantes.NEGRO, 7, 2);
		apNegras[fnRey] = new Rey(fnRey, Constantes.NEGRO, 7, 3);
		apNegras[fnDama] = new Dama(fnDama, Constantes.NEGRO, 7, 4);
		apNegras[fnAlfil2] = new Alfil(fnAlfil2, Constantes.NEGRO, 7, 5);
		apNegras[fnCaballo2] = new Caballo(fnCaballo2, Constantes.NEGRO, 7, 6);
		apNegras[fnTorre2] = new Torre(fnTorre2, Constantes.NEGRO, 7, 7);
	} /* Fin método crearPiezas */
	
	
	/**
	 * Crea una nueva partida, inicializando el tablero.
	 */
	protected void nuevaPartida() {
		// Se crean las piezas
		crearPiezas();
		// Se limpia el tablero
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				aapTablero[i][j] = null;
			}
		}
		
		// Se colocan las blancas
		aapTablero[apBlancas[fnTorre1].getFila()][apBlancas[fnTorre1].getColumna()] = apBlancas[fnTorre1];
		aapTablero[apBlancas[fnCaballo1].getFila()][apBlancas[fnCaballo1].getColumna()] = apBlancas[fnCaballo1];
		aapTablero[apBlancas[fnAlfil1].getFila()][apBlancas[fnAlfil1].getColumna()] = apBlancas[fnAlfil1];
		aapTablero[apBlancas[fnRey].getFila()][apBlancas[fnRey].getColumna()] = apBlancas[fnRey];
		aapTablero[apBlancas[fnDama].getFila()][apBlancas[fnDama].getColumna()] = apBlancas[fnDama];
		aapTablero[apBlancas[fnAlfil2].getFila()][apBlancas[fnAlfil2].getColumna()] = apBlancas[fnAlfil2];
		aapTablero[apBlancas[fnCaballo2].getFila()][apBlancas[fnCaballo2].getColumna()] = apBlancas[fnCaballo2];
		aapTablero[apBlancas[fnTorre2].getFila()][apBlancas[fnTorre2].getColumna()] = apBlancas[fnTorre2];
		for (int i=0; i<8; i++) {
			aapTablero[apBlancas[i].getFila()][apBlancas[i].getColumna()] = apBlancas[i];
		}
		
		// Se colocan las negras
		for (int i=0; i<8; i++) {
			aapTablero[apNegras[i].getFila()][apNegras[i].getColumna()] = apNegras[i];
		}
		aapTablero[apNegras[fnTorre1].getFila()][apNegras[fnTorre1].getColumna()] = apNegras[fnTorre1];
		aapTablero[apNegras[fnCaballo1].getFila()][apNegras[fnCaballo1].getColumna()] = apNegras[fnCaballo1];
		aapTablero[apNegras[fnAlfil1].getFila()][apNegras[fnAlfil1].getColumna()] = apNegras[fnAlfil1];
		aapTablero[apNegras[fnRey].getFila()][apNegras[fnRey].getColumna()] = apNegras[fnRey];
		aapTablero[apNegras[fnDama].getFila()][apNegras[fnDama].getColumna()] = apNegras[fnDama];
		aapTablero[apNegras[fnAlfil2].getFila()][apNegras[fnAlfil2].getColumna()] = apNegras[fnAlfil2];
		aapTablero[apNegras[fnCaballo2].getFila()][apNegras[fnCaballo2].getColumna()] = apNegras[fnCaballo2];
		aapTablero[apNegras[fnTorre2].getFila()][apNegras[fnTorre2].getColumna()] = apNegras[fnTorre2];
	} 
	
	
	/**
	 * Gestiona un movimiento.
	 * @return   Clave indicativa del suceso producido. Puede ser:
	 *         0: el movimiento se ha realizado correctamente
	 *         1: estado 0 y el jugador actual ha eliminado una pieza del contrincante
	 *         2: estado 0 y la pieza es un peón que ha llegado al final del tablero
	 *         3: estados 1 y 2
	 *         4: estado 0 y el movimiento realizado ha sido tomar al paso
	 *         5: estado 0 y el movimiento realizado ha sido el enroque corto
	 *         6: estado 0 y el movimiento realizado ha sido el enroque largo
	 *        1_: estado menor de 10 y se produce jaque al rey contrario
	 *        2_: estado menor de 10 y el jugador actual ha ganado la partida
	 *        3_: estado menor de 10 y se han producido tablas
	 *        -1: no es el turno del jugador actual
	 *        -2: no hay ninguna pieza en el origen
	 *        -3: la pieza de la casilla origen no es del jugador actual
	 *        -4: hay una pieza del jugador actual en la casilla destino
	 *        -5: el movimiento no se corresponde con la pieza del origen
	 *        -6: hay una pieza en medio que impide el movimiento solicitado
	 *        -7: el movimiento dejaría al rey en jaque
	 */
	public int mover(char cTurno, int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino, String sCasillaOrigen, String sCasillaDestino) {
		int nCaso = 0;
		Rey piezaRey;
		boolean bEsFin = false;
		// Ajuste de los valores a la nomenclatura interna
		nFilaOrigen--;
		nColumnaOrigen--;
		nFilaDestino--;
		nColumnaDestino--;
		if (cTurno != getColorDelJugadorConElTurno()) {  //Caso -1
			nCaso = -1;
		}
		else if (aapTablero[nFilaOrigen][nColumnaOrigen] == null) {  //Caso -2
			nCaso = -2;
		}
		else if (aapTablero[nFilaOrigen][nColumnaOrigen].getColor() != getColorDelJugadorConElTurno()) {  //Caso -3
			nCaso = -3;
		}
		else if ((aapTablero[nFilaDestino][nColumnaDestino] != null) &&
				(aapTablero[nFilaOrigen][nColumnaOrigen].getColor()==
				aapTablero[nFilaDestino][nColumnaDestino].getColor())) {  //Caso -4
			nCaso = -4;
		}
		else {
			nCaso = aapTablero[nFilaOrigen][nColumnaOrigen].esValido(aapTablero, nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino);
			if (nCaso == -1) {  //Movimiento no válido (caso -5)
				nCaso = -5;
			}
			else if (nCaso == -2) {  //Movimiento no válido (caso -6)
				nCaso = -6;
			}
			else if (quedaReyEnJaque(nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino)) {  //Caso -7
				nCaso = -7;
			}
			else {  //Movimiento en principio válido (casos positivos o '0')
				if (nCaso == 1) {  //Caso 4: tomar al paso
					if (esValidoTomarAlPaso(nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino)) {
						nCaso = 4;
					}
					else {
						nCaso = -5;
					}
				}
				else if (nCaso == 2) {  //Caso 5: enroque corto
					if (!estaReyEnJaque(cTurno, nFilaOrigen, nColumnaOrigen) && 
							!quedaReyEnJaque(nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino+1)) {
						nCaso = 5;
					}
					else {
						nCaso = -5;
					}
				}
				else if (nCaso == 3) {  //Caso 6: enroque largo
					if (!estaReyEnJaque(cTurno, nFilaOrigen, nColumnaOrigen) && 
							!quedaReyEnJaque(nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino-1)) {
						nCaso = 6;
					}
					else {
						nCaso = -5;
					}
				}
				else if (aapTablero[nFilaDestino][nColumnaDestino] == null) {  //Caso 0
					nCaso = 0;
				}
				else {  //Caso 1
					nCaso = 1;
					if (getColorDelJugadorConElTurno() == Constantes.BLANCO) {
						apNegras[aapTablero[nFilaDestino][nColumnaDestino].getId()] = null;
					}
					else {
						apBlancas[aapTablero[nFilaDestino][nColumnaDestino].getId()] = null;
					}
				}
				
				if (nCaso >= 0) {  //Movimiento seguro válido (casos positivos o '0')
					//Realización del movimiento
					aapTablero[nFilaDestino][nColumnaDestino] = aapTablero[nFilaOrigen][nColumnaOrigen];
					aapTablero[nFilaOrigen][nColumnaOrigen] = null;
					aapTablero[nFilaDestino][nColumnaDestino].setPosicion(nFilaDestino,nColumnaDestino);
					if (nCaso == 4) {  //Caso 4: tomar al paso
						if (getColorDelJugadorConElTurno() == Constantes.BLANCO) {
							apNegras[aapTablero[nFilaOrigen][nColumnaDestino].getId()] = null;
							aapTablero[nFilaOrigen][nColumnaDestino] = null;
						}
						else {
							apBlancas[aapTablero[nFilaOrigen][nColumnaDestino].getId()] = null;
							aapTablero[nFilaOrigen][nColumnaDestino] = null;
						}
					}
					else if (nCaso == 5) {  //Caso 5: enroque corto
						aapTablero[nFilaDestino][nColumnaDestino+1] = aapTablero[nFilaOrigen][nColumnaOrigen-3];
						aapTablero[nFilaOrigen][nColumnaOrigen-3] = null;
						aapTablero[nFilaDestino][nColumnaDestino+1].setPosicion(nFilaDestino,nColumnaDestino+1);
					}
					else if (nCaso == 6) {  //Caso 6: enroque largo
						aapTablero[nFilaDestino][nColumnaDestino-1] = aapTablero[nFilaOrigen][nColumnaOrigen+4];
						aapTablero[nFilaOrigen][nColumnaOrigen+4] = null;
						aapTablero[nFilaDestino][nColumnaDestino-1].setPosicion(nFilaDestino,nColumnaDestino-1);
					}
					
					if (getColorDelJugadorConElTurno() == Constantes.BLANCO) {
						piezaRey = (Rey) apBlancas[fnRey];
					}
					else {
						piezaRey = (Rey) apNegras[fnRey];
					}
					//Comprobación si se deshabilita el enroque corto
					if (aapTablero[nFilaDestino][nColumnaDestino].getTipo().equals("t") && nColumnaOrigen==0) {
						piezaRey.deshabilitarEnroqueCorto();
					}
					//Comprobación si se deshabilita el enroque largo
					else if (aapTablero[nFilaDestino][nColumnaDestino].getTipo().equals("t") && nColumnaOrigen==7) {
						piezaRey.deshabilitarEnroqueLargo();
					}
					//Comprobación si se deshabilitan los dos enroques
					else if (aapTablero[nFilaDestino][nColumnaDestino].getTipo().equals("r")) {
						piezaRey.deshabilitarEnroqueCorto();
						piezaRey.deshabilitarEnroqueLargo();
					}
					//Comprobación si la pieza es un peón que ha llegado al final del tablero
					if ((aapTablero[nFilaDestino][nColumnaDestino].getTipo().equals("p")) 
							&& (nFilaDestino==0 || nFilaDestino==7)) {  //Caso 2 o 3
						nCaso += 2;
					}
					//Comprobación de jaque al rey contrario
					bEsFin = estaReyEnJaque(getColorDelJugadorSinElTurno(), getFilaRey(getColorDelJugadorSinElTurno()), getColumnaRey(getColorDelJugadorSinElTurno()));
					if (bEsFin) {  //Casos 1_ y 2_
						//Comprobación de fin de partida con ganador y perdedor
						bEsFin = hayGanador(getColorDelJugadorConElTurno());
						if (bEsFin) {  //Caso 2_: es jaque-mate
							nCaso += 20;
							setGanador(cTurno);
						}
						else {  //Caso 1_: sólo es jaque
							nCaso += 10;
						}
					}
					else {
						//ComprobaciÓn de fin de partida en tablas
						bEsFin = hayTablas(sCasillaOrigen, sCasillaDestino);
						if (bEsFin) {  //Caso 3_
							nCaso += 30;
							setGanador('t');
						}
					}
					// Cambio del turno
					setColorDelJugadorConElTurno(getColorDelJugadorSinElTurno());
				} /* Fin if - movimiento seguro válido */
			} /* Fin if - movimiento en principio válido */
		}
		return nCaso;
	} 
	
	
	/**
	 * Determina si el movimiento tomar al paso es definitivamente válido.
	 * @return   Devuelve 'true' si el movimiento es válido o 'false' si no.
	 */
	private boolean esValidoTomarAlPaso(int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino) {
		// Al invocar este método las posiciones actuales de las piezas son 
		//las correctas, debiendo comprobar ?nicamente si el ?ltimo movimiento 
		//realizado fue la salida del pe?n contrario.
		boolean bEsValido = false;
		String sMovimientoRealizado = movimientos.get(movimientos.size()-1);
		String sColumnaOrigenAntigua = sMovimientoRealizado.substring(0,1);
		int nFilaOrigenAntigua = Integer.parseInt(sMovimientoRealizado.substring(1,2)) - 1;
		String sColumnaDestinoAntigua = sMovimientoRealizado.substring(3,4);
		int nFilaDestinoAntigua = Integer.parseInt(sMovimientoRealizado.substring(4,5)) - 1;
		String sColumnaDestino = "";
		switch (nColumnaDestino) {
			case 0:
				sColumnaDestino = "h";
				break;
			case 1:
				sColumnaDestino = "g";
				break;
			case 2:
				sColumnaDestino = "f";
				break;
			case 3:
				sColumnaDestino = "e";
				break;
			case 4:
				sColumnaDestino = "d";
				break;
			case 5:
				sColumnaDestino = "c";
				break;
			case 6:
				sColumnaDestino = "b";
				break;
			case 7:
				sColumnaDestino = "a";
				break;
		}
		
		/* Comparación de la columna */
		// Deben ser iguales las dos antiguas y adem?s la destino actual
		if (sColumnaOrigenAntigua.equals(sColumnaDestinoAntigua) && sColumnaOrigenAntigua.equals(sColumnaDestino)) {
			bEsValido = true;
			
			/* Comparación de la fila */
			// Las filas antiguas deben ser +1 y -1 de la actual
			if (((aapTablero[nFilaOrigen][nColumnaOrigen].getColor()==Constantes.BLANCO)
					&& nFilaOrigenAntigua==nFilaDestino+1 
					&& nFilaDestinoAntigua==nFilaDestino-1)
					|| ((aapTablero[nFilaOrigen][nColumnaOrigen].getColor()==Constantes.NEGRO)
					&& nFilaOrigenAntigua==nFilaDestino-1 
					&& nFilaDestinoAntigua==nFilaDestino+1)) {
				bEsValido = true;
			}
			else {
				bEsValido = false;
			}
		}
		return bEsValido;
	} /* Fin método esValidoTomarAlPaso */
	
	
	/**
	 * Comprueba si, tras el movimiento, el rey queda en jaque.
	 * @return   'true' si el rey queda en jaque o 'false' si no.
	 */
	protected boolean quedaReyEnJaque(int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino) {
		boolean bJaque = false;
		char cTurno = aapTablero[nFilaOrigen][nColumnaOrigen].getColor();
		Pieza pCasillaDestino = aapTablero[nFilaDestino][nColumnaDestino];
		//Se simula el movimiento
		aapTablero[nFilaDestino][nColumnaDestino] = aapTablero[nFilaOrigen][nColumnaOrigen];
		aapTablero[nFilaOrigen][nColumnaOrigen] = null;
		//Se comprueba si hay jaque
		if (aapTablero[nFilaDestino][nColumnaDestino].getTipo().equals("r")) {
			bJaque = estaReyEnJaque(cTurno, nFilaDestino, nColumnaDestino);
		}
		else {
			bJaque = estaReyEnJaque(cTurno, getFilaRey(cTurno), getColumnaRey(cTurno));
		}
		//Se deshace el movimiento
		aapTablero[nFilaOrigen][nColumnaOrigen] = aapTablero[nFilaDestino][nColumnaDestino];
		aapTablero[nFilaDestino][nColumnaDestino] = pCasillaDestino;
		return bJaque;
	} /* Fin método quedaReyEnJaque */
	
	
	/**
	 * Comprueba si el rey est? en jaque.
	 * @return   'true' si el rey est? en jaque o 'false' si no.
	 */
	protected boolean estaReyEnJaque(char cColor, int nFila, int nColumna) {
		boolean bJaque = false;
		if (indagarJaque(cColor, nFila, nColumna, new int[2]) > 0) {
			bJaque = true;
		}
		else {  // indagarJaque(cColor, nFila, nColumna, new int[]) == 0
			bJaque = false;
		}
		return bJaque;
	} /* Fin método estaReyEnJaque */
	
	
	/**
	 * Comprueba si el jugador actual ha ganado la partida.
	 * @return   'true' si el jugador ha ganado o 'false' si no.
	 */
	protected boolean hayGanador(char cTurno) {
		boolean bHayGanador = true;
		int nFilaRey = -1;  // Fila que ocupa el rey
		int nColumnaRey = -1;  // Columna que ocupa el rey
		char cTurnoRival;
		int nNumeroJaques = 0;  // N?mero de jaques que recibe el rey
		int [] anPosJaque = new int[2];  // Posici?n de la ?nica pieza que da jaque al rey
		if (cTurno == Constantes.BLANCO) {
			cTurnoRival = Constantes.NEGRO;
		}
		else {
			cTurnoRival = Constantes.BLANCO;
		}
		nFilaRey = getFilaRey(cTurnoRival);
		nColumnaRey = getColumnaRey(cTurnoRival);
		
		/* Se valoran cada una de las nueve posiciones posibles del rey. */
		if (bHayGanador) {  //Arriba-Izquierda
			if (nFilaRey-1>=0 && nColumnaRey-1>=0 && 
					(aapTablero[nFilaRey-1][nColumnaRey-1]==null || 
					aapTablero[nFilaRey-1][nColumnaRey-1].getColor()==cTurno)) {
				bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey-1,nColumnaRey-1);
			}
			
			if (bHayGanador) {  //Arriba-Centro
				if (nFilaRey-1>=0 && 
						(aapTablero[nFilaRey-1][nColumnaRey]==null || 
						aapTablero[nFilaRey-1][nColumnaRey].getColor()==cTurno)) {
					bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey-1,nColumnaRey);
				}
				
				if (bHayGanador) {  //Arriba-Derecha
					if (nFilaRey-1>=0 && nColumnaRey+1<=7 && 
							(aapTablero[nFilaRey-1][nColumnaRey+1]==null || 
							aapTablero[nFilaRey-1][nColumnaRey+1].getColor()==cTurno)) {
						bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey-1,nColumnaRey+1);
					}
					
					if (bHayGanador) {  //Centro-Izquierda
						if (nColumnaRey-1>=0 && 
								(aapTablero[nFilaRey][nColumnaRey-1]==null || 
								aapTablero[nFilaRey][nColumnaRey-1].getColor()==cTurno)) {
							bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey,nColumnaRey-1);
						}
						
						if (bHayGanador) {  //Centro-Centro
							if (cTurno==Constantes.BLANCO) {
								bHayGanador = estaReyEnJaque(Constantes.NEGRO,nFilaRey,nColumnaRey);
							}
							else {
								bHayGanador = estaReyEnJaque(Constantes.BLANCO,nFilaRey,nColumnaRey);
							}
							
							if (bHayGanador) {  //Centro-Derecha
								if (nColumnaRey+1<=7 && 
										(aapTablero[nFilaRey][nColumnaRey+1]==null || 
										aapTablero[nFilaRey][nColumnaRey+1].getColor()==cTurno)) {
									bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey,nColumnaRey+1);
								}
								
								if (bHayGanador) {  //Abajo-Izquierda
									if (nFilaRey+1<=7 && nColumnaRey-1>=0 && 
											(aapTablero[nFilaRey+1][nColumnaRey-1]==null || 
											aapTablero[nFilaRey+1][nColumnaRey-1].getColor()==cTurno)) {
										bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey+1,nColumnaRey-1);
									}
									
									if (bHayGanador) {  //Abajo-Centro
										if (nFilaRey+1<=7 && 
												(aapTablero[nFilaRey+1][nColumnaRey]==null || 
												aapTablero[nFilaRey+1][nColumnaRey].getColor()==cTurno)) {
											bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey+1,nColumnaRey);
										}
										
										if (bHayGanador) {  //Abajo-Derecha
											if (nFilaRey+1<=7 && nColumnaRey+1<=7 && 
													(aapTablero[nFilaRey+1][nColumnaRey+1]==null || 
													aapTablero[nFilaRey+1][nColumnaRey+1].getColor()==cTurno)) {
												bHayGanador = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey+1,nColumnaRey+1);
											}
										}  //Abajo-Derecha
									}  //Abajo-Centro
								}  //Abajo-Izquierda
							}  //Centro-Derecha
						}  //Centro-Centro
					}  //Centro-Izquierda
				}  //Arriba-Derecha
			}  //Arriba-Centro
		}  //Arriba-Izquierda
		
		/* Si el rey s?lo recibe jaque de una pieza contraria, pero no tiene
		 escapatoria, puede ser que una pieza compa?era suya corte el jaque. */
		nNumeroJaques = indagarJaque(cTurnoRival, nFilaRey, nColumnaRey, anPosJaque);
		if (nNumeroJaques==1 && bHayGanador) {
			if (hayPiezaQueSalveRey(cTurnoRival, nFilaRey, nColumnaRey, anPosJaque[0], anPosJaque[1])) {
				bHayGanador = false;
			}
			else {
				bHayGanador = true;
			}
		}
		
		return bHayGanador;
	} /* Fin método hayGanador */
	
	
	/**
	 * Contabiliza el n?mero de jaques que recibe el rey, guardando las
	 * posiciones de las piezas que dan jaques.
	 * @param cColor      Color del rey
	 * @param nFila       Fila que ocupa el rey
	 * @param nColumna    Columna que ocupa el rey
	 * @param anPosJaque  Par?metro de salida que, en el caso de atacar s?lo
	 *                    una pieza al rey, devuelve su posici?n
	 * @return   N?mero de jaques que recibe el rey.
	 */
	private int indagarJaque(char cColor, int nFila, int nColumna, int [] anPosJaque) {
		int nNumeroJaques = 0;
		int nFilaRey = -1;
		int nColumnaRey = -1;
		boolean bJaque = false;
		if (nNumeroJaques < 2) {  //Arriba-Izquierda
			nFilaRey = nFila;
			nColumnaRey = nColumna;
			bJaque = false;
			while (!bJaque && nFilaRey>0 && nColumnaRey>0) {
				nFilaRey--;
				nColumnaRey--;
				if (aapTablero[nFilaRey][nColumnaRey]!=null) {
					if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
							(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("a")) || 
							(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
							(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
							nFila-1==nFilaRey && nColumna-1==nColumnaRey) || 
							(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("p") && 
							aapTablero[nFilaRey][nColumnaRey].getColor()==Constantes.BLANCO && 
							nFila-1==nFilaRey && nColumna-1==nColumnaRey))) {
						nNumeroJaques++;
						anPosJaque[0] = nFilaRey;
						anPosJaque[1] = nColumnaRey;
						bJaque = true;
					}
					else {
						nFilaRey = -1;
						nColumnaRey = -1;
					}
				}
			}
			
			if (nNumeroJaques < 2) {  //Arriba-Centro
				nFilaRey = nFila;
				nColumnaRey = nColumna;
				bJaque = false;
				while (!bJaque && nFilaRey>0) {
					nFilaRey--;
					if (aapTablero[nFilaRey][nColumnaRey]!=null) {
						if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
								(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("t")) || 
								(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
								(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
								nFila-1==nFilaRey))) {
							nNumeroJaques++;
							anPosJaque[0] = nFilaRey;
							anPosJaque[1] = nColumnaRey;
							bJaque = true;
						}
						else {
							nFilaRey = -1;
						}
					}
				}
				
				if (nNumeroJaques < 2) {  //Arriba-Derecha
					nFilaRey = nFila;
					nColumnaRey = nColumna;
					bJaque = false;
					while (!bJaque && nFilaRey>0 && nColumnaRey<7) {
						nFilaRey--;
						nColumnaRey++;
						if (aapTablero[nFilaRey][nColumnaRey]!=null) {
							if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
									(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("a")) || 
									(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
									(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
									nFila-1==nFilaRey && nColumna+1==nColumnaRey) || 
									(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("p") && 
									aapTablero[nFilaRey][nColumnaRey].getColor()==Constantes.BLANCO && 
									nFila-1==nFilaRey && nColumna+1==nColumnaRey))) {
								nNumeroJaques++;
								anPosJaque[0] = nFilaRey;
								anPosJaque[1] = nColumnaRey;
								bJaque = true;
							}
							else {
								nFilaRey = -1;
								nColumnaRey = 8;
							}
						}
					}
					
					if (nNumeroJaques < 2) {  //Centro-Izquierda
						nFilaRey = nFila;
						nColumnaRey = nColumna;
						bJaque = false;
						while (!bJaque && nColumnaRey>0) {
							nColumnaRey--;
							if (aapTablero[nFilaRey][nColumnaRey]!=null) {
								if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
										(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("t")) || 
										(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
										(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
										nColumna-1==nColumnaRey))) {
									nNumeroJaques++;
									anPosJaque[0] = nFilaRey;
									anPosJaque[1] = nColumnaRey;
									bJaque = true;
								}
								else {
									nColumnaRey = -1;
								}
							}
						}
						
						if (nNumeroJaques < 2) {  //Centro-Derecha
							nFilaRey = nFila;
							nColumnaRey = nColumna;
							bJaque = false;
							while (!bJaque && nColumnaRey<7) {
								nColumnaRey++;
								if (aapTablero[nFilaRey][nColumnaRey]!=null) {
									if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
											(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("t")) || 
											(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
											(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
											nColumna+1==nColumnaRey))) {
										nNumeroJaques++;
										anPosJaque[0] = nFilaRey;
										anPosJaque[1] = nColumnaRey;
										bJaque = true;
									}
									else {
										nColumnaRey = 8;
									}
								}
							}
							
							if (nNumeroJaques < 2) {  //Abajo-Izquierda
								nFilaRey = nFila;
								nColumnaRey = nColumna;
								bJaque = false;
								while (!bJaque && nFilaRey<7 && nColumnaRey>0) {
									nFilaRey++;
									nColumnaRey--;
									if (aapTablero[nFilaRey][nColumnaRey]!=null) {
										if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
												(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("a")) || 
												(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
												(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
												nFila+1==nFilaRey && nColumna-1==nColumnaRey) || 
												(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("p") && 
												aapTablero[nFilaRey][nColumnaRey].getColor()==Constantes.NEGRO && 
												nFila+1==nFilaRey && nColumna-1==nColumnaRey))) {
											nNumeroJaques++;
											anPosJaque[0] = nFilaRey;
											anPosJaque[1] = nColumnaRey;
											bJaque = true;
										}
										else {
											nFilaRey = 8;
											nColumnaRey = -1;
										}
									}
								}
								
								if (nNumeroJaques < 2) {  //Abajo-Centro
									nFilaRey = nFila;
									nColumnaRey = nColumna;
									bJaque = false;
									while (!bJaque && nFilaRey<7) {
										nFilaRey++;
										if (aapTablero[nFilaRey][nColumnaRey]!=null) {
											if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
													(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("t")) || 
													(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
													(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
													nFila+1==nFilaRey))) {
												nNumeroJaques++;
												anPosJaque[0] = nFilaRey;
												anPosJaque[1] = nColumnaRey;
												bJaque = true;
											}
											else {
												nFilaRey = 8;
											}
										}
									}
									
									if (nNumeroJaques < 2) {  //Abajo-Derecha
										nFilaRey = nFila;
										nColumnaRey = nColumna;
										bJaque = false;
										while (!bJaque && nFilaRey<7 && nColumnaRey<7) {
											nFilaRey++;
											nColumnaRey++;
											if (aapTablero[nFilaRey][nColumnaRey]!=null) {
												if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
														(((aapTablero[nFilaRey][nColumnaRey].getTipo().equals("a")) || 
														(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("d"))) || 
														(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("r") && 
														nFila+1==nFilaRey && nColumna+1==nColumnaRey) || 
														(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("p") && 
														aapTablero[nFilaRey][nColumnaRey].getColor()==Constantes.NEGRO && 
														nFila+1==nFilaRey && nColumna+1==nColumnaRey))) {
													nNumeroJaques++;
													anPosJaque[0] = nFilaRey;
													anPosJaque[1] = nColumnaRey;
													bJaque = true;
												}
												else {
													nFilaRey = 8;
													nColumnaRey = 8;
												}
											}
										}
										
										if (nNumeroJaques < 2) {  //Caballo en Arriba-Arriba-Izquierda
											nFilaRey = nFila;
											nColumnaRey = nColumna;
											nFilaRey--;
											nFilaRey--;
											nColumnaRey--;
											if (nFilaRey>=0 && nColumnaRey>=0 && aapTablero[nFilaRey][nColumnaRey]!=null) {
												if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
														(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
													nNumeroJaques++;
													anPosJaque[0] = nFilaRey;
													anPosJaque[1] = nColumnaRey;
												}
											}
											
											if (nNumeroJaques < 2) {  //Caballo en Arriba-Arriba-Derecha
												nFilaRey = nFila;
												nColumnaRey = nColumna;
												nFilaRey--;
												nFilaRey--;
												nColumnaRey++;
												if (nFilaRey>=0 && nColumnaRey<=7 && aapTablero[nFilaRey][nColumnaRey]!=null) {
													if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
															(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
														nNumeroJaques++;
														anPosJaque[0] = nFilaRey;
														anPosJaque[1] = nColumnaRey;
													}
												}
												
												if (nNumeroJaques < 2) {  //Caballo en Derecha-Derecha-Arriba
													nFilaRey = nFila;
													nColumnaRey = nColumna;
													nFilaRey--;
													nColumnaRey++;
													nColumnaRey++;
													if (nFilaRey>=0 && nColumnaRey<=7 && aapTablero[nFilaRey][nColumnaRey]!=null) {
														if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
																(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
															nNumeroJaques++;
															anPosJaque[0] = nFilaRey;
															anPosJaque[1] = nColumnaRey;
														}
													}
													
													if (nNumeroJaques < 2) {  //Caballo en Derecha-Derecha-Abajo
														nFilaRey = nFila;
														nColumnaRey = nColumna;
														nFilaRey++;
														nColumnaRey++;
														nColumnaRey++;
														if (nFilaRey<=7 && nColumnaRey<=7 && aapTablero[nFilaRey][nColumnaRey]!=null) {
															if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
																	(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
																nNumeroJaques++;
																anPosJaque[0] = nFilaRey;
																anPosJaque[1] = nColumnaRey;
															}
														}
														
														if (nNumeroJaques < 2) {  //Caballo en Abajo-Abajo-Izquierda
															nFilaRey = nFila;
															nColumnaRey = nColumna;
															nFilaRey++;
															nFilaRey++;
															nColumnaRey--;
															if (nFilaRey<=7 && nColumnaRey>=0 && aapTablero[nFilaRey][nColumnaRey]!=null) {
																if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
																		(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
																	nNumeroJaques++;
																	anPosJaque[0] = nFilaRey;
																	anPosJaque[1] = nColumnaRey;
																}
															}
															
															if (nNumeroJaques < 2) {  //Caballo en Abajo-Abajo-Derecha
																nFilaRey = nFila;
																nColumnaRey = nColumna;
																nFilaRey++;
																nFilaRey++;
																nColumnaRey++;
																if (nFilaRey<=7 && nColumnaRey<=7 && aapTablero[nFilaRey][nColumnaRey]!=null) {
																	if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
																			(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
																		nNumeroJaques++;
																		anPosJaque[0] = nFilaRey;
																		anPosJaque[1] = nColumnaRey;
																	}
																}
																
																if (nNumeroJaques < 2) {  //Caballo en Izquierda-Izquierda-Arriba
																	nFilaRey = nFila;
																	nColumnaRey = nColumna;
																	nFilaRey--;
																	nColumnaRey--;
																	nColumnaRey--;
																	if (nFilaRey>=0 && nColumnaRey>=0 && aapTablero[nFilaRey][nColumnaRey]!=null) {
																		if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
																				(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
																			nNumeroJaques++;
																			anPosJaque[0] = nFilaRey;
																			anPosJaque[1] = nColumnaRey;
																		}
																	}
																	
																	if (nNumeroJaques < 2) {  //Caballo en Izquierda-Izquierda-Abajo
																		nFilaRey = nFila;
																		nColumnaRey = nColumna;
																		nFilaRey++;
																		nColumnaRey--;
																		nColumnaRey--;
																		if (nFilaRey<=7 && nColumnaRey>=0 && aapTablero[nFilaRey][nColumnaRey]!=null) {
																			if ((aapTablero[nFilaRey][nColumnaRey].getColor()!=cColor) && 
																					(aapTablero[nFilaRey][nColumnaRey].getTipo().equals("c"))) {
																				nNumeroJaques++;
																				anPosJaque[0] = nFilaRey;
																				anPosJaque[1] = nColumnaRey;
																			}
																		}
																	}  //Caballo en Izquierda-Izquierda-Abajo
																}  //Caballo en Izquierda-Izquierda-Arriba
															}  //Caballo en Abajo-Abajo-Derecha
														}  //Caballo en Abajo-Abajo-Izquierda
													}  //Caballo en Derecha-Derecha-Abajo
												}  //Caballo en Derecha-Derecha-Arriba
											}  //Caballo en Arriba-Arriba-Derecha
										}  //Caballo en Arriba-Arriba-Izquierda
									}  //Abajo-Derecha
								}  //Abajo-Centro
							}  //Abajo-Izquierda
						}  //Centro-Derecha
					}  //Centro-Izquierda
				}  //Arriba-Derecha
			}  //Arriba-Centro
		}  //Arriba-Izquierda
		return nNumeroJaques;
	} /* Fin método indagarJaque */
	
	
	/**
	 * Determina si existe alguna pieza compa?era del rey que pueda acabar con
	 * el ?nico jaque que ataca al rey, bien interponi?ndose en medio, bien
	 * eliminando a la pieza que da el jaque.
	 * @param cColor         Color del rey
	 * @param nFilaRey       Fila que ocupa el rey
	 * @param nColumnaRey    Columna que ocupa el rey
	 * @param nFilaJaque     Fila que ocupa la ?nica pieza que da jaque al rey
	 * @param nColumnaJaque  Columna que ocupa la ?nica pieza que da jaque al rey
	 * @return   Devuelve 'true' si existe alguna pieza que pueda acabar con
	 *           el jaque, o 'false' si no.
	 */
	private boolean hayPiezaQueSalveRey(char cColor, int nFilaRey, int nColumnaRey, int nFilaJaque, int nColumnaJaque) {
		boolean bHaySalvador = false;
		Pieza [] apPiezas = null;
		if (cColor == Constantes.BLANCO) {
			apPiezas = apBlancas;
		}
		else {
			apPiezas = apNegras;
		}
		//Para cada una de las piezas vivas menos el rey
		for (int i=0; !bHaySalvador && i<15; i++) {
			if (apPiezas[i] != null) {
				bHaySalvador = salvaRey(
						apPiezas[i].getFila(), apPiezas[i].getColumna(), 
						nFilaRey, nColumnaRey, 
						aapTablero[nFilaJaque][nColumnaJaque].getTipo(), 
						nFilaJaque, nColumnaJaque);
			}
		}
		return bHaySalvador;
	} /* Fin método hayPiezaQueSalveRey */
	
	
	/**
	 * Investiga si la pieza, dependiendo de su tipo y posici?n, puede cortar
	 * la l?nea de jaque o comer al atacante.
	 * @param nFila          Fila de la posible pieza salvadora
	 * @param nColumna       Columna de la posible pieza salvadora
	 * @param nFilaRey       Fila que ocupa el rey
	 * @param nColumnaRey    Columna que ocupa el rey
	 * @param sAtacante      Tipo de la ?nica pieza que da jaque al rey
	 * @param nFilaJaque     Fila que ocupa la ?nica pieza que da jaque al rey
	 * @param nColumnaJaque  Columna que ocupa la ?nica pieza que da jaque al rey
	 * @return   Devuelve 'true' si la pieza puede cortar el jaque, y 'false'
	 *           en caso contrario.
	 */
	private boolean salvaRey(int nFila, int nColumna, int nFilaRey, int nColumnaRey, String sAtacante, int nFilaJaque, int nColumnaJaque) {
		boolean bEsSalvadora = false;
		// Opci?n 1: la pieza salvadora come al atacante
		if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, nFilaJaque, nColumnaJaque)==0) {
			bEsSalvadora = true;
		}
		if (!bEsSalvadora) {
			// Opci?n 2: la pieza salvadora corta el jaque
			if (sAtacante.equals("t")) {  // El atacante es una torre
				if (nFilaRey>nFilaJaque && nColumnaRey==nColumnaJaque) {  // Caso 1: Atacante al N del Rey
					for (int i=nFilaRey-1; !bEsSalvadora && i!=nFilaJaque; i--) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, nColumnaRey)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey==nFilaJaque && nColumnaRey<nColumnaJaque) {  // Caso 2: Atacante al E del Rey
					for (int j=nColumnaRey+1; !bEsSalvadora && j!=nColumnaJaque; j++) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, nFilaRey, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey<nFilaJaque && nColumnaRey==nColumnaJaque) {  // Caso 3: Atacante al S del Rey
					for (int i=nFilaRey+1; !bEsSalvadora && i!=nFilaJaque; i++) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, nColumnaRey)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey==nFilaJaque && nColumnaRey>nColumnaJaque) {  // Caso 4: Atacante al O del Rey
					for (int j=nColumnaRey-1; !bEsSalvadora && j!=nColumnaJaque; j--) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, nFilaRey, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
			} // Fin if - El atacante es una torre
			
			else if (sAtacante.equals("a")) {  // El atacante es un alfil
				if (nFilaRey>nFilaJaque && nColumnaRey<nColumnaJaque) {  // Caso 1: Atacante al NE del Rey
					for (int i=nFilaRey-1, j=nColumnaRey+1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i--, j++) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey<nFilaJaque && nColumnaRey<nColumnaJaque) {  // Caso 2: Atacante al SE del Rey
					for (int i=nFilaRey+1, j=nColumnaRey+1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i++, j++) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey<nFilaJaque && nColumnaRey>nColumnaJaque) {  // Caso 3: Atacante al SO del Rey
					for (int i=nFilaRey+1, j=nColumnaRey-1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i++, j--) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey>nFilaJaque && nColumnaRey>nColumnaJaque) {  // Caso 4: Atacante al NO del Rey
					for (int i=nFilaRey-1, j=nColumnaRey-1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i--, j--) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
			} // Fin if - El atacante es un alfil
			
			else if (sAtacante.equals("d")) {  // El atacante es una dama
				if (nFilaRey>nFilaJaque && nColumnaRey==nColumnaJaque) {  // Caso 1: Atacante al N del Rey
					for (int i=nFilaRey-1; !bEsSalvadora && i!=nFilaJaque; i--) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, nColumnaRey)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey==nFilaJaque && nColumnaRey<nColumnaJaque) {  // Caso 2: Atacante al E del Rey
					for (int j=nColumnaRey+1; !bEsSalvadora && j!=nColumnaJaque; j++) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, nFilaRey, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey<nFilaJaque && nColumnaRey==nColumnaJaque) {  // Caso 3: Atacante al S del Rey
					for (int i=nFilaRey+1; !bEsSalvadora && i!=nFilaJaque; i++) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, nColumnaRey)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else if (nFilaRey==nFilaJaque && nColumnaRey>nColumnaJaque) {  // Caso 4: Atacante al O del Rey
					for (int j=nColumnaRey-1; !bEsSalvadora && j!=nColumnaJaque; j--) {
						if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, nFilaRey, j)==0) {
							bEsSalvadora = true;
						}
					}
				}
				else {  // Ataca en una diagonal
					if (nFilaRey>nFilaJaque && nColumnaRey<nColumnaJaque) {  // Caso 5: Atacante al NE del Rey
						for (int i=nFilaRey-1, j=nColumnaRey+1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i--, j++) {
							if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
								bEsSalvadora = true;
							}
						}
					}
					else if (nFilaRey<nFilaJaque && nColumnaRey<nColumnaJaque) {  // Caso 6: Atacante al SE del Rey
						for (int i=nFilaRey+1, j=nColumnaRey+1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i++, j++) {
							if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
								bEsSalvadora = true;
							}
						}
					}
					else if (nFilaRey<nFilaJaque && nColumnaRey>nColumnaJaque) {  // Caso 7: Atacante al SO del Rey
						for (int i=nFilaRey+1, j=nColumnaRey-1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i++, j--) {
							if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
								bEsSalvadora = true;
							}
						}
					}
					else if (nFilaRey>nFilaJaque && nColumnaRey>nColumnaJaque) {  // Caso 8: Atacante al NO del Rey
						for (int i=nFilaRey-1, j=nColumnaRey-1; !bEsSalvadora && i!=nFilaJaque && j!=nColumnaJaque; i--, j--) {
							if (aapTablero[nFila][nColumna].esValido(aapTablero, nFila, nColumna, i, j)==0) {
								bEsSalvadora = true;
							}
						}
					}
				} // Fin if - Ataca en una diagonal
			} // Fin if - El atacante es una dama
			// Los jaques del caballo y el pe?n s?lo se pueden eliminar 
			//comiendo a la pieza atacante.
		}
		return bEsSalvadora;
	} /* Fin método salvaRey */
	
	
	/**
	 * Comprueba si el resultado de la partida es tablas.
	 * @return   'true' si el resultado es tablas o 'false' si no.
	 */
	protected boolean hayTablas(String sCasillaOrigen, String sCasillaDestino) {
		boolean bHayTablas = true;
		String sMovimientoActual = sCasillaOrigen+"-"+sCasillaDestino;
		//Caso 1: s?lo quedan los reyes (piezas 0..14 = null)
		for (int i=0; bHayTablas && i<15; i++) {
			if (apBlancas[i]!=null || apNegras[i]!=null) {
				bHayTablas = false;
			}
		}
		if (!bHayTablas) {
			//Caso 2: jaque continuo
			int nTam = movimientos.size();
			if (nTam >= 11 && 
					sMovimientoActual.equals(movimientos.get(nTam-4)) && 
					movimientos.get(nTam-4).equals(movimientos.get(nTam-8)) && 
					movimientos.get(nTam-2).equals(movimientos.get(nTam-6)) && 
					movimientos.get(nTam-6).equals(movimientos.get(nTam-10)) && 
					movimientos.get(nTam-1).equals(movimientos.get(nTam-5)) && 
					movimientos.get(nTam-5).equals(movimientos.get(nTam-9)) && 
					movimientos.get(nTam-3).equals(movimientos.get(nTam-7)) && 
					movimientos.get(nTam-7).equals(movimientos.get(nTam-11))) {
				bHayTablas = true;
			}
		}
		if (!bHayTablas) {
			//Caso 3: mate ahogado
			if (estaJugadorAhogado(Constantes.BLANCO) || estaJugadorAhogado(Constantes.NEGRO)) {
				bHayTablas = true;
			}
		}
		return bHayTablas;
	} /* Fin método hayTablas */
	
	
	/**
	 * Determina si un jugador est? en "mate ahogado"; es decir, si no puede
	 * mover ninguna pieza, su rey no est? en jaque y tras cualquier movimiento
	 * quedar?a en jaque.
	 * @return   'true' si el jugador est? en mate ahogado y 'false' si no.
	 */
	private boolean estaJugadorAhogado(char cColor) {
		boolean bEstaAhogado = false;
		int nFilaRey = getFilaRey(cColor);
		int nColumnaRey = getColumnaRey(cColor);
		
		// El rey no debe estar en jaque
		if (!estaReyEnJaque(cColor, getFilaRey(cColor), getColumnaRey(cColor))) {
			bEstaAhogado = true;
			
			// Ninguna pieza se puede mover (el rey se comprueba despu?s)
			if (cColor == Constantes.BLANCO) {
				for (int i=0; bEstaAhogado && i<15; i++) {
					if (apBlancas[i]!=null && !apBlancas[i].estaBloqueada(aapTablero)) {
						bEstaAhogado = false;
					}
				}
			}
			else {
				for (int i=0; bEstaAhogado && i<15; i++) {
					if (apNegras[i]!=null && !apNegras[i].estaBloqueada(aapTablero)) {
						bEstaAhogado = false;
					}
				}
			}
			
			// El rey debe estar en jaque al moverse
			if (bEstaAhogado) {  //Arriba-Izquierda
				if (nFilaRey-1>=0 && nColumnaRey-1>=0 && 
						(aapTablero[nFilaRey-1][nColumnaRey-1]==null || 
						aapTablero[nFilaRey-1][nColumnaRey-1].getColor()!=cColor)) {
					bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey-1,nColumnaRey-1);
				}
				
				if (bEstaAhogado) {  //Arriba-Centro
					if (nFilaRey-1>=0 && 
							(aapTablero[nFilaRey-1][nColumnaRey]==null || 
							aapTablero[nFilaRey-1][nColumnaRey].getColor()!=cColor)) {
						bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey-1,nColumnaRey);
					}
					
					if (bEstaAhogado) {  //Arriba-Derecha
						if (nFilaRey-1>=0 && nColumnaRey+1<=7 && 
								(aapTablero[nFilaRey-1][nColumnaRey+1]==null || 
								aapTablero[nFilaRey-1][nColumnaRey+1].getColor()!=cColor)) {
							bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey-1,nColumnaRey+1);
						}
						
						if (bEstaAhogado) {  //Centro-Izquierda
							if (nColumnaRey>=0 && 
									(aapTablero[nFilaRey][nColumnaRey-1]==null || 
									aapTablero[nFilaRey][nColumnaRey-1].getColor()!=cColor)) {
								bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey,nColumnaRey-1);
							}
							
							if (bEstaAhogado) {  //Centro-Derecha
								if (nColumnaRey+1<=7 && 
										(aapTablero[nFilaRey][nColumnaRey+1]==null || 
										aapTablero[nFilaRey][nColumnaRey+1].getColor()!=cColor)) {
									bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey,nColumnaRey+1);
								}
								
								if (bEstaAhogado) {  //Abajo-Izquierda
									if (nFilaRey+1<=7 && nColumnaRey-1>=0 && 
											(aapTablero[nFilaRey+1][nColumnaRey-1]==null || 
											aapTablero[nFilaRey+1][nColumnaRey-1].getColor()!=cColor)) {
										bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey+1,nColumnaRey-1);
									}
									
									if (bEstaAhogado) {  //Abajo-Centro
										if (nFilaRey+1<=7 && 
												(aapTablero[nFilaRey+1][nColumnaRey]==null || 
												aapTablero[nFilaRey+1][nColumnaRey].getColor()!=cColor)) {
											bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey+1,nColumnaRey);
										}
										
										if (bEstaAhogado) {  //Abajo-Derecha
											if (nFilaRey+1<=7 && nColumnaRey+1<=7 && 
													(aapTablero[nFilaRey+1][nColumnaRey+1]==null || 
													aapTablero[nFilaRey+1][nColumnaRey+1].getColor()!=cColor)) {
												bEstaAhogado = quedaReyEnJaque(nFilaRey,nColumnaRey,nFilaRey+1,nColumnaRey+1);
											}
										}  //Abajo-Derecha
									}  //Abajo-Centro
								}  //Abajo-Izquierda
							}  //Centro-Derecha
						}  //Centro-Izquierda
					}  //Arriba-Derecha
				}  //Arriba-Centro
			}  //Arriba-Izquierda
		}
		return bEstaAhogado;
	} /* Fin método estaJugadorAhogado */
	
	
	/**
	 * Convierte el pe?n al tipo de pieza indicado.
	 * @return   Clave indicativa del suceso producido. Puede ser:
	 *         0: conversi?n realizada sin incidencias
	 *         1: estado 0 y se produce jaque al rey contrario
	 *         2: estado 0 y el jugador actual ha ganado la partida
	 *         3: estado 0 y se han producido tablas
	 */
	public int convertirPeon(char cTipo) {
		int nId=0, nFila=0, nColumna=0, nCaso=0;
		boolean bEsFin = false;
		Pieza nuevaPieza = null;
		// B?squeda del pe?n
		if (getColorDelJugadorSinElTurno() == Constantes.BLANCO) {  //(El turno ya se hab?a cambiado)
			for (int i=0; !bEsFin && i<8; i++) {
				if (apBlancas[i]!=null && apBlancas[i].getFila()==7) {
					bEsFin = true;
					nId = apBlancas[i].getId();
					nFila = apBlancas[i].getFila();
					nColumna = apBlancas[i].getColumna();
				}
			}
		}
		else {
			for (int i=0; !bEsFin && i<8; i++) {
				if (apNegras[i]!=null && apNegras[i].getFila()==0) {
					bEsFin = true;
					nId = apNegras[i].getId();
					nFila = apNegras[i].getFila();
					nColumna = apNegras[i].getColumna();
				}
			}
		}
		// Creación de la nueva pieza
		switch (cTipo) {
			case 't':
				nuevaPieza = new Torre(nId, getColorDelJugadorSinElTurno(), nFila, nColumna);
				break;
			case 'c':
				nuevaPieza = new Caballo(nId, getColorDelJugadorSinElTurno(), nFila, nColumna);
				break;
			case 'a':
				nuevaPieza = new Alfil(nId, getColorDelJugadorSinElTurno(), nFila, nColumna);
				break;
			case 'd':
				nuevaPieza = new Dama(nId, getColorDelJugadorSinElTurno(), nFila, nColumna);
				break;
		}
		// Asignación y colocación de la nueva pieza en el tablero
		if (getColorDelJugadorSinElTurno() == Constantes.BLANCO) {
			apBlancas[nId] = nuevaPieza;
		}
		else {
			apNegras[nId] = nuevaPieza;
		}
		aapTablero[nFila][nColumna] = nuevaPieza;
		
		//Comprobación de jaque al rey contrario
		bEsFin = estaReyEnJaque(getColorDelJugadorConElTurno(), getFilaRey(getColorDelJugadorConElTurno()), getColumnaRey(getColorDelJugadorConElTurno()));
		if (bEsFin) {  //Casos 1 y 2
			nCaso = 1;
			//Comprobación de fin de partida con ganador y perdedor
			bEsFin = hayGanador(getColorDelJugadorSinElTurno());
			if (bEsFin) {  //Caso 2
				nCaso = 2;
				setGanador(getColorDelJugadorSinElTurno());
			}
		}
		else {
			//Comprobación de fin de partida en tablas
			bEsFin = hayTablas("","");  // Da igual el movimiento porque no se puede producir el jaque continuo
			if (bEsFin) {  //Caso 3
				nCaso = 3;
				setGanador('t');
			}
		}
		return nCaso;
	} /* Fin método convertirPeon */
	
	
	/**
	 * Almacena el movimiento realizado.
	 */
	public void almacenarMovimiento(String sMov) {
		movimientos.add(sMov);
	} /* Fin método almacenarMovimiento */
	
	
	/**
	 * Ordena el almacenamiento en la base de datos.
	 */
	public void guardarEnBD() {
		//Metodos.insertaPartida(nId, sJugador1, sJugador2, nGanador, getMovimientosS());		
	} /* Fin método guardarEnBD */
	
	
	/**
	 * Devuelve el tablero listo para mostrar por pantalla.
	 */
	public String toString() {
		String cadena = "\n\n";
		cadena += "DISPOSICION ACTUAL DEL TABLERO\n";
		cadena += "==============================\n\n";
		//Numeración de las columnnas
		cadena += "\t ";
		for (int j=1; j<=8; j++) {
			cadena += " | " + j;
		}
		cadena += " |\n";
		//Inicio del tablero
		cadena += "\t--+---+---+---+---+---+---+---+---+\n";
		//Dibujo del tablero
		for (int i=0; i<8; i++) {
			if (i%2 != 0) {
				cadena += "\t" + "  |***|   |***|   |***|   |***|   |\n";
			}
			else {
				cadena += "\t" + "  |   |***|   |***|   |***|   |***|\n";
			}
			cadena += "\t" + (i+1) + " ";
			for (int j=0; j<8; j++) {
				cadena += "|";
				if ((i+j)%2 != 0) {  //Casilla negra
					cadena += "*";
					if (aapTablero[i][j] == null) {  //Casilla vac?a
						cadena += "*";
					}
					else {  //Casilla con ficha
						if (aapTablero[i][j].getColor() == Constantes.BLANCO) {  //Ficha blanca
							cadena += aapTablero[i][j].getTipo().toUpperCase();
						}
						else {  //Ficha negra
							cadena += aapTablero[i][j].getTipo().toLowerCase();
						}
					}
					cadena += "*";
				}
				else {  //Casilla blanca
					cadena += " ";
					if (aapTablero[i][j] == null) {  //Casilla vac?a
						cadena += " ";
					}
					else {  //Casilla con ficha
						if (aapTablero[i][j].getColor() == Constantes.BLANCO) {  //Ficha blanca
							cadena += aapTablero[i][j].getTipo().toUpperCase();
						}
						else {  //Ficha negra
							cadena += aapTablero[i][j].getTipo().toLowerCase();
						}
					}
					cadena += " ";
				}
			}
			cadena += "|\n";
			if (i%2 != 0) {
				cadena += "\t" + "  |***|   |***|   |***|   |***|   |\n";
			}
			else {
				cadena += "\t" + "  |   |***|   |***|   |***|   |***|\n";
			}
			if (i != 7) {
				cadena += "\t--+---+---+---+---+---+---+---+---+\n";
			}
		}
		//Final del tablero
		cadena += "\t--+---+---+---+---+---+---+---+---+\n";
		return cadena;
	} /* Fin método toString */


	public void setJugador(char color, Jugador jugador) {
		if (color==Constantes.BLANCO) {
			this.jugadorBlancas=jugador;
		} else {
			this.jugadorNegras=jugador;
		}
	}
	
} /* Fin clase Tablero */
