package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import mock.ModelMock;

public class ModelTest implements Observer {

	Model m;
	boolean notified = false;

	@Before
	public void setUp() throws Exception {
		m = new ModelMock();
	}

	@Override
	public void update(Observable observable, Object o) {
		notified = true;

	}

	@Test
	public void testFlush() throws Exception {
		m.addObserver(this);
		assertFalse("Need only to notify after have flushed", notified);

		m.flush();
		assertTrue("Need to notify after flush", notified);

	}

	@Test
	public void testGetObservableIsNotNull() throws Exception {
		assertNotNull("The observable can't be null", m.getObservable());
	}

	@Test
	public void testGetPlayer1IsNotNull() throws Exception {
		assertNotNull("The Player1 can't be null", m.getPlayer1());
	}

	@Test
	public void testGetPlayer2IsNotNull() throws Exception {
		assertNotNull("The Player2 can't be null", m.getPlayer2());
	}

	@Test
	public void testLoadArenaShouldCreateTheArena() throws Exception {
		m.loadArena();
		assertNotNull("The Level shouldn't be null after the creation", m.getArena());

		assertTrue("The Player1 should be alive at start", m.getArena().getPlayer1().isAlive());
		assertTrue("The Player2 should be alive at start", m.getArena().getPlayer2().isAlive());

	}

}
