package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Marcheur extends State{

	public State_Marcheur(Jeu j) {
		super(j);
	}
	public String toString(){
		return "State_Marcheur";
	}


	public void step(Lemming lem){
		testSortie(lem);
		testOutOfMap(lem);
		if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("OTerre")){
			//pas de vide
			if(lem.getDirection()==Direction.DROITE){
				// a droite
				if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("OTerre")){
					//obstacle a droite
					if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()-1).equals("OTerre")){
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl("images/lemmings_gifs/walkl_x2.gif");
						lem.setPosX(lem.getPosX()-1);
					} else {
						lem.setPosY(lem.getPosY()-1);
						lem.setPosX(lem.getPosX()+1);
					}
				} else {
					//pas obstacle a doite
					if(!this.jeu.getLemming(lem.getPosX()+1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()+1);
					}else{
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl("images/lemmings_gifs/walkl_x2.gif");
						lem.setPosX(lem.getPosX()-1);
					}
				}
			} else if (lem.getDirection()==Direction.GAUCHE){
				// a gauche
				if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("OTerre")){		
					//obstacle a gauche
					if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()-1).equals("OTerre")){
						lem.setDirection(Direction.DROITE);
						lem.setUrl("images/lemmings_gifs/walkr_x2.gif");
						lem.setPosX(lem.getPosX()+1);
					} else {
						lem.setPosX(lem.getPosX()-1);
						lem.setPosY(lem.getPosY()-1);
					}
				} else {
					//pas obstacle a gauche
					if(!this.jeu.getLemming(lem.getPosX()-1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()-1);
					}else{
						lem.setDirection(Direction.DROITE);
						lem.setUrl("images/lemmings_gifs/walkr_x2.gif");
						lem.setPosX(lem.getPosX()+1);
					}
				}
			}
		} else {
			lem.setPosY(lem.getPosY()+1);
		}
	}
}
