package tools.asd.cs.mum;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import application.asd.cs.mum.ScribbleCanvas;
import iface.asd.cs.mum.Tool;
import iface.asd.cs.mum.TwoEndsShape;

public class OvalShape extends GenericTool implements TwoEndsShape  {
	private Point p;
	
	public OvalShape(ScribbleCanvas canvas) {
		super(canvas);
	}

	public void drawShape(MouseEvent e) {
		  p = e.getPoint();
	      canvas.mouseButtonDown = true;
	      xStart = canvas.x = p.x; 
	      yStart = canvas.y = p.y; 
	      onscreen = canvas.getGraphics();
	      onscreen.setXORMode(Color.darkGray); 
	      onscreen.setColor(Color.lightGray); 
	      onscreen.drawOval(xStart, yStart, 1, 1);
	      
	      if (canvas.mouseButtonDown) {
		      onscreen.drawOval(xStart, yStart, canvas.x - xStart + 1, canvas.y - yStart + 1); 
		      onscreen.drawOval(xStart, yStart, p.x - xStart + 1, p.y - yStart + 1);  
		  }
		  canvas.x = p.x; 
		  canvas.y = p.y; 
	}

	public void drawOutline(MouseEvent e) {
		  p = e.getPoint();
		  
	      canvas.mouseButtonDown = false; 
	      onscreen.setPaintMode();
	      offscreen = canvas.getOffScreenGraphics(); 
	      offscreen.drawOval(xStart, yStart, p.x-xStart+1, p.y-yStart+1); 
	      canvas.repaint(); 
	}




}
