package view;

import java.util.Observer;

import controller.IController;

/**
 * <h1>The Interface IView.</h1>
 * 
 * @author flori
 *
 */
public interface IView {

	/**
	 * get the observer
	 * 
	 * @return observer
	 */
	Observer getObserver();

	/**
	 * Set visible the frame
	 */
	void openFrame();

	/**
	 * Set the controller
	 * 
	 * @param controller
	 */
	void setController(IController controller);

	/**
	 * Repaint the components
	 */
	void repaint();

}
