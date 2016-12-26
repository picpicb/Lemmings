package States;

import java.util.ArrayList;

import Model.Bloc;
import Model.Jeu;
import Model.Lemming;

public abstract class State {
	
	protected Jeu jeu;
	
	public State(Jeu j){
		jeu=j;
	}
	
	public abstract void step(Lemming lem);
	
	public String toString(){
		return this.getClass().getSimpleName();
	}
	public void testSortie(Lemming lem,int x, int y){
		if(this.jeu.getObstacle(x,y).equals("OSortie")){
			lem.setAfficher();
			jeu.sortieLem();
		}
	}
}
