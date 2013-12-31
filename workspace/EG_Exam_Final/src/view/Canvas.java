package view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

import view.tools.EllipseCreationTool;
import view.tools.LineCreationTool;
import view.tools.RectangleCreationTool;
import view.tools.SelectionTool;
import view.tools.TextCreationTool;
import view.tools.Tool;
import controller.App;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L;

	public Canvas() {
		
		createTools();
		registerMouseListeners();
	}

	private void createTools() {
		
		tools = new Tool[ NUM_TOOLS ];
		tools[ CREATE_LINE ] = new LineCreationTool();
		tools[ CREATE_RECT ] = new RectangleCreationTool();
		tools[ CREATE_ELLI ] = new EllipseCreationTool();
		tools[ CREATE_TEXT ] = new TextCreationTool();
		tools[ SELECTION ] = new SelectionTool();

		activeTool = tools[ DEFAULT_TOOL ];
	}

	// state/adapter
	private void registerMouseListeners() {

		addMouseListener( new MouseAdapter() {
			
			@Override
			public void mousePressed( final MouseEvent me ) {

				activeTool.mousePressed( me );
			}
			
			@Override
			public void mouseReleased( final MouseEvent me ) {

				activeTool.mouseReleased( me );
			}
		});

		addMouseMotionListener( new MouseAdapter() {
			
			@Override
			public void mouseDragged( final MouseEvent me ) {
				//System.out.println("out");
				activeTool.mouseDragged( me );
			}
			
			@Override
			public void mouseMoved( final MouseEvent me ) {

				activeTool.mouseMoved( me );
			}
		});

		addMouseWheelListener( new MouseAdapter() {
			
			@Override
			public void mouseWheelMoved( final MouseWheelEvent me ) {

				activeTool.mouseWheeled( me );
			}
		});
	}

	public void setActiveTool( final int t ) {
	
		if ( 0 <= t && t < tools.length ) {
		
			activeTool = tools[ t ];
		}
	}

	public void paint( final Graphics g ) {

		  super.paint( g );
		   
		  App.getInstance().paint( g ); 
	}

	private Tool[] tools;
	public static final int CREATE_LINE = 0;
	public static final int CREATE_RECT = 1;
	public static final int CREATE_ELLI = 2;
	public static final int CREATE_TEXT = 3;
	public static final int SELECTION = 4;
	public static final int NUM_TOOLS = 5;
	
	private Tool activeTool;

	public static final int DEFAULT_TOOL = CREATE_LINE;
}
