package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.BoundBox;
import model.Drawing;
import model.ShapeIf;

import view.Canvas;
import view.MainFrame;

public class App {

	private static App instance;
	private Drawing model;
	private MainFrame view;
	private Color activeColor = Color.BLACK;

	private App( ) {

		// 1. create the model
		model = new Drawing( );

		// 2. create the view
		view = new MainFrame( "Editor Gr�fico v0.6" );
	}

	private void run( ) {

		// 3. display the view
		view.setBounds( 100 , 100 , 600 , 400 );
		view.setVisible( true );

		// model.test();
	}

	public void paint( Graphics g ) {

		model.paint( g );
	}

	public void repaint( ) {

		view.repaintCanvas( );
	}

	public void deselect( ) {

		model.deselect( );
		repaint( );
	}

	public void select( final Point pt ) {

		if ( model.select( pt ) ) {

			repaint( );
		}
	}

	public void select( final BoundBox bbox ) {

		if ( model.select( bbox ) ) {

			repaint( );
		}
	}

	public void addShape( final ShapeIf shape ) {

		model.add( shape );
		repaint( );
	}

	// TODO: let the user select active color
	public Color getActiveColor( ) {

		return new Color( activeColor.getRed( ) , activeColor.getGreen( ) ,
				activeColor.getBlue( ) );
	}

	public void setActiveTool( final int t ) {

		view.setActiveTool( t );
	}

	// TODO: pattern?
	public void group( ) {
		model.group();
		repaint( );
	}

	// TODO: pattern?
	public void unGroup( ) {
		model.unGroup();
		repaint( );
	}

	// singleton
	public synchronized static App getInstance( ) {

		if ( instance == null ) {

			instance = new App( );
		}

		return instance;
	}

	public void newDocument( ) {

		// TODO
	}

	private void doSave( String path ) {

		ObjectOutputStream oos = null;

		try {

			oos = new ObjectOutputStream( new FileOutputStream( path ) );
			oos.writeObject( model );
		} catch ( Exception exc ) {

			// TODO
			System.err.println( exc );
		} finally {
			try {
				oos.close( );
			} catch ( IOException exc ) {
			}
		}
	}

	public void saveDocument( ) {

		// TODO
		doSave( TEST_FN );
	}

	public void saveAsDocument( ) {

		// TODO
		doSave( TEST_FN );
	}

	public void openDocument( ) {

		ObjectInputStream ois = null;

		try {

			ois = new ObjectInputStream( new FileInputStream( TEST_FN ) );
			model = ( Drawing ) ois.readObject( );
			repaint( );
		} catch ( Exception exc ) {

			// TODO
			System.err.println( exc );
		} finally {

			try {
				ois.close( );
			} catch ( IOException exc ) {
			}
		}
	}

	public static void main( String[ ] args ) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		final App app = getInstance( );
		UIManager.getInstalledLookAndFeels( );
		UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName( ) );
		// final JFontChooser fontChooser = new JFontChooser();

		SwingUtilities.invokeLater( new Runnable( ) {

			@Override
			public void run( ) {

				app.run( );
			}
		} );

	}

	public Graphics2D getCanvasGraphics( ) {
		// TODO Auto-generated method stub
		return view.getCanvasGraphics( );
	}

	public Canvas getCanvas( ) {
		// TODO Auto-generated method stub
		return view.getCanvas( );
	}

	public static final String TEST_FN = System.getProperty( "user.home" )
			+ File.separatorChar + "test.gef";

	public boolean selected( Point point ) {
		// TODO Auto-generated method stub
		return model.selected( point );
	}
}
