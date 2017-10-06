package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Minuteur extends JPanel{

	private String message;
	
	public Minuteur()
	{
		/*---------------------------------------------------
		 * Initialisation des paramètres du minuteur
		 * --------------------------------------------------
		 */
		this.setBackground(new Color(84, 130, 53));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Minuteur",TitledBorder.CENTER, TitledBorder.TOP, new Font("Serial", Font.BOLD, 25)));
		this.updateContent("00 : 00");
	}
	
	public void updateContent(String msg)
	{
		JLabel contenuMessage = new JLabel(msg);
		contenuMessage.setFont(new Font("Serial", Font.BOLD, 50));
		this.add(contenuMessage);
	}
}
