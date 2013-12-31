package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import view.control_points.ControlPoint;
import view.control_points.ControlPointEast;
import view.control_points.ControlPointNorth;
import view.control_points.ControlPointNorthEast;
import view.control_points.ControlPointNorthWest;
import view.control_points.ControlPointSouth;
import view.control_points.ControlPointSouthEast;
import view.control_points.ControlPointSouthWest;
import view.control_points.ControlPointWest;

public class BoundBox extends Rectangle {

	private static final long serialVersionUID = 1L;

	public BoundBox( int x, int y, int w, int h ) {
	
		super( x, y, w, h );
		//System.out.println("1");
	}

	public BoundBox( final BoundBox bbox ) {
		
		this( bbox.x, bbox.y, bbox.width, bbox.height );
		buildControlPoints( );
		//System.out.println("2");
	}

	public BoundBox normalize() {
		
		if ( x > x + width ) {
			
			x = x + width;
			width = -width;
		}
		
		if ( y > y + height ) {
			
			y = y + height;
			height = -height;
		}
		
		return this;
	}

	public BoundBox normalized() {
		
		return new BoundBox( this ).normalize();
	}
	public void paintControlPoints( Graphics2D g ) {
		for(ControlPoint cp : controlpts)
			cp.paint( g );
		
	}	
	private void buildControlPoints() {

		controlpts = new ControlPoint[NUM_CONTROLPTS];
		controlpts[ControlPoint.Cardinal.E.ordinal()] = new ControlPointEast(this);
		
		controlpts[ControlPoint.Cardinal.N.ordinal()] = new ControlPointNorth(this);
		controlpts[ControlPoint.Cardinal.NE.ordinal()] = new ControlPointNorthEast(this);
		
		controlpts[ControlPoint.Cardinal.SE.ordinal()] = new ControlPointSouthEast(this);
		controlpts[ControlPoint.Cardinal.S.ordinal()] = new ControlPointSouth(this);
		controlpts[ControlPoint.Cardinal.SW.ordinal()] = new ControlPointSouthWest(this);
		controlpts[ControlPoint.Cardinal.W.ordinal()] = new ControlPointWest(this);
		controlpts[ControlPoint.Cardinal.NW.ordinal()] = new ControlPointNorthWest(this);
		
	}
	private ControlPoint[] controlpts;
	public static final int NUM_CONTROLPTS = 8;


}
