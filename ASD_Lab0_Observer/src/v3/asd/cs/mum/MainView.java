package v3.asd.cs.mum;

import javax.swing.JFrame;

public class MainView extends JFrame {
	private int count;
	private ShapeResizeSubjectImpl srs;
	
	public MainView(ShapeResizeSubjectImpl srs){
		
		getContentPane().setLayout(null);
		this.count = 0;
		this.srs = srs;
		
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}
	
	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{

		}
	}
}
