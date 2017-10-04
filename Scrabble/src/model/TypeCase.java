package model;

/**
 * TypeCase
 * 
 * @author Anonymous by outlawz enumération permettant de definir les
 *         différentes types de case dans un plateau de jeu de scrabble
 */
public enum TypeCase {
	MS("+ ", 1), MT("3W", 3), MD("2W", 2), LT("3L", 3), LD("2L", 2);

	private final int multiplicateur;
	private final String libelle;

	TypeCase(String libelle, int multiplicateur) {
		this.libelle = libelle;
		this.multiplicateur = multiplicateur;
	}

	public int getMultiplicateur() {
		return this.multiplicateur;
	}

	public String getLibelle() {
		return this.libelle;
	}
}
