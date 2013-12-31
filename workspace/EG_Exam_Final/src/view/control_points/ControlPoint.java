package view.control_points;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

import model.BoundBox;


public abstract class ControlPoint implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected abstract Point getPosition();
	protected abstract Cursor getCursor();
	protected abstract void updateBoundBox();
	
	public static enum Cardinal {
		N, NE, E, SE, S, SW, W, NW
	}

	public ControlPoint(BoundBox owner, Cardinal cardinal) {
		super();
		this.owner = owner;
		this.cardinal = cardinal;

		pt = getPosition();
	}

	public void paint(Graphics2D g) {

		g.setColor(COLOR);
		g.fillRect(pt.x - SIZE + 1, pt.y - SIZE + 1, 2 * SIZE, 2 * SIZE);
	}

	public void move( int dx, int dy ) {
		
		move( dx, dy, false );
	}

	public void move( int dx, int dy, boolean updateBoundBox ) {
	
		pt.x += dx;
		pt.y += dy;
		
		if (updateBoundBox) {
			
			updateBoundBox();
		}
	}
	
	public String toString() {
	
		return ("c=" + cardinal + ", pt=" + pt);
	}
	
	// cyclic graph: JVM knows how to handle them
	protected BoundBox owner;
	protected Cardinal cardinal;
	protected Point pt;

	public static final int SIZE = 4;
	public static final Color COLOR = Color.GRAY;
}
