package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Foreur extends State{
	
	private int duree;

	public State_Foreur(Jeu j) {
		super(j);
		this.duree=5;
	}

	@Override
	public void step(Lemming lem) {
		testSortie(lem);
		testOutOfMap(lem);
		boolean step=false;
		if(this.duree>0){
			System.out.println("duree >0");
			String bloc=jeu.getObstacle(lem.getPosX(), lem.getPosY()+1);
			if(bloc.compareTo("OTerre")==0){
				jeu.destroyObstacle(lem.getPosX(), lem.getPosY()+1);
				this.duree--;
				lem.setPosY(lem.getPosY()+1);
			}else if(bloc.compareTo("null")==0){
				lem.setPosY(lem.getPosY()+1);
				this.duree--;
			}else{
				this.duree--;
				step=true;
			}
		}
		if(this.duree<=0 || step){
			if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("OTerre")){
				//pas de vide
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
			} else {
				lem.setPosY(lem.getPosY()+1);
			}
		}
	}
}
