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
	protected boolean afficher;

	/**
	 * Un bloc est la classe mere des obstacles et des lemmings
	 * Il s'agit d'un carre avec une image
	 */
	
	public Bloc(int x, int y){
		this.posX=x;
		this.posY=y;
		this.setOpaque(false);
		this.afficher = true;
	}
	
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

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * retourne le type du bloc
	 * @return
	 */
	public String typeOf(){
		return "null";
	}
	
	/**
	 * permet de supprimer un bloc du jeu
	 * si l'attribut afficher est faux
	 * le bloc sera supprime au prochain pas du jeu
	 */
	public void nePasAfficher(){
		afficher = false;
	}
	
	public boolean getAfficher(){
		return afficher;
	}

}
