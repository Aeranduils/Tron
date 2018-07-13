package controller;

import model.IModel;
import view.Order;

/**
 * 
 * @author flori
 *
 */
public interface IController {
	public void setModel(IModel model);

	/**
	 * Begin the game
	 */
	public void start();

	public void orderPerform(Order order);

}
