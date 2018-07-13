package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import model.dao.DBConnection;

public class DBConnectionTest {

	DBConnection dbc;

	@Before
	public void setUp() throws Exception {
		dbc = DBConnection.getInstance();
	}

	@Test
	public void testGetInstance() throws Exception {
		assertNotNull("The DB Instance can't be null", dbc);
	}

	@Test
	public void testGetConnection() throws Exception {
		assertNotNull("The connection can't be null", dbc.getConnection());
	}

	/*
	 * @Test public void testFillDatabase() throws Exception { ResultSet res =
	 * dbc.fillDatabase("player", 1); assertNotNull(res); }
	 */

}
