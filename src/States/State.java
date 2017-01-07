package States;

import java.util.ArrayList;

import Model.Bloc;
import Model.Jeu;
import Model.Lemming;

public abstract class State {
	
	protected Jeu jeu;
	private String urll;
	private String urlr;
	
	public State(Jeu j){
		jeu=j;
	}
	
	public abstract void step(Lemming lem);
	
	public String toString(){
		return "state";
	}
	
	public String getUrll() {
		return urll;
	}

	public String getUrlr() {
		return urlr;
	}
	
	public void stateInit(Lemming lem){
		lem.setState(new State_Marcheur(jeu));
	}

	public void testSortie(Lemming lem){
		int x= lem.getPosX();
		int y= lem.getPosY();
		if(this.jeu.getObstacle(x,y).equals("OSortie")){
			lem.setAfficher();
			jeu.sortieLem();
		}
	}
	
	public void testOutOfMap(Lemming lem){
		if(lem.getPosX()==-1 || lem.getPosY()==-1 || lem.getPosX()==46 || lem.getPosY()==31){
			lem.setAfficher();
		}
	}
	
}
