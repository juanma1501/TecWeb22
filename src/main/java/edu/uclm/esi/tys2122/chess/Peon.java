package edu.uclm.esi.tys2122.chess;


/* Especifica las caracter?sticas y funciones particulares de un pe?n. */
public class Peon extends Pieza {
	
	
	public Peon(int nId, char cColor, int nPosFila, int nPosColumna) {
		super(nId, cColor, nPosFila, nPosColumna);
		this.sTipo = "p";
	} /* Fin m?todo constructor */
	
	
	/**
	 * Determina si el movimiento especificado es v?lido o legal.
	 * @return   Clave indicativa de la validez del movimiento. Puede ser:
	 *         0: el movimiento es v?lido o legal
	 *         1: se quiere tomar al paso a otro pe?n
	 *        -1: el movimiento no se corresponde con la pieza del origen
	 *        -2: hay una pieza en medio que impide el movimiento solicitado
	 */
	public int esValido(Pieza [][] tablero, int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino) {
		int nValido;
		if (	/* Movimiento normal */
				(nColumnaOrigen==nColumnaDestino && nFilaOrigen+1==nFilaDestino && getColor()=='b')
				|| (nColumnaOrigen==nColumnaDestino && nFilaOrigen-1==nFilaDestino && getColor()=='n')
				/* Movimiento de dos casillas en el inicio */
				|| (nColumnaOrigen==nColumnaDestino && nFilaOrigen==1 && nFilaDestino==3 && getColor()=='b')
				|| (nColumnaOrigen==nColumnaDestino && nFilaOrigen==6 && nFilaDestino==4 && getColor()=='n')) {
			if (caminoLibre(tablero, nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino)) {
				nValido = 0;
			}
			else {
				nValido = -2;
			}
		}
		else if (  /* Comer otra pieza hacia la derecha */
				(nColumnaOrigen+1==nColumnaDestino && nFilaOrigen+1==nFilaDestino && getColor()=='b' && tablero[nFilaDestino][nColumnaDestino]!=null)
				|| (nColumnaOrigen+1==nColumnaDestino && nFilaOrigen-1==nFilaDestino && getColor()=='n' && tablero[nFilaDestino][nColumnaDestino]!=null)
				/* Comer otra pieza hacia la izquierda */
				|| (nColumnaOrigen-1==nColumnaDestino && nFilaOrigen+1==nFilaDestino && getColor()=='b' && tablero[nFilaDestino][nColumnaDestino]!=null)
				|| (nColumnaOrigen-1==nColumnaDestino && nFilaOrigen-1==nFilaDestino && getColor()=='n' && tablero[nFilaDestino][nColumnaDestino]!=null)) {
			nValido = 0;
		}
		else if (  /* Se quiere tomar otro pe?n al paso */
				(tablero[nFilaDestino][nColumnaDestino]==null && tablero[nFilaOrigen][nColumnaDestino]!=null && tablero[nFilaOrigen][nColumnaDestino].getTipo().equals("p")) && 
				/* Tomar otro pe?n al paso hacia la derecha */
				((nColumnaOrigen+1==nColumnaDestino && nFilaOrigen+1==nFilaDestino && getColor()=='b' && tablero[nFilaOrigen][nColumnaDestino].getColor()=='n')
				|| (nColumnaOrigen+1==nColumnaDestino && nFilaOrigen-1==nFilaDestino && getColor()=='n' && tablero[nFilaOrigen][nColumnaDestino].getColor()=='b')
				/* Tomar otro pe?n al paso hacia la izquierda */
				|| (nColumnaOrigen-1==nColumnaDestino && nFilaOrigen+1==nFilaDestino && getColor()=='b' && tablero[nFilaOrigen][nColumnaDestino].getColor()=='n')
				|| (nColumnaOrigen-1==nColumnaDestino && nFilaOrigen-1==nFilaDestino && getColor()=='n' && tablero[nFilaOrigen][nColumnaDestino].getColor()=='b'))) {
			nValido = 1;
		}
		else {
			nValido = -1;
		}
		return nValido;
	}  /* Fin m?todo esValido */
	
	
	/**
	 * Determina si el camino que debe seguir la pieza est? libre.
	 * @return   'true' si el camino est? libre y 'false' si no.
	 */
	protected boolean caminoLibre(Pieza [][] tablero, int nFila, int nColumna, int nFilaDestino, int nColumnaDestino) {
		boolean bLibre = true;
		while (bLibre && (nFila!=nFilaDestino || nColumna!=nColumnaDestino)) {
			//Se calcula la siguiente casilla del camino: s?lo movimiento en fila
			if (nFila<nFilaDestino) {
				nFila++;
			}
			else {
				nFila--;
			}
			//Se comprueba la casilla
			if (tablero[nFila][nColumna] != null) {
				bLibre = false;
			}
		}
		return bLibre;
	} /* Fin m?todo caminoLibre */
	
	
	/**
	 * Determina si la pieza est? bloqueada o no.
	 * @return   'true' si la pieza est? bloqueada y 'false' si no.
	 */
	public boolean estaBloqueada(Pieza [][] aapTablero) {
		boolean bEstaBloqueada = true;
		if (getColor()=='b') {
			//Abajo-Izquierda
			if (bEstaBloqueada && getFila()+1<=7 && getColumna()-1>=0 && 
					(aapTablero[getFila()+1][getColumna()-1]==null || 
					aapTablero[getFila()+1][getColumna()-1].getColor()!=getColor())) {
				bEstaBloqueada = false;
			}
			//Abajo-Centro
			if (bEstaBloqueada && getFila()+1<=7 && 
					aapTablero[getFila()+1][getColumna()]==null) {
				bEstaBloqueada = false;
			}
			//Abajo-Derecha
			if (bEstaBloqueada && getFila()+1<=7 && getColumna()+1<=7 && 
					(aapTablero[getFila()+1][getColumna()+1]==null || 
					aapTablero[getFila()+1][getColumna()+1].getColor()!=getColor())) {
				bEstaBloqueada = false;
			}
		}
		else {
			//Arriba-Izquierda
			if (bEstaBloqueada && getFila()-1>=0 && getColumna()-1>=0 && 
					(aapTablero[getFila()-1][getColumna()-1]==null || 
					aapTablero[getFila()-1][getColumna()-1].getColor()!=getColor())) {
				bEstaBloqueada = false;
			}
			//Arriba-Centro
			if (bEstaBloqueada && getFila()-1>=0 && 
					aapTablero[getFila()-1][getColumna()]==null) {
				bEstaBloqueada = false;
			}
			//Arriba-Derecha
			if (bEstaBloqueada && getFila()-1>=0 && getColumna()+1<=7 && 
					(aapTablero[getFila()-1][getColumna()+1]==null || 
					aapTablero[getFila()-1][getColumna()+1].getColor()!=getColor())) {
				bEstaBloqueada = false;
			}
		}
		return bEstaBloqueada;
	} /* Fin m?todo estaBloqueada */
	
} /* Fin clase Peon */
