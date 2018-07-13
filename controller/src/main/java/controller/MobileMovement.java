package controller;

import model.Direction;
import model.IModel;
import model.IPlayer;

/**
 * 
 * @author flori
 *
 */
public class MobileMovement {

	private static MobileMovement mov;
	private IModel model;
	private ElementMovement em;
	private Direction P2_UP;

	public static MobileMovement getMov() {
		return mov;
	}

	private MobileMovement(IModel model) {
		this.model = model;
		this.em = ElementMovement.getMov();
	}

	public static void init(IModel model) {
		mov = new MobileMovement(model);
	}

	/**
	 * Set the new coordinate of Player1
	 * 
	 * @param direction
	 * @return
	 */
	public boolean moveP1(Direction direction) {

		IPlayer P1 = this.model.getArena().getPlayer1();
		if (!P1.isAlive()) {
			return false;
		}

		int nextX = P1.getPosition().getX();
		int nextY = P1.getPosition().getY();

		switch (direction) {

		case P1_UP:
			nextY--;
			break;
		case P1_DOWN:
			nextY++;
			break;
		case P1_LEFT:
			nextX--;
			break;
		case P1_RIGHT:
			nextX++;
			break;
		default:
			break;

		}
		this.model.getArena().createTrailP1(nextX, nextY);
		P1.setMovement(direction);
		return em.MoveP1(P1, nextY, nextX, direction);

	}

	/**
	 * Set the new coordinate of player2
	 * 
	 * @param direction
	 * @return
	 */
	public boolean moveP2(Direction direction) {
		IPlayer P2 = this.model.getArena().getPlayer2();

		if (!P2.isAlive()) {
			return false;
		}

		int nextX = P2.getPosition().getX();
		int nextY = P2.getPosition().getY();

		switch (direction) {

		case P2_UP:

			nextY--;
			break;

		case P2_DOWN:
			nextY++;
			break;

		case P2_LEFT:
			nextX--;
			break;
		case P2_RIGHT:
			nextX++;
			break;
		default:
			break;

		}

		P2.setMovement(direction);
		return em.MoveP2(P2, nextY, nextX, direction);

	}

	/**
	 * Launch a trail for player1
	 */

	public void launchTrailP1() {
		IPlayer P1 = this.model.getArena().getPlayer1();
		int trailX = P1.getPosition().getX();
		int trailY = P1.getPosition().getY();
		switch (P1.getDirection()) {
		case P1_UP:
			trailX++;
			break;
		case P1_DOWN:
			trailX--;
			break;
		case P1_LEFT:
			trailY++;
			break;
		case P1_RIGHT:
			trailY--;
			break;
		default:
			break;
		}
		this.model.getArena().createTrailP1(trailX, trailY);

	}

	/**
	 * launch a trail for player 2
	 */

	public void launchTrailP2() {
		IPlayer P2 = this.model.getArena().getPlayer2();
		int trailX = P2.getPosition().getX();
		int trailY = P2.getPosition().getY();
		switch (P2.getDirection()) {
		case P2_UP:
			trailX++;
			break;
		case P2_DOWN:
			trailX--;
			break;
		case P2_LEFT:
			trailY++;
			break;
		case P2_RIGHT:
			trailY--;
			break;
		default:
			break;
		}
		this.model.getArena().createTrailP2(trailX, trailY);
	}

}
