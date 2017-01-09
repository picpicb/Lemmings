package Vue;

import javax.swing.JLabel;

public class Compteur extends JLabel{
	private int valeur;
	private int valeurMax;
	public int getValeur() {
		return valeur;
	}

	public int getValeurMax() {
		return valeurMax;
	}

	public Compteur(int valeurMax) {
		this.valeurMax = valeurMax;
		this.valeur = 0;
		setText(valeur+"/"+valeurMax+" Lemming");
	}
	
	/**
	 * incrémente dans l'affichage le nombre de lemming sortis
	 */
	public void incrementer(){
		valeur++;
		setText(this.valeur+"/"+this.valeurMax+" Lemming");
	}
}
