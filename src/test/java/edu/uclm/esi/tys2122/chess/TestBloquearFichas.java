package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestBloquearFichas extends TestCase {

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
	
	
	
	
	/****************************PEONES**********************************/
	
	public void testbloquearPeonLlenodB(){
		Peon p = this.addPeon(4, 4, 'b');
		this.addTorre(5, 4, 'b');
		this.addTorre(5, 3, 'b');
		this.addTorre(5, 5, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearPeonLlenodN(){
		Peon p = this.addPeon(4, 4, 'n');
		this.addTorre(3, 4, 'n');
		this.addTorre(3, 3, 'n');
		this.addTorre(3, 5, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearPeonVaciosBAb(){
		Peon p = this.addPeon(8, 4, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	
	public void testbloquearPeonVaciosNAb(){
		Peon p = this.addPeon(1, 4, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}

	public void testbloquearPeonLlenodBD(){
		Peon p = this.addPeon(4, 8, 'b');
		this.addTorre(5, 8, 'b');
		this.addTorre(5, 7, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	
	public void testbloquearPeonLlenodND(){
		Peon p = this.addPeon(4, 8, 'n');
		this.addTorre(3, 8, 'n');
		this.addTorre(3, 7, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearPeonLlenodBI(){
		Peon p = this.addPeon(4, 1, 'b');
		this.addTorre(5, 1, 'b');
		this.addTorre(5, 2, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	
	public void testbloquearPeonLlenodNI(){
		Peon p = this.addPeon(4, 1, 'n');
		this.addTorre(3, 1, 'n');
		this.addTorre(3, 2, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testNobloquearPeonLlenodBAbI(){
		Peon p = this.addPeon(7, 2, 'b');
		this.addTorre(8, 3, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	
	public void testNobloquearPeonLlenodBAbD(){
		Peon p = this.addPeon(7, 7, 'b');
		this.addTorre(8, 6, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearPeonLlenodNAbI(){
		Peon p = this.addPeon(2, 2, 'n');
		this.addTorre(1, 3, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearPeonLlenodNAbD(){
		Peon p = this.addPeon(2, 7, 'n');
		this.addTorre(1, 6, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	
	/****************************** Caballos **************/
	
	
	public void testbloquearCaballoLateralI(){
		Caballo c = this.addCaballo(4, 1, 'b');
		this.addCaballo(2, 2, 'b');
		this.addCaballo(3, 3, 'b');
		this.addCaballo(5, 3, 'b');
		this.addCaballo(6, 2, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	public void testbloquearCaballoLateralI2(){
		Caballo c = this.addCaballo(4, 2, 'b');
		this.addCaballo(2, 1, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(3, 4, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 1, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearCaballoLateralD(){
		Caballo c = this.addCaballo(4, 8, 'b');
		this.addCaballo(2, 7, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 7, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	public void testbloquearCaballoLateralD2(){
		Caballo c = this.addCaballo(4, 7, 'b');
		this.addCaballo(2, 8, 'b');
		this.addCaballo(2, 6, 'b');
		this.addCaballo(5, 5, 'b');
		this.addCaballo(3, 5, 'b');
		this.addCaballo(6, 6, 'b');
		this.addCaballo(6, 8, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	
	public void testbloquearCaballoFichas(){
		Caballo c = this.addCaballo(4, 4, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(3, 2, 'b');
		this.addCaballo(5, 2, 'b');
		this.addCaballo(3, 6, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 3, 'b');
		this.addCaballo(6, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearCaballoFichasArI(){
		Caballo c = this.addCaballo(1, 1, 'b');
		this.addCaballo(2, 3, 'b');
		this.addCaballo(3, 2, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearCaballoFichasArI2(){
		Caballo c = this.addCaballo(2, 2, 'b');
		this.addCaballo(1, 4, 'b');
		this.addCaballo(3, 4, 'b');
		this.addCaballo(4, 1, 'b');
		this.addCaballo(4, 3, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearCaballoFichasAbD(){
		Caballo c = this.addCaballo(8, 8, 'b');
		this.addCaballo(7, 6, 'b');
		this.addCaballo(6, 7, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	public void testbloquearCaballoFichasAbD2(){
		Caballo c = this.addCaballo(7, 7, 'b');
		this.addCaballo(5, 8, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 5, 'b');
		this.addCaballo(8, 5, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b);
	}
	
	
	public void testNobloquearCaballoAbD_1(){
		Caballo c = this.addCaballo(7, 7, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 5, 'b');
		this.addCaballo(5, 8, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearCaballoAbD_2(){
		Caballo c = this.addCaballo(7, 7, 'b');
		this.addCaballo(5, 6, 'b');
		this.addCaballo(6, 5, 'b');
		this.addCaballo(8, 5, 'b');
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearCaballoAbD2_1(){
		Caballo c = this.addCaballo(6, 6, 'b');
		this.addCaballo(4, 7, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(7, 4, 'b');
		
		
		this.addCaballo(7, 8, 'b');
		this.addCaballo(8, 5, 'b');
		this.addCaballo(8, 7, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearCaballoAbD2_2(){
		Caballo c = this.addCaballo(6, 6, 'b');
		this.addCaballo(4, 7, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(7, 4, 'b');
		
		this.addCaballo(5, 8, 'b');
		
		this.addCaballo(8, 5, 'b');
		this.addCaballo(8, 7, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearCaballoAbD2_3(){
		Caballo c = this.addCaballo(6, 6, 'b');
		this.addCaballo(4, 7, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(7, 4, 'b');
		
		this.addCaballo(5, 8, 'b');
		this.addCaballo(7, 8, 'b');
		
		this.addCaballo(8, 7, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearCaballoAbD2_4(){
		Caballo c = this.addCaballo(6, 6, 'b');
		this.addCaballo(4, 7, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(7, 4, 'b');
		
		this.addCaballo(5, 8, 'b');
		this.addCaballo(7, 8, 'b');
		this.addCaballo(8, 5, 'b');
		
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearCaballoArI_1(){
		Caballo c = this.addCaballo(2, 2, 'b');
		this.addCaballo(4, 3, 'b');
		this.addCaballo(3, 4, 'b');
		this.addCaballo(1, 4, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearCaballoArI_2(){
		Caballo c = this.addCaballo(2, 2, 'b');
		this.addCaballo(4, 3, 'b');
		this.addCaballo(3, 4, 'b');
		this.addCaballo(4, 1, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearCaballoArI2_1(){
		Caballo c = this.addCaballo(3, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(5, 2, 'b');
		
		
		this.addCaballo(1, 2, 'b');
		this.addCaballo(2, 1, 'b');
		this.addCaballo(4, 1, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearCaballoArI2_2(){
		Caballo c = this.addCaballo(3, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(5, 2, 'b');
		
		this.addCaballo(1, 4, 'b');
		
		this.addCaballo(2, 1, 'b');
		this.addCaballo(4, 1, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearCaballoArI2_3(){
		Caballo c = this.addCaballo(3, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(5, 2, 'b');
		
		
		this.addCaballo(1, 4, 'b');
		this.addCaballo(1, 2, 'b');
		
		this.addCaballo(4, 1, 'b');
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearCaballoArI2_4(){
		Caballo c = this.addCaballo(3, 3, 'b');
		this.addCaballo(2, 5, 'b');
		this.addCaballo(4, 5, 'b');
		this.addCaballo(5, 4, 'b');
		this.addCaballo(5, 2, 'b');
		
		
		this.addCaballo(1, 4, 'b');
		this.addCaballo(1, 2, 'b');
		this.addCaballo(2, 1, 'b');
		
		
		boolean b = c.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	/**********************************Torre*****/
	
	
	public void testBloquearTorreLateralAr(){
		Torre t = this.addTorre(1, 4, 'b');
		this.addTorre(1, 3, 'b');
		this.addTorre(1, 5, 'b');
		this.addTorre(2, 4, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearTorreLateralAr_1(){
		Torre t = this.addTorre(2, 4, 'b');
		this.addTorre(2, 3, 'b');
		this.addTorre(2, 5, 'b');
		this.addTorre(3, 4, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	public void testBloquearTorreLateralAb(){
		Torre t = this.addTorre(8, 4, 'b');
		this.addTorre(8, 3, 'b');
		this.addTorre(8, 5, 'b');
		this.addTorre(7, 4, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearTorreLateralAb_1(){
		Torre t = this.addTorre(7, 4, 'b');
		this.addTorre(7, 3, 'b');
		this.addTorre(7, 5, 'b');
		this.addTorre(6, 4, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearTorreLateralD(){
		Torre t = this.addTorre(5, 8, 'b');
		this.addTorre(4, 8, 'b');
		this.addTorre(6, 8, 'b');
		this.addTorre(5, 7, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearTorreLateralD_1(){
		Torre t = this.addTorre(5, 7, 'b');
		this.addTorre(4, 7, 'b');
		this.addTorre(6, 7, 'b');
		this.addTorre(5, 6, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearTorreLateralI(){
		Torre t = this.addTorre(5, 1, 'b');
		this.addTorre(4, 1, 'b');
		this.addTorre(6, 1, 'b');
		this.addTorre(5, 2, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearTorreLateralI_1(){
		Torre t = this.addTorre(5, 2, 'b');
		this.addTorre(4, 2, 'b');
		this.addTorre(6, 2, 'b');
		this.addTorre(5, 3, 'b');
		
		boolean b = t.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	/*************************ALFIL**************/
	
	
	public void testBloquearAlfilLateralI(){
		Alfil f = this.addAlfil(4, 1, 'b');
		this.addAlfil(3, 2, 'b');
		this.addAlfil(5, 2, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearAlfilLateralI_1(){
		Alfil f = this.addAlfil(4, 2, 'b');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(5, 3, 'b');
		this.addAlfil(3, 1, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearAlfilLateralI_2(){
		Alfil f = this.addAlfil(4, 2, 'b');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(5, 3, 'b');
		this.addAlfil(5, 1, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	public void testBloquearAlfilLateralD(){
		Alfil f = this.addAlfil(4, 8, 'b');
		this.addAlfil(3, 7, 'b');
		this.addAlfil(5, 7, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearAlfilLateralD_1(){
		Alfil f = this.addAlfil(4, 7, 'b');
		this.addAlfil(3, 6, 'b');
		this.addAlfil(5, 6, 'b');
		this.addAlfil(3, 8, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearAlfilLateralD_2(){
		Alfil f = this.addAlfil(4, 7, 'b');
		this.addAlfil(3, 6, 'b');
		this.addAlfil(5, 6, 'b');
		this.addAlfil(5, 8, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearAlfilLateralAr(){
		Alfil f = this.addAlfil(1, 4, 'b');
		this.addAlfil(2, 3, 'b');
		this.addAlfil(2, 5, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearAlfilLateralAr_1(){
		Alfil f = this.addAlfil(2, 4, 'b');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(3, 5, 'b');
		this.addAlfil(1, 3, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearAlfilLateralAr_2(){
		Alfil f = this.addAlfil(2, 4, 'b');
		this.addAlfil(3, 3, 'b');
		this.addAlfil(3, 5, 'b');
		this.addAlfil(1, 5, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearAlfilLateralAb(){
		Alfil f = this.addAlfil(8, 4, 'b');
		this.addAlfil(7, 3, 'b');
		this.addAlfil(7, 5, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearAlfilLateralAb_1(){
		Alfil f = this.addAlfil(7, 4, 'b');
		this.addAlfil(6, 3, 'b');
		this.addAlfil(6, 5, 'b');
		this.addAlfil(8, 3, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	public void testBloquearAlfilLateralAb_2(){
		Alfil f = this.addAlfil(7, 4, 'b');
		this.addAlfil(6, 3, 'b');
		this.addAlfil(6, 5, 'b');
		this.addAlfil(8, 5, 'b');
		
		boolean b = f.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	/***********************DAMA****************************/
	
	
	public void testBloquearDamaLateralI(){
		Dama m = this.addDama(4, 1, 'b');
		this.addDama(3, 1, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(4, 2, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(5, 1, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearDamaLateralI_1(){
		Dama m = this.addDama(4, 2, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(4, 1, 'b');
		this.addDama(5, 1, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralI_2(){
		Dama m = this.addDama(4, 2, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(3, 1, 'b');
		this.addDama(5, 1, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralI_3(){
		Dama m = this.addDama(4, 2, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(4, 1, 'b');
		this.addDama(3, 1, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	public void testBloquearDamaLateralD(){
		Dama m = this.addDama(4, 8, 'b');
		this.addDama(3, 8, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(4, 7, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(5, 8, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearDamaLateralD_1(){
		Dama m = this.addDama(4, 7, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(3, 6, 'b');
		this.addDama(4, 6, 'b');
		this.addDama(5, 6, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(4, 8, 'b');
		this.addDama(5, 8, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralD_2(){
		Dama m = this.addDama(4, 7, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(3, 6, 'b');
		this.addDama(4, 6, 'b');
		this.addDama(5, 6, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(3, 8, 'b');
		this.addDama(5, 8, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralD_3(){
		Dama m = this.addDama(4, 7, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(3, 6, 'b');
		this.addDama(4, 6, 'b');
		this.addDama(5, 6, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(4, 8, 'b');
		this.addDama(3, 8, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearDamaLateralAr(){
		Dama m = this.addDama(1, 4, 'b');
		this.addDama(1, 3, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(2, 4, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearDamaLateralAr_1(){
		Dama m = this.addDama(2, 4, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 3, 'b');
		this.addDama(1, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralAr_2(){
		Dama m = this.addDama(2, 4, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 3, 'b');
		this.addDama(1, 5, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralAr_3(){
		Dama m = this.addDama(2, 4, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 5, 'b');
		this.addDama(1, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearDamaLateralAb(){
		Dama m = this.addDama(8, 4, 'b');
		this.addDama(8, 3, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(7, 4, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearDamaLateralAb_1(){
		Dama m = this.addDama(7, 4, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(6, 3, 'b');
		this.addDama(6, 4, 'b');
		this.addDama(6, 5, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 3, 'b');
		this.addDama(8, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralAb_2(){
		Dama m = this.addDama(7, 4, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(6, 3, 'b');
		this.addDama(6, 4, 'b');
		this.addDama(6, 5, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 3, 'b');
		this.addDama(8, 5, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearDamaLateralAb_3(){
		Dama m = this.addDama(7, 4, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(6, 3, 'b');
		this.addDama(6, 4, 'b');
		this.addDama(6, 5, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 5, 'b');
		this.addDama(8, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	/*************************Rey************************/
	
	
	public void testBloquearReyLateralI(){
		Rey m = this.addRey(4, 1, 'b');
		this.addDama(3, 1, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(4, 2, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(5, 1, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearReyLateralI_1(){
		Rey m = this.addRey(4, 2, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(4, 1, 'b');
		this.addDama(5, 1, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralI_2(){
		Rey m = this.addRey(4, 2, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(3, 1, 'b');
		this.addDama(5, 1, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralI_3(){
		Rey m = this.addRey(4, 2, 'b');
		this.addDama(3, 2, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(4, 3, 'b');
		this.addDama(5, 3, 'b');
		this.addDama(5, 2, 'b');
		this.addDama(4, 1, 'b');
		this.addDama(3, 1, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	public void testBloquearReyLateralD(){
		Rey m = this.addRey(4, 8, 'b');
		this.addDama(3, 8, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(4, 7, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(5, 8, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearReyLateralD_1(){
		Rey m = this.addRey(4, 7, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(3, 6, 'b');
		this.addDama(4, 6, 'b');
		this.addDama(5, 6, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(4, 8, 'b');
		this.addDama(5, 8, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralD_2(){
		Rey m = this.addRey(4, 7, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(3, 6, 'b');
		this.addDama(4, 6, 'b');
		this.addDama(5, 6, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(3, 8, 'b');
		this.addDama(5, 8, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralD_3(){
		Rey m = this.addRey(4, 7, 'b');
		this.addDama(3, 7, 'b');
		this.addDama(3, 6, 'b');
		this.addDama(4, 6, 'b');
		this.addDama(5, 6, 'b');
		this.addDama(5, 7, 'b');
		this.addDama(4, 8, 'b');
		this.addDama(3, 8, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearReyLateralAr(){
		Rey m = this.addRey(1, 4, 'b');
		this.addDama(1, 3, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(2, 4, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearReyLateralAr_1(){
		Rey m = this.addRey(2, 4, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 3, 'b');
		this.addDama(1, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralAr_2(){
		Rey m = this.addRey(2, 4, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 3, 'b');
		this.addDama(1, 5, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralAr_3(){
		Rey m = this.addRey(2, 4, 'b');
		this.addDama(2, 3, 'b');
		this.addDama(3, 3, 'b');
		this.addDama(3, 4, 'b');
		this.addDama(3, 5, 'b');
		this.addDama(2, 5, 'b');
		this.addDama(1, 5, 'b');
		this.addDama(1, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testBloquearReyLateralAb(){
		Rey m = this.addRey(8, 4, 'b');
		this.addDama(8, 3, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(7, 4, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 5, 'b');
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b);
	}
	
	public void testBloquearReyLateralAb_1(){
		Rey m = this.addRey(7, 4, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(6, 3, 'b');
		this.addDama(6, 4, 'b');
		this.addDama(6, 5, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 3, 'b');
		this.addDama(8, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralAb_2(){
		Rey m = this.addRey(7, 4, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(6, 3, 'b');
		this.addDama(6, 4, 'b');
		this.addDama(6, 5, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 3, 'b');
		this.addDama(8, 5, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	public void testBloquearReyLateralAb_3(){
		Rey m = this.addRey(7, 4, 'b');
		this.addDama(7, 3, 'b');
		this.addDama(6, 3, 'b');
		this.addDama(6, 4, 'b');
		this.addDama(6, 5, 'b');
		this.addDama(7, 5, 'b');
		this.addDama(8, 5, 'b');
		this.addDama(8, 4, 'b');
		
		
		boolean b = m.estaBloqueada(this.t.getTablero());
		assertTrue(b==false);
	}
	
	
	
	/***********************PONES_REVELDES******************/
	
	public void testNobloquearPeonLlenodBAb_1(){
		Peon p = this.addPeon(7, 4, 'b');
		this.addTorre(8, 4, 'b');
		this.addTorre(8, 5, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearPeonLlenodBAb_2(){
		Peon p = this.addPeon(7, 4, 'b');
		this.addTorre(8, 3, 'b');
		this.addTorre(8, 5, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearPeonLlenodBAb_3(){
		Peon p = this.addPeon(7, 4, 'b');
		this.addTorre(8, 3, 'b');
		this.addTorre(8, 4, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearPeonLlenodNAr_1(){
		Peon p = this.addPeon(2, 4, 'n');
		this.addTorre(1, 4, 'n');
		this.addTorre(1, 5, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearPeonLlenodNAr_2(){
		Peon p = this.addPeon(2, 4, 'n');
		this.addTorre(1, 3, 'n');
		this.addTorre(1, 5, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearPeonLlenodNAr_3(){
		Peon p = this.addPeon(2, 4, 'n');
		this.addTorre(1, 3, 'n');
		this.addTorre(1, 4, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	
	public void testNobloquearPeonLlenodBI(){
		Peon p = this.addPeon(4, 2, 'b');
		this.addTorre(5, 2, 'b');
		this.addTorre(5, 3, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearPeonLlenodNI(){
		Peon p = this.addPeon(4, 2, 'n');
		this.addTorre(3, 3, 'n');
		this.addTorre(3, 2, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	public void testNobloquearPeonLlenodBD(){
		Peon p = this.addPeon(4, 7, 'b');
		this.addTorre(5, 6, 'b');
		this.addTorre(5, 7, 'b');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
	
	public void testNobloquearPeonLlenodND(){
		Peon p = this.addPeon(4, 7, 'n');
		this.addTorre(3, 6, 'n');
		this.addTorre(3, 7, 'n');
		boolean b = p.estaBloqueada(t.getTablero());
		assertTrue(b==false);
	}
}
