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
		 * normalement, ces instructions suffisent pour cr�er une fenetre avec swing par exemple. Je veux ilustrer un exemple de cycle vues -> controller -> modele 
		 * ensuite le cycle de retour sera modele -> controleur -> vue .
		 * Supposons que l'utilisateur a d�clench� un �v�nement qui se comporte comme suit :
		 */
		//on recup�re le mot � rechercher par exemple
		this.motARechercher = "test123"; //l'�quivalent de unObjetTextField.getTexte() dans un add listener par exemple
		
		//ensuite pour informer le controlleur de cette nouvelle op�ration � executer, on proc�de comme suit :
		message = "rechercher"; //on dit au controleur que la prochaine op�ration c'est rechercher
		this.isAvalaible = false; //pour �viter que l'utilisateur n'ecrase le contenu du message(laction � executer en cours)
		
	}
	
	//m�thode que le controleur pourra appeller pour traiter une action (un message)
	
	public void afficheDefinition(String definition)
	{
		if(definition.isEmpty())
		{
			//on affiche selon les m�thodes du JFrame que le mot est vide
		}
		else
		{
			//on affiche la d�finition du mot.
			JOptionPane.showMessageDialog(this, this.motARechercher+" : "+definition, " "+this.motARechercher, JOptionPane.INFORMATION_MESSAGE, null);	
		}
		
	}
	
	/**
	 * m�thode qui lib�re l'occupation de la fenetre et �coute de nouvelles t�ches � executer
	 */
	public void cleanAction()
	{
		this.message = "";
		isAvalaible = true; // on lib�re l'occupation
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
