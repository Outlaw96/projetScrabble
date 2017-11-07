package view;

import java.awt.Color;

import javax.swing.JFrame;

import model.Case;
/**
 * Frame qui gèrera l'affichage de l'interface d'échange de pions
 * @author Anonymous
 *
 */
public class SwapPions extends JFrame{
	
	private SwapPionsIHM conteneur;
	
	public SwapPions(Case[] chevalet)
	{
		//paramètres de la fenêtre
		super();
		this.conteneur = new SwapPionsIHM(chevalet, this);
		this.setContentPane(conteneur);
		this.setTitle("Echanger mes pions");
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
}
