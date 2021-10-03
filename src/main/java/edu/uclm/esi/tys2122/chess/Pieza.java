package edu.uclm.esi.tys2122.chess;


/* Especifica las caracter?sticas y funciones comunes de las piezas. */
abstract public class Pieza {
	protected int nId = -1;
	protected String sTipo = "-";
	protected char cColor = '-';
	protected int nPosFila = 0;
	protected int nPosColumna = 0;
	
	
	public Pieza(int nId, char cColor, int nPosFila, int nPosColumna) {
		this.nId = nId;
		this.cColor = cColor;
		this.nPosFila = nPosFila;
		this.nPosColumna = nPosColumna;
	} /* Fin m?todo constructor */
	
	
	/**
	 * Devuelve el identificador de la pieza.
	 */
	public int getId() {
		return nId;
	} /* Fin m?todo getId */
	
	
	/**
	 * Devuelve el tipo de la pieza.
	 */
	public String getTipo() {
		return sTipo;
	} /* Fin m?todo getTipo */
	
	
	/**
	 * Devuelve el nombre de la pieza.
	 */
	public String getNombre() {
		if (getTipo().equals("p")) {
			return "peon";
		}
		else if (getTipo().equals("t")) {
			return "torre";
		}
		else if (getTipo().equals("c")) {
			return "caballo";
		}
		else if (getTipo().equals("a")) {
			return "alfil";
		}
		else if (getTipo().equals("d")) {
			return "dama";
		}
		else {
			return "rey";
		}
	} /* Fin m?todo getTipo */
	
	
	/**
	 * Devuelve el color de la pieza.
	 */
	public char getColor() {
		return cColor;
	} 
	
	
	/**
	 * Devuelve la fila de la casilla que ocupa la pieza.
	 */
	public int getFila() {
		return nPosFila;
	} 
	
	
	/**
	 * Devuelve la columna de la casilla que ocupa la pieza.
	 */
	public int getColumna() {
		return nPosColumna;
	} 
	
	
	/**
	 * Fila la nueva posici?n de la pieza en el tablero.
	 */
	public void setPosicion(int nFila, int nColumna) {
		nPosFila = nFila;
		nPosColumna = nColumna;
	} 
	
	
	/**
	 * Determina si el movimiento especificado es v?lido o legal.
	 * @return   Clave indicativa de la validez del movimiento. Puede ser:
	 *         0: el movimiento es v?lido o legal
	 *         1: (sólo Peon) se quiere tomar al paso a otro pe?n
	 *         2: (sólo Rey) se ha realizado el enroque corto
	 *         3: (sólo Rey) se ha realizado el enroque largo
	 *        -1: el movimiento no se corresponde con la pieza del origen
	 *        -2: hay una pieza en medio que impide el movimiento solicitado
	 */
	abstract public int esValido(Pieza [][] tablero, int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino);
	
	
	/**
	 * Determina si el camino que debe seguir la pieza est? libre.
	 * @return   'true' si el camino est? libre y 'false' si no.
	 */
	protected boolean caminoLibre(Pieza [][] tablero, int nFila, int nColumna, int nFilaDestino, int nColumnaDestino) {
		boolean bLibre = true;
		while (bLibre && (nFila!=nFilaDestino || nColumna!=nColumnaDestino)) {
			//Se calcula la siguiente casilla del camino
			if (nColumna==nColumnaDestino) {  //sólo movimiento en fila
				if (nFila<nFilaDestino) {
					nFila++;
				}
				else {
					nFila--;
				}
			}
			else if (nFila==nFilaDestino) {  //sólo movimiento en columna
				if (nColumna<nColumnaDestino) {
					nColumna++;
				}
				else {
					nColumna--;
				}
			}
			else {  //Movimiento en diagonal
				if (nFila<nFilaDestino) {
					nFila++;
					if (nColumna<nColumnaDestino) {
						nColumna++;
					}
					else {
						nColumna--;
					}
				}
				else {
					nFila--;
					if (nColumna<nColumnaDestino) {
						nColumna++;
					}
					else {
						nColumna--;
					}
				}
			}
			//Se comprueba la casilla
			if ((tablero[nFila][nColumna] != null) &&
					!(nFila==nFilaDestino && nColumna==nColumnaDestino)) {
				bLibre = false;
			}
		}
		return bLibre;
	} /* Fin m?todo caminoLibre */
	
	
	/**
	 * Determina si la pieza est? bloqueada o no.
	 * @return   'true' si la pieza est? bloqueada y 'false' si no.
	 */
	abstract public boolean estaBloqueada(Pieza [][] aapTablero);
	
	
	/**
	 * Devuelve la pieza como cadena.
	 */
	public String toString() {
		if (getColor()==Constantes.BLANCO) {
			return (getNombre() + " blanco en " + getFila() + "-" + getColumna());
		}
		else {
			return (getNombre() + " negro en " + getFila() + "-" + getColumna());
		}
	} /* Fin m?todo toString */
	
} /* Fin clase Pieza */
