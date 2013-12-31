package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import util.ShapeFactory;

public class Rect extends Fillable {

	private static class Factory extends ShapeFactory
	{
		protected ShapeIf create()
		{
			return new Rect();
		}
	}

	static
	{
		ShapeFactory.addFactory( Rect.class.getName(), 
				new Factory() );
	}

	@Override
	public void doPaint( Graphics2D g ) {
		
		Rectangle r = getBoundBox();

		g.drawRect( r.x, r.y, r.width, r.height );
	}
}
