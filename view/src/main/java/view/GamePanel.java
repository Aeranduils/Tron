package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.IArena;
import model.IModel;
import model.IPlayer;
import model.ITrail;

/**
 * 
 * @author flori
 *
 */
public class GamePanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private IModel model;

	Font f;

	/**
	 * The GamePanel of the game
	 */
	GamePanel() {
		setBackground(Color.BLACK);
		setVisible(true);

	}

	/**
	 * Set the model
	 * 
	 * @param model
	 */

	public void setModel(IModel model) {
		this.model = model;

	}

	/**
	 * Get the model
	 * 
	 * @return model
	 */

	public IModel getModel() {
		return this.model;
	}

	/**
	 * Display the graphics components on screen
	 */

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		IModel model = getModel();
		IArena arena = this.model.getArena();
		IPlayer ele1 = arena.getPlayer1();
		IPlayer ele2 = arena.getPlayer2();
		int i;

		g.setColor(Color.GREEN);
		g.drawRect(1, 1, arena.getDimension().getheight(), arena.getDimension().getwidth());

		for (int x = 0; x < arena.getDimension().getheight(); x++) {
			for (int y = 0; y < arena.getDimension().getwidth(); y++) {

				ITrail elep1 = arena.getTrailP1(x, y);
				ITrail elep2 = arena.getTrailP2(x, y);

				if (elep1 != null) {
					g.setColor(Color.CYAN);
					g.fillRect(x, y, 1, 1);
				}

				if (elep2 != null) {
					g.setColor(Color.YELLOW);
					g.fillRect(x, y, 1, 1);
				}

			}

		}

		if (this.model.getArena().getPlayer1().isAlive()) {

			g.setColor(Color.BLUE);
			g.fillRect(ele1.getPosition().getX(), ele1.getPosition().getY(), 4, 4);

		}

		if (this.model.getArena().getPlayer2().isAlive()) {

			g.setColor(Color.ORANGE);
			g.fillRect(ele2.getPosition().getX(), ele2.getPosition().getY(), 4, 4);

		}

		f = new Font("Console", Font.BOLD, 20);
		g.setFont(f);
		g.setColor(Color.WHITE);

		if (arena.getTrailP1(ele2.getPosition().getX(), ele2.getPosition().getY()) != null) {

			model.setGameIsFinished(true);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER :", 235, 180);
			g.setColor(Color.BLUE);
			g.drawString("Player 1 WON", 235, 210);
			g.drawString("Press R to retry", 1, 20);

			if (arena.getWinner() == null & arena.getGameTime() == 0) {
				arena.setWinner("player1");
				long temps = System.currentTimeMillis() - this.model.getDebut();
				arena.setGameTime(temps / 1000);

				this.model.Database();
			}

		}

		if (arena.getTrailP2(ele1.getPosition().getX(), ele1.getPosition().getY()) != null) {

			model.setGameIsFinished(true);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER :", 235, 180);
			g.setColor(Color.ORANGE);
			g.drawString("Player 2 WON", 235, 210);
			g.drawString("Press R to retry", 1, 20);

			if (arena.getWinner() == null & arena.getGameTime() == 0) {
				arena.setWinner("player2");
				long temps = System.currentTimeMillis() - this.model.getDebut();
				arena.setGameTime(temps / 1000);

				this.model.Database();
			}

		}

		if (ele1.getPosition().getX() == ele2.getPosition().getX()
				&& ele1.getPosition().getY() == ele2.getPosition().getY()) {

			model.setGameIsFinished(true);
			g.drawString("GAME OVER :", 235, 180);
			g.drawString("Press R to retry", 1, 20);

			if (arena.getWinner() == null & arena.getGameTime() == 0) {
				arena.setWinner("egalite");
				long temps = System.currentTimeMillis() - this.model.getDebut();
				arena.setGameTime(temps / 1000);

				this.model.Database();
			}
		}

	}

	public void update(Observable observable, Object o) {

		this.model = (IModel) observable;
		this.repaint();
	}
}
