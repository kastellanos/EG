package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import util.ShapeFactory;

public class Ellipse extends Fillable {

	private static class Factory extends ShapeFactory
	{
		protected ShapeIf create()
		{
			return new Ellipse();
		}
	}

	static
	{
		ShapeFactory.addFactory( Ellipse.class.getName(), 
				new Factory() );
	}

	@Override
	public void doPaint( Graphics2D g ) {
		
		Rectangle r = getBoundBox();

		g.drawOval( r.x, r.y, r.width, r.height );
	}
}
