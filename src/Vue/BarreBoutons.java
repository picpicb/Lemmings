package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controleur.AuditeurBarreBoutons;


public class BarreBoutons extends JPanel{
	
	//C'est la barre a droite de l'ecran qui permet de selectionner l'action de chaque lemming
	AuditeurBarreBoutons a;
	List<JRadioButton> boutons;
	
	public BarreBoutons(AuditeurBarreBoutons a){
		this.a = a;
		this.setSize(100,600);
		boutons = new ArrayList<JRadioButton>();
		
		//boutons d'action
		boutons.add(new JRadioButton("Marcheur"));
		boutons.add(new JRadioButton("Grimpeur"));
		boutons.add(new JRadioButton("Parachutiste"));
		boutons.add(new JRadioButton("Bloqueur"));
		boutons.add(new JRadioButton("Bomber"));
		boutons.add(new JRadioButton("Charpentier"));
		boutons.add(new JRadioButton("Foreur"));
		boutons.add(new JRadioButton("Tunnelier"));
		
		//ajout du listener pour chaque bouton
		for(JRadioButton b : boutons)
			b.addActionListener(a);

		
		//ajout des bouton dans un group de selection "unique"
		ButtonGroup actions = new ButtonGroup();
		for(JRadioButton b : boutons)
			actions.add(b);
		
		JPanel barre = new JPanel(new GridLayout(0,1));
		for(JRadioButton b : boutons)
			barre.add(b);

		add(barre, BorderLayout.LINE_START);
	}
}
