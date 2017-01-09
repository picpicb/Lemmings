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
	private Compteur cpt;
	private Grille grille;
	private ArrayList<Lemming> listeL;
	private ArrayList<Obstacle> listeO;
	private State state;
	private String selectedState;
	private AuditeurGrille auditeurG;
	private int entrX;
	private int entrY;
	private int sortieX;
	private int sortieY;
	private boolean quitter;

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
		quitter = false;
	}
	
	public void setNiveau(int niveau){
		this.niveau = niveau;
	}
	public ArrayList<Obstacle> getObstacles(){
		return listeO;
	}

	public ArrayList<Lemming> getLemmings(){
		return listeL;
	}

	public void sortieLem(){
		cpt.incrementer();
	}

	/**
	 * attribue l'etat séléctionné par l'attribut state
	 * au lemming au coordonnées
	 * @param x
	 * @param y
	 */
	public void selectedLem(int x, int y){
		for(Lemming lem: this.listeL){
			if(lem.getPosX()==x && lem.getPosY()==y){
				lem.setState(state);
				selectedState(selectedState);
				
			}
		}
	}
	
	/**
	 * Supprime l'obstacle au coordonnées
	 * @param x
	 * @param y
	 */
	public void destroyObstacle(int x, int y){
		for(Obstacle o: this.listeO){
			if(o.getPosX()==x && o.getPosY()==y){
				o.setAfficher();
			}
		}
	}
	
	public void createTerre(int x, int y){
		OTerre t = new OTerre(x,y);
		listeO.add(t);
		grille.add(t);
	}
	
	/**
	 * Selectionne l'état correspondant a la chaine de caractère 
	 * dans l'attribut state
	 * @param s
	 */
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
	public void quitter(){
		quitter = true; 
	}

	/**
	 * methode faisant avancer le jeu
	 */
	public void run(){
			int i=0;
			int tmp=0;
			Lemming l1 = new Lemming(entrX, entrY, this);
			this.listeL.add(l1);
			grille.add(l1);
			while(!listeL.isEmpty() ){ 
				try {
					if(i<cpt.getValeurMax() && tmp==0){
						l1 = new Lemming(entrX, entrY, this);
						this.listeL.add(l1);
						grille.add(l1);
						i++;
						tmp = 4;
					}
					tmp--;
					Thread.sleep(400);
					for (Iterator<Lemming> iterator = listeL.iterator(); iterator.hasNext(); ) {
					    Lemming l = iterator.next();
					    l.step();
					    if (!l.getAfficher()) {
					    	grille.supprimer(l);
					        iterator.remove();
					    }
					}
					for (Iterator<Obstacle> iterator = listeO.iterator(); iterator.hasNext(); ) {
					    Obstacle l = iterator.next();
					    if (!l.getAfficher()) {
					    	grille.supprimer(l);
					        iterator.remove();
					    }
					}
					grille.refresh(listeL,listeO);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			grille.finJeu();
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "Score : "+cpt.getValeur()+"/"+cpt.getValeurMax()+" lemmings sauv�s", "Fin", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * permet de reccuperer le type de l'obstacle aux coordonnée
	 * @param x
	 * @param y
	 * @return
	 */
	public String getObstacle(int x, int y){
		for(Obstacle o: this.listeO){
			if(o.getPosX()==x && o.getPosY()==y){
				return o.typeOf();
			}
		}
		return "null";
	}
	
	/**
	 * permet de reccuperer l'etat du lemming aux coordonnée
	 * @param x
	 * @param y
	 * @return
	 */
	public String getLemming(int x, int y){
		for(Lemming l: this.listeL){
			if(l.getPosX()==x && l.getPosY()==y){
				return l.role();
			}
		}
		return "null";
	}

	/**
	 * methode permetant de charger le niveau depuis le dossier niveau
	 */
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
	
	public int getSortieX() {
		return sortieX;
	}
	public int getSortieY() {
		return sortieY;
	}
}
