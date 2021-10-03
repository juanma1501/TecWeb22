package edu.uclm.esi.tys2122.chess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import junit.framework.TestCase;

public class TestGestorAjedrez extends TestCase {
	
	protected void init() {
		try {
			Connection bd=Broker.get().getDB("ideas", "ideas123");
			String sql="delete from jugador";
			PreparedStatement p=bd.prepareStatement(sql);
			p.executeUpdate();
			bd.close();
		}
		catch (Exception e) {
			fail();
		}
	}
	
	public void testRegistro() {
		init();
		Jugador j=new Jugador("a", "a");
		try {
			j.insert();
		} catch (Exception e) {
			fail();
		}
	}
	
	public void testMatePastor() {
		Jugador a=new Jugador("a", "a");
		Jugador b=new Jugador("b", "b");
		GestorAjedrez gestor=GestorAjedrez.get();
		try {
			gestor.add(a);
			gestor.add(b); 
		} catch (Exception e) {
			fail("No esperaba: " + e.getMessage());
		}
		
		gestor.retar(a, b);
		gestor.contestarReto(b, a, true);
		
		Tablero t=gestor.getTablero(1);
		gestor.setJugador(1, a, Constantes.BLANCO);
		gestor.setJugador(1, b, Constantes.NEGRO);
		
		int result=gestor.mover(1, Constantes.BLANCO, "e2", "e4");
		assertTrue(result==Constantes.CORRECTO);
		
		result=gestor.mover(1, Constantes.BLANCO, "d2", "d4");
		assertTrue(result==Constantes.NO_TIENE_EL_TURNO);
		
		result=gestor.mover(1, Constantes.NEGRO, "e7", "e5");
		assertTrue(result==Constantes.CORRECTO);
		
		result=gestor.mover(1, Constantes.BLANCO, "d1", "h5");
		assertTrue(result==Constantes.CORRECTO);
		
		result=gestor.mover(1, Constantes.NEGRO, "b8", "c6");
		assertTrue(result==Constantes.CORRECTO);
		
		result=gestor.mover(1, Constantes.BLANCO, "f1", "c4");
		assertTrue(result==Constantes.CORRECTO);
		
		result=gestor.mover(1, Constantes.NEGRO, "g8", "f6");
		assertTrue(result==Constantes.CORRECTO);
		
		result=gestor.mover(1, Constantes.BLANCO, "h5", "f7");
		assertTrue(result>20 && result<30);
		System.out.println(t.toString());
	}
}
