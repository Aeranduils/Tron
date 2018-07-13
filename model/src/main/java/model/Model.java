package model;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import model.dao.DBConnection;

/**
 * 
 * @author flori
 *
 */
public class Model extends Observable implements IModel {

	private Arena arena;
	private IPlayer player1;
	private IPlayer player2;
	long debut = System.currentTimeMillis();
	boolean GameIsFinished = false;

	/**
	 * The Model Constructor
	 */
	public Model() {

	}

	/**
	 * Notify that the data has changed
	 */

	public void flush() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * The Getter of the Observable
	 * 
	 * @return this
	 */

	public Observable getObservable() {
		return this;
	}

	/**
	 * The Getter of the Arena
	 * 
	 * @return Arena
	 */

	public final Arena getArena() {
		return this.arena;

	}

	/**
	 * The Getter of the starting time
	 * 
	 * @return debut
	 */

	public final long getDebut() {
		return this.debut;
	}

	/**
	 * Create the Arena with specific colors
	 * 
	 * @param Colorp1
	 * @param Colorp2
	 */

	public void createArena(Color Colorp1, Color Colorp2) {

		this.arena = new Arena(400, 600, new Player(1, 1, Colorp1), new Player(15, 15, Colorp2));

	}

	/**
	 * Load the Arena
	 * 
	 * @return true
	 */

	public boolean loadArena() {

		createArena();
		return true;
	}

	/**
	 * The Getter of player1
	 * 
	 * @return player1
	 */

	public final IPlayer getPlayer1() {
		return this.player1;
	}

	/**
	 * The Getter of player2
	 * 
	 * @return player 2
	 */

	public final IPlayer getPlayer2() {
		return this.player2;
	}

	/**
	 * Create the arena
	 */

	public void createArena() {
		this.arena = new Arena(400, 600, new Player(1, 1, Color.BLUE), new Player(15, 15, Color.YELLOW));

	}

	/**
	 * Game is finished ?
	 * 
	 * @return GameIsFinished
	 */

	public boolean GameIsFinished() {
		return GameIsFinished;

	}

	/**
	 * Set GameIsFinished
	 * 
	 * @param GameIsFinished
	 */

	public void setGameIsFinished(boolean GameIsFinished) {
		this.GameIsFinished = GameIsFinished;
	}

	/**
	 * Call the database and fill it with data
	 */

	public void Database() {
		DBConnection dbConnection = DBConnection.getInstance();
		try {
			ResultSet result = dbConnection.fillDatabase(arena.getWinner(), arena.getGameTime());
			System.out.println(arena.getWinner());
		} catch (SQLException e) {
			System.err.println("SQL error : " + e.getMessage());
			e.printStackTrace();
		}
	}

}
