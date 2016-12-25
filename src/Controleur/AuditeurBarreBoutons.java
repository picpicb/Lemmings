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
		System.out.println(((JRadioButton)e.getSource()).getText());
		jeu.selectedState(((JRadioButton)e.getSource()).getText());
	}

}
