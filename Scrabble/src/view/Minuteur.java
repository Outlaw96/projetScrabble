package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Minuteur extends JPanel implements Runnable {
	private JLabel affichage;
	private String message;
	private int minutes;
	private int secondes;
	private boolean start;
	private Thread t;
	private Font font;

	public Minuteur(boolean start, int minutes) {
		/*---------------------------------------------------
		 * Initialisation des paramètres du minuteur
		 * --------------------------------------------------
		 */
		this.setBackground(new Color(84, 130, 53));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Minuteur",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Serial", Font.BOLD, 25)));
		// initialisation du minuteur
		this.start = start;
		this.minutes = minutes;
		this.secondes = 59;
		this.font = new Font("Courier new", Font.BOLD, 30);
		this.affichage = new JLabel(this.minutes + " " + this.secondes);
		this.affichage.setFont(font);
		this.add(affichage);
		t = new Thread(this);
		t.start();
	}

	public void run() {
		while (this.start == true) {
			try {
				Thread.sleep(1000);
				this.secondes--;
				if (this.secondes == -1) {
					this.secondes = 59;
					this.minutes--;
				}
				if (this.secondes == 0 && this.minutes == 0) {
					this.start = false;
				}
				message = this.minutes + " : " + this.secondes;
				this.affichage.setText(message);
				System.out.println(message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}
}
