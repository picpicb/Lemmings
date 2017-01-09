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
		testLave(lem);
		if(lem.getDirection()==Direction.DROITE){
			lem.setUrl(urlr);
		}else if(lem.getDirection()==Direction.GAUCHE){
			lem.setUrl(urll);
		}

		if(lem.getChute() <= 0){
			lem.nePasAfficher();
		}
		lem.resetChute();

		if(!this.jeu.getTypeObstacle(lem.getPosX()+1, lem.getPosY()).equals("null") || !this.jeu.getTypeObstacle(lem.getPosX()-1, lem.getPosY()).equals("null")){
			if(!jeu.getTypeObstacle(lem.getPosX(), lem.getPosY()-1).equals("null")){
				this.stateInit(lem);
			}else{
				lem.setPosY(lem.getPosY()-1);
			}
		} else {

			if(!jeu.getTypeObstacle(lem.getPosX(), lem.getPosY()+1).equals("null")){

				if(lem.getChute() <= 0){
					lem.nePasAfficher();
				}
				lem.resetChute();
				if(lem.getDirection()==Direction.DROITE){
					if(!this.jeu.getRoleLemming(lem.getPosX()+1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()+1);
					}else{
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
					}
				} else if (lem.getDirection()==Direction.GAUCHE){
					if(!this.jeu.getRoleLemming(lem.getPosX()-1, lem.getPosY()).equals("State_Bloqueur")){
						lem.setPosX(lem.getPosX()-1);
					}else{
						lem.setDirection(Direction.DROITE);
						lem.setUrl(urlr);
					}
				}
			}else{
				if(!jeu.getTypeObstacle(lem.getPosX()+1, lem.getPosY()+1).equals("null")){
					lem.setPosX(lem.getPosX()+1);
					this.stateInit(lem);
				}else if(!jeu.getTypeObstacle(lem.getPosX()-1, lem.getPosY()+1).equals("null")){
					lem.setPosX(lem.getPosX()-1);
					this.stateInit(lem);
				}else{
					lem.setPosY(lem.getPosY()+1);
					lem.decChute();
				}
			}

		}




	}

}
