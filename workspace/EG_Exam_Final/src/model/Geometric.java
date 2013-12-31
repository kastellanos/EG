package model;

public abstract class Geometric extends Graphic {

	public int getLineWidth() {
		
		return lineWidth;
	}

	public void setLineWidth( final int lineWidth ) {
		
		this.lineWidth = lineWidth;
	}

	private int lineWidth;
}
