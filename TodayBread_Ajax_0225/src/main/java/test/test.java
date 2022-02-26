package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.BreadDAO;

public class test {

	
	@Test
	public void dbConTest_bread() {
		BreadDAO b = new BreadDAO();
		b.getConnection();
		
		assertNotNull(b);
		
	}
}
