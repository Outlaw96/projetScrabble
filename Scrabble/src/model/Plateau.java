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
	}

	// fonction qui permet de v�rifier si un pion � un voisin � droite
	public boolean hasNeighbourRight(int i, int j) {
		assert (j < this.cases.length);
		return this.cases[i][j + 1].isTaken();
	}

	// fonction pour v�rifier qu'un pion a un voisin en dessous
	public boolean hasNeighbourDown(int i, int j) {
		assert (i < this.cases.length);
		return this.cases[i + 1][j].isTaken();
	}

	// cr�er un mot retrouver sur les lignes horizontales
	public Mot createWordHorizontal(int i) {
		Mot m = new Mot();
		boolean isCreating = true;
		int j = 0;
		while (j < this.cases.length && isCreating == true) {
			if (this.cases[i][j].isTaken()) {
				m.addPion(this.cases[i][j].getPion());
				j++;
			} else
				isCreating = false;
		}
		return m;
	}

	// cr�er un mot retrouver sur les lignes vertificales
	public Mot createWordVertical(int j) {
		Mot m = new Mot();
		boolean isCreating = true;
		int i = 0;
		while (i < this.cases.length && isCreating == true) {
			if (this.cases[i][j].isTaken()) {
				m.addPion(this.cases[i][j].getPion());
				i++;
			} else
				isCreating = false;
		}
		return m;
	}

	// retrouver les mots plac�s par le joueur
	public void playWord() {
		for (int i = 0; i < this.getCases().length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				if (!this.cases[i][j].getPion().isFixed()) {
					if (hasNeighbourDown(i, j)) {
						createWordVertical(j);
						return;
					} else if (hasNeighbourRight(i, j)) {
						createWordHorizontal(i);
					}
				}
			}
		}
	}

	/* METHODES */
	public void initPlateau() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				cases[i][j] = new Case(TypeCase.MS);
			}
		}
	}

	// Rechercher les mots plac�s verticalement
	public void searchMotVertical() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.cases[i][j].isTaken() && this.cases[i][j + 1].isTaken()) {

				}
			}
		}
	}

	/**
	 * pour v�rifier si le plateau est vide
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
	 * v�rifier si le plateau est plein
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
