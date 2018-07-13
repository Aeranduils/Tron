package controller;

import model.Direction;
import model.IArena;
import model.IModel;
import view.IView;
import view.Order;

/**
 * 
 * @author flori
 *
 */
public class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	private GameLoop loop;

	/**
	 * Instantiates a new controller facade.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public Controller(final IView view, final IModel model) {

		this.setView(view);
		this.setModel(model);
		ElementMovement.init(this.model);
		MobileMovement.init(this.model);
	}

	/**
	 * Instanciate the game loop and load the arena
	 */
	public void start() {

		this.model.loadArena();
		this.model.getDebut();
		this.model.getObservable().addObserver(this.view.getObserver());
		this.loop = new GameLoop(this);
		this.loop.start();
		this.view.openFrame();

	}

	/**
	 * Update
	 */

	public void update() {
		IArena arena = this.model.getArena();

		this.model.flush();
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public IView getView() {
		return this.view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModel getModel() {
		return this.model;

	}

	/**
	 * Set the View of the game
	 * 
	 * @param view
	 */

	public void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Set the tron Model of the game
	 * 
	 * @param model
	 */

	public void setModel(IModel model) {
		this.model = model;

	}

	/**
	 * Order of the player
	 */

	public void orderPerform(Order order) {
		MobileMovement mm = MobileMovement.getMov();
		IModel model = getModel();
		IArena arena = this.model.getArena();
		int dirp1 = 0;
		long start = System.nanoTime();

		switch (order)

		{

		case P1_UP:

			if (arena.getWinner() == null) {
				mm.moveP1(Direction.P1_UP);
				mm.launchTrailP1();
				// System.out.println("Up");
				break;

			}
			break;

		case P1_DOWN:
			if (arena.getWinner() == null) {
				mm.moveP1(Direction.P1_DOWN);
				mm.launchTrailP1();
				// System.out.println("Down");
				break;
			}
			break;

		case P1_LEFT:
			if (arena.getWinner() == null) {
				mm.moveP1(Direction.P1_LEFT);
				mm.launchTrailP1();
				// System.out.println("Left");
				break;
			}
			break;
		case P1_RIGHT:
			if (arena.getWinner() == null) {
				mm.moveP1(Direction.P1_RIGHT);
				mm.launchTrailP1();
				// System.out.println("Right");
				break;
			}
			break;

		case P2_UP:
			if (arena.getWinner() == null) {
				mm.moveP2(Direction.P2_UP);
				mm.launchTrailP2();
				// System.out.println("Up");
				break;
			}
			break;

		case P2_DOWN:
			if (arena.getWinner() == null) {
				mm.moveP2(Direction.P2_DOWN);
				mm.launchTrailP2();
				// System.out.println("Down");
				break;
			}
			break;

		case P2_LEFT:
			if (arena.getWinner() == null) {
				mm.moveP2(Direction.P2_LEFT);
				mm.launchTrailP2();
				// System.out.println("Left");
				break;
			}
			break;
		case P2_RIGHT:
			if (arena.getWinner() == null) {
				mm.moveP2(Direction.P2_RIGHT);
				mm.launchTrailP2();

				// break;
			}
			break;
		case RETRY:
			if (arena.getWinner() != null) {
				this.model.createArena();

				break;
			}

			break;

		default:
			System.out.println("Not supported order : " + order.toString());
			break;
		}
		this.model.flush();

	}
}
