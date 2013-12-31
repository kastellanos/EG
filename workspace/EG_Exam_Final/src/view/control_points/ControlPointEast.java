package view.control_points;

import java.awt.Cursor;
import java.awt.Point;

import model.BoundBox;

public class ControlPointEast extends ControlPoint{

	public ControlPointEast( BoundBox owner) {
		super( owner , Cardinal.E );
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */


	@Override
	protected Point getPosition( ) {
		return new Point( (int)owner.getMaxX( ),(int)owner.getCenterY( ));
	}

	@Override
	protected Cursor getCursor( ) {
		return Cursor.getPredefinedCursor( Cursor.E_RESIZE_CURSOR );
	}

	@Override
	protected void updateBoundBox( ) {
		// TODO Auto-generated method stub
		
	}
	private static final long serialVersionUID = 1L;
}
