package Model;

import java.util.Observable;
import java.util.Observer;

public class Bloc extends Observable{
	protected int posX;
	protected int posY;
	protected String url;
	
	public Bloc(int x, int y, Observer o){
		this.posX=x;
		this.posY=y;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String typeOf(){
		return "Bloc";
	}

}
