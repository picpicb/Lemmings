package Model;



public class OMetal extends Obstacle {

	public OMetal(int x, int y) {
		super(x,y);
		this.url = "images/metal.png";
	}
	@Override
	public String typeOf(){
		return "OMetal";
	}
}
