package view.tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import view.Canvas;

import controller.App;

public abstract class Tool
{
	public Tool() {
		float[] dashPattern = {
				4.0f, 4.0f
		};

		m_dashStroke = new BasicStroke( 1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f );
	}
	public void mousePressed( final MouseEvent mePressed ) {
		
		this.mePressed = mePressed;
		ptPressed = mePressed.getPoint();
		ptDragged = ptPressed;
		App.getInstance().deselect();
	}
	
	public abstract void processMouseReleased( final Point mePressed, final Point meReleased );
	public void processMouseDragged( final MouseEvent me){
		Canvas canvas = App.getInstance().getCanvas();
		Graphics2D g2D = (Graphics2D) canvas.getGraphics();
		g2D.setColor(Color.BLACK);
		g2D.setXORMode(Color.WHITE);
		g2D.setStroke(m_dashStroke);
		
		drawDashedTool(g2D);
		ptDragged = me.getPoint();
		drawDashedTool(g2D);
	}
	// template method
	public void mouseReleased( final MouseEvent meReleased ) {
		
		this.meReleased = meReleased;
		
		processMouseReleased( mePressed.getPoint(), meReleased.getPoint() );
	}

	// TODO: set mouse pointer
	public void mouseMoved( final MouseEvent me ) {
		
		
	}

	public void mouseDragged( final MouseEvent me ){
		processMouseDragged(me);
	}
	
	// TODO: to be redefined in ZoomTool
	public void mouseWheeled( final MouseWheelEvent me ) {
		
		// placeholder: does nothing by default
	}
	
	//See the tool when we are dragging
	public abstract void drawDashedTool(Graphics2D g);
	
	protected MouseEvent meDragged;
	protected MouseEvent mePressed;
	protected MouseEvent meReleased;
	protected Point ptDragged;
	protected Point ptPressed;
	protected BasicStroke m_dashStroke;
}
