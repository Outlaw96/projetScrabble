package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import listeners.PlateauListener;
import model.Case;
import model.Joueur;
import model.Partie;
import model.Plateau;

/**
 * Classe qui va representer graphiquemnt la classe plateau
 * 
 * @author nicolas
 *
 */
public class PlateauView extends JPanel {
	private Plateau plateau;
	private int xP, yP, sizeCaz, yIA, yHum, yB, sizeButton, xTool, sizeTool;
	private Joueur[] players;
	private Partie partie;

	/* CONSTRUCTOR */
	public PlateauView() {
		this.partie = new Partie();
		// test initialisation du sac de pion
		this.partie.initSacPion();
		this.plateau = new Plateau(15);
		this.players = new Joueur[2];

		// initialisation des deux joueurs
		this.players[1] = new Joueur("J1", true, this.partie);
		this.players[0] = new Joueur("IA", false, this.partie);

		// initialisation des chevalet des joueurs
		this.players[0].initChevalet();
		this.players[0].approvisionning();
		this.players[1].initChevalet();
		this.players[1].approvisionning();

		// afficher les chevalets
		// this.players[0].showChevalet();
		// this.players[1].showChevalet();
		this.partie.showSacPion();

		this.plateau.initPlateau();
		this.plateau.addMD();
		this.plateau.addMT();
		this.plateau.addLD();
		this.plateau.addLT();

		// Coord Y chevalet IA
		this.yIA = 10;
		this.xP = 50;
		this.yP = 60;
		this.sizeCaz = 30;
		this.sizeButton = 80;
		this.xTool = 550;
		this.sizeTool = 200;

		// Coord Y chevalet humain
		this.yHum = (this.yP + this.sizeCaz * 15) + 15;
		this.yB = this.yHum + 50;
		this.addMouseListener(new PlateauListener(this, this.plateau, this.players[1]));
	}

	// Recupérer tous les pions du joueurs placés sur le plateau
	public void retrieve() {
		for (int i = 0; i < this.plateau.getCases().length; i++) {
			for (int j = 0; j < this.plateau.getCases()[i].length; j++) {
				if (this.plateau.getCases()[i][j].isTaken() && !this.plateau.getCases()[i][j].getPion().isFixed()) {
					this.players[1].addPion(this.plateau.getCases()[i][j].getPion());
					this.plateau.removePion(i, j);
				}
			}
		}
	}

	// dessiner le minuteur
	public void drawMinuteur(Graphics g) {
		g.setColor(new Color(84, 130, 53));
		g.fillRect(xTool, yP, this.sizeTool, 100);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier new", Font.BOLD, 30));
		g.drawString("Minuteur", (this.xTool + this.sizeTool * 1 / 4) -20, (xP + 30) + 10);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.drawString("00 : 00", this.xTool + this.sizeTool * 1 / 4, (xP + 60) + 20);
	}
	
	//dessiner score joeur
	public void drawScore(Graphics g)
	{
		g.setColor(new Color(84, 130, 53));
		g.fillRect(xTool, yP + 120, this.sizeTool, 200);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier new", Font.BOLD, 30));
		g.drawString("Score", (this.xTool + this.sizeTool * 1 / 4), (xP + 30) + 130);
		g.drawString("IA", (this.xTool + this.sizeTool * 1 / 4) - 30, xP + 200);
		g.drawString("J1", (this.xTool + this.sizeTool * 1 / 4) + 90, xP + 200);
		g.setFont(new Font("Century", Font.ITALIC, 40));
		g.drawString("Vs", (this.xTool + this.sizeTool * 1 / 4) + 20, xP + 240);
		g.setFont(new Font("Century", Font.BOLD, 28));
		g.drawString(""+this.players[0].getPoints(), (this.xTool + this.sizeTool * 1 / 4) - 30, xP + 260); //IA
		g.drawString(""+this.players[1].getPoints(), (this.xTool + this.sizeTool * 1 / 4) + 90, xP + 260); //J1		
	}
	
	//dessiner la partie dico
	public void drawDictionnaire(Graphics g)
	{
		g.setColor(new Color(84, 130, 53));
		g.fillRect(xTool, yP + 400, this.sizeTool, 50);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Century", Font.BOLD, 30));
		g.drawString("Dictionnaire", (this.xTool + this.sizeTool * 1 / 4) - 47, (xP + 30) + 420);
	}

	// Desinner les boutons en dessous du chevalet joueur
	public void drawButtons(Graphics g) {
		for (int i = 0; i < 5; i++) {
			g.setColor(Color.BLACK);
			g.fill3DRect(this.xP, this.yB, this.sizeButton, this.sizeCaz, true);
			this.xP += 90;
		}
		this.xP = 50;
	}

	// Ecrire le nom de boutons
	public void drawNameButtons(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		g.drawString("Passer", this.xP + 10, this.yB + this.sizeCaz * 2 / 3);
		g.drawString("Echanger", this.xP + 100, this.yB + this.sizeCaz * 2 / 3);
		g.drawString("Mélanger", this.xP + 190, this.yB + this.sizeCaz * 2 / 3);
		g.drawString("Récup.", this.xP + 280, this.yB + this.sizeCaz * 2 / 3);
		g.drawString("Jouer", this.xP + 370, this.yB + this.sizeCaz * 2 / 3);
	}

	// Cliquer sur le bouton passer
	public boolean isSkiping(int x, int y) {
		return (x > this.xP && x < this.xP + this.sizeButton && y > this.yB && y < this.yB + this.sizeCaz);
	}

	// Cliquer sur le bouton échanger les pions
	public boolean isSwapping(int x, int y) {
		return (x > this.xP + 90 && x < this.xP + 90 + +this.sizeButton && y > this.yB && y < this.yB + this.sizeCaz);
	}

	// Cliquer sur le bouton mélanger les pions
	public boolean isMixing(int x, int y) {
		return (x > this.xP + 180 && x < this.xP + 180 + this.sizeButton && y > this.yB && y < this.yB + this.sizeCaz);
	}

	// Cliquer sur le bouton récupérer les pions
	public boolean isRetrieving(int x, int y) {
		return (x > this.xP + 270 && x < this.xP + 270 + this.sizeButton && y > this.yB && y < this.yB + this.sizeCaz);
	}

	// Cliquer sur le bouton jouer
	public boolean isPlaying(int x, int y) {
		return (x > this.xP + 360 && x < this.xP + 360 + this.sizeButton && y > this.yB && y < this.yB + this.sizeCaz);
	}
	
	//cliquer sur le bouton dictionnaire
	public boolean isSearching(int x, int y)
	{
		return (x >= 550 && x <= 750) && (y >= 460 && y <= 510);
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

	// Ecrire la dscription des différents type de case multiplicateurs
	public void writeCase(Graphics g, Case caz) {
		g.setColor(Color.YELLOW);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		g.drawString(caz.getTypeCase().getLibelle(), caz.getCoordX() + this.sizeCaz * 1 / 5,
				caz.getCoordY() + this.sizeCaz * 2 / 3);
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
			writeCase(g, caz);
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
		g.setColor(new Color(31, 78, 120));
		g.fillRect(0, 0, this.getWidth(), this.getWidth());
		drawPlateau(g);
		// desinner les deux chevalets
		drawChevalet(g, this.players[1], this.yHum);
		drawChevalet(g, this.players[0], this.yIA);
		drawMinuteur(g);
		drawScore(g);
		drawDictionnaire(g);
		drawButtons(g);
		drawNameButtons(g);
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public Joueur getPlayer(int index) {
		return players[index];
	}

	public void setPlayers(Joueur[] players) {
		this.players = players;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
}
