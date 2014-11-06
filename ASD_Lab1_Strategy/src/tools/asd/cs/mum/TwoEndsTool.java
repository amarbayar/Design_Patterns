//Note by Amar on 10.30.2014 9:04 PM
//Haven't had a chance to implement this TwoEndsTool, TwoEndsShape yet
//Therefore, I just used the LineShape, RectShape, and OvalShape on the same level as the EraseTool and ScribbleTool classes.
//Everything works fine now and I have a decoupled design, with dynamic bindings (with Poly) and P2i. 
//Will work on the TwoEndsTool and TwoEndsShape later after thinking through them.  

package tools.asd.cs.mum;

import java.awt.event.MouseEvent;

import application.asd.cs.mum.ScribbleCanvas;
import iface.asd.cs.mum.Tool;
import iface.asd.cs.mum.TwoEndsShape;

public class TwoEndsTool implements Tool{
	
	private TwoEndsShape shape;
	
	public TwoEndsTool(TwoEndsShape shape) {
		this.shape = shape;
	}

	public void mousePressed(MouseEvent e) {
		shape.drawShape(e);		
	}

	public void mouseReleased(MouseEvent e) {
		shape.drawOutline(e);
	}

	public void mouseDragged(MouseEvent e) {
		shape.drawShape(e);
	}

}
