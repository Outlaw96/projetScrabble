package model;

import java.util.ArrayList;

public class Joueur {
	private int count;
	private String pseudo;
	private boolean winner;
	private boolean human;
	private Case chevalet[];

	public Joueur(String pseudo, boolean human) {
		this.pseudo = pseudo;
		this.winner = false;
		this.chevalet = new Case[7];
		this.count = 0;
	}

	/**
	 * initialiser le chevalet du joueur
	 */
	public void initChevalet() {
		for (int i = 0; i < this.chevalet.length; i++) {
			this.chevalet[i] = new Case(TypeCase.MS);
		}
	}

	public void approvisionning(ArrayList<Pion> sacPions) {
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Case[] getChevalet() {
		return chevalet;
	}

	public void setChevalet(Case[] chevalet) {
		this.chevalet = chevalet;
	}

	public boolean isHuman() {
		return human;
	}

	public void setHuman(boolean human) {
		this.human = human;
	}

	/**
	 * Le nombre pion dans le chevalet
	 * 
	 * @return nombre de pion
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * ajouter un pion dans une case du chevalet
	 * 
	 * @param i
	 *            index
	 * @param p
	 *            pion
	 */
	public void addPion(int i, Pion p) {
		this.chevalet[i].addPion(p);
		this.count++;
	}

	public void removePion(int i) {
		this.chevalet[i].removePion();
		this.count--;
	}

	/**
	 * Tester si le chevalet du joueur est plein
	 * 
	 * @return vrai
	 */
	public boolean isFull() {
		return count == 7;
	}

	/**
	 * Tester si lec chevalet est vide
	 * 
	 * @return vrai
	 */
	public boolean isEmpty() {
		return this.count == 0;
	}

	public void showChevalet() {
		for (int i = 0; i < this.chevalet.length; i++) {
			if (this.chevalet[i].isTaken()) {
				System.out.print("[" + this.chevalet[i].getPion().getLetter() + "]");
			} else
				System.out.print("[ ]");
		}
		System.out.println();
	}
}
