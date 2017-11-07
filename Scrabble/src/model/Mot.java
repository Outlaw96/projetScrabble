package model;

import java.util.ArrayList;

public class Mot {
	private String libelle;
	private ArrayList<Case> lesCases;

	public Mot() {
		this.libelle = "";
		this.lesCases = new ArrayList<>();
	}

	public Mot(ArrayList<Pion> pions) {
		// détermination du libelle à partir de la liste de pions reçus en
		// argument
		// et initialisation de l'attribut pions
		libelle = "";
	}

	// obtenir un mot a partir des pions
	public String getWord() {
		for (int i = 0; i < this.lesCases.size(); i++) {
			this.libelle += this.lesCases.get(i).getPion().getLetter();
		}
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public ArrayList<Case> getCases() {
		return lesCases;
	}

	public void setCases(ArrayList<Case> lesCases) {
		this.lesCases = lesCases;
	}

	public void addCase(Case p) {
		this.lesCases.add(p);
	}

	public Pion getPion(int indexPion) {
		return this.lesCases.get(indexPion).getPion();
	}

	public boolean contains(Pion p) {
		boolean contains = false;
		for (int i = 0; i < this.lesCases.size(); i++) {
			if (this.lesCases.get(i).getPion() == p) {
				contains = true;
			}
		}
		return contains;
	}

	/**
	 * getPoints() fonction qui renvoie le nombre de points d'un mot placé sur
	 * le scrabble.
	 * 
	 * @return
	 */
	public int getPointsFromWord() {
		int points = 0;
		for (int i = 0; i < this.lesCases.size(); i++) {
			if (this.lesCases.get(i).getTypeCase().getLibelle().equals("MD")
					|| this.lesCases.get(i).getTypeCase().getLibelle().equals("MT")) {
				points += this.lesCases.get(i).getPion().getPoint();
			} else {
				int a = this.lesCases.get(i).getPion().getPoint()
						* this.lesCases.get(i).getTypeCase().getMultiplicateur();
				points += a;
			}
		}
		return points;
	}

	public int getPointsFromCase() {
		int points = 1;
		for (int i = 0; i < this.lesCases.size(); i++) {
			if (this.lesCases.get(i).getTypeCase().getLibelle().equals("MD")
					|| this.lesCases.get(i).getTypeCase().getLibelle().equals("MT")) {
				points *= this.lesCases.get(i).getTypeCase().getMultiplicateur();
			}
		}
		return points;
	}

	public int getPoints() {
		return getPointsFromCase() * getPointsFromWord();
	}
}
