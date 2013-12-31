package model;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GraphicComposite extends Graphic{
public GraphicComposite( ) {
	firstShape = true;
	compositeShape = true;
	
}
	//Composite
	@Override
	protected void doPaint( Graphics2D g ) {
		for(Graphic graph: elements){
			graph.doPaint( g );
			
		}
		
	}

}
