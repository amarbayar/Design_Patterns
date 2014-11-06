package tools.asd.cs.mum;

import java.awt.Graphics;
import application.asd.cs.mum.ScribbleCanvas;

public class GenericTool {
	protected Graphics onscreen, offscreen;
	protected int xStart, yStart;
	protected ScribbleCanvas canvas;
	
	public GenericTool(ScribbleCanvas canvas){
		this.canvas = canvas;
	}
}
