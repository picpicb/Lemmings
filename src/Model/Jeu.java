package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import Controleur.AuditeurGrille;
import Vue.Compteur;
import Vue.Grille;
import States.*;

public class Jeu{
	private int niveau;
	private Compteur cpt; 						//compteur de lemmings
	private Grille grille; 						//afficheur du jeu
	private ArrayList<Lemming> listeL;
	private ArrayList<Obstacle> listeO;
	private State state; 						//role en memoire
	private String selectedState; 				//role selectionne par le joueur
	private AuditeurGrille auditeurG;		
	private int entrX;							//position de l'entree
	private int entrY;
	private int sortieX;						//position de la sortie
	private int sortieY;

	public Jeu(Compteur cpt, Grille grille, int niveau){
		this.cpt = cpt;
		this.grille = grille;
		this.niveau = niveau;
		this.state = new State_Marcheur(this);
		this.selectedState = "";
		auditeurG = new AuditeurGrille(this);
		this.grille.addMouseListener(auditeurG);
		listeL = new ArrayList<Lemming>();
		listeO = new ArrayList<Obstacle>();	
	}

	//********************* Getters et Setters *********************
	public ArrayList<Obstacle> getObstacles(){
		return listeO;
	}

	public ArrayList<Lemming> getLemmings(){
		return listeL;
	}

	public void setNiveau(int niveau){
		this.niveau = niveau;
	}
	public int getSortieX() {
		return sortieX;
	}
	public int getSortieY() {
		return sortieY;
	}
	//return le role du Lemming
	public String getRoleLemming(int x, int y){
		for(Lemming l: this.listeL){
			if(l.getPosX()==x && l.getPosY()==y){
				return l.role();
			}
		}
		return "null";
	}
	public String getTypeObstacle(int x, int y){
		for(Obstacle o: this.listeO){
			if(o.getPosX()==x && o.getPosY()==y){
				return o.typeOf();
			}
		}
		return "null";
	}
	//**************************************************************

	//methode faisant avancer le jeu
	public void run(){
		int i=0;
		int tmp=0;
		createLemming(entrX,entrY);
		while(!listeL.isEmpty() ){ 
			try {
				if(i<cpt.getValeurMax() && tmp==0){
					//creation des lemmings
					createLemming(entrX,entrY);
					i++;
					tmp = 4;
				}
				tmp--;
				Thread.sleep(500);
				//Utilisation de l'iterator pour supprimer des element<Lemming> de la liste
				for (Iterator<Lemming> iterator = listeL.iterator(); iterator.hasNext(); ) {
					Lemming l = iterator.next();
					l.step();
					if (!l.getAfficher()) {
						grille.supprimer(l);
						iterator.remove();
					}
				}
				//Utilisation de l'iterator pour supprimer des element<Obstacle> de la liste
				for (Iterator<Obstacle> iterator = listeO.iterator(); iterator.hasNext(); ) {
					Obstacle l = iterator.next();
					if (!l.getAfficher()) {
						grille.supprimer(l);
						iterator.remove();
					}
				}
				grille.refresh(listeL,listeO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		grille.finJeu(); // vide l'afficheur
		JOptionPane.showMessageDialog(null, "Score : "+cpt.getValeur()+"/"+cpt.getValeurMax()+" lemmings sauves", "Fin", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//incremente le nombre de lemming sortis par la porte
	public void sortieLem(){
		cpt.incrementer();
	}

	/**
	 * attribue l'etat selectionne par l'attribut state
	 * au lemming aux coordonnees
	 * @param x
	 * @param y
	 */
	public void changeLemmingState(int x, int y){
		for(Lemming lem: this.listeL){
			if(lem.getPosX()==x && lem.getPosY()==y){
				lem.setState(state);
				selectedState(selectedState);// nouvelle instance de state
			}
		}
	}

	//******************** Modification de bloc ********************
	public void removeObstacle(int x, int y){
		for(Obstacle o: this.listeO){
			if(o.getPosX()==x && o.getPosY()==y){
				o.nePasAfficher();
			}
		}
	}

	public void createTerre(int x, int y){
		OTerre t = new OTerre(x,y);
		listeO.add(t);
		grille.add(t);
	}
	
	private void createLemming(int x, int y){
		Lemming l = new Lemming(entrX, entrY, this);
		this.listeL.add(l);
		grille.add(l);
	}
	//**************************************************************

	public void selectedState(String s){
		selectedState = s;
		switch (s) {
		case "Bloqueur":
			state = new State_Bloqueur(this);
			break;
		case "Bomber":
			state = new State_Bomber(this);
			break;
		case "Charpentier":
			state = new State_Charpentier(this);
			break;
		case "Foreur":
			state = new State_Foreur(this);
			break;
		case "Grimpeur":
			state = new State_Grimpeur(this);
			break;
		case "Marcheur":
			state = new State_Marcheur(this);
			break;
		case "Parachutiste":
			state = new State_Parachutiste(this);
			break;
		case "Tunnelier":
			state = new State_Tunnelier(this);	
			break;
		default:
			break;
		}
	}
	
	//methode permetant de charger le niveau depuis le dossier niveau
	
	public void chargerNiveau(){
		File f = new File("niveaux/niv"+this.niveau);//fichier qui contient la matrice du monde
		InputStream in = null;
		try {
			in = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Reader lecteur = new InputStreamReader(in);
		int c;
		try {
			for(int i=0; i<30; i++){
				for(int j=0; j<45; j++){
					c = lecteur.read(); //lecture du fichier caractere par caractere, ligne par ligne
					switch (c) {
					case 10:
						c = lecteur.read();
						break;
					case 49:
						listeO.add(new OTerre(j,i));
						break;
					case 50:
						listeO.add(new OLave(j,i));
						break;
					case 51:
						listeO.add(new OMetal(j,i));
						break;
					case 52:
						listeO.add(new OEntree(j,i));
						entrX = j;
						entrY = i;
						break;
					case 53:
						listeO.add(new OSortie(j,i));
						sortieX = j;
						sortieY = i;
						break;
					default:
						break;
					}
				}
			}
			for(Obstacle obs : listeO){
				grille.add(obs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
