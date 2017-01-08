package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Tunnelier extends State{
	private String urll = "images/lemmings_gifs/minel.png";
	private String urlr = "images/lemmings_gifs/miner.png";
	
	public State_Tunnelier(Jeu j) {
		super(j);
	}
	@Override
	public void step(Lemming lem) {
		if(lem.getDirection()==Direction.DROITE){
			lem.setUrl(urlr);
		}else if(lem.getDirection()==Direction.GAUCHE){
			lem.setUrl(urll);
		}
		
	}

}
