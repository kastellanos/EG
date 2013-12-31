package view.control_points;

import java.awt.Cursor;
import java.awt.Point;

import model.BoundBox;

public class ControlPointNorth extends ControlPoint{

	public ControlPointNorth( BoundBox owner) {
		super( owner , Cardinal.N );
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Point getPosition( ) {
		// TODO Auto-generated method stub
		return new Point( (int)owner.getCenterX( ),(int)owner.getMinY( ));
	}

	@Override
	protected Cursor getCursor( ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updateBoundBox( ) {
		// TODO Auto-generated method stub
		
	}

}
