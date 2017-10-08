package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Joueur;
import model.Pion;
import model.Plateau;
import view.PlateauView;

public class PlateauListener implements MouseListener {
	private PlateauView pv;
	private Joueur jr;
	private Plateau pl;
	private Pion pion;
	private int i, j, index;

	public PlateauListener(PlateauView pv, Plateau pl, Joueur jr) {
		this.pv = pv;
		this.pl = pl;
		this.jr = jr;
		this.i = -1;
		this.j = -1;
		this.index = -1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// un peu sale donc à redefinir
		if (e.getY() > 0 && e.getY() < 510) {
			int x = this.pv.getX(e.getY());
			int y = this.pv.getY(e.getX());
			if (x >= 0 && y >= 0) {
				if (pl.getCases()[x][y].isTaken()) {
					this.pion = pl.getCases()[x][y].getPion();
					this.i = x;
					this.j = y;
				}
			}
		} else if (e.getY() > 510 && e.getY() < 555) {
			int x = this.pv.getIndexChevalet(e.getX(), e.getY());
			if (x >= 0) {
				if (this.jr.getChevalet()[x].isTaken()) {
					this.pion = this.jr.getChevalet()[x].getPion();
					this.index = x;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// un peu sale donc à redefinir aussi
		if (e.getY() > 0 && e.getY() < 510) {
			int x = this.pv.getX(e.getY());
			int y = this.pv.getY(e.getX());
			if (!this.pl.getCases()[x][y].isTaken() && this.pion != null) {
				if (this.i >= 0 && this.j >= 0) {
					this.pl.getCases()[x][y].addPion(this.pion);
					this.pl.getCases()[i][j].removePion();
				} else if (this.index >= 0) {
					this.pl.getCases()[x][y].addPion(this.pion);
					this.jr.getChevalet()[this.index].removePion();
				}
			}
		} else if (e.getY() > 510 && e.getY() < 555) {
			int x = this.pv.getIndexChevalet(e.getX(), e.getY());
			if (x >= 0) {
				if (!this.jr.getChevalet()[x].isTaken()) {
					if (this.i >= 0 && this.j >= 0) {
						this.jr.getChevalet()[x].addPion(this.pion);
						this.pl.getCases()[i][j].removePion();
					} else if (this.index >= 0) {
						this.jr.getChevalet()[x].addPion(this.pion);
						this.jr.getChevalet()[this.index].removePion();
					}
				}
			}
		}
		this.i = -1;
		this.j = -1;
		this.index = -1;
		this.pion = null;
		this.pv.repaint();
	}
}
