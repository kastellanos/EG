package view.tools;

import java.awt.Graphics2D;
import java.awt.Point;

import util.ShapeFactory;
import controller.App;

import model.BoundBox;
import model.Ellipse;

import model.ShapeIf;

public class EllipseCreationTool extends CreationTool{

	@Override
	public ShapeIf createObject(Point ptPressed, Point ptReleased) {
		ShapeIf shape = ShapeFactory.getShape( 
				Ellipse.class.getName(),
				new BoundBox( ptPressed.x, ptPressed.y, ptReleased.x - ptPressed.x, ptReleased.y - ptPressed.y ),
				App.getInstance().getActiveColor() );
		return shape;
	}

	@Override
	public void drawDashedTool(Graphics2D g) {
		g.drawOval(ptPressed.x, ptPressed.y, ptDragged.x-ptPressed.x, ptDragged.y-ptPressed.y);		
	}

}
