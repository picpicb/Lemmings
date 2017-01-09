package Model;

import States.*;

public class Lemming extends Bloc{
	
	private Direction direction;
	private State state;
	private int chute;
	
	public Lemming(int x, int y, Jeu jeu) {
		super(x, y);
		direction = Direction.DROITE;
		this.url = "images/lemmings_gifs/walkr_x2.gif";
		this.state=new State_Marcheur(jeu);
		chute = 5;
	}
	
	/**
	 * permet de savoir depuis combien de temps le lemming tombe
	 * si ce nombre est inferieur a 1, il est alors supprimé
	 */
	public void decChute(){
		chute--;
	}
	
	/**
	 * on reinitialise la chute
	 * methode utilisée si le lemming tombe et survis
	 */
	public void resetChute(){
		chute = 5;
	}
	public int getChute(){
		return chute;
	}
	
	public Direction getDirection(){
		return this.direction;
	}
	
	public void setDirection(Direction d){
		this.direction=d;
	}
	public void setState(State s){
		state = s;
	}

	/**
	 * appelle la methode d'avancement du lemming correspondant a son etat
	 */
	public void step() {
		this.state.step(this);
	}
	
	/**
	 * renvoie le state actuel du lemming
	 * @return
	 */
	public String role(){
		return state.toString();
	}

	
}
