package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import Model.*;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Grille extends JPanel implements Observer{

	private ArrayList<Obstacle> obstacles;

	public Grille() {
		this.obstacles=new ArrayList<Obstacle>();
		this.setSize(900,600);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
	}



	public void afficher(Bloc b){
		/**
		System.out.println("kjf");
		Graphics g=this.getGraphics();
		for(Bloc b : l ){
			try {
				File f = new File(b.getUrl());
				Image image = ImageIO.read(f);
				g.drawImage(image, b.getPosX()*20, b.getPosY()*20, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 */
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Obstacle b: this.obstacles){
			try {
				System.out.println(b.typeOf());
				File f = new File(b.getUrl());
				Image image = ImageIO.read(f);
				g.drawImage(image, b.getPosX()*20, b.getPosY()*20, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	@Override
	public void update(Observable o, Object argO) {
		System.out.println("notify");
		if(((Bloc) o).typeOf()=="Lemming"){
			this.repaint();
			try {
				Lemming b=(Lemming)o;
				System.out.println(b.typeOf());
				File f = new File(b.getUrl());
				Image image = ImageIO.read(f);
				this.getGraphics().drawImage(image, b.getPosX()*20, b.getPosY()*20, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			this.obstacles.add((Obstacle )o);
			this.repaint();
		}
	}


}
