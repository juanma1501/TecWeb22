package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestMoverPeonDoble extends TestCase {

	
	private Tablero t;
	private Jugador ja, jb;
	
	protected void setUp(){
		ja=new Jugador("ja");
		jb=new Jugador("jb");
		t = new Tablero(1, ja, jb);
		Pieza[][] tablero = t.getTablero();
		for(int i = 0;i<tablero.length;i++){
			for(int j = 0;j<tablero[i].length;j++){
				tablero[i][j] = null;
			}
		}
	}
	
	
	protected Peon addPeon(int fila, int colum, char color){
		Peon p = new Peon(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	
	public void testMoverDoble(){
		this.addPeon(1, 4, 'b');
		int dev = t.mover('b', 1, 4, 4, 4, "e1", "e4");
		assertTrue(dev == -5);
	}
	
	public void testMoverDoble2(){
		this.addPeon(2, 4, 'b');
		int dev = t.mover('b', 2, 4, 6, 4, "e2", "e6");
		assertTrue(dev == -5);
	}
	
	
	public void testMoverDobleN(){
		this.addPeon(8, 4, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 8, 4, 5, 4, "e8", "e5");
		assertTrue(dev == -5);
	}
	
	public void testMoverDobleN2(){
		this.addPeon(7, 4, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 7, 4, 4, 4, "e7", "e4");
		assertTrue(dev == -5);
	}
	
	
	public void testMoverDoble3(){
		this.addPeon(6, 4, 'b');		
		int dev = t.mover('b', 6, 4, 4, 4, "e6", "e4");
		assertTrue(dev == -5);
	}
	
	
	public void testMoverDoble3N(){
		this.addPeon(3, 4, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 3, 4, 5, 4, "e3", "e5");
		assertTrue(dev == -5);
	}
	
}
