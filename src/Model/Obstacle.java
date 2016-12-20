package Model;

import java.util.Observer;

public class Obstacle extends Bloc{

	protected boolean destructible;
	
	public Obstacle(int x, int y, Observer o) {
		super(x, y, o);
	}
	
	public String typeOf(){
		return "Obstacle";
	}
}
