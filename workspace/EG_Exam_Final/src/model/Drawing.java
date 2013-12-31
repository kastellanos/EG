package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;
import javax.swing.undo.UndoableEditSupport;



import util.ShapeFactory;

public class Drawing {

	public Drawing() {

		elements = new LinkedList<ShapeIf>(); 

		// initialize the undo/redo system
		m_undoManager = new UndoManager();
		m_undoSupport = new UndoableEditSupport();
		m_undoSupport.addUndoableEditListener( new UndoAdapter() );
		
		refreshUndoRedo();
	}

	private class UndoAdapter implements UndoableEditListener
	{
		public void undoableEditHappened( UndoableEditEvent evt )
		{
			UndoableEdit edit = evt.getEdit();
			m_undoManager.addEdit( edit );
			refreshUndoRedo();
		}
	}

	public void refreshUndoRedo() {

		// refresh undo

		// refresh redo
	}

	public boolean add( ShapeIf s ) {
		
		return elements.add( s );
	}
	
	public boolean remove( ShapeIf s ) {
		
		return elements.remove( s );
	}
	
	public int numElements() {
	
		return elements.size();
	}
	
	public void paint( Graphics g ) {
		
		Graphics2D gg = (Graphics2D)g;
		
		for ( ShapeIf shape : elements ) {
			
			shape.paint( gg );
			
		}
	}
	
	public void deselect() {
		
		for ( ShapeIf shape : elements ) {
			
			shape.setSelected( false );
		}
	}

	public int numSelected() {
		
		int n = 0;
		
		for ( ShapeIf shape : elements ) {
			
			if ( shape.isSelected() ) {
				
				n++;
			}
		}
		
		return n;
	}
	
	public boolean select( final Point pt ) {

		boolean selected = false;
		
		for ( int i = elements.size() - 1; i >= 0; i-- ) {
			
			ShapeIf shape = elements.get( i );
			
			if ( shape.select( pt ) ) {
				
				selected = true;
				break;
			}
		}
		
		return selected;
	}

	public boolean select( final BoundBox bbox ) {

		int n = 0;
		
		for ( ShapeIf shape : elements ) {
			
			if ( shape.select( bbox ) ) {
				
				n++;
			}
		}
		
		return (n > 0);
	}
	
	public void test() {
	
		BoundBox r1 = new BoundBox( 500, 50, -300, 400 );
		BoundBox r2 = new BoundBox( 500, 50, +300, -400 );
		Color c = Color.RED;
		
		add( ShapeFactory.getShape( Line.class.getName(), r1, c ) );
//		add( ShapeFactory.getShape( Rect.class.getName(), r2, c ) );
		add( ShapeFactory.getShape( Ellipse.class.getName(), r2, c ) );
		add( ShapeFactory.getShape( Text.class.getName(), r2, c ) );
		
		assert( 3 == numElements() );
	}
	public boolean selected( Point point ) {
		// TODO Auto-generated method stub
		boolean can = false;
		for(ShapeIf shape: elements){
			if(((Graphic)shape).isSelected( ) && ((Graphic)shape).getBoundBox( ).contains( point )){
				can = true;
				break;
			}
		}
		return can;
	}
	public void group( ) {
		GraphicComposite g = new GraphicComposite( );
		List<ShapeIf> auxList = new ArrayList<>( );
		for(ShapeIf shape: elements){
			if(shape.isSelected( )){
				//shape.setSelected( false );
				g.add( (Graphic)shape );
				auxList.add( shape );
				
			}
		}
		for(ShapeIf shape : auxList ){
			remove(shape);
		}
		g.setSelected( true );
		add( g );
	}
	public void unGroup( ) {
		ShapeIf temp;
		for(ShapeIf shape: elements){
			if(shape.isSelected( ) && ((Graphic)shape).isComposite()){
				temp = shape;
				for ( Iterator<Graphic> it = ((Graphic)shape).elementsIterator(); it.hasNext(); )
				{
					ShapeIf tempShape = it.next( );
					tempShape.setSelected( true );
					add( tempShape  );
				}
				remove( temp );
				break;
			}
		}
		
	}

	private List<ShapeIf> elements;

	/**
	 * undo system elements
	 */
	private UndoManager m_undoManager; // history list
	private UndoableEditSupport m_undoSupport; // event support



}








