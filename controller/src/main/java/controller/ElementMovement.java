package controller;

import model.Direction;
import model.IModel;
import model.IPlayer;

/**
 * 
 * @author flori
 *
 */

public class ElementMovement {

	private static ElementMovement mov;
	private IModel model;

	public static ElementMovement getMov() {
		return mov;
	}

	public static void init(IModel model) {
		mov = new ElementMovement(model);
	}

	private ElementMovement(IModel model) {
		this.model = model;
	}

	/**
	 * Set the new position of the player1 according to the order
	 * 
	 * @param player1
	 * @param y
	 * @param x
	 * @param direction
	 * @return
	 */
	boolean MoveP1(IPlayer player1, int y, int x, Direction direction) {
		player1.setPosition(x, y);
		this.model.flush();
		return true;
	}

	/**
	 * Set the new position of the player2 according to the order
	 * 
	 * @param player2
	 * @param y
	 * @param x
	 * @param direction
	 * @return
	 */

	boolean MoveP2(IPlayer player2, int y, int x, Direction direction) {
		player2.setPosition(x, y);
		this.model.flush();
		return true;
	}

}
