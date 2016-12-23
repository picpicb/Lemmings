package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bloc extends JPanel{
	protected int posX;
	protected int posY;
	protected String url;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		File f = new File(url);
		try {
			Image	image = ImageIO.read(f);
			g.drawImage(image, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Bloc(int x, int y){
		this.posX=x;
		this.posY=y;
		this.setOpaque(false);
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
