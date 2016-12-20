package Model;

import java.util.Observer;

public class OMetal extends Obstacle {

	public OMetal(int x, int y, Observer o) {
		super(x,y, o);
		destructible = false;
		this.url = "images/metal.png";
	}
}
