package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Graphic implements ShapeIf {

	protected abstract void doPaint( Graphics2D g );
	
	public ShapeIf init( final BoundBox bbox, final Color color ) {
		
		this.bbox = bbox;
		this.color = color;
		compositeShape = false;
		if ( needsNormalization() ) {
			
			bbox.normalize();
		}
		
		setSelected( true );
		
		return this;
	}
	
	// template method
	public void paint( final Graphics2D g ) {
		
		// 1. paint object
		doPaint( g );
		
		// 2. paint bound box
		if ( isSelected() )
		{
			drawBoundBox( g );
			drawControlPoints( g );
		}
	}
	
	protected void drawBoundBox( final Graphics2D g )
	{
		BoundBox r = new BoundBox( getBoundBox() );
		r.normalize();
		
		// 1. save active stroke
		Stroke stroke = g.getStroke();

		// 2. change active stroke to dashed
		g.setStroke( new BasicStroke(
			1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, DEF_DASHED_PATTERN, DEF_DASHED_SIZE ) );

		// 3. draw dashed rectangle
		g.drawRect( r.x, r.y, r.width, r.height );

		// 4. restore original stroke
		g.setStroke( stroke );
	}
	protected void drawControlPoints( final Graphics2D g )
	{
		BoundBox r = new BoundBox( getBoundBox() );
		r.paintControlPoints(g);
		r.normalize();
		
		
	}	
	@Override
	public void store() {

	}

	@Override
	public void load() {

	}
	
	protected BoundBox getBoundBox() {
		
		return bbox;
	}

	public void setBoundBox( final BoundBox bbox ) {
		
		this.bbox = bbox;
	}

	public Color getColor() {
		
		return new Color( color.getRed(), color.getGreen(), color.getBlue() );
	}

	public void setColor( final Color color ) {
		
		this.color = color;
	}

	public boolean isSelected() {
		
		return selected;
	}

	public void setSelected( boolean selected ) {
		
		this.selected = selected;
	}

	protected boolean needsNormalization() {
	
		return true;
	}

	public boolean select( final Point pt ) {

		setSelected( bbox.normalized().contains( pt ) );
		
		return selected;
	}

	public boolean select( final BoundBox bbox ) {

		setSelected( bbox.normalized().contains( bbox.normalized() ) );
		
		return selected;
	}
	public void add( Graphic g ) {
		elements.add( g );
		BoundBox compositeBox;
		if(!firstShape){
			compositeBox = getBoundBox( );
			BoundBox temp = g.getBoundBox( );
			leftTop = new Point( Math.min(temp.x,compositeBox.x) , Math.min(temp.y,compositeBox.y) );
			rightBttm = new Point( (int)Math.max( temp.getMaxX( ) , compositeBox.getMaxX( ) ) , (int)Math.max( temp.getMaxY( ) , compositeBox.getMaxY( ) ) );
			compositeBox.setBounds( leftTop.x , leftTop.y , rightBttm.x-leftTop.x , rightBttm.y-leftTop.y );
			
		}else{
			firstShape = false;
			leftTop = g.getBoundBox( ).getLocation( );
			compositeBox = new BoundBox( g.getBoundBox( ) );
		}
		
		
		setBoundBox( compositeBox );

	}
	public void remove( Graphic g ) {
		elements.remove( g );

	}
	
	public Iterator<Graphic> elementsIterator(){
		return elements.iterator( );
	}
	protected List< Graphic > elements = new ArrayList<>( );	
	private BoundBox bbox;
	private Color color;
	private boolean selected;
	protected boolean compositeShape;

	protected Point leftTop;
	protected Point rightBttm;
	protected boolean firstShape;
	public static final float[] DEF_DASHED_PATTERN = new float[] {
		1.0f, 3.0f
	};

	public static final float DEF_DASHED_SIZE = 1.0f;

	public boolean isComposite( ) {
		// TODO Auto-generated method stub
		return compositeShape;
	}
}
