package view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import mock.ComponentMock;
import mock.ControllerMock;

public class GameFrameTest {

	GameFrame g;
	ControllerMock c;

	@Before
	public void setUp() throws Exception {
		c = new ControllerMock();
		g = new GameFrame();
		g.setController(c);
	}

	@Test
	public void testKeyPressedZ() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_Z);
		this.g.keyPressed(e);
		assertEquals(Order.P1_UP, c.getLastOrder());
	}

	@Test
	public void testKeyPressedS() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_S);
		this.g.keyPressed(e);
		assertEquals(Order.P1_DOWN, c.getLastOrder());
	}

	@Test
	public void testKeyPressedQ() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_Q);
		this.g.keyPressed(e);
		assertEquals(Order.P1_LEFT, c.getLastOrder());
	}

	@Test
	public void testKeyPressedD() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_D);
		this.g.keyPressed(e);
		assertEquals(Order.P1_RIGHT, c.getLastOrder());
	}

	@Test
	public void testKeyPressedUp() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_UP);
		this.g.keyPressed(e);
		assertEquals(Order.P2_UP, c.getLastOrder());
	}

	@Test
	public void testKeyPressedDown() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_DOWN);
		this.g.keyPressed(e);
		assertEquals(Order.P2_DOWN, c.getLastOrder());
	}

	@Test
	public void testKeyPressedLeft() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_LEFT);
		this.g.keyPressed(e);
		assertEquals(Order.P2_LEFT, c.getLastOrder());
	}

	@Test
	public void testKeyPressedRight() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_RIGHT);
		this.g.keyPressed(e);
		assertEquals(Order.P2_RIGHT, c.getLastOrder());
	}

	@Test
	public void testKeyPressedR() throws Exception {
		KeyEvent e = new KeyEvent(new ComponentMock(), 0, 0, 0, 0);
		e.setKeyCode(KeyEvent.VK_R);
		this.g.keyPressed(e);
		assertNotEquals("We're not supposed to press R until the game is over", Order.RETRY, c.getLastOrder());
	}
}
