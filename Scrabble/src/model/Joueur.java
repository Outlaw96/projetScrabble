package model;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
	private int count;
	private String pseudo;
	private boolean winner;
	private boolean human;
	private Case chevalet[];
	private Random rand;

	public Joueur(String pseudo, boolean human) {
		this.pseudo = pseudo;
		this.winner = false;
		this.chevalet = new Case[7];
		this.count = 0;
		rand = new Random();
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

	/**
	 * echanger deux pions dans deux cases
	 * 
	 * @param i
	 * @param j
	 */
	public void swapp(int i, int j) {
		Pion caz = this.chevalet[i].getPion();
		this.chevalet[i].removePion();
		this.chevalet[i].addPion(this.chevalet[j].getPion());
		this.chevalet[j].removePion();
		this.chevalet[j].addPion(caz);
	}

	/**
	 * mélangez aléatoirement les pions sur le chevalet d'un joueur
	 */
	public void mix() {
		if (this.isFull()) {
			for (int i = 0; i < this.chevalet.length; i++) {
				int x = rand.nextInt(this.chevalet.length);
				swapp(i, x);
			}
		}
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
