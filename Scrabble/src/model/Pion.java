package model;

/**
 * Class Pion
 * @author Anonymous
 * Cette classe modélise un pion de jeu dans le scrabble. Il est composé comme l'indique la classe ci dessous
 */

public class Pion {
	private String letter;
	private int point;
	private boolean isPlaced;
	private boolean isJoker;
	private Case casee;
	
	public Pion(String letter, int point, boolean isPlaced, boolean isJoker) {
		super();
		this.letter = letter;
		this.point = point;
		this.isPlaced = isPlaced;
		this.isJoker = isJoker;
		this.casee = null;
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
		return isPlaced;
	}

	public void setPlaced(boolean isPlaced) {
		this.isPlaced = isPlaced;
	}

	public boolean isJoker() {
		return isJoker;
	}

	public void setJoker(boolean isJoker) {
		this.isJoker = isJoker;
	}

	public Case getCasee() {
		return casee;
	}

	public void setCasee(Case casee) {
		this.casee = casee;
	}
	
	
}
