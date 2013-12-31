package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import util.ShapeFactory;

public class Line extends Geometric {

	private static class Factory extends ShapeFactory
	{
		protected ShapeIf create()
		{
			return new Line();
		}
	}

	static
	{
		ShapeFactory.addFactory( Line.class.getName(), new Factory() );
	}

	@Override
	protected boolean needsNormalization() {
	
		return false;
	}

	@Override
	public void doPaint( final Graphics2D g ) {
		
		Rectangle r = getBoundBox();

		g.drawLine( r.x, r.y, r.x + r.width, r.y + r.height );
	}
}
