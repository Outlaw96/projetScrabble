package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AccueilExample extends JFrame{

	/* variables obligatoires pour le traitement
	 * 
	 */
	private String message;
	private boolean isAvalaible;
	private String motARechercher;
	
	//fin variable obligatoires
	
	public AccueilExample()
	{
		//initialisation des variables obligatoires pour la communication avec le controleur
		message="";
		isAvalaible = true;
		
		
		motARechercher = "";
		this.setTitle("Ma page d'accueil");
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setLocationRelativeTo(null);
		this.setSize(800, 500);
		this.setVisible(true);
		
		/**
		 * normalement, ces instructions suffisent pour créer une fenetre avec swing par exemple. Je veux ilustrer un exemple de cycle vues -> controller -> modele 
		 * ensuite le cycle de retour sera modele -> controleur -> vue .
		 * Supposons que l'utilisateur a déclenché un évènement qui se comporte comme suit :
		 */
		//on recupère le mot à rechercher par exemple
		this.motARechercher = "test123"; //l'équivalent de unObjetTextField.getTexte() dans un add listener par exemple
		
		//ensuite pour informer le controlleur de cette nouvelle opération à executer, on procède comme suit :
		message = "rechercher"; //on dit au controleur que la prochaine opération c'est rechercher
		this.isAvalaible = false; //pour éviter que l'utilisateur n'ecrase le contenu du message(laction à executer en cours)
		
	}
	
	//méthode que le controleur pourra appeller pour traiter une action (un message)
	
	public void afficheDefinition(String definition)
	{
		if(definition.isEmpty())
		{
			//on affiche selon les méthodes du JFrame que le mot est vide
		}
		else
		{
			//on affiche la définition du mot.
			JOptionPane.showMessageDialog(this, this.motARechercher+" : "+definition, " "+this.motARechercher, JOptionPane.INFORMATION_MESSAGE, null);	
		}
		
	}
	
	/**
	 * méthode qui libère l'occupation de la fenetre et écoute de nouvelles tâches à executer
	 */
	public void cleanAction()
	{
		this.message = "";
		isAvalaible = true; // on libère l'occupation
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isAvalaible() {
		return isAvalaible;
	}

	public void setAvalaible(boolean isAvalaible) {
		this.isAvalaible = isAvalaible;
	}

	public String getMotARechercher() {
		return motARechercher;
	}

	public void setMotARechercher(String motARechercher) {
		this.motARechercher = motARechercher;
	}
	
	
}
