package Model;



public class OLave extends Obstacle {

	public OLave(int x, int y) {
		super(x,y);
		this.url = "images/lave.png";
	}
	@Override
	public String typeOf(){
		return "OLave";
	}
}
