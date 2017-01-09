package Model;

public class OEntree extends Obstacle{

	public OEntree(int x, int y) {
		super(x,y);
		destructible = false;
		this.url = "images/depart.png";
	}
	/**
	 * on ne considère pas l'entree comme un bloc
	 * au sens ou le lemming rentre dans celui ci
	 */
	public String typeOf(){
		return "null";
	}
}
