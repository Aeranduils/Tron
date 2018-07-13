package model;

/**
 * 
 * @author flori
 *
 */

public class Arena implements IArena {

	private int width = 600;
	private int height = 400;
	private IDimension dimension;
	private IPlayer player1;
	private IPlayer player2;
	private ITrail trailP1[][];
	private ITrail trailP2[][];

	private String Winner;
	private long GameTime;

	/**
	 * The Constructor of the Arena
	 * 
	 * @param height
	 * @param width
	 * @param player1
	 * @param player2
	 */

	public Arena(int height, int width, IPlayer player1, IPlayer player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.dimension = new Dimension(width, height);
		this.trailP1 = new Trail[width][height];
		this.trailP2 = new Trail[width][height];
	}

	/**
	 * The Getter of Player1
	 * 
	 * @return player1
	 */

	public IPlayer getPlayer1() {
		return player1;
	}

	/**
	 * The Setter of player 1
	 * 
	 * @param player1
	 * 
	 */

	public void setPlayer1(IPlayer player1) {
		this.player1 = player1;
	}

	/**
	 * The Getter of player2
	 * 
	 * @return player2
	 */

	public IPlayer getPlayer2() {
		return player2;
	}

	/**
	 * The Setter of player2
	 * 
	 * @param player2
	 * 
	 */

	public void setPlayer2(IPlayer player2) {
		this.player2 = player2;
	}

	/**
	 * Get dimension of the arena
	 * 
	 * @return dimension
	 */
	public IDimension getDimension() {
		return this.dimension;
	}

	/**
	 * Set dimension of the arena
	 * 
	 * @param dimension
	 */
	public void setDimension(IDimension dimension) {
		this.dimension = dimension;
	}

	/**
	 * Get the width of the arena
	 * 
	 * @return width
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * Set the width of the arena
	 * 
	 * @param width
	 */

	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the height of the arena
	 * 
	 * @return height
	 */

	public int getHeight() {
		return height;
	}

	/**
	 * Set the height of the arena
	 * 
	 * @param height
	 */

	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Create The trail for player1
	 * 
	 * @param trailX,
	 * @param trailY
	 */

	public void createTrailP1(int trailX, int trailY) {
		this.setTrailP1(trailX, trailY, new Trail(trailX, trailY));

	}

	/**
	 * Create The Trail for player2
	 * 
	 * @param trailX
	 * @param trailY
	 */

	public void createTrailP2(int trailX, int trailY) {
		this.setTrailP2(trailX, trailY, new Trail(trailX, trailY));
	}

	/**
	 * The Getter of the player1 trail table
	 * 
	 * @return trailP1
	 */

	public ITrail[][] getTrailP1() {
		return trailP1;
	}

	/**
	 * The Getter of the player2 trail table
	 * 
	 * @return trailP2
	 */

	public ITrail[][] getTrailP2() {
		return trailP2;
	}

	/**
	 * The Setter of the player1 trail table
	 * 
	 * @param trailP1
	 */

	public void setTrailsP1(ITrail[][] trailP1) {
		this.trailP1 = trailP1;
	}

	/**
	 * The Setter of the player1 trail table
	 * 
	 * @param trailP2
	 */

	public void setTrailsP2(ITrail[][] trailP2) {
		this.trailP2 = trailP2;
	}

	/**
	 * The Getter of a specific trailP1
	 * 
	 * @return trailP1[x][y]
	 */

	public ITrail getTrailP1(int x, int y) {
		return this.trailP1[x][y];
	}

	/**
	 * The Getter of a specific trailP2
	 * 
	 * @return trailP2[x][y]
	 */

	public ITrail getTrailP2(int x, int y) {
		return this.trailP2[x][y];
	}

	/**
	 * The Setter of a specific trailP1
	 * 
	 * @param x
	 * @param y
	 * @param trailP1
	 */

	public void setTrailP1(int x, int y, ITrail trailP1) {
		this.trailP1[x][y] = trailP1;
	}

	/**
	 * The Setter of a specific trailP2
	 * 
	 * @param x
	 * @param y
	 * @param trailP2
	 */

	public void setTrailP2(int x, int y, ITrail trailP2) {
		this.trailP2[x][y] = trailP2;
	}

	/**
	 * The Getter of the Winner of the Round
	 * 
	 * @return Winner
	 */

	public String getWinner() {
		return Winner;
	}

	/**
	 * The Setter of the Winner of the Round
	 * 
	 * @param Winner
	 */

	public void setWinner(String winner) {
		Winner = winner;
	}

	/**
	 * The Getter of the gameTime
	 * 
	 * @return gameTime
	 */

	public long getGameTime() {
		return GameTime;
	}

	/**
	 * The Setter of the gameTime
	 * 
	 * @param gameTime
	 */

	public void setGameTime(long gameTime) {
		GameTime = gameTime;
	}

}
