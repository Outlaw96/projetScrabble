package model;

/**
 * Class Case
 * 
 * @author Anonymous Cette classe modelise une case dans le plateau de jeu de
 *         scrabble
 */
public class Case {
	private int coordX;
	private int coordY;
	private boolean isTaken;
	private TypeCase typeCase;
	private Pion pion;

	/* CONSTRUCTORS */
	public Case(TypeCase typeCase) {
		this.typeCase = typeCase;
		this.isTaken = false;
	}

	public Case(int coordX, int coordY, boolean isTaken, TypeCase typeCase) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.isTaken = isTaken;
		this.typeCase = typeCase;
		pion = null;
	}

	public Case() {
		this.coordX = 0;
		this.coordY = 0;
		this.isTaken = false;
		this.typeCase = null;
		pion = null;
	}

	/**
	 * ajouter un pion dans une case
	 * 
	 * @param p
	 *            pion
	 */
	public void addPion(Pion p) {
		this.setPion(p);
		this.isTaken = true;
	}

	/**
	 * Supprimer un pion d'une case
	 */
	public void removePion() {
		this.setPion(null);
		this.setTaken(false);
	}

	/* GETTERS AND SETTERS */
	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public TypeCase getTypeCase() {
		return typeCase;
	}

	public void setTypeCase(TypeCase typeCase) {
		this.typeCase = typeCase;
	}

	public Pion getPion() {
		return pion;
	}

	public void setPion(Pion pion) {
		this.pion = pion;
	}

	public String toString() {
		return "" + this.typeCase;
	}
}
