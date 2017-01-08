package Model;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controleur.AuditeurBarreBoutons;
import Vue.BarreBoutons;
import Vue.Compteur;
import Vue.Grille;

public class Application {

	private static final int MAXLEMMING = 10;
	private static final int NIVEAUSTART = 1;

	public static void main(String[] args) {
		
		JFrame fenetre = new JFrame("Lemmings");
		fenetre.setSize(1000, 600);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BorderLayout bo = new BorderLayout();
		bo.setVgap(0);
		fenetre.setLayout(bo);
		
		Compteur panelCompteur = new Compteur(MAXLEMMING);
		Grille grille = new Grille();
		Jeu jeu = new Jeu(panelCompteur,grille,NIVEAUSTART);
		
		BarreBoutons barre = new BarreBoutons(new AuditeurBarreBoutons(jeu));
		JPanel panelDroit = new JPanel();
		panelDroit.setLayout(new BorderLayout());
		panelDroit.add(barre,BorderLayout.NORTH);
		panelDroit.add(panelCompteur,BorderLayout.CENTER);
			
		fenetre.add(grille,BorderLayout.CENTER);
		fenetre.add(panelDroit,BorderLayout.EAST);
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		jeu.run();
		
	}	
}
