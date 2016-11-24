package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import Model.*;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Grille extends JPanel implements Observer{
	public Grille() {
		this.setSize(900,600);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
	}

	@Override
	public void update(Observable o, Object arg) {
		Graphics g=this.getGraphics();
		for(Obstacle obs : ((Jeu)o).getObstacle()){
			try {
				File f = new File(obs.getUrl());
				Image image = ImageIO.read(f);
				g.drawImage(image, obs.getPosX()*20, obs.getPosY()*20, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		for(Lemming lem : ((Jeu)o).getLemmings()){
//			try {
//				File f = new File(lem.getUrl());
//				Image image = ImageIO.read(f);
//				g.drawImage(image, lem.getPosX()*20, lem.getPosY()*20, this);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		this.repaint();

	}


}
