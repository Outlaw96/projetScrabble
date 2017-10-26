package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe pour representer graphiquement une partie
 * 
 * @author nicolas
 *
 */
public class PartieView extends JFrame {
	private PlateauView plateauView;

	public PartieView() {
		/*-----------------------------------------------------------
		 * Configuration de la fenêtre
		 * ----------------------------------------------------------
		 */
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Scrabble Game");

		/*-----------------------------------------------------------
		 * préparation du contenu de la fenêtre
		 * ----------------------------------------------------------
		 */
		this.plateauView = new PlateauView();

		/*-----------------------------------------------------------
		 * Ajout du contenu de la fenêtre
		 * ----------------------------------------------------------
		 */

		this.setContentPane(plateauView);
		/*
		 * this.plateauView = new PlateauView(); this.joueurView = new
		 * JoueurView();
		 * 
		 * fond = new JPanel(); fond.setLayout(new BorderLayout());
		 * fond.add(plateauView, BorderLayout.CENTER); fond.add(joueurView,
		 * BorderLayout.SOUTH);
		 * 
		 * this.getContentPane().add(fond);
		 */
		this.setVisible(true);
	}
}
