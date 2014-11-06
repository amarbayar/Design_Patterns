package application.asd.cs.mum;

import iface.asd.cs.mum.Tool;

import java.awt.*;
import java.awt.event.*;

import tools.asd.cs.mum.EraseTool;
import tools.asd.cs.mum.GenericTool;
import tools.asd.cs.mum.ScribbleTool;

public class ScribbleCanvasListener 
    implements MouseListener, MouseMotionListener {
        
  protected Lab1 drawframe;
  protected ScribbleCanvas canvas; 
  protected int xStart, yStart; 
  protected Graphics onscreen, offscreen; 
  protected Tool tool;
  private GenericTool gTool;
  
  public ScribbleCanvasListener(ScribbleCanvas canvas, Lab1 drawframe) {
    this.canvas = canvas;
    this.drawframe=drawframe;
  }

  public void mousePressed(MouseEvent e) {
	tool = drawframe.getCurrentTool();
	if(tool!=null)
		tool.mousePressed(e);
  } 

  public void mouseReleased(MouseEvent e) {
		tool = drawframe.getCurrentTool();
		if(tool!=null)
			tool.mouseReleased(e);    
  }    

  public void mouseDragged(MouseEvent e) {
		tool = drawframe.getCurrentTool();
		if(tool!=null)
			tool.mouseDragged(e);      
  }

  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}  
  public void mouseExited(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}     

  
}

