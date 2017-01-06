package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Tunnelier extends State{
	private String urll = "images/lemmings_gifs/minel_x2.png";
	private String urlr = "images/lemmings_gifs/miner_x2.png";
	
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
