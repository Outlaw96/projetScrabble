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
 *         fenêtre c'est à dire tous les éléménts à afficher dans la fenêtre y
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
		 * préparation du contenu du panel (conteneur principal
		 * ----------------------------------------------------------
		 */

		// Préparation chevalet IA

		chevaletIA = new JPanel();
		chevaletIA.setBackground(Color.WHITE);
		chevaletIA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel labelChevaletIA = new JLabel("Chevalet IA");
		labelChevaletIA.setFont(new Font("Serial", Font.BOLD, 30));
		chevaletIA.add(labelChevaletIA);

		// Préparation du plateau de jeu
		plateauView = new PlateauView();

		// préparation du tool menu
		toolMenu = new ToolMenu();

		// Préparation du chevaletDuJoueur
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
