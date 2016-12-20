package Model;

import java.util.Observer;

public class OLave extends Obstacle {

	public OLave(int x, int y, Observer o) {
		super(x,y, o);
		destructible = false;
		this.url = "images/lave.png";
	}
}
