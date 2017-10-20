package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class ToolMenu extends JPanel {

	private Minuteur minuteur;
	private ScoreJoueurs scoreJoueurs;
	private Dictionnaire dictionnaire;

	public ToolMenu() {
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(31, 78, 120));

		this.minuteur = new Minuteur(true, 1);
		this.scoreJoueurs = new ScoreJoueurs();
		this.dictionnaire = new Dictionnaire();

		this.add(minuteur, BorderLayout.NORTH);
		this.add(scoreJoueurs, BorderLayout.CENTER);
		this.add(dictionnaire, BorderLayout.SOUTH);
	}
}
