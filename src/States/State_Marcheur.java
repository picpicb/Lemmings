package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Marcheur extends State{
	private String urll = "images/lemmings_gifs/walkl.png";
	private String urlr = "images/lemmings_gifs/walkr.png";
	public State_Marcheur(Jeu j) {
		super(j);
	}
	public String toString(){
		return "State_Marcheur";
	}


	public void step(Lemming lem){
		testSortie(lem);
		testOutOfMap(lem);
		testLave(lem);
		if(lem.getDirection()==Direction.DROITE){
			lem.setUrl(urlr);
		}else if(lem.getDirection()==Direction.GAUCHE){
			lem.setUrl(urll);
		}
		if(!this.jeu.getTypeObstacle(lem.getPosX(), lem.getPosY()+1).equals("null")){
			//pas de vide
			if(lem.getChute() <= 0){
				lem.nePasAfficher();
			}
			lem.resetChute();
			if(lem.getDirection()==Direction.DROITE){
				// a droite
				if(!this.jeu.getTypeObstacle(lem.getPosX()+1, lem.getPosY()).equals("null")){
					//obstacle a droite
					if(!this.jeu.getTypeObstacle(lem.getPosX()+1, lem.getPosY()-1).equals("null")){
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
					} else {
						lem.setPosY(lem.getPosY()-1);
						lem.setPosX(lem.getPosX()+1);
					}
				} else {
					//pas obstacle a doite
					if(!this.jeu.getRoleLemming(lem.getPosX()+1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()+1);
					}else{
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
					}
				}
			} else if (lem.getDirection()==Direction.GAUCHE){
				// a gauche
				if(!this.jeu.getTypeObstacle(lem.getPosX()-1, lem.getPosY()).equals("null")){		
					//obstacle a gauche
					if(!this.jeu.getTypeObstacle(lem.getPosX()-1, lem.getPosY()-1).equals("null")){
						lem.setDirection(Direction.DROITE);
						lem.setUrl(urlr);
					} else {
						lem.setPosX(lem.getPosX()-1);
						lem.setPosY(lem.getPosY()-1);
					}
				} else {
					//pas obstacle a gauche
					if(!this.jeu.getRoleLemming(lem.getPosX()-1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()-1);
					}else{
						lem.setDirection(Direction.DROITE);
						lem.setUrl(urlr);
					}
				}
			}
		} else {
			lem.setPosY(lem.getPosY()+1);
			lem.decChute();
		}
	}
}
