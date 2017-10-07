package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Case;
import model.Joueur;
import model.Pion;
import model.Plateau;

/**
 * Classe qui va representer graphiquemnt la classe plateau
 * 
 * @author nicolas
 *
 */
public class PlateauView extends JPanel {
	private Plateau plateau;
	private int xP, yP, sizeCaz, yIA, yHum;
	private Joueur[] players;

	/* CONSTRUCTOR */
	public PlateauView() {
		this.plateau = new Plateau(15);
		this.players = new Joueur[2];

		// initialisation des deux joueurs
		this.players[1] = new Joueur("Player1", true);
		this.players[0] = new Joueur("IA", false);

		// initialisation des chevalet des joueurs
		this.players[0].initChevalet();
		this.players[1].initChevalet();

		// tester un chevalet avec des pions
		this.players[1].addPion(0, new Pion("X", 12, false, false));
		// this.players[1].addPion(1, new Pion("X", 12, false, false));
		// this.players[1].addPion(2, new Pion("X", 12, false, false));
		this.players[1].addPion(3, new Pion("X", 12, false, false));
		this.players[1].addPion(4, new Pion("X", 12, false, false));
		this.players[0].addPion(5, new Pion("X", 12, false, false));
		this.players[0].addPion(6, new Pion("X", 12, false, false));
		// affichage des deux chevalets dans la console
		this.players[0].showChevalet();
		this.players[1].showChevalet();

		this.plateau.initPlateau();
		this.plateau.addMD();
		this.plateau.addMT();
		this.plateau.addLD();
		this.plateau.addLT();

		// tester la présence des pions sur le plateau
		this.plateau.getCases()[7][7].addPion(new Pion("L", 10, true, false));
		this.plateau.getCases()[7][8].addPion(new Pion("L", 10, true, false));
		// this.plateau.getCases()[7][9].addPion(new Pion("L", 10, true,
		// false));
		// this.plateau.getCases()[7][10].addPion(new Pion("L", 10, true,
		// false));
		this.plateau.getCases()[7][11].addPion(new Pion("L", 10, true, false));
		this.plateau.getCases()[7][12].addPion(new Pion("L", 10, true, false));

		this.plateau.getPlateau();

		// Coord Y chevalet IA
		this.yIA = 10;
		this.xP = 50;
		this.yP = this.yIA + 50;
		this.sizeCaz = 30;

		// Coord Y chevalet humain
		this.yHum = (this.yP + this.sizeCaz * 15) + 15;
	}

	/**
	 * Attribuer une couleur à chaque type de case
	 * 
	 * @param caz
	 * @return la couleur
	 */
	public Color getCaseColor(Case caz) {
		if (!caz.isTaken()) {
			switch (caz.getTypeCase()) {
			case MT:
				return new Color(255, 0, 0);
			case MD:
				return new Color(255, 128, 229);
			case LT:
				return new Color(0, 0, 255);
			case LD:
				return new Color(0, 192, 255);
			default:
				return new Color(25, 190, 114);
			}
		} else
			return Color.YELLOW;
	}

	/**
	 * ecrire la lettre et le point d'un pion
	 * 
	 * @param g
	 *            pour dessiner
	 * @param caz
	 *            le pion
	 */
	public void writeLetter(Graphics g, Case caz) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString(caz.getPion().getLetter(), caz.getCoordX(), caz.getCoordY() + this.sizeCaz * 4 / 5);
		g.setFont(new Font("Arial", Font.BOLD, 10));
		g.drawString("" + caz.getPion().getPoint(), caz.getCoordX() + this.sizeCaz / 2,
				caz.getCoordY() + 4 * this.sizeCaz / 5);
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
		if (caz.isTaken()) {
			g.setColor(getCaseColor(caz));
			g.fill3DRect(caz.getCoordX(), caz.getCoordY(), size, size, false);
			writeLetter(g, caz);
		} else {
			g.setColor(getCaseColor(caz));
			g.fill3DRect(caz.getCoordX(), caz.getCoordY(), size, size, false);
		}
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

	/**
	 * dessiner une case du chevalet du joueur
	 * 
	 * @param g
	 *            pour dessiner
	 * @param x
	 *            coord x
	 * @param y
	 *            coord y
	 */
	public void caseChevalet(Graphics g, int x, int y, Joueur joueur, int i) {
		if (joueur.getChevalet()[i].isTaken()) {
			g.setColor(Color.YELLOW);
			g.fill3DRect(x, y, this.sizeCaz, this.sizeCaz, false);
			writeLetter(g, joueur.getChevalet()[i]);
		} else {
			g.setColor(Color.GRAY);
			g.fill3DRect(x, y, this.sizeCaz, this.sizeCaz, false);
		}
	}

	/**
	 * dessiner le chevalet
	 * 
	 * @param g
	 *            dessiner
	 * @param joueur
	 * @param y
	 *            hauteur
	 */
	public void drawChevalet(Graphics g, Joueur joueur, int y) {
		for (int i = 0; i < joueur.getChevalet().length; i++) {
			joueur.getChevalet()[i].setCoordX(xP);
			joueur.getChevalet()[i].setCoordY(y);
			caseChevalet(g, xP, y, joueur, i);
			xP += this.sizeCaz;
		}
		this.xP = 50;
	}

	/**
	 * Savoir si la souris est dans la case
	 * 
	 * @param x
	 *            coord x case
	 * @param y
	 *            coord y case
	 * @param xm
	 *            coord x souris
	 * @param ym
	 *            coord y souris
	 * @return vrai
	 */
	public boolean isInsideCase(Case caz, int xm, int ym) {
		return (xm >= caz.getCoordX() || xm <= caz.getCoordX() + this.sizeCaz)
				&& (ym >= caz.getCoordY() || ym <= caz.getCoordY() + this.sizeCaz);
	}

	public void paint(Graphics g) {
		drawPlateau(g);
		// desinner les deux chevalets
		drawChevalet(g, this.players[1], this.yHum);
		drawChevalet(g, this.players[0], this.yIA);
	}
}
