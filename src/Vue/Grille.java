package Vue;

import java.awt.Color;
import Model.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Grille extends JPanel{

	public Grille() {
		this.setSize(900,600);
		this.setBackground(Color.BLACK);
	}

	/**
	 * dessine tout les modèles
	 * @param listeL
	 * @param listeO
	 */
	public void refresh(ArrayList<Lemming> listeL,ArrayList<Obstacle> listeO){
		repaint();
		for(Lemming lem : listeL){
			lem.setBounds(lem.getPosX()*20,lem.getPosY()*20,20,20);
			
		}
		for(Obstacle obs : listeO){
			obs.setBounds(obs.getPosX()*20,obs.getPosY()*20,20,20);
		}
	}
	
	public void supprimer(Bloc b){
		remove(b);
	}
	
	public void finJeu(){
		removeAll();
		repaint();
	}
}
