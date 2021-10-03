package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestMoverAlfil extends TestCase {

	
	private Tablero t;
	private Jugador ja, jb;
	
	protected void setUp(){
		ja=new Jugador("ja", "");
		jb=new Jugador("jb", "");
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
	
	
	
	public void testMoverIDAbAr(){
		this.addAlfil(8, 1, 'b');
		int d = t.mover('b', 8, 1, 1, 8,"h8", "a1");
		assertTrue(d == 0);
	}
	
	public void testMoverIDArAb(){
		this.addAlfil(1, 1, 'b');
		int d = t.mover('b', 1, 1, 8, 8,"h1", "a8");
		assertTrue(d == 0);
	}
	
	public void testMoverDIAbAr(){
		this.addAlfil(8, 8, 'b');
		int d = t.mover('b', 8, 8, 1, 1,"a8", "h1");
		assertTrue(d == 0);
	}
	
	public void testMoverDIArAb(){
		this.addAlfil(1, 8, 'b');
		int d = t.mover('b', 1, 8, 8, 1,"a1", "h8");
		assertTrue(d == 0);
	}
	
	
	public void testMoverIDAbArBloc(){
		this.addAlfil(8, 1, 'b');
		this.addPeon(5, 4, 'b');
		int d = t.mover('b', 8, 1, 1, 8,"h8", "a1");
		assertTrue(d == -6);
	}
	
	public void testMoverIDArAbBloc(){
		this.addAlfil(1, 1, 'b');
		this.addPeon(4, 4, 'b');
		int d = t.mover('b', 1, 1, 8, 8,"h1", "a8");
		assertTrue(d == -6);
	}
	
	public void testMoverDIAbArBloc(){
		this.addAlfil(8, 8, 'b');
		this.addPeon(4, 4, 'b');
		int d = t.mover('b', 8, 8, 1, 1,"a8", "h1");
		assertTrue(d == -6);
	}
	
	public void testMoverDIArAbBloc(){
		this.addAlfil(1, 8, 'b');
		this.addPeon(5, 4, 'b');
		int d = t.mover('b', 1, 8, 8, 1,"a1", "h8");
		assertTrue(d == -6);
	}
	
}
