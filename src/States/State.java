package States;

import java.util.ArrayList;

import Model.Bloc;
import Model.Jeu;
import Model.Lemming;

public abstract class State {
	
	protected Jeu jeu;
	
	public State(Jeu j){
		jeu=j;
	}
	
	public abstract void step(Lemming lem);
}
