package Vue;

import javax.swing.JLabel;

public class Compteur extends JLabel{
	int valeur;
	public int getValeur() {
		return valeur;
	}

	public int getValeurMax() {
		return valeurMax;
	}

	int valeurMax;
	public Compteur(int valeurMax) {
		this.valeurMax = valeurMax;
		this.valeur = 0;
		setText(valeur+"/"+valeurMax+" Lemming");
	}
	
	public void incrementer(){
		valeur++;
		setText(valeur+"/"+valeurMax+" Lemming");
	}
}
