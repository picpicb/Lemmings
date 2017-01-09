package Model;


public class OTerre extends Obstacle {

	public OTerre(int x, int y) {
		super(x,y);
		this.url ="images/terre.png";
	}
	@Override
	public String typeOf(){
		return "OTerre";
	}
	
}
