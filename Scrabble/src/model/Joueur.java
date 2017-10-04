package model;

import java.util.ArrayList;

public class Joueur {
	private String pseudo;
	private boolean isWinner;
	Pion chevalet[];

	public Joueur(String pseudo, ArrayList<Pion> sacPions) {

		this.pseudo = pseudo;
		this.isWinner = false;
		this.chevalet = new Pion[7];

		for (Pion p : this.chevalet) {
			p = null;
		}

		// ensuite on tire aleatoirement 7 pions pour le joueur
		this.initialiserChevalet(sacPions);
	}

	private void initialiserChevalet(ArrayList<Pion> sacPions) {

	}

	public boolean isFullChevalet() {
		return this.chevalet.length == 7;
	}

	public boolean approvisionning(ArrayList<Pion> sacPions) {
		return true;
	}
}
