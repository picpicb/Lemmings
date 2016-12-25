package Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.Jeu;

public class AuditeurGrille implements MouseListener{
	Jeu jeu;
	public AuditeurGrille(Jeu jeu) {
		this.jeu = jeu;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		jeu.selectedLem((e.getX())/20,(e.getY())/20);
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


