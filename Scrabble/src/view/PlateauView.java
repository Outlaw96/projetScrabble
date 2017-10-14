package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import listeners.PlateauListener;
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
		this.players[1].addPion(0, new Pion("A", 9, false, false));
		this.players[1].addPion(1, new Pion("B", 2, false, false));
		this.players[1].addPion(2, new Pion("C", 5, false, false));
		this.players[1].addPion(3, new Pion("D", 1, false, false));
		this.players[1].addPion(4, new Pion("E", 10, false, false));
		this.players[1].addPion(5, new Pion("F", 11, false, false));
		this.players[1].addPion(6, new Pion("G", 12, false, false));
		this.players[0].addPion(4, new Pion("E", 10, false, false));
		this.players[0].addPion(5, new Pion("F", 11, false, false));
		this.players[0].addPion(6, new Pion("G", 12, false, false));
		// affichage des deux chevalets dans la console
		// this.players[0].showChevalet();
		// this.players[1].showChevalet();

		this.plateau.initPlateau();
		this.plateau.addMD();
		this.plateau.addMT();
		this.plateau.addLD();
		this.plateau.addLT();

		// tester la présence des pions sur le plateau
		this.plateau.getCases()[7][7].addPion(new Pion("L", 10, true, false));
		this.plateau.getCases()[0][0].addPion(new Pion("L", 10, true, false));
		this.plateau.getCases()[7][8].addPion(new Pion("L", 10, true, false));
		this.plateau.getCases()[7][9].addPion(new Pion("L", 10, true, false));

		// test mix des pions dans chevalet du joueur
		// this.plateau.getPlateau();
		// this.players[1].showChevalet();
		// this.players[1].mix();
		// this.players[1].showChevalet();

		// Coord Y chevalet IA
		this.yIA = 10;
		this.xP = 50;
		this.yP = 60;
		this.sizeCaz = 30;

		// Coord Y chevalet humain
		this.yHum = (this.yP + this.sizeCaz * 15) + 15;
		this.addMouseListener(new PlateauListener(this, this.plateau, this.players[1]));
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
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		g.drawString(caz.getPion().getLetter(), caz.getCoordX(), caz.getCoordY() + this.sizeCaz * 3 / 4);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
		g.drawString("" + caz.getPion().getPoint(), caz.getCoordX() + this.sizeCaz * 3 / 5,
				caz.getCoordY() + this.sizeCaz - 1);
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
		this.yP = 60;
		this.xP = 50;
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

	/**
	 * renvoi le coordonnée de la seconde dimension du plateau
	 * 
	 * @param y
	 *            coordy souris
	 * @return indice y de la case
	 */
	public int getY(int y) {
		int coordy = -1;
		if (y > 50 && y < 80) {
			coordy = 0;
		} else if (y > 80 && y < 110) {
			coordy = 1;
		} else if (y > 110 && y < 140) {
			coordy = 2;
		} else if (y > 140 && y < 170) {
			coordy = 3;
		} else if (y > 170 && y < 200) {
			coordy = 4;
		} else if (y > 200 && y < 230) {
			coordy = 5;
		} else if (y > 230 && y < 260) {
			coordy = 6;
		} else if (y > 260 && y < 290) {
			coordy = 7;
		} else if (y > 290 && y < 310) {
			coordy = 8;
		} else if (y > 320 && y < 350) {
			coordy = 9;
		} else if (y > 350 && y < 380) {
			coordy = 10;
		} else if (y > 380 && y < 410) {
			coordy = 11;
		} else if (y > 410 && y < 440) {
			coordy = 12;
		} else if (y > 440 && y < 470) {
			coordy = 13;
		} else if (y > 470 && y < 500) {
			coordy = 14;
		}
		return coordy;
	}

	/**
	 * renvoi le coordonnée de la première dimension du plateau
	 * 
	 * @param x
	 *            coordy de la souris
	 * @return indice x de la case
	 */
	public int getX(int x) {
		int coordx = -1;
		if (x > 60 && x < 90) {
			coordx = 0;
		} else if (x > 90 && x < 120) {
			coordx = 1;
		} else if (x > 120 && x < 150) {
			coordx = 2;
		} else if (x > 150 && x < 180) {
			coordx = 3;
		} else if (x > 180 && x < 210) {
			coordx = 4;
		} else if (x > 210 && x < 240) {
			coordx = 5;
		} else if (x > 240 && x < 270) {
			coordx = 6;
		} else if (x > 270 && x < 300) {
			coordx = 7;
		} else if (x > 300 && x < 330) {
			coordx = 8;
		} else if (x > 330 && x < 360) {
			coordx = 9;
		} else if (x > 360 && x < 390) {
			coordx = 10;
		} else if (x > 390 && x < 420) {
			coordx = 11;
		} else if (x > 420 && x < 450) {
			coordx = 12;
		} else if (x > 450 && x < 480) {
			coordx = 13;
		} else if (x > 480 && x < 510) {
			coordx = 14;
		}
		return coordx;
	}

	/**
	 * Renvoyer l'index du chevalet joueur
	 * 
	 * @param x
	 *            coordonnée x de la souris
	 * @return l'index d'un chevalet
	 */
	public int getIndexChevalet(int x, int y) {
		int index = -1;
		if (y > 525 && y < 555) {
			if (x > 50 && x < 80) {
				index = 0;
			} else if (x > 80 && x < 110) {
				index = 1;
			} else if (x > 110 && x < 140) {
				index = 2;
			} else if (x > 140 && x < 170) {
				index = 3;
			} else if (x > 170 && x < 200) {
				index = 4;
			} else if (x > 200 && x < 230) {
				index = 5;
			} else if (x > 230 && x < 260) {
				index = 6;
			}
		}
		return index;
	}

	public void paint(Graphics g) {
		drawPlateau(g);
		// desinner les deux chevalets
		drawChevalet(g, this.players[1], this.yHum);
		drawChevalet(g, this.players[0], this.yIA);
	}
}
