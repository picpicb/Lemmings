package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import Model.Jeu;

public class AuditeurBarreBoutons implements ActionListener{
	Jeu jeu;
	public AuditeurBarreBoutons(Jeu jeu) {
		this.jeu = jeu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Change de role selectionne grace aux boutons dans le jeu
		jeu.selectedState(((JRadioButton)e.getSource()).getText());
	}
}

