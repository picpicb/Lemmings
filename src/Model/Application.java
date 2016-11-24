package Model;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Controleur.AuditeurBarreBoutons;
import Vue.BarreBoutons;
import Vue.Compteur;
import Vue.Grille;

public class Application {

	private static final int MAXLEMMING = 10;
	private static final int NIVEAUSTART = 1;
	private static final int WIDTH = 100;
	private static final int HEIGTH = 100;

	public static void main(String[] args) {
		
		JFrame fenetre = new JFrame("Lemmings");
		fenetre.setSize(1000, 600);
		fenetre.setLayout(new BorderLayout());
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Compteur panelCompteur = new Compteur(MAXLEMMING);
		Grille grille = new Grille();
		Jeu lemming = new Jeu(panelCompteur,grille,NIVEAUSTART);
		BarreBoutons barre = new BarreBoutons(panelCompteur, new AuditeurBarreBoutons(lemming));
		
		
		fenetre.add(grille,BorderLayout.CENTER);
		fenetre.add(barre,BorderLayout.EAST);
		fenetre.setVisible(true);
		lemming.run();
		
	}	
}
