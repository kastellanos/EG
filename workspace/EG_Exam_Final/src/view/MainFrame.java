package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;

import controller.App;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame( String title ) {

		super( title );

		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setExtendedState( JFrame.MAXIMIZED_BOTH );

		canvas = new Canvas( );
		canvas.setBackground( Color.WHITE );

		JMenu jmEdit = new JMenu( "Edit" );
		toolsBar = new ToolsBar( );
		statusBar = new StatusBar( );
		jmEdit.add( new AbstractAction( "Group" ) {

			@Override
			public void actionPerformed( ActionEvent ae ) {

				App.getInstance( ).group( );
			}
		} );

		jmEdit.add( new AbstractAction( "Ungroup" ) {

			@Override
			public void actionPerformed( ActionEvent ae ) {

				App.getInstance( ).unGroup( );
			}
		} );

		JMenu jmTool = new JMenu( "Tool" );
		jmTool.add( new AbstractAction( "Line" ) {

			@Override
			public void actionPerformed( ActionEvent ae ) {

				App.getInstance( ).setActiveTool( Canvas.CREATE_LINE );
			}
		} );
		jmTool.add( new AbstractAction( "Rectangle" ) {

			@Override
			public void actionPerformed( ActionEvent ae ) {

				App.getInstance( ).setActiveTool( Canvas.CREATE_RECT );
			}
		} );
		jmTool.add( new AbstractAction( "Ellipse" ) {

			@Override
			public void actionPerformed( ActionEvent ae ) {

				App.getInstance( ).setActiveTool( Canvas.CREATE_ELLI );
			}
		} );
		jmTool.add( new AbstractAction( "Text" ) {

			@Override
			public void actionPerformed( ActionEvent ae ) {

				App.getInstance( ).setActiveTool( Canvas.CREATE_TEXT );
			}
		} );
		jmTool.add( new JSeparator( ) );
		jmTool.add( new AbstractAction( "Selection" ) {

			@Override
			public void actionPerformed( ActionEvent ae ) {

				App.getInstance( ).setActiveTool( Canvas.SELECTION );
			}
		} );
		menuBar = new JMenuBar( );
		menuBar.add( new JMenu( "File" ) );
		menuBar.add( jmEdit );
		menuBar.add( jmTool );
		menuBar.add( new JMenu( "Help" ) );

		add( menuBar , BorderLayout.NORTH );
		add( canvas , BorderLayout.CENTER );
		add( toolsBar , BorderLayout.EAST );
		add( statusBar , BorderLayout.SOUTH );
	}

	public void repaintCanvas( ) {

		canvas.repaint( );
	}

	public void setActiveTool( final int t ) {

		canvas.setActiveTool( t );
	}

	public Graphics2D getCanvasGraphics( ) {
		// TODO Auto-generated method stub
		return ( Graphics2D ) canvas.getGraphics( );
	}

	public Canvas getCanvas( ) {
		// TODO Auto-generated method stub
		return canvas;
	}

	private Canvas canvas;
	private JMenuBar menuBar;
	private ToolsBar toolsBar;
	private StatusBar statusBar;
}
