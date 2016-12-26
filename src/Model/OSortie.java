package Model;

public class OSortie extends Obstacle{
	public OSortie(int x, int y) {
		super(x,y);
		destructible = false;
		this.url = "images/sortie.png";
	}
	public String typeOf(){
		return "OSortie";
	}
}
