package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import model.dao.DBProperties;

public class DBPropertiesTest {

	DBProperties dbp;

	@Before
	public void setUp() throws Exception {
		dbp = new DBProperties();
	}

	@Test
	public void testGetLoginAndPassword() throws Exception {
		assertNotNull(dbp.getLogin());
		assertNotNull(dbp.getPassword());

	}

}
