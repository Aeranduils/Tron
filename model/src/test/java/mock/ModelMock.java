package mock;

import model.Model;

public class ModelMock extends Model {

	public boolean loadArena() {
		createArena();
		return true;
	}

}
