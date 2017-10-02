package model;

import java.util.ArrayList;

public class Partie {
	private boolean isFinished;
	private boolean isDraw;
	private Joueur[] players;
	private Joueur currentPlayer;
	private int timer;
	private ArrayList<Pion> sacPions;
	private Plateau plateau;
	
	
	public Partie(boolean isFinished, boolean isDraw, Joueur[] players, Joueur currentPlayer, int timer,
			ArrayList<Pion> sacPions, Plateau plateau) {
		super();
		this.isFinished = isFinished;
		this.isDraw = isDraw;
		this.players = players;
		this.currentPlayer = currentPlayer;
		this.timer = timer;
		this.sacPions = sacPions;
		this.plateau = plateau;
	}
	
	public boolean isFinished() {
		return isFinished;
	}
	
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	
	public boolean isDraw() {
		return isDraw;
	}
	
	public void setDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}
	
	public Joueur[] getPlayers() {
		return players;
	}
	
	public void setPlayers(Joueur[] players) {
		this.players = players;
	}
	
	public Joueur getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Joueur currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	public ArrayList<Pion> getSacPions() {
		return sacPions;
	}
	
	public void setSacPions(ArrayList<Pion> sacPions) {
		this.sacPions = sacPions;
	}
	
	public Plateau getPlateau() {
		return plateau;
	}
	
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
}
