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

public class Grille extends JPanel{

	public Grille() {
		this.setSize(900,600);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
	}

	public void refresh(ArrayList<Lemming> listeL,ArrayList<Obstacle> listeO){
		for(Lemming lem : listeL){
			lem.setBounds(lem.getPosX()*20,lem.getPosY()*20,20,20);
		}
		for(Obstacle obs : listeO){
			obs.setBounds(obs.getPosX()*20,obs.getPosY()*20,20,20);
		}

	}
}
