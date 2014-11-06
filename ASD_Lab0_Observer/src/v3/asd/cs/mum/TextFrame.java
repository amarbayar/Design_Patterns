package v3.asd.cs.mum;

import javax.swing.*;

import java.beans.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;

public class TextFrame extends javax.swing.JFrame implements Observer
{
	private int count;
	private ShapeResizeSubjectImpl srs;
	
	public TextFrame(ShapeResizeSubjectImpl srs)
	{
		//{{INIT_CONTROLS
		getContentPane().setLayout(null);
		setSize(227,196);
		setVisible(false);
		getContentPane().add(JLabelCount);
		JLabelCount.setFont(new Font("Dialog", Font.BOLD, 36));
		JLabelCount.setBounds(48,48,170,86);
		setTitle("TextFrame");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		this.count = 0;
		this.srs = srs;
		JLabelCount.setText(String.valueOf(this.count));
	}


	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
		Object object = event.getSource();
		if (object == TextFrame.this)
			TextFrame_WindowClosing(event);
		}
	}

	void TextFrame_WindowClosing(java.awt.event.WindowEvent event)
	{
		dispose();		 // dispose of the Frame.
	}
	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabelCount = new javax.swing.JLabel();
	//}}

	//{{DECLARE_MENUS
	//}}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 == this.srs){
			this.count = srs.getCount();
			JLabelCount.setText(String.valueOf(count));
		}
	}
}