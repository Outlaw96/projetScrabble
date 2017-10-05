package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe pour representer graphiquement une partie
 * 
 * @author nicolas
 *
 */
public class PartieView extends JFrame {
	private PlateauView plateauView;
	private JPanel fond;
	private JoueurView joueurView;

	public PartieView() {
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.plateauView = new PlateauView();
		this.joueurView = new JoueurView();

		fond = new JPanel();
		fond.setLayout(new BorderLayout());
		fond.add(plateauView, BorderLayout.CENTER);
		fond.add(joueurView, BorderLayout.SOUTH);

		this.getContentPane().add(fond);
		this.setVisible(true);
	}
}
