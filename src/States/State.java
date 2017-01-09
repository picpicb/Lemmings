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
	
	/**
	 * la methode faisant avancer un lemming
	 * @param lem
	 */
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
	
	/**
	 * attribue au lemming l'etat de base de marcheur
	 * @param lem
	 */
	public void stateInit(Lemming lem){
		lem.setState(new State_Marcheur(jeu));
	}

	/**
	 * permet de verifier si un lemming a passe la porte
	 * si ce n'est pas le cas il est supprimé
	 * @param lem
	 */
	public void testSortie(Lemming lem){
		int x= lem.getPosX();
		int y= lem.getPosY();
		if(x == jeu.getSortieX() && y==jeu.getSortieY()){
			lem.setAfficher();
			jeu.sortieLem();
		}
	}
	
	/**
	 * teste si le lemming est sortis du cadre du jeu
	 * @param lem
	 */
	public void testOutOfMap(Lemming lem){
		if(lem.getPosX()==-1 || lem.getPosY()==-1 || lem.getPosX()==46 || lem.getPosY()==31){
			lem.setAfficher();
		}
	}
	
	/**
	 * teste si le Lemming marche sur de la Lave
	 * @param lem
	 */
	public void testLave(Lemming lem){
		if(this.jeu.getObstacle(lem.getPosX(), lem.getPosY()+1).equals("OLave")){
			lem.setAfficher();
		}
	}
	
}
