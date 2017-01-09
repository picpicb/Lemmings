package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Charpentier extends State {
	private String urll = "images/lemmings_gifs/charl.png";
	private String urlr = "images/lemmings_gifs/charr.png";
	private int pas;
	public State_Charpentier(Jeu j) {
		super(j);
		pas = 0;
	}
	@Override
	public void step(Lemming lem) {
		testSortie(lem);
		testOutOfMap(lem);
		testLave(lem);
		if(lem.getDirection()==Direction.DROITE){
			lem.setUrl(urlr);
		}else if(lem.getDirection()==Direction.GAUCHE){
			lem.setUrl(urll);
		}
		if(pas < 5){
			pas++;
		}else{
			this.stateInit(lem);
		}
		if(!this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("null")){
			//pas de vide
			if(lem.getChute() <= 0){
				lem.setAfficher();
			}
			lem.resetChute();
			if(lem.getDirection()==Direction.DROITE){
				// a droite
				if(!this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("null")){
					//obstacle a droite
					if(!this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()-1).equals("null")){
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
					} else {
						lem.setPosY(lem.getPosY()-1);
						lem.setPosX(lem.getPosX()+1);
					}
				} else {
					//pas obstacle a doite
					if(!this.jeu.getLemming(lem.getPosX()+1, lem.getPosY()).equals("State_Bloqueur")){
						jeu.createTerre(lem.getPosX()+1, lem.getPosY());
						lem.setPosY(lem.getPosY()-1);
						lem.setPosX(lem.getPosX()+1);
					}else{
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
					}
				}
			} else if (lem.getDirection()==Direction.GAUCHE){
				// a gauche
				if(!this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("null")){		
					//obstacle a gauche
					if(!this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()-1).equals("null")){
						lem.setDirection(Direction.DROITE);
						lem.setUrl(urlr);
					} else {
						lem.setPosX(lem.getPosX()-1);
						lem.setPosY(lem.getPosY()-1);
					}
				} else {
					//pas obstacle a gauche
					if(!this.jeu.getLemming(lem.getPosX()-1, lem.getPosY()).equals("State_Bloqueur")){
						jeu.createTerre(lem.getPosX()-1, lem.getPosY());
						lem.setPosX(lem.getPosX()-1);
						lem.setPosY(lem.getPosY()-1);
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
