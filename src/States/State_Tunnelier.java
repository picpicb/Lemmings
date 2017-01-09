package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Tunnelier extends State{
	private String urll = "images/lemmings_gifs/minel.png";
	private String urlr = "images/lemmings_gifs/miner.png";
	private boolean creuse;

	public State_Tunnelier(Jeu j) {
		super(j);
		creuse = false;
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
		if(!this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("null")){
			//pas de vide
			if(lem.getChute() <= 0){
				lem.setAfficher();
			}
			lem.resetChute();
			if(lem.getDirection()==Direction.DROITE){
				// a droite
				if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("OTerre")){
					//obstacle a droite à creuser
					jeu.destroyObstacle(lem.getPosX()+1, lem.getPosY());
					creuse = true;
					lem.setPosX(lem.getPosX()+1);
				}else{
					//pas obstacle a doite
					if(creuse)
						this.stateInit(lem);
					if(this.jeu.getLemming(lem.getPosX()+1, lem.getPosY()).equals("State_Bloqueur") || this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("OMetal")){
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
					}else{
						lem.setPosX(lem.getPosX()+1);
					}
				}
			} else if (lem.getDirection()==Direction.GAUCHE){
				// a gauche
				if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("OTerre")){		
					//obstacle a gauche a creuser
					jeu.destroyObstacle(lem.getPosX()-1, lem.getPosY());
					creuse = true;
					lem.setPosX(lem.getPosX()-1);
				}else{
					//pas obstacle a gauche
					if(creuse)
						this.stateInit(lem);
					if(this.jeu.getLemming(lem.getPosX()-1, lem.getPosY()).equals("State_Bloqueur") || this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("OMetal")){
						lem.setDirection(Direction.DROITE);
						lem.setUrl(urlr);
					}else{
						lem.setPosX(lem.getPosX()-1);
					}
				}
			}
		} else {
			lem.setPosY(lem.getPosY()+1);
			lem.decChute();
		}
	}
}
