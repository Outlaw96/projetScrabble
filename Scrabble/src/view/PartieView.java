package view;

import javax.swing.JFrame;

/**
 * Classe pour representer graphiquement une partie
 * 
 * @author nicolas
 *
 */
public class PartieView extends JFrame {
	private PlateauView plateauView;

	public PartieView() {
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.plateauView = new PlateauView();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(plateauView);
		this.setVisible(true);
	}
}
