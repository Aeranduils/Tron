package model;

import java.awt.Color;

/**
 * 
 * @author flori
 *
 */

public class Player implements IPlayer {

	private IPosition position;
	private Color color;
	private int roundsWon = 0;
	private boolean alive;
	private Direction direction;

	/**
	 * 
	 * @param y
	 *            Y position of the player
	 * @param x
	 *            X position of the player
	 */
	public Player(int x, int y) {
		this.position = new Position(x, y);
		this.setAlive(true);
		long debut = System.currentTimeMillis();
		System.out.println("temps: " + (System.currentTimeMillis() - debut));
	}

	/**
	 * 
	 * @param y
	 *            Y position of the player
	 * @param x
	 *            X position of the player
	 * @param color
	 *            Color of the player
	 * 
	 */

	public Player(int x, int y, Color color) {
		this.position = new Position(x, y);
		this.color = color;
		this.setAlive(true);
	}

	/**
	 * Get the position of the player
	 * 
	 * @return position
	 */
	public IPosition getPosition() {
		return position;
	}

	/**
	 * Get the color of the player
	 * 
	 * @return color
	 */

	public Color getColor1() {
		return color;

	}

	/**
	 * Set the position of the player
	 * 
	 * @param position
	 */
	public void setPosition(IPosition position) {
		this.position = position;
	}

	/**
	 * Set the position of the player
	 * 
	 * @param y
	 * @param x
	 */
	public void setPosition(int x, int y) {
		this.position.setY(y);
		this.position.setX(x);
	}

	/**
	 * isAlive ?
	 * 
	 * @return alive
	 */
	public boolean isAlive() {
		return alive;

	}

	/**
	 * Set alive
	 * 
	 * @param alive
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Get the direction of the player
	 * 
	 * @return direction
	 */

	public Direction getDirection() {
		return direction;
	}

	/**
	 * Set the direction of the player
	 * 
	 * @param direction
	 */

	public void setDirection(Direction direction) {
		this.direction = direction;

	}

	/**
	 * Move the player to the X Y position
	 */

	public void move(int y, int x) {
		this.setPosition(x, y);

	}

	/**
	 * Set the Movement of the player
	 * 
	 * @param direction
	 */

	public void setMovement(Direction direction) {
		this.direction = direction;

	}

}
