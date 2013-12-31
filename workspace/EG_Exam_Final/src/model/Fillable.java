package model;

import java.awt.Color;

public abstract class Fillable extends Geometric {

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	private Color fillColor;
}
