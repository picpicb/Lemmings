package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controleur.AuditeurBarreBoutons;


public class BarreBoutons extends JPanel{
	
	//C'est la barre a droite de l'ecran qui permet de selectionner l'action de chaque lemming
	AuditeurBarreBoutons a;
	List<JRadioButton> boutons;
	List<JLabel> imgBoutons;
	
	public BarreBoutons(AuditeurBarreBoutons a){
		this.a = a;
		this.setSize(100,600);
		boutons = new ArrayList<JRadioButton>();
		imgBoutons = new ArrayList<JLabel>();
		//boutons d'action
		boutons.add(new JRadioButton("Marcheur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/walkr.png")));
		boutons.add(new JRadioButton("Grimpeur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/climbr.png")));
		boutons.add(new JRadioButton("Parachutiste"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/parar.png")));
		boutons.add(new JRadioButton("Bloqueur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/block.png")));
		boutons.add(new JRadioButton("Bomber"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/bomberr.png")));
		boutons.add(new JRadioButton("Charpentier"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/charr.png")));
		boutons.add(new JRadioButton("Foreur"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/miner.png")));
		boutons.add(new JRadioButton("Tunnelier"));
		imgBoutons.add(new JLabel(new ImageIcon("images/lemmings_gifs/miner.png")));
		
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
		JPanel barre1 = new JPanel(new GridLayout(0,1));
		for(JLabel lb : imgBoutons){
			lb.setBorder(BorderFactory.createEmptyBorder(2, 0, 1, 0));
			barre1.add(lb);
		}
		
		add(barre1, BorderLayout.LINE_START);
		add(barre, BorderLayout.LINE_START);
	}
}
