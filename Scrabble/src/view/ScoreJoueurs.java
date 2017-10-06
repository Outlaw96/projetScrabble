package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ScoreJoueurs extends JPanel{

	private String message;
	
	public ScoreJoueurs()
	{
		/*---------------------------------------------------
		 * Initialisation des paramètres du minuteur
		 * --------------------------------------------------
		 */
		this.setBackground(new Color(84, 130, 53));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Score joueurs",TitledBorder.CENTER, TitledBorder.TOP, new Font("Serial", Font.BOLD, 25)));
		this.updateContent("IA : 0 VS J1 : 0");
	}
	
	public void updateContent(String msg)
	{
		JLabel contenuMessage = new JLabel(msg);
		contenuMessage.setFont(new Font("Serial", Font.BOLD, 40));
		this.add(contenuMessage);
	}
}
