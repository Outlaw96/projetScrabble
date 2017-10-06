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

	/* METHODES */
	public void initPlateau() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				cases[i][j] = new Case(TypeCase.MS);
			}
		}
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

	public void getPlateau() {
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases[i].length; j++) {
				System.out.print(" " + cases[i][j].getTypeCase().getLibelle() + " ");
			}
			System.out.println();
		}
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