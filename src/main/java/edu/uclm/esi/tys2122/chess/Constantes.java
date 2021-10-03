package edu.uclm.esi.tys2122.chess;

public class Constantes {
	public static final char BLANCO = 'b', NEGRO = 'n';
	
	/*** Restultados de mover ***/
	public static final int CORRECTO = 0;
	public static final int CORRECTO_COMIENDO = 1;
	public static final int CORRECTO_CORONANDO = 2;
	public static final int CORRECTO_COMIENDO_Y_CORONANDO = 3;
	public static final int CORRECTO_COMIENDO_AL_PASO = 4;
	public static final int CORRECTO_Y_ENROQUE_CORTO = 5;
	public static final int CORRECTO_Y_ENROQUE_LARGO = 6;
	
	public static final int NO_TIENE_EL_TURNO = -1;
	public static final int NO_HAY_PIEZA_EN_ORIGEN = -2;
	public static final int PIEZA_EN_ORIGEN_NO_ES_DEL_JUGADOR = -3;
	public static final int DESTINO_OCUPADO_POR_MISMO_COLOR = -4;
	public static final int MOVIMIENTO_NO_CORRESPONDE_A_PIEZA = -5;
	public static final int PIEZA_IMPIDE_MOVIMIENTO = -6;
	public static final int REY_QUEDARIA_EN_JAQUE = -7;
	
	public static final int JAQUE = 10;
	public static final int JAQUE_MATE = 20;
	public static final int TABLAS = 30;
}
