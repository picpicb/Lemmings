package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Marcheur extends State{

	public State_Marcheur(Jeu j) {
		super(j);
	}

	public void step(Lemming lem){
		if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).compareTo("OTerre")==0){

			//pas de vide

			if(lem.getDirection()==Direction.DROITE){

				// a droite

				if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).compareTo("OTerre")==0){

					//obstacle a droite

					if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()-1).compareTo("OTerre")==0){
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl("images/lemmings_gifs/walkl_x2.gif");
						lem.setPosX(lem.getPosX()-1);
					} else {
						lem.setPosY(lem.getPosY()-1);
						lem.setPosX(lem.getPosX()+1);
					}
				} else {

					//pas obstacle a doite

					lem.setPosX(lem.getPosX()+1);
				}

			} else if (lem.getDirection()==Direction.GAUCHE){

				// a gauche

				if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).compareTo("OTerre")==0){		

					//obstacle a gauche

					if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()-1).compareTo("OTerre")==0){
						lem.setDirection(Direction.DROITE);
						lem.setUrl("images/lemmings_gifs/walkr_x2.gif");
						lem.setPosY(lem.getPosX()+1);
					} else {
						lem.setPosX(lem.getPosX()-1);
						lem.setPosY(lem.getPosY()-1);
					}
				} else {

					//pas obstacle a gauche

					lem.setPosX(lem.getPosX()-1);
				}

			}
		} else {
			lem.setPosY(lem.getPosY()+1);
		}
	}

}
