package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import controller.IController;

/**
 * 
 * @author flori
 *
 */
public class GameFrame extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 616;
	private int height = 439;

	private IController controller;
	private GamePanel panel;

	/**
	 * The Game Frame of the game
	 */

	GameFrame() {

		this.setTitle("Tron : A Java Game");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new GamePanel();
		this.panel.setBackground(Color.BLACK);
		this.setContentPane(this.panel);
		this.setResizable(false);

		this.addKeyListener(this);

		;
	}

	/**
	 * Repaint the component
	 */

	public void repaint() {
		this.panel.repaint();
	}

	/**
	 * Get the GamePanel
	 * 
	 * @return panel
	 */

	public GamePanel getGamePanel() {
		return this.panel;
	}

	/**
	 * Get width of the panel
	 * 
	 * @return width
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * Get height of the panel
	 * 
	 * @return height
	 */

	public int getHeight() {
		return height;
	}

	/**
	 * Get the controller
	 * 
	 * @return controller
	 */

	public IController getController() {
		return controller;
	}

	/**
	 * Set the controller
	 * 
	 * @param controller
	 */

	public void setController(IController controller) {
		this.controller = controller;

	}

	/**
	 * Manage the KeyPressed Output
	 */

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {

		case KeyEvent.VK_Z:
			this.controller.orderPerform(Order.P1_UP);
			break;

		case KeyEvent.VK_S:
			this.controller.orderPerform(Order.P1_DOWN);
			break;

		case KeyEvent.VK_Q:
			this.controller.orderPerform(Order.P1_LEFT);
			break;

		case KeyEvent.VK_D:
			this.controller.orderPerform(Order.P1_RIGHT);
			break;

		case KeyEvent.VK_R:
			this.controller.orderPerform(Order.RETRY);

		case KeyEvent.VK_UP:
			this.controller.orderPerform(Order.P2_UP);
			break;

		case KeyEvent.VK_DOWN:
			this.controller.orderPerform(Order.P2_DOWN);
			break;
		case KeyEvent.VK_LEFT:
			this.controller.orderPerform(Order.P2_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			this.controller.orderPerform(Order.P2_RIGHT);
			break;

		}

	}

	public void keyTyped(KeyEvent e2) {

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
