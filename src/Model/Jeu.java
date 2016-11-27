package Model;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.AuditeurBarreBoutons;
import Vue.BarreBoutons;
import Vue.Compteur;
import Vue.Grille;


public class Jeu extends Observable{
	private int niveau;
	private Compteur cpt;
	private Grille grille;
	private ArrayList<Lemming> listeL;
	private ArrayList<Obstacle> listeO;
	
	public Jeu(Compteur cpt, Grille grille, int niveau){
		this.cpt = cpt;
		this.grille = grille;
		this.addObserver(grille);
		this.niveau = niveau;
		listeL = new ArrayList<Lemming>();
		listeO = new ArrayList<Obstacle>();		
	}
	
	
	public ArrayList<Obstacle> getObstacle(){
		return listeO;
	}
	
	public ArrayList<Lemming> getLemmings(){
		return listeL;
	}
	
	public void run(){
		File f = new File("niveaux/niv"+this.niveau);//fichier bin qui contient la matrice du monde
		chargerNiveau(f);
		
		grille.afficher(listeO);
		
//		while(isAlive()){
//			try {
//				Thread.sleep(200);
//				notifyObservers();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
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
						
						break;
					case 51:
						
						break;
					default:
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
