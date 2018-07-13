package model;

public interface IPlayer {
	/**
	 * Get the position
	 * 
	 * @return position
	 */
	IPosition getPosition();

	/**
	 * Set the position
	 * 
	 * @param position
	 */
	void setPosition(IPosition position);

	/**
	 * Set the Position
	 * 
	 * @param y
	 * @param x
	 */
	void setPosition(int y, int x);

	/**
	 * Get the sprite
	 * 
	 * @return sprite
	 */

	Direction getDirection();

	void setDirection(Direction direction);

	void move(int y, int x);

	/**
	 * is Alive ?
	 */
	boolean isAlive();

	/**
	 * Set alive
	 * 
	 * @param alive
	 */

	void setAlive(boolean alive);

	void setMovement(Direction direction);

}
