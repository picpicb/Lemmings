package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;
import States.*;

public class State_Bloqueur extends State {
	private String urll = "images/lemmings_gifs/block.png";
	private String urlr = "images/lemmings_gifs/block.png";
	public State_Bloqueur(Jeu j) {
		super(j);
	}

	@Override
	public void step(Lemming lem) {
		testSortie(lem);
		testOutOfMap(lem);
		testLave(lem);
		lem.setUrl(urlr);
		if(lem.getChute() <= 0){
			lem.setAfficher();
		}
		if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("null")){
			lem.setPosY(lem.getPosY()+1);
			lem.decChute();
		}else{
			lem.resetChute();
		}
	}
	public String toString(){
		return "State_Bloqueur";
	}
}
