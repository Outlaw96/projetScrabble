package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Case;
import model.Plateau;

/**
 * Classe qui va representer graphiquemnt la classe plateau
 * 
 * @author nicolas
 *
 */
public class PlateauView extends JPanel {
	private Plateau plateau;
	private int xP, yP, sizeCaz;

	/* CONSTRUCTOR */
	public PlateauView() {
		this.setBackground(Color.BLACK);
		this.plateau = new Plateau(15);
		this.plateau.initPlateau();
		this.plateau.addMD();
		this.plateau.addMT();
		this.plateau.addLD();
		this.plateau.addLT();
		this.plateau.getPlateau();
		this.xP = 50;
		this.yP = 50;
		this.sizeCaz = 35;
	}

	/**
	 * Attribuer une couleur à chaque type de case
	 * 
	 * @param caz
	 * @return la couleur
	 */
	public Color getCaseColor(Case caz) {
		switch (caz.getTypeCase()) {
		case MT:
			return Color.RED;
		case MD:
			return Color.PINK;
		case LT:
			return Color.BLUE;
		case LD:
			return Color.CYAN;
		default:
			return Color.GREEN;
		}
	}

	/**
	 * Déssiner une case du plateau
	 * 
	 * @param g
	 *            graphic
	 * @param size
	 *            taille case
	 * @param caz
	 *            case
	 */
	public void drawCase(Graphics g, int size, Case caz) {
		g.setColor(getCaseColor(caz));
		g.fill3DRect(caz.getCoordX(), caz.getCoordY(), size, size, false);
	}

	/**
	 * Dessiner toutes les cases du plateau un par un
	 * 
	 * @param g
	 *            graphic
	 */
	public void drawPlateau(Graphics g) {
		for (int i = 0; i < this.plateau.getCases().length; i++) {
			for (int j = 0; j < this.plateau.getCases()[i].length; j++) {
				this.plateau.getCases()[i][j].setCoordX(xP);
				this.plateau.getCases()[i][j].setCoordY(yP);
				drawCase(g, sizeCaz, this.plateau.getCases()[i][j]);
				this.xP += this.sizeCaz;
			}
			this.xP = 50;
			this.yP += this.sizeCaz;
		}
	}

	public void paint(Graphics g) {
		drawPlateau(g);
	}
}
