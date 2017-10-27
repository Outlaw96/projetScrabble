package model;

import java.io.File;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dictionnaire extends JPanel {

	public Dictionnaire() {
		this.display();
	}

	public void display() {
		JLabel label = new JLabel("Entrez le mot à rechercher dans le dictionnaire : ");
		JTextField textField = new JTextField();

		Object[] formulaire = new Object[] { label, textField };

		int reponse = JOptionPane.showOptionDialog(this, formulaire, "Scrabble Game Projet - Dictionary",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new javax.swing.ImageIcon("search.png"),
				null, null);

		// si l'utilisateur tape sur le bouton OK du formulaire
		if (reponse == JOptionPane.OK_OPTION) {
			String mot = textField.getText();
			// Si le champ est vide,
			if (mot.isEmpty()) {
				JOptionPane.showMessageDialog(this,
						"Aucun mot saisi! Veuillez remplir le champ avant de procéder à la recherche.",
						"Erreur de recherche", JOptionPane.ERROR_MESSAGE);

				// ensuite on rappelle cette fonction
				this.display();
			}
			// Sinon on cherche le mot dans le dico
			else {
				// System.out.println(System.getProperty("user.dir"));

				// le dictionnaire se situe en l'emplacement /src/script/francais.dic.txt
				File fichier = new File("src/script/francais.dic.txt");

				try {
					Scanner lecteurDictionnaire = new Scanner(fichier);
					boolean isFound = false;
					while (lecteurDictionnaire.hasNextLine()) {
						// si il trouve le mot
						if (mot.equalsIgnoreCase(lecteurDictionnaire.nextLine())) {
							isFound = true;
							JOptionPane.showMessageDialog(this,
									"Le mot " + mot + " existe dans le dictionnaire français.", "Mot trouvé",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					if (!isFound) {
						JOptionPane.showMessageDialog(this,
								"Le mot " + mot + " n'existe pas dans le dictionnaire français.", "Mot non trouvé",
								JOptionPane.ERROR_MESSAGE);
					}

					lecteurDictionnaire.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, e.getMessage() + ". Contacter l'administrateur",
							"Erreur de recherche", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		// Sinon tantpis
	}
}
