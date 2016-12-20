package States;

import java.util.ArrayList;

import Model.Bloc;
import Model.Jeu;

public abstract class State {
	
	private Jeu jeu;
	
	public State(Jeu j){
		jeu=j;
	}
	
	public abstract void step(int x, int y);
}
