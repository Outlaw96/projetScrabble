package model;

import java.util.ArrayList;

public class Mot {
	private String libelle;
	private ArrayList<Pion> pions;

	public Mot() {
		this.libelle = "";
		this.pions = new ArrayList<>();
	}

	public Mot(ArrayList<Pion> pions) {
		// détermination du libelle à partir de la liste de pions reçus en
		// argument
		// et initialisation de l'attribut pions
		libelle = "";
		this.pions = new ArrayList<>();
	}

	// obtenir un mot a partir des pions
	public String getWord() {
		for (int i = 0; i < this.pions.size(); i++) {
			this.libelle += this.pions.get(i).getLetter();
		}
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public ArrayList<Pion> getPions() {
		return pions;
	}

	public void setPions(ArrayList<Pion> pions) {
		this.pions = pions;
	}

	public void addPion(Pion p) {
		this.pions.add(p);
	}

	public Pion getPion(int indexPion) {
		return this.pions.get(indexPion);
	}

	/**
	 * getPoints() fonction qui renvoie le nombre de points d'un mot placé sur
	 * le scrabble.
	 * 
	 * @return
	 */
	public int getPoints() {
		int points = 0;
		for (int i = 0; i < this.pions.size(); i++) {
			points += this.pions.get(i).getPoint();
		}
		return points;
	}
}
