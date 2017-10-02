package model;

import java.util.ArrayList;

public class Plateau {

	private int size;
	private ArrayList<Mot> mots;
	private Case[][] cases;
	
	public Plateau(int size)
	{
		this.size = size;
		this.cases = new Case[size][size];
		
		int i,j;
		
		for(i=0; i<size; i++)
		{
			for(j=0; j<size; j++)
			{
				this.cases[i][j] = new Case();
			}
			
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Mot> getMots() {
		return mots;
	}

	public void setMots(ArrayList<Mot> mots) {
		this.mots = mots;
	}

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}
	
	public void addCase(Case c)
	{
		
	}
}
