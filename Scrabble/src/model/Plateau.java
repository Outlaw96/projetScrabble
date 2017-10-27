package model;

import java.util.ArrayList;

public class Plateau {

	private int size;
	private ArrayList<Mot> mots;
	private Case[][] cases;

	/* CONSTRUCTOR(S) */
	public Plateau(int size) {
		this.size = size;
		this.cases = new Case[size][size];
		this.mots = new ArrayList<>();
	}

	// fonction qui permet de vérifier si un pion à un voisin à droite
	public boolean hasNeighbourRight(int i, int j) {
		if (j < this.cases.length - 1)
			return this.cases[i][j + 1].isTaken();
		return false;
	}

	// fonction pour vérifier qu'un pion a un voisin en dessous
	public boolean hasNeighbourDown(int i, int j) {
		if (i < this.cases.length - 1)
			return this.cases[i + 1][j].isTaken();
		return false;
	}

	// fonction qui permet de vérifier si un pion à un voisin à gauche
	public boolean hasNeighbourLeft(int i, int j) {
		if (j > 0)
			return this.cases[i][j - 1].isTaken();
		return false;
	}

	// fonction pour vérifier qu'un pion a un voisin au dessus
	public boolean hasNeighbourUp(int i, int j) {
		if (i > 0)
			return this.cases[i - 1][j].isTaken();
		return false;
	}

	// retour à la première lettre du mot
	public void backToFirst(int i, int j) {
		if (hasNeighbourUp(i, j)) {

		}
	}

	// valider un mot et fixer tous ses pions
	public void fixPions() {
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (!this.cases[i][j].getPion().isFixed()) {
					this.cases[i][j].getPion().setFixed(true);
				}
			}
		}
	}

	// créer un mot retrouver sur les lignes horizontales
	public Mot createWordHorizontal(int i, int j) {
		Mot m = new Mot();
		boolean isCreating = true;
		while (j <= this.cases.length - 1 && isCreating == true) {
			if (this.cases[i][j].isTaken()) {
				m.addPion(this.cases[i][j].getPion());
				j++;
			} else
				isCreating = false;
		}
		return m;
	}

	// créer un mot retrouver sur les lignes vertificales
	public Mot createWordVertical(int i, int j) {
		Mot m = new Mot();
		boolean isCreating = true;
		while (i <= this.cases.length - 1 && isCreating == true) {
			if (this.cases[i][j].isTaken()) {
				m.addPion(this.cases[i][j].getPion());
				i++;
			} else
				isCreating = false;
		}
		return m;
	}

	// retrouver les mots placés par le joueur
	public void playWord() {
		for (int i = 0; i < this.getCases().length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (this.cases[i][j].isTaken() && !this.cases[i][j].getPion().isFixed()) {
					if (hasNeighbourDown(i, j) && hasNeighbourRight(i, j)) {
						this.mots.add(createWordVertical(i, j));
						this.mots.add(createWordHorizontal(i, j));
						return;
					} else if (hasNeighbourDown(i, j)) {
						this.mots.add(createWordVertical(i, j));
						return;
					} else if (hasNeighbourRight(i, j)) {
						this.mots.add(createWordHorizontal(i, j));
						return;
					}
				}
			}
		}
	}

	// afficher les mots
	public void showWords() {
		for (int i = 0; i < this.mots.size(); i++) {
			System.out.println(this.mots.get(i).getWord() + " " + this.mots.get(i).getPoints());
		}
	}

	// fonction pour recupérer le multiplicateur des cases où le mot est placé
	public int getMultiple(Mot mot) {
		int multiple = 1;
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (this.cases[i][j].isTaken() && mot.contains(this.cases[i][j].getPion())) {
					multiple *= this.cases[i][j].getTypeCase().getMultiplicateur();
				}
			}
		}
		return multiple;
	}

	// fonction pour calculer les points d'un mot en fonction des cases où il
	// est placé
	public int getPoints(Mot mot) {
		return mot.getPoints() * this.getMultiple(mot);
	}

	/* METHODES */
	public void initPlateau() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				cases[i][j] = new Case(TypeCase.MS);
			}
		}
	}

	// Rechercher les mots placés verticalement
	public void searchMotVertical() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.cases[i][j].isTaken() && this.cases[i][j + 1].isTaken()) {

				}
			}
		}
	}

	/**
	 * pour vérifier si le plateau est vide
	 * 
	 * @return vrai
	 */
	public boolean isEmpty() {
		boolean isEmpty = true;
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (this.cases[i][j].isTaken()) {
					isEmpty = false;
				}
			}
		}
		return isEmpty;
	}

	/**
	 * vérifier si le plateau est plein
	 * 
	 * @return vrai
	 */
	public boolean isFull() {
		boolean isFull = true;
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (!this.cases[i][j].isTaken()) {
					isFull = false;
				}
			}
		}
		return isFull;
	}

	/* ajout des cases MOT TRIPLE */
	public void addMT() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				if (i == 0 || i == 14) {
					cases[i][0] = new Case(TypeCase.MT);
					cases[i][7] = new Case(TypeCase.MT);
					cases[i][14] = new Case(TypeCase.MT);
				}
				if (i == 7) {
					cases[i][0] = new Case(TypeCase.MT);
					cases[i][14] = new Case(TypeCase.MT);
				}
			}
		}
	}

	/* Ajout des cases MOT DOUBLE */
	public void addMD() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				if (i == 1 || i == 13) {
					cases[i][1] = new Case(TypeCase.MD);
					cases[i][13] = new Case(TypeCase.MD);
				}
				if (i == 2 || i == 12) {
					cases[i][2] = new Case(TypeCase.MD);
					cases[i][12] = new Case(TypeCase.MD);
				}
				if (i == 3 || i == 11) {
					cases[i][3] = new Case(TypeCase.MD);
					cases[i][11] = new Case(TypeCase.MD);
				}
				if (i == 4 || i == 10) {
					cases[i][4] = new Case(TypeCase.MD);
					cases[i][10] = new Case(TypeCase.MD);
				}
				if (i == 7) {
					cases[i][7] = new Case(TypeCase.MD);
				}
			}
		}
	}

	/* ajout des cases LETTRE TRIPLE */
	public void addLT() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 1 || i == 13) {
					cases[i][5] = new Case(TypeCase.LT);
					cases[i][9] = new Case(TypeCase.LT);
				}
				if (i == 5 || i == 9) {
					cases[i][1] = new Case(TypeCase.LT);
					cases[i][5] = new Case(TypeCase.LT);
					cases[i][9] = new Case(TypeCase.LT);
					cases[i][13] = new Case(TypeCase.LT);
				}
			}
		}
	}

	/* ajout des cases LETTRE DOUBLE */
	public void addLD() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0 || i == 14) {
					cases[i][3] = new Case(TypeCase.LD);
					cases[i][11] = new Case(TypeCase.LD);
				}
				if (i == 2 || i == 12) {
					cases[i][6] = new Case(TypeCase.LD);
					cases[i][8] = new Case(TypeCase.LD);
				}
				if (i == 3 || i == 11) {
					cases[i][0] = new Case(TypeCase.LD);
					cases[i][7] = new Case(TypeCase.LD);
					cases[i][14] = new Case(TypeCase.LD);
				}
				if (i == 6 || i == 8) {
					cases[i][2] = new Case(TypeCase.LD);
					cases[i][6] = new Case(TypeCase.LD);
					cases[i][8] = new Case(TypeCase.LD);
					cases[i][12] = new Case(TypeCase.LD);
				}
				if (i == 7) {
					cases[i][3] = new Case(TypeCase.LD);
					cases[i][11] = new Case(TypeCase.LD);
				}
			}
		}
	}

	/**
	 * afficher le plateau dans la console
	 */
	public void getPlateau() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				if (cases[i][j].isTaken()) {
					System.out.print(" " + cases[i][j].getPion().getLetter() + " ");
				} else
					System.out.print(" " + cases[i][j].getTypeCase().getLibelle() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Ajouter pion dans les cases du plateau
	 * 
	 * @param i
	 *            ligne
	 * @param j
	 *            colonne
	 * @param p
	 *            pion
	 */
	public void addPion(int i, int j, Pion p) {
		this.cases[i][j].addPion(p);
	}

	/**
	 * supprimer un pion d'une des cases du plateau
	 * 
	 * @param i
	 *            ligne
	 * @param j
	 *            colonne
	 */
	public void removePion(int i, int j) {
		this.cases[i][j].removePion();
	}

	/* GETTERS AND SETTERS */
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Mot> getMots() {
		return mots;
	}

	public void setMots(ArrayList<Mot> mots) {
		this.mots = mots;
	}

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
}
