package model;

import java.util.ArrayList;

public class Partie {
	private boolean isFinished;
	private boolean isDraw;
	private Joueur[] players;
	private Joueur currentPlayer;
	private int timer;
	private ArrayList<Pion> sacPions;
	private Plateau plateau;
	public static ArrayList<Mot> dictionnaire;

	/* CONSTRUCTOR(S) */
	public Partie() {
		this.sacPions = new ArrayList<>();
	}

	public Partie(boolean isFinished, boolean isDraw, Joueur[] players, Joueur currentPlayer, int timer,
			ArrayList<Pion> sacPions, Plateau plateau) {
		this.isFinished = isFinished;
		this.isDraw = isDraw;
		this.players = players;
		this.currentPlayer = currentPlayer;
		this.timer = timer;
		this.sacPions = sacPions;
		this.plateau = plateau;
	}

	public Pion getPion(int i) {
		return this.sacPions.get(i);
	}

	// Si le sac est vide
	public boolean isEmptySac() {
		return this.sacPions.isEmpty();
	}

	// supprimer pion à l'index i
	public void removeFromSac(int i) {
		this.sacPions.remove(i);
	}

	/**
	 * ajouter une case (échangée) dans le sac
	 * 
	 * @param index
	 *            : index de la case dans la quelle il faut mettre la case
	 * @param c
	 *            : Case à placer
	 */
	public void addIntoSac(int index, Pion p) {
		if (index < this.sacPions.size())
			this.sacPions.set(index, p);
	}

	/**
	 * Remplir le sac de pions
	 */
	public void initSacPion() {
		addJoker("", 0, true);

		// ajout des pions 1 point
		addPion("E", 1, 15);
		addPion("A", 1, 9);
		addPion("I", 1, 8);
		addPion("N", 1, 6);
		addPion("O", 1, 6);
		addPion("R", 1, 6);
		addPion("S", 1, 6);
		addPion("T", 1, 6);
		addPion("U", 1, 6);
		addPion("L", 1, 5);

		// ajout des pions 2 points
		addPion("D", 2, 3);
		addPion("G", 2, 2);
		addPion("M", 2, 3);

		// ajout des pions 3 points
		addPion("B", 3, 2);
		addPion("C", 3, 2);
		addPion("P", 3, 2);

		// ajout des pions 4 pionts
		addPion("F", 4, 2);
		addPion("H", 4, 2);
		addPion("V", 4, 2);

		// ajout des pions 8 points
		addPion("J", 8, 1);
		addPion("Q", 8, 1);

		// ajout des pions 10 points
		addPion("K", 10, 1);
		addPion("W", 10, 1);
		addPion("X", 10, 1);
		addPion("Y", 10, 1);
		addPion("Z", 10, 1);
	}

	// ajouter un pion une ou plusieurs fois
	public void addPion(String letter, int point, int nb) {
		for (int i = 0; i < nb; i++) {
			this.sacPions.add(new Pion(letter, point));
		}
	}

	// ajouter les joker dans le sac
	public void addJoker(String letter, int point, boolean joker) {
		this.sacPions.add(new Pion(letter, point, joker));
		this.sacPions.add(new Pion(letter, point, joker));
	}

	public void showSacPion() {
		for (int i = 0; i < this.sacPions.size(); i++) {
			System.out.println("[" + i + "] " + this.sacPions.get(i).getLetter() + " " + this.sacPions.get(i).getPoint()
					+ " " + this.sacPions.get(i).isJoker());
		}
	}

	/* GETTERS AND SETTERS */
	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public boolean isDraw() {
		return isDraw;
	}

	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}

	public Joueur[] getPlayers() {
		return players;
	}

	public void setPlayers(Joueur[] players) {
		this.players = players;
	}

	public Joueur getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Joueur currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public ArrayList<Pion> getSacPions() {
		return sacPions;
	}

	public void setSacPions(ArrayList<Pion> sacPions) {
		this.sacPions = sacPions;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public ArrayList<Mot> getDictionnaire() {
		return dictionnaire;
	}

	public void setDictionnaire(ArrayList<Mot> dictionnaire) {
		this.dictionnaire = dictionnaire;
	}
}
