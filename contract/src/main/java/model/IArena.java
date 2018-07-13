package model;

public interface IArena {
	/**
	 * Get the dimension
	 * 
	 * @return dimension
	 */
	IDimension getDimension();

	/**
	 * Set the dimension
	 * 
	 * @param dimension
	 */

	public void setWinner(String winner);

	public String getWinner();

	void setDimension(IDimension dimension);

	IPlayer getPlayer1();

	void setPlayer1(IPlayer player1);

	IPlayer getPlayer2();

	void setPlayer2(IPlayer player2);

	void createTrailP1(int trailX, int trailY);

	void createTrailP2(int trailX, int trailY);

	public ITrail[][] getTrailP1();

	public ITrail[][] getTrailP2();

	public void setTrailsP1(ITrail[][] trailP1);

	public void setTrailsP2(ITrail[][] trailP2);

	public ITrail getTrailP1(int x, int y);

	public ITrail getTrailP2(int x, int y);

	public void setTrailP1(int x, int y, ITrail trailP1);

	public void setTrailP2(int x, int y, ITrail trailP2);

	public long getGameTime();

	public void setGameTime(long temps);

}
