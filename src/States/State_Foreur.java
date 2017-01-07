package States;

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
		if(this.duree>0){
			this.duree--;
			lem.setPosY(lem.getPosY()+1);
			String bloc=jeu.getObstacle(lem.getPosX(), lem.getPosY());
			if(bloc.compareTo("OTerre")==0){
				jeu.destroyObstacle(lem.getPosX(), lem.getPosY());
			}else if(bloc.compareTo("OMetal")==0){
				this.duree=0;
			}
		}
	}
}
