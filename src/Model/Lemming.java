package Model;

import java.util.Observer;
import States.*;

public class Lemming extends Bloc{
	
	private Direction direction;
	private State state;
	
	public Lemming(int x, int y, Observer o, Jeu jeu) {
		super(x, y, o);
		direction = Direction.DROITE;
		this.url = "images/lemmings_gifs/walkr_x2.gif";
		this.addObserver(o);
		this.setChanged();
		this.notifyObservers();
		this.state=new State_Marcheur(jeu);
	}
	
	public Direction getDirection(){
		return this.direction;
	}
	
	public void setDirection(Direction d){
		this.direction=d;
	}

	public void step() {
		this.state.step(this);
		this.setChanged();
		this.notifyObservers();
	}

	
}
