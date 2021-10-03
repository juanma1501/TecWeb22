package edu.uclm.esi.tys2122.chess;

import junit.framework.TestCase;

public class TestFichaQueSalvaAlRey extends TestCase {
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
		
		Pieza[] pb = t.getBlancas();
		for(int i = 0;i<pb.length;i++){
			pb[i] = null;
		}
		
		
		Pieza[] pn = t.getNegras();
		for(int i = 0;i<pn.length;i++){
			pn[i] = null;
		}
	}
	
	
	protected Peon addPeon(int fila, int colum, char color, int numero){
		Peon p = new Peon(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		
		if(color == 'b'){
			t.getBlancas()[numero] = p;
			
		}else{
			t.getNegras()[numero] = p;
		}
		return p;
	}
	
	protected Torre addTorre1(int fila, int colum, char color){
		Torre p = new Torre(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnTorre1] = p;
		}else{
			t.getNegras()[Tablero.fnTorre1] = p;
		}
		return p;
	}
	protected Torre addTorre2(int fila, int colum, char color){
		Torre p = new Torre(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnTorre2] = p;
		}else{
			t.getNegras()[Tablero.fnTorre2] = p;
		}
		return p;
	}
	
	protected Caballo addCaballo1(int fila, int colum, char color){
		Caballo p = new Caballo(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnCaballo1] = p;
		}else{
			t.getNegras()[Tablero.fnCaballo1] = p;
		}
		return p;
	}
	protected Caballo addCaballo2(int fila, int colum, char color){
		Caballo p = new Caballo(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnCaballo2] = p;
		}else{
			t.getNegras()[Tablero.fnCaballo2] = p;
		}
		return p;
	}
	
	protected Alfil addAlfil1(int fila, int colum, char color){
		Alfil p = new Alfil(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnAlfil1] = p;
		}else{
			t.getNegras()[Tablero.fnAlfil1] = p;
		}
		return p;
	}
	protected Alfil addAlfil2(int fila, int colum, char color){
		Alfil p = new Alfil(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnAlfil2] = p;
		}else{
			t.getNegras()[Tablero.fnAlfil2] = p;
		}
		return p;
	}
	
	protected Dama addDama(int fila, int colum, char color){
		Dama p = new Dama(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnDama] = p;
		}else{
			t.getNegras()[Tablero.fnDama] = p;
		}
		return p;
	}
	
	protected Rey addRey(int fila, int colum, char color){
		Rey p = new Rey(1, color, fila-1, colum-1);
		Pieza[][] tablero = t.getTablero();
		tablero[fila-1][colum-1] = p;
		if(color == 'b'){
			t.getBlancas()[Tablero.fnRey] = p;
		}else{
			t.getNegras()[Tablero.fnRey] = p;
		}
		return p;
	}
	
	
	
	
	/**********************Ataque Torre desde arriba********************************/
	public void testATorreAr_Come(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addPeon(2, 6, 'n', 1);
		
		int r = t.mover('b', 3, 1, 3, 5, "", "");
		assertTrue(r == 10);
		
	}
	
	public void testATorreAr_Corta(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addAlfil1(5, 4, 'n');
		
		int r = t.mover('b', 3, 1, 3, 5, "", "");
		assertTrue(r == 10);
		
	}
	
	public void testATorreD_Come(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addAlfil1(1, 5, 'n');
		
		int r = t.mover('b', 3, 1, 5, 1, "", "");
		assertTrue(r == 10);
		
	}
	
	public void testATorreD_Corta(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addAlfil1(4, 5, 'n');
		
		int r = t.mover('b', 3, 1, 5, 1, "", "");
		assertTrue(r == 10);
		
	}
	
	public void testATorreI_Come(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 8, 'b');
		this.addAlfil1(2, 5, 'n');
		
		int r = t.mover('b', 3, 8, 5, 8, "", "");
		assertTrue(r == 10);
		
	}
	
	public void testATorreI_Corta(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 8, 'b');
		this.addAlfil1(4, 5, 'n');
		
		int r = t.mover('b', 3, 8, 5, 8, "", "");
		assertTrue(r == 10);
		
	}
	
	public void testATorreAb_Corta(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(8, 1, 'b');
		this.addAlfil1(5, 4, 'n');
		
		int r = t.mover('b', 8, 1, 8, 5, "", "");
		assertTrue(r == 10);
		
	}
	
	public void testATorreAb_Come(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(8, 1, 'b');
		this.addAlfil1(6, 3, 'n');
		
		int r = t.mover('b', 8, 1, 8, 5, "", "");
		assertTrue(r == 10);
		
	}
	
	
	/**********************Ataque Torre desde arriba_ No hay fichas que corten********************************/
	
	
	public void testATorreAr_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addTorre2(1, 4, 'b');
		this.addDama(1, 6, 'b');
		this.addAlfil1(6, 5, 'n');
		
		int r = t.mover('b', 3, 1, 3, 5, "", "");
		assertTrue(r == 20);
		
	}
	
	
	public void testATorreI_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addTorre2(4, 2, 'b');
		this.addDama(6, 2, 'b');
		this.addAlfil1(5, 6, 'n');
		
		int r = t.mover('b', 3, 1, 5, 1, "", "");
		assertTrue(r == 20);
		
	}
	
	
	public void testATorreD_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(3, 8, 'b');
		this.addTorre2(4, 2, 'b');
		this.addDama(6, 2, 'b');
		this.addAlfil1(5, 4, 'n');
		
		int r = t.mover('b', 3, 8, 5, 8, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testATorreAb_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(5, 5, 'n');
		this.addTorre1(8, 1, 'b');
		this.addTorre2(1, 4, 'b');
		this.addDama(1, 6, 'b');
		this.addAlfil1(4, 5, 'n');
		
		int r = t.mover('b', 8, 1, 8, 5, "", "");
		assertTrue(r == 20);
		
	}
	
	
/**********************Ataque Alfil _ No hay fichas que corten********************************/
	
	
	public void testAlfilArD_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(4, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addTorre1(4, 4, 'n');
		this.addDama(5, 7, 'b');
		this.addAlfil1(1, 6, 'b');
		
		int r = t.mover('b', 1, 6, 2, 7, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testAlfilArI_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(4, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addTorre1(4, 6, 'n');
		this.addDama(5, 3, 'b');
		this.addAlfil1(4, 1, 'b');
		
		int r = t.mover('b', 4, 1, 2, 3, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testAlfilAbI_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(4, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addTorre1(4, 6, 'n');
		this.addDama(5, 3, 'b');
		this.addAlfil1(4, 1, 'b');
		
		int r = t.mover('b', 4, 1, 6, 3, "", "");
		assertTrue(r == 20);
		
	}
	
	public void testAlfilAbD_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(4, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addTorre1(4, 4, 'n');
		this.addDama(5, 7, 'b');
		this.addAlfil1(7, 6, 'b');
		
		int r = t.mover('b', 7, 6, 6, 7, "", "");
		assertTrue(r == 20);
		
	}
	
	
	/***************Con la dama *************/
	
	public void testDamaArI_Corta_no(){
		this.addRey(8, 8, 'b');
		this.addRey(4, 5, 'n');
		this.addTorre1(3, 1, 'b');
		this.addTorre1(4, 6, 'n');
		this.addDama(5, 3, 'b');
		this.addDama(4, 1, 'b');
		
		int r = t.mover('b', 4, 1, 2, 3, "", "");
		assertTrue(r == 20);
		
	}
	
}
