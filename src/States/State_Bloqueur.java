package States;

import Model.Jeu;
import Model.Lemming;
import States.*;

public class State_Bloqueur extends State {
	
	public State_Bloqueur(Jeu j) {
		super(j);
	}

	@Override
	public void step(Lemming lem) {
		lem.setUrl("images/lemmings_gifs/block_x2.gif");
	}
	public String toString(){
		return "State_Bloqueur";
	}
}
