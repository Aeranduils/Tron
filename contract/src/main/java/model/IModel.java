package model;

import java.util.Observable;

/**
 * 
 * @author flori
 *
 */
public interface IModel {

	IArena getArena();

	void flush();

	Observable getObservable();

	IPlayer getPlayer1();

	IPlayer getPlayer2();

	void createArena();

	boolean loadArena();

	public long getDebut();

	public boolean GameIsFinished();

	public void setGameIsFinished(boolean GameIsFinished);

	public void Database();

}
