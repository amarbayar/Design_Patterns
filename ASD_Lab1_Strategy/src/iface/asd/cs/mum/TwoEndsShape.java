//Note by Amar on 10.30.2014 9:04 PM
//Haven't had a chance to implement this TwoEndsTool, TwoEndsShape yet
//Therefore, I just used the LineShape, RectShape, and OvalShape on the same level as the EraseTool and ScribbleTool classes.
//Everything works fine now and I have a decoupled design, with dynamic bindings (with Poly) and P2i. 
//Will work on the TwoEndsTool and TwoEndsShape later after thinking through them. 

package iface.asd.cs.mum;

import java.awt.event.MouseEvent;

public interface TwoEndsShape {
	public void drawShape(MouseEvent e);
	public void drawOutline(MouseEvent e);
}
