package model;

public interface ITrail {
	void setPosition(IPosition position);

	void setPosition(int x, int y);

	IPosition getPosition();
}
