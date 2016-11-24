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
		listeO.add(new OTerre(2,6));
		while(isAlive()){
			System.out.println("hgh");
			try {
				Thread.sleep(200);
				cpt.incrementer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean isAlive(){
		if(cpt.getValeur() != cpt.getValeurMax()){
			return true;
		}else{
			return false;
		}
	}
}
