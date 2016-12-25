package Model;

import States.*;

public class Lemming extends Bloc{
	
	private Direction direction;
	private State state;
	
	public Lemming(int x, int y, Jeu jeu) {
		super(x, y);
		direction = Direction.DROITE;
		this.url = "images/lemmings_gifs/walkr_x2.gif";
		this.state=new State_Marcheur(jeu);
	}
	
	public Direction getDirection(){
		return this.direction;
	}
	
	public void setDirection(Direction d){
		this.direction=d;
	}
	public void setState(State s){
		System.out.println("Change state"+state+" to "+s);
	}

	public void step() {
		this.state.step(this);
	}
	
	public String typeOf(){
		return "Lemming";
	}

	
}
