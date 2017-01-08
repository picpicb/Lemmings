package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;
import States.*;

public class State_Bloqueur extends State {
	private String urll = "images/lemmings_gifs/block_x2.png";
	private String urlr = "images/lemmings_gifs/block_x2.png";
	public State_Bloqueur(Jeu j) {
		super(j);
	}

	@Override
	public void step(Lemming lem) {
			lem.setUrl(urlr);
	}
	public String toString(){
		return "State_Bloqueur";
	}
}
