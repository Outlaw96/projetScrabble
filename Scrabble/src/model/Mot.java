package model;

import java.util.ArrayList;

public class Mot {
	private String libelle;
	private ArrayList<Pion> pions;
	
	public Mot(ArrayList<Pion> pions)
	{
		//détermination du libelle à partir de la liste de pions reçus en argument
		//et initialisation de l'attribut pions
		libelle = "";
		this.pions = new ArrayList<>();
		for(Pion p : pions)
		{
			libelle = libelle+""+p.getLetter();
			this.pions.add(p);
		}

	}

	public String getWord() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public ArrayList<Pion> getPions() {
		return pions;
	}

	public void setPions(ArrayList<Pion> pions) {
		this.pions = pions;
	}
	
	public void addPion(Pion p)
	{
		this.pions.add(p);
	}
	
	public Pion getPion(int indexPion)
	{
		return this.pions.get(indexPion);
	}
	
	/**
	 * getPoints()
	 * fonction qui renvoie le nombre de points d'un mot placé sur le scrabble.
	 * @return
	 */
	public int getPoints()
	{
		//initialisation du nombre de points à retourner
		int nbPointsMot = 0;
		int multiplicateurMot = 1;
		
		//Pour chaque pion se trouvant dans la liste des pions du mot, on calcule le nombre de points
		for(Pion p : this.pions )
		{
			int nbPointsPion = 0;
			
			//On vérifie le type de la case 
			switch (p.getCasee().getTypeCase()) 
			{
			
				//Si la lettre de ce pion compte "lettre double"
				case LD:
					nbPointsPion = p.getPoint() * 2;
				break;
				
				//Sinon si la lettre de ce pion compte "mot triple"
				case MT:
					nbPointsPion = p.getPoint();
					multiplicateurMot *= 3;
				break;
				
				//Si la lettre de ce pion compte "lettre tripple"
				case LT:
					nbPointsPion = p.getPoint() * 3;
				break;
				
				//Si le mot compte "double"
				case MD:
					multiplicateurMot *= 2;
					nbPointsPion = p.getPoint();
				break;
				
				//Si la lettre de ce pion compte pour "mot simple"
				default:
					nbPointsPion = p.getPoint();
				break;
			}
			
			//après des opérations spécifiques selon le type de la case qui héberge le mot,
			//on ajoute au nombre de points du mot celui du pion.
			nbPointsMot += nbPointsPion;
		}
		//avant de retourner, on multiplie le nombre de points du mot (On multiplie par 1 par défaut sinon 2 ou 3 pour respectivement les types de cases MD ou MT
		return nbPointsMot * multiplicateurMot;
	}
	
}
