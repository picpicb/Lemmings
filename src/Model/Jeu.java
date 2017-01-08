package Model;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.AuditeurBarreBoutons;
import Controleur.AuditeurGrille;
import Vue.BarreBoutons;
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
	private AuditeurGrille auditeurG;
	private int entrX;
	private int entrY;

	public Jeu(Compteur cpt, Grille grille, int niveau){
		this.cpt = cpt;
		this.grille = grille;
		this.niveau = niveau;
		this.state = new State_Marcheur(this);
		auditeurG = new AuditeurGrille(this);
		this.grille.addMouseListener(auditeurG);
		listeL = new ArrayList<Lemming>();
		listeO = new ArrayList<Obstacle>();	
	}


	public ArrayList<Obstacle> getObstacles(){
		return listeO;
	}

	public ArrayList<Lemming> getLemmings(){
		return listeL;
	}

	public void setLemmings(ArrayList<Lemming> lemmings){
		this.listeL=lemmings;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles){
		this.listeO=obstacles;
	}

	public void sortieLem(){
		cpt.incrementer();
	}

	public void selectedLem(int x, int y){
		for(Lemming lem: this.listeL){
			if(lem.getPosX()==x && lem.getPosY()==y){
				lem.setState(state);
			}
		}
	}
	
	public void destroyObstacle(int x, int y){
		for(Obstacle o: this.listeO){
			if(o.getPosX()==x && o.getPosY()==y){
				o.setAfficher();
			}
		}
	}

	public void selectedState(String s){
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

	public void run(){
		File f = new File("niveaux/niv"+this.niveau);//fichier bin qui contient la matrice du monde
		chargerNiveau(f);
		int i=0;
		int tmp=0;
		while(isAlive()){
			try {
				if(i<cpt.getValeurMax() && tmp==0){
					Lemming l1 = new Lemming(entrX, entrY, this);
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
				    l.role();
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
	}

	public String getObstacle(int x, int y){
		for(Obstacle o: this.listeO){
			if(o.getPosX()==x && o.getPosY()==y){
				return o.typeOf();
			}
		}
		return "null";
	}
	public String getLemming(int x, int y){
		for(Lemming l: this.listeL){
			if(l.getPosX()==x && l.getPosY()==y){
				return l.role();
			}
		}
		return "null";
	}

	public boolean isAlive(){
		if(cpt.getValeur() != cpt.getValeurMax()){
			return true;
		}else{
			return false;
		}
	}

	public void chargerNiveau(File f){
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
