package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listeners.SwapListener;
import model.Case;

/**
 * 
 * @author Anonymous Panel qui dessine et gère l'affichage de l'IHM pour
 *         l'échange de pion
 */
public class SwapPionsIHM extends JPanel {
	private Case[] chevalet;
	private boolean[] isDrawable;
	private final int widthCase = 50;
	private JFrame parent;

	public SwapPionsIHM(Case[] chevalet, JFrame parent) {
		this.chevalet = new Case[chevalet.length];
		this.parent = parent;
		System.out.println("Chevalet contient " + chevalet.length + " lettres");
		this.chevalet = chevalet;
		this.isDrawable = new boolean[this.chevalet.length];
		for (int i = 0; i < this.isDrawable.length; i++) {
			this.isDrawable[i] = true;
		}

		this.addMouseListener(new SwapListener(this));

		/*
		 * for (int i = 0; i < chevalet.length; i++) { Case c = chevalet[i];
		 * System.out.println(c.getPion().getLetter()); }
		 */
	}

	public void drawChevalet(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Century", Font.BOLD, 25));
		g.drawString("Mes pions actuels ", 200, 30);
		// on dessine les cases et leurs pions
		int x = 0;
		for (int i = 0; i < this.chevalet.length; i++) 
		{
			if (this.isDrawable[i]) {
				g.setColor(Color.WHITE);
				// pour bien centrer
				if (i == 0) {
					x = (i * this.widthCase) + 30;
				} else {
					x += this.widthCase + 30;
					// g.fillRect( (i * this.widthCase) + 50 + 50, 50, this.widthCase,
					// this.widthCase);
				}

				g.fillRect(x, 50, this.widthCase, this.widthCase);
				g.setColor(Color.BLACK);
				g.drawString(this.chevalet[i].getPion().getLetter(), x + 10, 85);

			} else
				x += drawPionsToSwap(g, this.chevalet[i], i, x);
			
			System.out.println("dessin réalisé à : "+x);
		}
	}
	
	public void echangerPion()
	{
		for(int i=0;i<this.chevalet.length;i++)
		{
			//si le pion courant est à échaner
			if(!this.isDrawable[i])
			{
				
			}
		}
	}
	public int drawPionsToSwap(Graphics g, Case c, int index, int x) {
		int toReturn=30;
		
		if (!this.isDrawable[index]) {
			int X = index == 0 ? 30 : x + this.widthCase +30;
			toReturn = index == 0 ? 30 : 80;
			g.setColor(Color.WHITE);
			g.fillRect(X, 185, this.widthCase, this.widthCase);
			g.setColor(Color.BLACK);
			g.drawString(this.chevalet[index].getPion().getLetter(), X + 10, 215);
			System.out.println(X);
		}
		return toReturn;
	}

	public void paint(Graphics g) {
		g.setColor(new Color(31, 78, 120));
		g.fillRect(0, 0, 600, 315);
		this.drawChevalet(g);
		g.setColor(Color.WHITE);
		g.drawLine(30, 130, 565, 130);
		g.setColor(Color.BLACK);
		g.drawString("Mes pions à échanger", 180, 170);
		g.setColor(Color.RED);
		g.setFont(new Font("Century", Font.BOLD, 16));
		g.drawString("* Cliquez sur vos pions actuels à échanger", 30, 260);
		g.fillRect(300, 275, 120, 30);
		g.setColor(new Color(84, 130, 53));
		g.fillRect(100, 275, 120, 30);
		g.setColor(Color.BLACK);
		g.drawString("Echanger", 120, 295);
		g.drawString("Annuler", 320, 295);
	}

	public Case[] getChevalet() {
		return chevalet;
	}

	public void setChevalet(Case[] chevalet) {
		this.chevalet = chevalet;
	}

	public JFrame getParent() {
		return parent;
	}

	public void setParent(JFrame parent) {
		this.parent = parent;
	}

	public int getWidthCase() {
		return widthCase;
	}

	public boolean[] getIsDrawable() {
		return isDrawable;
	}

	public void setIsDrawable(int index, boolean value) {
		this.isDrawable[index] = value;
	}

	
}
