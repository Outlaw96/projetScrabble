package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * MainContainer Class
 * 
 * @author Anonymous Cette classe represente le conteneur principale de notre
 *         fen�tre c'est � dire tous les �l�m�nts � afficher dans la fen�tre y
 *         seront
 */
public class MainContainer extends JPanel {

	private PlateauView plateauView;
	private JPanel chevaletIA;
	private JPanel chevaletJoueur;
	private ToolMenu toolMenu;

	public MainContainer() {
		/*----------------------------------------------------------
		 * Configuration du conteneur principal
		 * ---------------------------------------------------------
		 */
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(31, 78, 120));

		/*-----------------------------------------------------------
		 * pr�paration du contenu du panel (conteneur principal
		 * ----------------------------------------------------------
		 */

		// Pr�paration chevalet IA

		chevaletIA = new JPanel();
		chevaletIA.setBackground(Color.WHITE);
		chevaletIA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel labelChevaletIA = new JLabel("Chevalet IA");
		labelChevaletIA.setFont(new Font("Serial", Font.BOLD, 30));
		chevaletIA.add(labelChevaletIA);

		// Pr�paration du plateau de jeu
		plateauView = new PlateauView();

		// pr�paration du tool menu
		toolMenu = new ToolMenu();

		// Pr�paration du chevaletDuJoueur
		chevaletJoueur = new JPanel();
		chevaletJoueur.setBackground(Color.WHITE);

		/*-----------------------------------------------------------
		 * Ajout du contenu du panel
		 * ----------------------------------------------------------
		 */
		// this.add(chevaletIA, BorderLayout.NORTH);
		this.add(plateauView, BorderLayout.CENTER);
		this.add(toolMenu, BorderLayout.EAST);
		// this.add(chevaletJoueur, BorderLayout.SOUTH);
	}
}
