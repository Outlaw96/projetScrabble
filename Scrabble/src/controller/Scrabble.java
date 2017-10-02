package controller;

//importation de toutes les classes du model
import model.*;

//On fait pareille pour les vues
import view.AccueilExample;

/**
 * Class Scrabble
 * @author Anonymous
 * Cette classe située dans le package controller, joue le rôle d'intermédiaire entre notre logique métier (manipulation des données, utilisation bdd)
 * et notre vue. 
 */
public class Scrabble {
	
	private static Partie partie;
	
	public void rechercherMot(String motARechercher, AccueilExample vue)
	{
		//j'instancie la partie du modele qu'il faut
		//ensuite je lui donne le mot à recherche
		//je stocke le resultat dans une variable : supposons 
		String resultat = "est une définition inconnue pour le moment mais ça viendra!";
		
		//je renvoie ce resultat à la vue pour qu'elle puisse l'afficher
		vue.afficheDefinition(resultat);
	}
	
	//méthode qui gère quel méthode du controleur executé pour une demande de la vue
	public void process(AccueilExample vue)
	{
		//Si la vue contient une tâche à executer,
		if(!(vue.getMessage().isEmpty()))
		{
			switch(vue.getMessage())
			{
				//Si l'opération c'est la recherche de mot
				case "rechercher":
					rechercherMot(vue.getMotARechercher(), vue);
				break;
				default:
					System.out.println("/!\\ RAS");
				break;
			}
			
		}
		//ensuite on met le controleur en écoute à nouveau grâce à la recursivité
		process(vue);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/** Exemple d'utilisation de notre contrôleur : 
		 * Supposons qu'on veuille afficher le nombre de points d'un mots.
		 * on va stocker dans un arrayList temporaire de pion, l'ensemble des pions renvoyés par la vue (lorsque l'utilisateur effectue des clics)
		 * on va ensuite instancier un objet Mot et faire toutes les opérations qu'il faut grace à ses méthodes (notamment getPoints() pour savoir le nombre de points du mot
		 * ce nombre de points sera récupérer dans une variable int qu'on donnera en argument à une méthode d'une classe de la vue
		 * qui se chargera d'effectuer la maj dans l'interface
		 */
		
		
		/**
		 * Exemple
		 */
		AccueilExample maVue = new AccueilExample(); 
		
		//ensuite on met le controleur à l'écoute de la vue
		
	}

}
