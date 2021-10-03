package edu.uclm.esi.tys2122.chess;


/* Especifica las caracter?sticas y funciones particulares de una torre. */
public class Torre extends Pieza {
	
	
	public Torre(int nId, char cColor, int nPosFila, int nPosColumna) {
		super(nId, cColor, nPosFila, nPosColumna);
		this.sTipo = "t";
	} /* Fin m?todo constructor */
	
	
	/**
	 * Determina si el movimiento especificado es v?lido o legal.
	 * @return   Clave indicativa de la validez del movimiento. Puede ser:
	 *         0: el movimiento es v?lido o legal
	 *        -1: el movimiento no se corresponde con la pieza del origen
	 *        -2: hay una pieza en medio que impide el movimiento solicitado
	 */
	public int esValido(Pieza [][] aapTablero, int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino) {
		int nValido;
		if (nFilaOrigen==nFilaDestino || nColumnaOrigen==nColumnaDestino) {
			if (caminoLibre(aapTablero, nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino)) {
				nValido = 0;
			}
			else {
				nValido = -2;
			}
		}
		else {
			nValido = -1;
		}
		return nValido;
	}  /* Fin m?todo esValido */
	
	
	/**
	 * Determina si la pieza est? bloqueada o no.
	 * @return   'true' si la pieza est? bloqueada y 'false' si no.
	 */
	public boolean estaBloqueada(Pieza [][] aapTablero) {
		boolean bEstaBloqueada = true;
		//Arriba
		if (getFila()-1>=0 && 
				(aapTablero[getFila()-1][getColumna()]==null || 
				aapTablero[getFila()-1][getColumna()].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo
		if (bEstaBloqueada && getFila()+1<=7 && 
				(aapTablero[getFila()+1][getColumna()]==null || 
				aapTablero[getFila()+1][getColumna()].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Izquierda
		if (bEstaBloqueada && getColumna()-1>=0 && 
				(aapTablero[getFila()][getColumna()-1]==null || 
				aapTablero[getFila()][getColumna()-1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Derecha
		if (bEstaBloqueada && getColumna()+1<=7 && 
				(aapTablero[getFila()][getColumna()+1]==null || 
				aapTablero[getFila()][getColumna()+1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		return bEstaBloqueada;
	} /* Fin m?todo estaBloqueada */
	
} /* Fin clase Torre */
