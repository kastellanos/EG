package view.tools;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.ShapeIf;
import controller.App;

public abstract class CreationTool extends Tool
{
	public abstract ShapeIf createObject( final Point ptPressed, final Point ptReleased );

	@Override // template method
	public void processMouseReleased( final Point ptPressed, final Point ptReleased )
	{
		ShapeIf shape = createObject( ptPressed, ptReleased );
		if ( shape != null )
		{
			App.getInstance().addShape( shape );
		}
	}
	
	
}
