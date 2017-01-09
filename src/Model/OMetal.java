package Model;



public class OMetal extends Obstacle {

	public OMetal(int x, int y) {
		super(x,y);
		destructible = false;
		this.url = "images/metal.png";
	}
	public String typeOf(){
		return "OMetal";
	}
}
