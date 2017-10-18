package model;

/**
 * Class Pion
 * 
 * @author Anonymous Cette classe modélise un pion de jeu dans le scrabble. Il
 *         est composé comme l'indique la classe ci dessous
 */

public class Pion {
	private String letter;
	private int point;
	private boolean placed;
	private boolean joker;
	private Case casee;
	private boolean fixed;

	/* CONSTRUCTOR(S) */
	public Pion(String letter, int point) {
		this.letter = letter;
		this.point = point;
		this.setJoker(false);
		this.setPlaced(false);
		this.setFixed(false);
	}

	public Pion(String letter, int point, boolean joker) {
		this.letter = letter;
		this.point = point;
		this.joker = joker;
		this.setPlaced(false);
	}

	public Pion(String letter, int point, boolean isPlaced, boolean isJoker) {
		this.letter = letter;
		this.point = point;
		this.placed = isPlaced;
		this.joker = isJoker;
		this.casee = null;
	}

	/* GETTERS AND SETTERS */
	public boolean isFixed() {
		return this.fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isPlaced() {
		return this.placed;
	}

	public void setPlaced(boolean isPlaced) {
		this.placed = isPlaced;
	}

	public boolean isJoker() {
		return this.joker;
	}

	public void setJoker(boolean isJoker) {
		this.joker = isJoker;
	}

	public Case getCasee() {
		return casee;
	}

	public void setCasee(Case casee) {
		this.casee = casee;
	}
}
