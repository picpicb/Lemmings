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
	
	public void decChute(){
		chute--;
	}
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

	public void step() {
		this.state.step(this);
	}
	
	public String role(){
		return state.toString();
	}

	
}
