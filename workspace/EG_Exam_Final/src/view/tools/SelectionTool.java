package view.tools;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import model.BoundBox;
import controller.App;

public class SelectionTool extends Tool {
	@Override
	public void processMouseReleased( final Point ptPressed,
			final Point ptReleased ) {

		if ( ptReleased.x == ptPressed.x || ptReleased.y == ptPressed.y ) {

			App.getInstance( ).select( ptPressed );
		} else {

			BoundBox bbox = new BoundBox( ptPressed.x , ptPressed.y ,
					ptReleased.x - ptPressed.x , ptReleased.y - ptPressed.y );

			App.getInstance( ).select( bbox );
		}
	}

	// TODO: show feedback (dashed bounding box)
	public void mouseDragged( final MouseEvent me ) {

	}

	@Override
	public void drawDashedTool( Graphics2D g ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved( MouseEvent me ) {
		if ( App.getInstance( ).selected( me.getPoint( ) ) )
			App.getInstance( )
					.getCanvas( )
					.setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
		else
			App.getInstance( )
			.getCanvas( )
			.setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR) );
	}
}
