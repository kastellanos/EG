package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolsBar extends JPanel{
	private JButton lineBttn, textBttn, rectBttn, ellipBttn, undoBttn,redoBttn, selectBttn, resizeBttn, eraseBttn;
	private ToolBttnListener tbL;
	public ToolsBar() {
		lineBttn = new JButton("", new ImageIcon("resources/line.png"));
		rectBttn = new JButton("", new ImageIcon("resources/rectangle.png"));
		ellipBttn = new JButton("", new ImageIcon("resources/ellipse.png"));
		undoBttn = new JButton("", new ImageIcon("resources/undo.png"));
		redoBttn = new JButton("", new ImageIcon("resources/redo.png"));
		selectBttn = new JButton("", new ImageIcon("resources/select.png"));
		resizeBttn = new JButton("", new ImageIcon("resources/resize.png"));
		eraseBttn = new JButton("", new ImageIcon("resources/eraser.png"));
		textBttn = new JButton( "", new ImageIcon("resources/text.png" ));
		tbL = new ToolBttnListener();
		
		lineBttn.addActionListener(tbL);
		lineBttn.setToolTipText("Dibujar línea");
		rectBttn.addActionListener(tbL);
		rectBttn.setToolTipText("Dibujar Rectángulo");
		ellipBttn.addActionListener(tbL);
		ellipBttn.setToolTipText("Dibujar Elipse");
		textBttn.addActionListener( tbL );
		textBttn.setToolTipText( "Dibujar Texto" );
		undoBttn.addActionListener(tbL);
		undoBttn.setToolTipText("Deshacer");
		redoBttn.addActionListener(tbL);
		redoBttn.setToolTipText("Rehacer");
		selectBttn.addActionListener(tbL);
		selectBttn.setToolTipText("Seleccionar");
		resizeBttn.addActionListener(tbL);
		resizeBttn.setToolTipText("Redimensionar");
		eraseBttn.addActionListener(tbL);
		eraseBttn.setToolTipText("Borrar");
		
		
		this.setLayout( new GridLayout(9,1));
		JPanel undoRedoPanel = new JPanel( );
		undoRedoPanel.setLayout( new GridLayout( 1, 2 ) );
		undoRedoPanel.add(undoBttn);
		undoRedoPanel.add(redoBttn);
		add(lineBttn);
		add(rectBttn);
		add(ellipBttn);
		add( textBttn );
		add(undoRedoPanel);
		add(selectBttn);
		add(resizeBttn);
		add(eraseBttn);
		
	}
	private class ToolBttnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	} 
}
