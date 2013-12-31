package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface ShapeIf {

	void paint( Graphics2D g );
	
	void setSelected( boolean b );
	boolean isSelected();
	boolean select( final Point pt );
	boolean select( final BoundBox bbox );
	
	ShapeIf init( final BoundBox r, final Color c );
	
	void store();
	void load();
}
