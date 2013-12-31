package model;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import util.ShapeFactory;

public class Text extends Graphic {

	private static class Factory extends ShapeFactory
	{
		protected ShapeIf create()
		{
			return new Text();
		}
	}

	static
	{
		ShapeFactory.addFactory( Text.class.getName(), 
				new Factory() );
	}

	@Override
	public void doPaint( Graphics2D g ) {

		Rectangle r = getBoundBox();

		g.drawString( value != null ? value : "", r.x, r.y );
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	private String value;
	private Font font;
}
