package edu.uclm.esi.tys2122.chess;


/* Especifica las caracter?sticas y funciones particulares de un rey. */
public class Rey extends Pieza {
	
	private boolean bPosibleEnroqueCorto = true;
	private boolean bPosibleEnroqueLargo = true;
	
	
	public Rey(int nId, char cColor, int nPosFila, int nPosColumna) {
		super(nId, cColor, nPosFila, nPosColumna);
		this.sTipo = "r";
	} /* Fin m?todo constructor */
	
	
	/**
	 * Indica si el rey puede hacer el enroque corto.
	 */
	public boolean getEnroqueCorto() {
		return bPosibleEnroqueCorto;
	} /* Fin m?todo getEnroqueCorto */
	
	
	/**
	 * Indica al rey que ya no puede hacer el enroque corto.
	 */
	public void deshabilitarEnroqueCorto() {
		bPosibleEnroqueCorto = false;
	} /* Fin m?todo deshabilitarEnroqueCorto */
	
	
	/**
	 * Indica si el rey puede hacer el enroque largo.
	 */
	public boolean getEnroqueLargo() {
		return bPosibleEnroqueLargo;
	} /* Fin m?todo getEnroqueLargo */
	
	
	/**
	 * Indica al rey que ya no puede hacer el enroque largo.
	 */
	public void deshabilitarEnroqueLargo() {
		bPosibleEnroqueLargo = false;
	} /* Fin m?todo deshabilitarEnroqueLargo */
	
	
	/**
	 * Determina si el movimiento especificado es v?lido o legal.
	 * @return   Clave indicativa de la validez del movimiento. Puede ser:
	 *         0: el movimiento es v?lido o legal
	 *         2: se ha realizado el enroque corto
	 *         3: se ha realizado el enroque largo
	 *        -1: el movimiento no se corresponde con la pieza del origen
	 */
	public int esValido(Pieza [][] aapTablero, int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino) {
		int nValido;
		if (	/* Arb-Izq */ (nFilaOrigen+1==nFilaDestino && nColumnaOrigen-1==nColumnaDestino) || 
				/* Arb-Cen */ (nFilaOrigen+1==nFilaDestino && nColumnaOrigen==nColumnaDestino)   || 
				/* Arb-Der */ (nFilaOrigen+1==nFilaDestino && nColumnaOrigen+1==nColumnaDestino) || 
				/* Cen-Der */ (nFilaOrigen==nFilaDestino   && nColumnaOrigen+1==nColumnaDestino) || 
				/* Abj-Der */ (nFilaOrigen-1==nFilaDestino && nColumnaOrigen+1==nColumnaDestino) || 
				/* Abj-Cen */ (nFilaOrigen-1==nFilaDestino && nColumnaOrigen==nColumnaDestino)   || 
				/* Abj-Izq */ (nFilaOrigen-1==nFilaDestino && nColumnaOrigen-1==nColumnaDestino) || 
				/* Cen-Izq */ (nFilaOrigen==nFilaDestino   && nColumnaOrigen-1==nColumnaDestino)) {
			nValido = 0;
		}
		else if (getEnroqueCorto() && nFilaOrigen==nFilaDestino && nColumnaOrigen-2==nColumnaDestino 
				&& caminoLibre(aapTablero, nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino-1)) {  // Enroque corto
			nValido = 2;
		}
		else if (getEnroqueLargo() && nFilaOrigen==nFilaDestino && nColumnaOrigen+2==nColumnaDestino 
				&& caminoLibre(aapTablero, nFilaOrigen, nColumnaOrigen, nFilaDestino, nColumnaDestino+2)) {  // Enroque largo
			nValido = 3;
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
		//Arriba-Izquierda
		if (getFila()-1>=0 && getColumna()-1>=0 && 
				(aapTablero[getFila()-1][getColumna()-1]==null || 
				aapTablero[getFila()-1][getColumna()-1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Arriba-Centro
		if (bEstaBloqueada && getFila()-1>=0 && 
				(aapTablero[getFila()-1][getColumna()]==null || 
				aapTablero[getFila()-1][getColumna()].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Arriba-Derecha
		if (bEstaBloqueada && getFila()-1>=0 && getColumna()+1<=7 && 
				(aapTablero[getFila()-1][getColumna()+1]==null || 
				aapTablero[getFila()-1][getColumna()+1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Centro-Izquierda
		if (bEstaBloqueada && getColumna()-1>=0 && 
				(aapTablero[getFila()][getColumna()-1]==null || 
				aapTablero[getFila()][getColumna()-1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Centro-Derecha
		if (bEstaBloqueada && getColumna()+1<=7 && 
				(aapTablero[getFila()][getColumna()+1]==null || 
				aapTablero[getFila()][getColumna()+1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo-Izquierda
		if (bEstaBloqueada && getFila()+1<=7 && getColumna()-1>=0 && 
				(aapTablero[getFila()+1][getColumna()-1]==null || 
				aapTablero[getFila()+1][getColumna()-1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo-Centro
		if (bEstaBloqueada && getFila()+1<=7 && 
				(aapTablero[getFila()+1][getColumna()]==null || 
				aapTablero[getFila()+1][getColumna()].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo-Derecha
		if (bEstaBloqueada && getFila()+1<=7 && getColumna()+1<=7 && 
				(aapTablero[getFila()+1][getColumna()+1]==null || 
				aapTablero[getFila()+1][getColumna()+1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		return bEstaBloqueada;
	} /* Fin m?todo estaBloqueada */
	
} /* Fin clase Rey */
