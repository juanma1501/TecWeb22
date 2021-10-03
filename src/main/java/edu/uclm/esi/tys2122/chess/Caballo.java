package edu.uclm.esi.tys2122.chess;


/* Especifica las caracter?sticas y funciones particulares de un caballo. */
public class Caballo extends Pieza {
	
	
	public Caballo(int nId, char cColor, int nPosFila, int nPosColumna) {
		super(nId, cColor, nPosFila, nPosColumna);
		this.sTipo = "c";
	} /* Fin m?todo constructor */
	
	
	/**
	 * Determina si el movimiento especificado es v?lido o legal.
	 * @return   Clave indicativa de la validez del movimiento. Puede ser:
	 *         0: el movimiento es v?lido o legal
	 *        -1: el movimiento no se corresponde con la pieza del origen
	 */
	public int esValido(Pieza [][] aapTablero, int nFilaOrigen, int nColumnaOrigen, int nFilaDestino, int nColumnaDestino) {
		int nValido;
		if (	/* Arb-Arb-Izq */ (nFilaOrigen+2==nFilaDestino && nColumnaOrigen-1==nColumnaDestino) || 
				/* Arb-Arb-Der */ (nFilaOrigen+2==nFilaDestino && nColumnaOrigen+1==nColumnaDestino) || 
				/* Abj-Der-Der */ (nFilaOrigen-1==nFilaDestino && nColumnaOrigen+2==nColumnaDestino) || 
				/* Arb-Der-Der */ (nFilaOrigen+1==nFilaDestino && nColumnaOrigen+2==nColumnaDestino) || 
				/* Abj-Abj-Izq */ (nFilaOrigen-2==nFilaDestino && nColumnaOrigen-1==nColumnaDestino) || 
				/* Abj-Abj-Der */ (nFilaOrigen-2==nFilaDestino && nColumnaOrigen+1==nColumnaDestino) || 
				/* Abj-Izq-Izq */ (nFilaOrigen-1==nFilaDestino && nColumnaOrigen-2==nColumnaDestino) || 
				/* Abj-Der-Der */ (nFilaOrigen+1==nFilaDestino && nColumnaOrigen-2==nColumnaDestino)) {
			nValido = 0;
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
		//Arriba-Arriba-Izquierda
		if (getFila()-2>=0 && getColumna()-1>=0 && 
				(aapTablero[getFila()-2][getColumna()-1]==null || 
				aapTablero[getFila()-2][getColumna()-1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Arriba-Arriba-Derecha
		if (bEstaBloqueada && getFila()-2>=0 && getColumna()+1<=7 && 
				(aapTablero[getFila()-2][getColumna()+1]==null || 
				aapTablero[getFila()-2][getColumna()+1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Arriba-Izquierda-Izquierda
		if (bEstaBloqueada && getFila()-1>=0 && getColumna()-2>=0 && 
				(aapTablero[getFila()-1][getColumna()-2]==null || 
				aapTablero[getFila()-1][getColumna()-2].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo-Izquierda-Izquierda
		if (bEstaBloqueada && getFila()+1<=7 && getColumna()-2>=0 && 
				(aapTablero[getFila()+1][getColumna()-2]==null || 
				aapTablero[getFila()+1][getColumna()-2].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Arriba-Derecha-Derecha
		if (bEstaBloqueada && getFila()-1>=0 && getColumna()+2<=7 && 
				(aapTablero[getFila()-1][getColumna()+2]==null || 
				aapTablero[getFila()-1][getColumna()+2].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo-Derecha-Derecha
		if (bEstaBloqueada && getFila()+1<=7 && getColumna()+2<=7 && 
				(aapTablero[getFila()+1][getColumna()+2]==null || 
				aapTablero[getFila()+1][getColumna()+2].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo-Abajo-Izquierda
		if (bEstaBloqueada && getFila()+2<=7 && getColumna()-1>=0 && 
				(aapTablero[getFila()+2][getColumna()-1]==null || 
				aapTablero[getFila()+2][getColumna()-1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		//Abajo-Abajo-Derecha
		if (bEstaBloqueada && getFila()+2<=7 && getColumna()+1<=7 && 
				(aapTablero[getFila()+2][getColumna()+1]==null || 
				aapTablero[getFila()+2][getColumna()+1].getColor()!=getColor())) {
			bEstaBloqueada = false;
		}
		return bEstaBloqueada;
	} /* Fin m?todo estaBloqueada */
	
} /* Fin clase Caballo */
