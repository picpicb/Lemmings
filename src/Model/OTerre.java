package Model;

import java.util.Observer;

public class OTerre extends Obstacle {

	public OTerre(int x, int y, Observer o) {
		super(x,y, o);
		this.url ="images/terre.png";
		this.addObserver(o);
		this.setChanged();
		this.notifyObservers();
	}
	
	public String typeOf(){
		return "OTerre";
	}
	
}
