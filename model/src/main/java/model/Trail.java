package model;

/**
 * 
 * @author flori
 *
 */

public class Trail implements ITrail {

	protected String color;
	protected IPosition position;

	/**
	 * Trail Constructor. Create a position of the trail
	 * 
	 * @param x
	 * @param y
	 */

	public Trail(int x, int y) {
		this.position = new Position(x, y);

	}

	/**
	 * Set the position of the trail
	 * 
	 * @param position
	 */

	public Trail(Position position) {
		this.position = position;

	}

	/**
	 * Get the position of the trail
	 * 
	 * @return position
	 */

	public IPosition getPosition() {
		return position;
	}

	/**
	 * Set the position of the trail
	 * 
	 * @param position
	 */

	public void setPosition(IPosition position) {
		this.position = position;
	}

	/**
	 * Set the position X Y of the trail
	 * 
	 * @param x
	 * @param y
	 */

	public void setPosition(int y, int x) {
		this.position.setY(y);
		this.position.setX(x);
	}

}
