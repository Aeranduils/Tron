package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import mock.TrailMock;

public class ArenaTest {

	Arena a;
	Player p1;
	Player p2;

	@Before
	public void setUp() throws Exception {
		p1 = new Player(4, 10);
		p2 = new Player(10, 4);
		a = new Arena(400, 600, p1, p2);
	}

	@Test
	public void testSetTrailP1() throws Exception {
		Trail t = new TrailMock(1, 2);
		a.setTrailP1(1, 2, t);
		assertNotNull("Trail can't be null", a.getTrailP1()[1][2]);
		assertSame("Set a Trail must place it at the good case in the table", t, a.getTrailP1()[1][2]);
	}

	@Test
	public void testSetTrailP2() throws Exception {
		Trail t = new TrailMock(1, 2);
		a.setTrailP2(1, 2, t);
		assertNotNull("Trail can't be null", a.getTrailP2()[1][2]);
		assertSame("Set a Trail must place it at the good case in the table", t, a.getTrailP2()[1][2]);
	}

	@Test
	public void testGetDimension() throws Exception {
		Dimension d = new Dimension(25, 32);
		a.setDimension(d);
		assertSame("The dimension should have been modified", d, a.getDimension());
	}

}
