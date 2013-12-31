package util;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import model.BoundBox;
import model.ShapeIf;

public abstract class ShapeFactory
{
	// factory method
	protected abstract ShapeIf create();

	private static Map<String, ShapeFactory> factories = new HashMap<String, ShapeFactory>();

	public static void addFactory( final String id, final ShapeFactory sf )
	{
		assert id != null;
		assert sf != null;
		
		factories.put( id, sf );
	}

	public static final ShapeIf getShape( 
			final String id, final BoundBox r, final Color c )
	{
		assert id != null;
		
		if ( !factories.containsKey( id ) )
		{
			try
			{
				// load class dynamically
				Class.forName( id );
			}
			catch ( ClassNotFoundException e )
			{
				throw new RuntimeException( "Class doesn't exist: " + id );
			}

			// sanity check
			if ( !factories.containsKey( id ) )
			{
				throw new RuntimeException( "Class hasn't registered its factory: " + id );
			}
		}

		ShapeIf shape = factories.get( id ).create();
		shape.init( r, c );
		
		return shape;
	}
}



