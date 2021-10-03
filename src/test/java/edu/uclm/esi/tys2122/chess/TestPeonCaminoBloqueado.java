package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestPeonCaminoBloqueado extends TestCase {

	public void testPeonMoverDobleCBNegro(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		t.setColorDelJugadorConElTurno('n');
		
		
		Pieza o= t.getTablero()[1][3];
		t.getTablero()[1][3] = null;
		t.getTablero()[5][3] = o;
		dev = t.mover('n', 7, 4, 5, 4, "e7", "e5");
		super.assertEquals(-6, dev);
	}
	
	public void testPeonMoverDobleCBBlanco(){
		int dev;
		
		Tablero t = new Tablero(1, new Jugador("a", ""), new Jugador("b", ""));
		
		Pieza o= t.getTablero()[6][3];
		t.getTablero()[6][3] = null;
		t.getTablero()[2][3] = o;
		
		dev = t.mover('b', 2, 4, 4, 4, "e2", "e4");
		super.assertEquals(-6, dev);
	}
	
	
	
}
