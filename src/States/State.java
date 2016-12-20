package States;

import java.util.ArrayList;

import Model.Bloc;

public interface State {
	public void step(ArrayList<Bloc> obstacles,Bloc lem);
}
