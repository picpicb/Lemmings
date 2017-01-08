package States;

import Model.Direction;
import Model.Jeu;
import Model.Lemming;

public class State_Foreur extends State{
	private String urll = "images/lemmings_gifs/minel.png";
	private String urlr = "images/lemmings_gifs/miner.png";
	private int duree;

	public State_Foreur(Jeu j) {
		super(j);
		this.duree=5;
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
			this.stateInit(lem);
		}
	}
}
