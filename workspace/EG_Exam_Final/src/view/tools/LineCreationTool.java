package view.tools;

import java.awt.Graphics2D;
import java.awt.Point;

import model.BoundBox;
import model.Line;
import model.ShapeIf;
import util.ShapeFactory;
import controller.App;

public class LineCreationTool extends CreationTool
{
	public ShapeIf createObject( final Point ptPressed, final Point ptReleased ) {
		
		ShapeIf shape = ShapeFactory.getShape( 
				Line.class.getName(),
				new BoundBox( ptPressed.x, ptPressed.y, ptReleased.x - ptPressed.x, ptReleased.y - ptPressed.y ),
				App.getInstance().getActiveColor() );
				
		return shape;
	}

	@Override
	public void drawDashedTool(Graphics2D g) {
		
		g.drawLine(ptPressed.x, ptPressed.y, ptDragged.x, ptDragged.y);
	}
}
