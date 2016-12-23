package Model;



public class Obstacle extends Bloc{

	protected boolean destructible;
	
	public Obstacle(int x, int y) {
		super(x, y);
	}
	
	public String typeOf(){
		return "Obstacle";
	}
}
