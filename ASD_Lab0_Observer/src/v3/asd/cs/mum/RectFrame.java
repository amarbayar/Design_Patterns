package v3.asd.cs.mum;

import javax.swing.*;

import java.beans.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;

public class RectFrame extends javax.swing.JFrame implements Observer
{
    private int count;
    private ShapeResizeSubjectImpl srs;
    
	public RectFrame(ShapeResizeSubjectImpl srs)
	{
		getContentPane().setLayout(null);
		setSize(300,200);
		setTitle("RectangleFrame");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		this.count = 0;
		this.srs = srs;
		repaint();
	}


	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
		Object object = event.getSource();
		if (object == RectFrame.this)
			RectFrame_WindowClosing(event);
		}
	}

	void RectFrame_WindowClosing(java.awt.event.WindowEvent event)
	{
		dispose();		 // dispose of the Frame.
	}
	
	public  void  paint(  Graphics  display  )  
    {
            // clear display first
          Dimension sizes = getSize();
          display.clearRect(0,0,sizes.width,sizes.height);

          int x = 50;
          int y = 30;
          
          // Magnify value by 9 to get a bigger visual effect
          int height =  count*9;
          int width = count*9;
          
          display.setColor( Color.red );
          
          display.fillRect(x, y, Math.abs(width), Math.abs( height ) );
    }
    
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 == this.srs){
			this.count = srs.getCount();
			repaint();
		}
	}
}