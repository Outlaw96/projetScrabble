package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Dictionnaire extends JPanel{

	private JTextField searchField;
	private JButton submit;

	public Dictionnaire()
	{
		/*---------------------------------------------------
		 * Initialisation des paramètres du minuteur
		 * --------------------------------------------------
		 */
		this.setBackground(new Color(68, 114, 196));
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Dictionnaire",TitledBorder.CENTER, TitledBorder.TOP, new Font("Serial", Font.BOLD, 25)));
		this.searchField = new JTextField("Placer ici le mot à rechercher...");
		this.submit = new JButton("OK");
		this.submit.setBackground(new Color(169, 209, 142));
		this.updateContent("");
	}
	
	public void updateContent(String msg)
	{
		//contenuMessage.setFont(new Font("Serial", Font.BOLD, 40));
		JPanel tmp=new JPanel();
		tmp.setBackground(new Color(68, 114, 196));
		tmp.add(searchField);
		tmp.add(submit);
		this.add(new JLabel("Entrez le mot à vérifier l'existence : "),BorderLayout.NORTH);
		this.add(tmp, BorderLayout.CENTER);
		this.add(new JLabel(msg), BorderLayout.SOUTH);
	}
}
