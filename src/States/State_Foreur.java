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
			String bloc=jeu.getObstacle(lem.getPosX(), lem.getPosY()+1);
			if(bloc.compareTo("OTerre")==0){
				jeu.destroyObstacle(lem.getPosX(), lem.getPosY());
				this.duree--;
				lem.setPosY(lem.getPosY()+1);
			}else if(bloc.compareTo("OMetal")==0){
				this.duree=0;
			}
		}
		if(this.duree<=0){
			lem.setState(new State_Marcheur(jeu));
		}
	}
}
