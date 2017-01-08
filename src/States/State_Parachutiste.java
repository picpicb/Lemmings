package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Parachutiste extends State{

	private boolean tombe;

	public State_Parachutiste(Jeu j) {
		super(j);
		this.tombe=true;
	}

	@Override
	public void step(Lemming lem) {
		testSortie(lem);
		testOutOfMap(lem);
		if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("null")){
			//si il tombe
			if(this.tombe){
				lem.setPosY(lem.getPosY()+1);
			}
			this.tombe=!this.tombe;
		}else{
			//pas de vide
			this.tombe=false;
			if(lem.getDirection()==Direction.DROITE){
				// a droite
				if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("OTerre")){
					//obstacle a droite
					if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()-1).equals("OTerre")){
						lem.setDirection(Direction.GAUCHE);
						//lem.setUrl(urll);
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
						//lem.setUrl(urll);
						lem.setPosX(lem.getPosX()-1);
					}
				}
			} else if (lem.getDirection()==Direction.GAUCHE){
				// a gauche
				if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("OTerre")){		
					//obstacle a gauche
					if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()-1).equals("OTerre")){
						lem.setDirection(Direction.DROITE);
						//lem.setUrl(urlr);
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
						//lem.setUrl(urlr);
						lem.setPosX(lem.getPosX()+1);
					}
				}
			}
		}
	}

}
