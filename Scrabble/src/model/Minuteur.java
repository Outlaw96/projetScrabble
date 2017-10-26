package model;

public class Minuteur {
	private boolean start;
	private int minutes;
	private int secondes;

	public Minuteur(boolean start, int minutes, int secondes) {
		this.start = start;
		this.minutes = minutes;
		this.secondes = secondes;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSecondes() {
		return secondes;
	}

	public void setSecondes(int secondes) {
		this.secondes = secondes;
	}
}
