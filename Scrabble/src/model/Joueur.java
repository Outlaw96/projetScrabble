package model;

import java.util.ArrayList;

public class Joueur {
	private String pseudo;
	private boolean isWinner;
	private Pion chevalet[];

	public Joueur(String pseudo, ArrayList<Pion> sacPions) {

		this.pseudo = pseudo;
		this.isWinner = false;
		this.chevalet = new Pion[7];
	}

	public boolean isFullChevalet() {
		return this.chevalet.length == 7;
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
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public Pion[] getChevalet() {
		return chevalet;
	}

	public void setChevalet(Pion[] chevalet) {
		this.chevalet = chevalet;
	}
}
