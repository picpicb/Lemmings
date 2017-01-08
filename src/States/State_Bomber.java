package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Bomber extends State {
	private String urll = "images/lemmings_gifs/bomberl.png";
	private String urlr = "images/lemmings_gifs/bomberr.png";
	private int pas;
	private int chute;

	public State_Bomber(Jeu j) {
		super(j);
		pas = 0;
		chute = 5;
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
		if(pas < 3){
			pas++;
		}else{
			lem.setAfficher();
			for(int x=lem.getPosX()-2; x<=lem.getPosX()+2; x++){
				for(int y=lem.getPosY()-2; y<=lem.getPosY()+2; y++){
					if(this.jeu.getObstacle(x, y).equals("OTerre")){
						jeu.destroyObstacle(x, y);
					}
				}
			}
			return;
		}
		if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("OTerre")){
			//pas de vide
			if(chute <= 0){
				lem.setAfficher();
			}
			chute = 5;
			if(lem.getDirection()==Direction.DROITE){
				// a droite
				if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()).equals("OTerre")){
					//obstacle a droite
					if(this.jeu.getObstacle(lem.getPosX()+1, lem.getPosY()-1).equals("OTerre")){
						lem.setDirection(Direction.GAUCHE);
						lem.setUrl(urll);
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
						lem.setUrl(urll);
						lem.setPosX(lem.getPosX()-1);
					}
				}
			} else if (lem.getDirection()==Direction.GAUCHE){
				// a gauche
				if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()).equals("OTerre")){		
					//obstacle a gauche
					if(this.jeu.getObstacle(lem.getPosX()-1, lem.getPosY()-1).equals("OTerre")){
						lem.setDirection(Direction.DROITE);
						lem.setUrl(urlr);
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
						lem.setUrl(urlr);
						lem.setPosX(lem.getPosX()+1);
					}
				}
			}
		} else {
			lem.setPosY(lem.getPosY()+1);
			chute--;
		}
		
	}

}
