package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import erreurs.NotFullWarning;
import erreurs.NotStarted;
import model.Dictionnaire;
import model.Joueur;
import model.Partie;
import model.Pion;
import model.Plateau;
import view.PlateauView;
import view.SearchView;
import view.SwapPions;

public class PlateauListener implements MouseListener {
	private PlateauView pv;
	private Joueur jr;
	private Plateau pl;
	private Pion pion;
	private Partie partie;
	private int i, j, index;

	public PlateauListener(PlateauView pv, Plateau pl, Joueur jr, Partie partie) {
		this.pv = pv;
		this.partie = partie;
		this.pl = pl;
		this.jr = jr;
		this.i = -1;
		this.j = -1;
		this.index = -1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!partie.getSacPions().isEmpty()) {
			if (this.pv.isSkiping(e.getX(), e.getY())) {
				System.out.println("skip");
			} else if (this.pv.isSwapping(e.getX(), e.getY())) {
				if (jr.isFull()) {
					new SwapPions(jr.getChevalet(), pv);
				} else {
					new NotFullWarning();
				}
			} else if (this.pv.isMixing(e.getX(), e.getY())) {
				if (this.jr.isFull()) {
					System.out.println("mix");
					this.jr.mix();
					this.jr.showChevalet();
					this.pv.repaint();
				} else {
					new NotFullWarning();
				}
			} else if (this.pv.isRetrieving(e.getX(), e.getY())) {
				System.out.println("retrieve");
				this.pv.retrieve();
				this.jr.showChevalet();
				// this.pl.removeLastWord();
				this.pv.repaint();
			} else if (this.pv.isPlaying(e.getX(), e.getY())) {
				if (pl.hasStarted()) {
					this.pl.playWord(jr);
					this.jr.showChevalet();
					System.out.println("play");
				} else {
					new NotStarted();
				}
			} else if (this.pv.isSearching(e.getX(), e.getY())) {
				new SearchView().display();
			}
		}
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
		if (e.getY() > 0 && e.getY() < 510 && e.getX() > 50 && e.getX() < 500) {
			int x = this.pv.getX(e.getY());
			int y = this.pv.getY(e.getX());
			if (x >= 0 && y >= 0) {
				if (pl.getCases()[x][y].isTaken() && !pl.getCases()[x][y].getPion().isFixed()) {
					this.pion = pl.getCases()[x][y].getPion();
					this.i = x;
					this.j = y;
				}
			}
		} else if (e.getY() > 510 && e.getY() < 555 && e.getX() > 50 && e.getX() < 260) {
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
		if (e.getY() > 0 && e.getY() < 510 && e.getX() > 50 && e.getX() < 500) {
			int x = this.pv.getX(e.getY());
			int y = this.pv.getY(e.getX());
			if (!this.pl.getCases()[x][y].isTaken() && this.pion != null) {
				if (this.i >= 0 && this.j >= 0) {
					this.pl.addPion(x, y, this.pion);
					this.pl.removePion(i, j);
				} else if (this.index >= 0) {
					this.pl.addPion(x, y, this.pion);
					this.jr.removePion(this.index);
				}
			}
		} else if (e.getY() > 510 && e.getY() < 555 && e.getX() > 50 && e.getX() < 260) {
			int x = this.pv.getIndexChevalet(e.getX(), e.getY());
			if (x >= 0) {
				if (!this.jr.getChevalet()[x].isTaken()) {
					if (this.i >= 0 && this.j >= 0) {
						this.jr.addPion(x, this.pion);
						this.pl.removePion(i, j);
					} else if (this.index >= 0) {
						this.jr.addPion(x, this.pion);
						this.jr.removePion(this.index);
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