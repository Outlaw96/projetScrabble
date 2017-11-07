package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Case;
/**
 * Frame qui g�rera l'affichage de l'interface d'�change de pions
 * @author Anonymous
 *
 */
public class SwapPions extends JFrame{
	
	private SwapPionsIHM conteneur;
	
	public SwapPions(Case[] chevalet, PlateauView plateau)
	{
		//param�tres de la fen�tre
		super();
		this.conteneur = new SwapPionsIHM(chevalet, this, plateau);
		this.setContentPane(conteneur);
		this.setTitle("Echanger mes pions");
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
}
