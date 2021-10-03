package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestBloquearFichasOtrosColores extends TestCase {

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
	
	
	
	
	/****************************PEONES**********************************/
	
	public void testbloquearPeonLlenodB(){
		Peon p = this.addPeon(4, 4, 'b');
		this.addTorre(3, 4, 'n');
		this.addTorre(3, 3, 'b');
		this.addTorre(3, 5, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testbloquearPeonLlenodB_2(){
		Peon p = this.addPeon(4, 4, 'b');
		this.addTorre(3, 4, 'b');
		this.addTorre(3, 3, 'b');
		this.addTorre(3, 5, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testbloquearPeonLlenodN_2(){
		Peon p = this.addPeon(4, 4, 'n');
		this.addTorre(3, 4, 'n');
		this.addTorre(3, 3, 'n');
		this.addTorre(3, 5, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	
	
	
	/****************************** Caballos **************/
	
	
	public void testbloquearCaballoFichasB_1(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasB_2(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasB_3(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasB_4(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasB_5(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasB_6(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasB_7(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasB_8(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	

	public void testbloquearCaballoFichasN_1(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testbloquearCaballoFichasN_2(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasN_3(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasN_4(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasN_5(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasN_6(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasN_7(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'n');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testbloquearCaballoFichasN_8(){
		Caballo c = this.addCaballo(4, 4, 'n');
		this.addCaballo(2, 3, 'n');
		this.addCaballo(2, 5, 'n');
		this.addCaballo(3, 2, 'n');
		this.addCaballo(5, 2, 'n');
		this.addCaballo(3, 6, 'n');
		this.addCaballo(5, 6, 'n');
		this.addCaballo(6, 3, 'n');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	/**********************************Torre*****/
	
	
	public void testBloquearTorreB_1(){
		Torre t = this.addTorre(4, 4, 'b');
		this.addTorre(3, 4, 'n');
		this.addTorre(5, 4, 'b');
		this.addTorre(4, 3, 'b');
		this.addTorre(4, 5, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearTorreB_2(){
		Torre t = this.addTorre(4, 4, 'b');
		this.addTorre(3, 4, 'b');
		this.addTorre(5, 4, 'n');
		this.addTorre(4, 3, 'b');
		this.addTorre(4, 5, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearTorreB_3(){
		Torre t = this.addTorre(4, 4, 'b');
		this.addTorre(3, 4, 'b');
		this.addTorre(5, 4, 'b');
		this.addTorre(4, 3, 'n');
		this.addTorre(4, 5, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearTorreB_4(){
		Torre t = this.addTorre(4, 4, 'b');
		this.addTorre(3, 4, 'b');
		this.addTorre(5, 4, 'b');
		this.addTorre(4, 3, 'b');
		this.addTorre(4, 5, 'n');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearTorreN_1(){
		Torre t = this.addTorre(4, 4, 'n');
		this.addTorre(3, 4, 'b');
		this.addTorre(5, 4, 'n');
		this.addTorre(4, 3, 'n');
		this.addTorre(4, 5, 'n');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearTorreN_2(){
		Torre t = this.addTorre(4, 4, 'n');
		this.addTorre(3, 4, 'n');
		this.addTorre(5, 4, 'b');
		this.addTorre(4, 3, 'n');
		this.addTorre(4, 5, 'n');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearTorreN_3(){
		Torre t = this.addTorre(4, 4, 'n');
		this.addTorre(3, 4, 'n');
		this.addTorre(5, 4, 'n');
		this.addTorre(4, 3, 'b');
		this.addTorre(4, 5, 'n');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearTorreN_4(){
		Torre t = this.addTorre(4, 4, 'n');
		this.addTorre(3, 4, 'n');
		this.addTorre(5, 4, 'n');
		this.addTorre(4, 3, 'n');
		this.addTorre(4, 5, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	/*************************ALFIL**************/
	
	public void testBloquearAlfilB_1(){
		Alfil f = this.addAlfil(4, 4, 'b');
		this.addAlfil(3, 3, 'n');
		this.addAlfil(5, 5, 'b');
		this.addAlfil(3, 5, 'b');
		this.addAlfil(5, 3, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearAlfilB_2(){
		Alfil f = this.addAlfil(4, 4, 'b');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(5, 5, 'n');
		this.addAlfil(3, 5, 'b');
		this.addAlfil(5, 3, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearAlfilB_3(){
		Alfil f = this.addAlfil(4, 4, 'b');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(5, 5, 'b');
		this.addAlfil(3, 5, 'n');
		this.addAlfil(5, 3, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearAlfilB_4(){
		Alfil f = this.addAlfil(4, 4, 'b');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(5, 5, 'b');
		this.addAlfil(3, 5, 'b');
		this.addAlfil(5, 3, 'n');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearAlfilN_1(){
		Alfil f = this.addAlfil(4, 4, 'n');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(5, 5, 'n');
		this.addAlfil(3, 5, 'n');
		this.addAlfil(5, 3, 'n');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearAlfilN_2(){
		Alfil f = this.addAlfil(4, 4, 'n');
		this.addAlfil(3, 3, 'n');
		this.addAlfil(5, 5, 'b');
		this.addAlfil(3, 5, 'n');
		this.addAlfil(5, 3, 'n');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearAlfilN_3(){
		Alfil f = this.addAlfil(4, 4, 'n');
		this.addAlfil(3, 3, 'n');
		this.addAlfil(5, 5, 'n');
		this.addAlfil(3, 5, 'b');
		this.addAlfil(5, 3, 'n');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearAlfilN_4(){
		Alfil f = this.addAlfil(4, 4, 'n');
		this.addAlfil(3, 3, 'n');
		this.addAlfil(5, 5, 'n');
		this.addAlfil(3, 5, 'n');
		this.addAlfil(5, 3, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	
	/***********************DAMA****************************/
	
	
	public void testBloquearDamaB_1(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaB_2(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaB_3(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaB_4(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaB_5(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaB_6(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaB_7(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaB_8(){
		Dama m = this.addDama(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearDamaN_1(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaN_2(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaN_3(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaN_4(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaN_5(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaN_6(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaN_7(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaN_8(){
		Dama m = this.addDama(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	/*************************Rey************************/
	
	
	public void testBloquearReyB_1(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyB_2(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyB_3(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyB_4(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyB_5(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyB_6(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyB_7(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyB_8(){
		Rey m = this.addRey(4, 4, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearReyN_1(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyN_2(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyN_3(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'b');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyN_4(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'b');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyN_5(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'b');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyN_6(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'b');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyN_7(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'n');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyN_8(){
		Rey m = this.addRey(4, 4, 'n');
		this.addDama(3, 3, 'n');
		this.addDama(3, 4, 'n');
		this.addDama(3, 5, 'n');
		this.addDama(4, 3, 'n');
		this.addDama(4, 5, 'b');
		this.addDama(5, 3, 'n');
		this.addDama(5, 4, 'n');
		this.addDama(5, 5, 'n');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	

}
