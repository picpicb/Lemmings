package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Grimpeur extends State{
	private String urll = "images/lemmings_gifs/climbl.png";
	private String urlr = "images/lemmings_gifs/climbr.png";
	public State_Grimpeur(Jeu j) {
		super(j);
	}

	@Override
	public void step(Lemming lem) {
		testSortie(lem);
		testOutOfMap(lem);
		if(lem.getDirection()==Direction.DROITE){
			lem.setUrl(urlr);
		}else if(lem.getDirection()==Direction.GAUCHE){
			lem.setUrl(urll);
		}

		if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("OTerre") || !this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("OTerre") && this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("OTerre") || !this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("OTerre") && this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("OTerre")){
			//pas de vide
			if(lem.getDirection()==Direction.DROITE){
				// a droite
				if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("OTerre")){
					//obstacle a droite
					lem.setPosY(lem.getPosY()-1);
				}else{
					//pas obstacle a doite
					if(!this.jeu.getLemming(lem.getPosX()+1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()+1);
					}else{
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
						lem.setPosX(lem.getPosX()-1);
					}
				}

			}else if(lem.getDirection()==Direction.GAUCHE){
				// a gauche
				if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("OTerre")){		
					//obstacle a gauche
					lem.setPosY(lem.getPosY()-1);
				} else {
					//pas obstacle a gauche
					if(!this.jeu.getLemming(lem.getPosX()-1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()-1);
					}else{
						lem.setDirection(Direction.DROITE);
						lem.setUrl(urlr);
						lem.setPosX(lem.getPosX()-1);
					}
				}
			}
		} else {
			if(lem.getDirection()==Direction.DROITE){
				lem.setPosX(lem.getPosX()+1);
				this.stateInit(lem);
			}else if(lem.getDirection()==Direction.GAUCHE){
				lem.setPosX(lem.getPosX()-1);
				this.stateInit(lem);
			}
		}




	}

}
