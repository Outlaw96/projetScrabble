package model;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import erreurs.UnknownWord;

@SuppressWarnings("serial")
public class Dictionnaire extends JPanel {
	public ArrayList<String> dictionnaire;

	public Dictionnaire() {
		this.dictionnaire = new ArrayList<>();
		initDictionnaire();
	}

	public void initDictionnaire() {
		File fichier = new File("src/script/francais.dic.txt");
		try {
			Scanner lecteurDictionnaire = new Scanner(fichier);
			while (lecteurDictionnaire.hasNextLine()) {
				String mot = lecteurDictionnaire.nextLine();
				dictionnaire.add(mot);
			}
			lecteurDictionnaire.close();
		} catch (Exception e) {
			System.err.println("problème ouverture fichier!");
		}
	}

	// pour vérifier si un mot existe ou pas
	public boolean exists(Mot word) {
		boolean exist = false;
		String mot = word.getWord();
		for (String m : dictionnaire) {
			if (m.equalsIgnoreCase(mot)) {
				exist = true;
			}
		}
		return exist;
	}
}
