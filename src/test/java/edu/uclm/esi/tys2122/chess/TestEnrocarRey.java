package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestEnrocarRey extends TestCase {

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
	
	protected Torre addTorre(int fila, int colum, char color){
		Torre p = new Torre(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Caballo addCaballo(int fila, int colum, char color){
		Caballo p = new Caballo(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Alfil addAlfil(int fila, int colum, char color){
		Alfil p = new Alfil(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Dama addDama(int fila, int colum, char color){
		Dama p = new Dama(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	protected Rey addRey(int fila, int colum, char color){
		Rey p = new Rey(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		return p;
	}
	
	
	
	public void testErLB(){
		this.addRey(1, 4, 'b');
		this.addTorre(1, 8, 'b');
		
		int dev = t.mover('b', 1, 4, 1, 6, "e1","c1");
		assertTrue(dev == 6);
	}
	
	public void testErCB(){
		this.addRey(1, 4, 'b');
		this.addTorre(1, 1, 'b');
		
		int dev = t.mover('b', 1, 4, 1, 2, "e1","g1");
		assertTrue(dev == 5);
	}
	
	public void testErLN(){
		this.addRey(8, 4, 'n');
		this.addTorre(8, 8, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 8, 4, 8, 6, "e1","c1");
		assertTrue(dev == 6);
	}
	
	public void testErCN(){
		this.addRey(8, 4, 'n');
		this.addTorre(8, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 8, 4, 8, 2, "e1","g1");
		assertTrue(dev == 5);
	}
	
	
	
	public void testErLBbloc(){
		this.addRey(1, 4, 'b');
		this.addTorre(1, 8, 'b');
		this.addCaballo(1, 7, 'b');
		int dev = t.mover('b', 1, 4, 1, 6, "e1","c1");
		assertTrue(dev == -5);
	}
	
	public void testErCBbloc(){
		this.addRey(1, 4, 'b');
		this.addTorre(1, 1, 'b');
		this.addCaballo(1, 3, 'b');
		int dev = t.mover('b', 1, 4, 1, 2, "e1","g1");
		assertTrue(dev == -5);
	}
	
	public void testErLNbloc(){
		this.addRey(8, 4, 'n');
		this.addTorre(8, 8, 'n');
		this.addCaballo(8, 7, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 8, 4, 8, 6, "e1","c1");
		assertTrue(dev == -5);
	}
	
	public void testErCNbloc(){
		this.addRey(8, 4, 'n');
		this.addTorre(8, 1, 'n');
		this.addCaballo(8, 3, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 8, 4, 8, 2, "e1","g1");
		assertTrue(dev == -5);
	}
	
	
	
	public void testErLBNo(){
		this.addRey(1, 4, 'b');
		this.addTorre(2, 8, 'b');
		
		int dev = t.mover('b', 1, 4, 2, 6, "e1","c2");
		assertTrue(dev == -5);
	}
	
	public void testErCBNo(){
		this.addRey(1, 4, 'b');
		this.addTorre(2, 1, 'b');
		
		int dev = t.mover('b', 1, 4, 2, 2, "e1","g2");
		assertTrue(dev == -5);
	}
	
	public void testErLNNo(){
		this.addRey(8, 4, 'n');
		this.addTorre(7, 8, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 8, 4, 7, 6, "e1","c8");
		assertTrue(dev == -5);
	}
	
	public void testErCNNo(){
		this.addRey(8, 4, 'n');
		this.addTorre(7, 1, 'n');
		t.setColorDelJugadorConElTurno('n');
		int dev = t.mover('n', 8, 4, 7, 2, "e1","g1");
		assertTrue(dev == -5);
	}
	
}
