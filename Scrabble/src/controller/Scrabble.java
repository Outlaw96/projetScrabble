package controller;

//importation de toutes les classes du model
import model.*;

//On fait pareille pour les vues
import view.AccueilExample;

/**
 * Class Scrabble
 * @author Anonymous
 * Cette classe situ�e dans le package controller, joue le r�le d'interm�diaire entre notre logique m�tier (manipulation des donn�es, utilisation bdd)
 * et notre vue. 
 */
public class Scrabble {
	
	private static Partie partie;
	
	public void rechercherMot(String motARechercher, AccueilExample vue)
	{
		//j'instancie la partie du modele qu'il faut
		//ensuite je lui donne le mot � recherche
		//je stocke le resultat dans une variable : supposons 
		String resultat = "est une d�finition inconnue pour le moment mais �a viendra!";
		
		//je renvoie ce resultat � la vue pour qu'elle puisse l'afficher
		vue.afficheDefinition(resultat);
	}
	
	//m�thode qui g�re quel m�thode du controleur execut� pour une demande de la vue
	public void process(AccueilExample vue)
	{
		//Si la vue contient une t�che � executer,
		if(!(vue.getMessage().isEmpty()))
		{
			switch(vue.getMessage())
			{
				//Si l'op�ration c'est la recherche de mot
				case "rechercher":
					rechercherMot(vue.getMotARechercher(), vue);
				break;
				default:
					System.out.println("/!\\ RAS");
				break;
			}
			
		}
		//ensuite on met le controleur en �coute � nouveau gr�ce � la recursivit�
		process(vue);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/** Exemple d'utilisation de notre contr�leur : 
		 * Supposons qu'on veuille afficher le nombre de points d'un mots.
		 * on va stocker dans un arrayList temporaire de pion, l'ensemble des pions renvoy�s par la vue (lorsque l'utilisateur effectue des clics)
		 * on va ensuite instancier un objet Mot et faire toutes les op�rations qu'il faut grace � ses m�thodes (notamment getPoints() pour savoir le nombre de points du mot
		 * ce nombre de points sera r�cup�rer dans une variable int qu'on donnera en argument � une m�thode d'une classe de la vue
		 * qui se chargera d'effectuer la maj dans l'interface
		 */
		
		
		/**
		 * Exemple
		 */
		AccueilExample maVue = new AccueilExample(); 
		
		//ensuite on met le controleur � l'�coute de la vue
		
	}

}
