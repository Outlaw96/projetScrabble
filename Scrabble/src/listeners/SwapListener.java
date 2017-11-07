package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Case;
import view.SwapPionsIHM;

public class SwapListener implements MouseListener {
	private SwapPionsIHM swapIHM;
	private Case caseTMP;

	public SwapListener(SwapPionsIHM swapPionsIHM) {
		this.swapIHM = swapPionsIHM;
		this.caseTMP = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//System.out.println("clique détecté");
		// TODO Auto-generated method stub
		//System.out.println(e.getX()+" "+e.getY());
		//System.out.println((e.getX() >= 300 && e.getX() <= 420) && (e.getY() >= 275 && e.getY() <= 338));
		
		//s'il veut fermer la fenêtre
		if (e.getX() >= 300 && e.getX() <= 420 && e.getY() >= 275 && e.getY() <= 338) 
		{
			this.swapIHM.getParent().dispose();
		} 
		//Si il valide l'échange
		else if(e.getY() >= 308 && e.getY() <= 336 && e.getX() >= 104 && e.getX() < 221)
		{
			//on effectue les changements de pion
			this.swapIHM.echangerPion();
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

	public int getClickedIndex(int x)
	{
		int res = -1;
		System.out.println();
		if(x >= 34 && x <=81) 
		{
			res = 0;
		}
		
		else if(x >= 114 && x <=161)
		{
			res = 1;
		}
		
		else if(x >= 194 && x <= 240)
		{
			res = 2;
		}
		
		else if(x >= 274 && x <= 321)
		{
			res = 3;
		}
		
		else if(x >= 354 && x <= 401)
		{
			res = 4;
		}
		
		else if(x >= 434 && x <= 481)
		{
			res = 5;
		}
		
		else if(x >= 514 && x <=561)
		{
			res = 6;
		}
		
		return res;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getX()+" "+e.getY());
		//Si il clique pour échanger
		if (e.getY() >= 79 && e.getY() <= 130 && e.getX() >= 34 && e.getX() < 565) 
		{
			this.swapIHM.setIsDrawable(this.getClickedIndex(e.getX()), false);
			this.swapIHM.repaint();
		}
		//Si il clique pour annuler l'échange
		else if(e.getY() >= 216 && e.getY() <= 267 && e.getX() >= 34 && e.getX() < 565)
		{
			this.swapIHM.setIsDrawable(this.getClickedIndex(e.getX()), true);
			this.swapIHM.repaint();
		}

		//System.out.println("Y : "+e.getY()+", X = "+e.getX());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// un peu sale donc à redefinir aussi
		
	}
}