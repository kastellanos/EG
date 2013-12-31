package view.control_points;

import java.awt.Cursor;
import java.awt.Point;

import model.BoundBox;
import view.control_points.ControlPoint.Cardinal;

public class ControlPointSouthEast extends ControlPoint{

	public ControlPointSouthEast( BoundBox owner ) {
		super( owner , Cardinal.SE );
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Point getPosition( ) {
		// TODO Auto-generated method stub
		return new Point( (int)owner.getMaxX( ), (int)owner.getMaxY( ));
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
