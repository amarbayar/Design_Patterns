package tools.asd.cs.mum;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;

import application.asd.cs.mum.ScribbleCanvas;
import iface.asd.cs.mum.Tool;
import iface.asd.cs.mum.TwoEndsShape;

public class LineShape extends GenericTool implements TwoEndsShape {
	
	Point p;
	
	public LineShape(ScribbleCanvas canvas) {
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
	      onscreen.drawLine(xStart, yStart, xStart, yStart);
	      
	      if (canvas.mouseButtonDown) {
		      onscreen.drawLine(xStart, yStart, canvas.x, canvas.y); 
		      onscreen.drawLine(xStart, yStart, p.x, p.y);
		  }
		  canvas.x = p.x; 
		  canvas.y = p.y; 
	}


	public void drawOutline(MouseEvent e) {
		  p = e.getPoint();
	      canvas.mouseButtonDown = false; 
	      onscreen.setPaintMode();
	      offscreen = canvas.getOffScreenGraphics(); 
	      offscreen.drawLine(xStart, yStart, p.x, p.y); 
	      canvas.repaint();
	}

	

}
