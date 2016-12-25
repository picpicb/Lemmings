package Model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		BorderLayout bo = new BorderLayout();
		bo.setVgap(0);
		fenetre.setLayout(bo);
		
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
