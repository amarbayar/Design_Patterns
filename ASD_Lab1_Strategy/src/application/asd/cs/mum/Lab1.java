package application.asd.cs.mum;

import iface.asd.cs.mum.Tool;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import tools.asd.cs.mum.EraseTool;
import tools.asd.cs.mum.LineShape;
import tools.asd.cs.mum.OvalShape;
import tools.asd.cs.mum.RectShape;
import tools.asd.cs.mum.ScribbleTool;
import tools.asd.cs.mum.TwoEndsTool;

import java.util.*;

public class Lab1 extends javax.swing.JFrame
{
    private JButton clearb     = null;
    private JButton scribbleb  = null;
    private JButton lineb      = null;
    private JButton rectangleb = null;
    private JButton ovalb      = null;
    private JButton eraseb     = null;

    protected ScribbleCanvas canvas; 
    protected EventListener listener;
    
    // constants representing tools  
    public static final int SCRIBBLE_TOOL =0;
    public static final int LINE_TOOL =1;
    public static final int RECTANGLE_TOOL =2;
    public static final int OVAL_TOOL =3;
    public static final int ERASER_TOOL =4;
    
    // the currently selected tool
    protected Tool currentTool;
  
	public Lab1 ()
	{
		setTitle("Drawing Application.");    
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
        setBackground(Color.lightGray);
        getContentPane().add(makeCanvas(), BorderLayout.CENTER);
        listener = makeCanvasListener(canvas);     
        canvas.addMouseListener((MouseListener) listener); 
        canvas.addMouseMotionListener((MouseMotionListener) listener); 
		setSize(480,312);
		setVisible(false);

		// add a toolbar to the frame
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);                    // toolbar is not floatable
		addToolbarButtons(toolBar);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		// add a menu bar to the frame
        JMenuBar menuBar = new JMenuBar();
        AddMenuItems(menuBar);
        setJMenuBar(menuBar);
        
		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
	}

  protected Component makeCanvas() {
    canvas = new ScribbleCanvas(); 
    canvas.setBackground(Color.white); 
    return canvas; 
  }

  protected EventListener makeCanvasListener(ScribbleCanvas canvas) {
    return new ScribbleCanvasListener(canvas,this); 
  }

	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }

			//Create a new instance of our application's frame, and make it visible.
			(new Lab1()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


    protected void addToolbarButtons(JToolBar toolBar) {

   
         clearb = new JButton(new ImageIcon("resource/clear.gif"));
		 clearb.setToolTipText("Clear drawing");
         toolBar.add(clearb);
         // add actionlistener to button
	     clearb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearb_actionPerformed(e);
                }
            });
            
         // add a separator
         toolBar.addSeparator(new Dimension(20,1));
         
         scribbleb = new JButton(new ImageIcon("resource/scribble.gif"));
		 scribbleb.setToolTipText("Scribble");
         toolBar.add(scribbleb);
         // add actionlistener to button
	     scribbleb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    scribbleb_actionPerformed(e);
                }
            });
         lineb = new JButton(new ImageIcon("resource/line.gif"));
		 lineb.setToolTipText("Draw Lines");
         toolBar.add(lineb);
         // add actionlistener to button
	     lineb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    lineb_actionPerformed(e);
                }
            });
         rectangleb = new JButton(new ImageIcon("resource/rectangle.gif"));
		 rectangleb.setToolTipText("Draw Rectangles");
         toolBar.add(rectangleb);
         // add actionlistener to button
	     rectangleb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rectangleb_actionPerformed(e);
                }
            });
         ovalb = new JButton(new ImageIcon("resource/oval.gif"));
		 ovalb.setToolTipText("draw ovals");
         toolBar.add(ovalb);
         // add actionlistener to button
	     ovalb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ovalb_actionPerformed(e);
                }
            });
         eraseb = new JButton(new ImageIcon("resource/eraser.gif"));
		 eraseb.setToolTipText("Eraser");
         toolBar.add(eraseb);
         // add actionlistener to button
	     eraseb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eraseb_actionPerformed(e);
                }
            });
    }
          
	/**
	 * Add menu items to the menu bar
	 * @param menuBar the JMenuBar
	 */
    protected void AddMenuItems(JMenuBar menuBar) {
        JMenu menu;
        JMenuItem menuItem;
        //Build the first menu.
 

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        menuItem = new JMenuItem("New");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        menu.add(menuItem);
	    menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearb_actionPerformed(e);
                }
            });
        
        
        menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(KeyEvent.VK_F);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.ALT_MASK));
        menu.add(menuItem);
	    menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    exitApplication();
                }
            });

        menu = new JMenu("Tool ");
        menu.setMnemonic(KeyEvent.VK_T);
        menuBar.add(menu);

        menuItem = new JMenuItem("Scribble");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menu.add(menuItem);
	    menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    scribbleb_actionPerformed(e);
                }
            });

        menuItem = new JMenuItem("Line");
        menuItem.setMnemonic(KeyEvent.VK_L);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_L, ActionEvent.ALT_MASK));
        menu.add(menuItem);
	    menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    lineb_actionPerformed(e);
                }
            });

        menuItem = new JMenuItem("Rectangle");
        menuItem.setMnemonic(KeyEvent.VK_R);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.ALT_MASK));
        menu.add(menuItem);
	    menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rectangleb_actionPerformed(e);
                }
            });
 
        menuItem = new JMenuItem("Oval");
        menuItem.setMnemonic(KeyEvent.VK_O);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.ALT_MASK));
        menu.add(menuItem);
	    menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ovalb_actionPerformed(e);
                }
            });

        menuItem = new JMenuItem("Eraser");
        menuItem.setMnemonic(KeyEvent.VK_E);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.ALT_MASK));
        menu.add(menuItem);
	    menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eraseb_actionPerformed(e);
                }
            });


     }

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == Lab1.this)
				JDrawFrame_windowClosing(event);
		}
	}

	void JDrawFrame_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		JDrawFrame_windowClosing_Interaction1(event);
	}

	void JDrawFrame_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			
		}
	}
	
	void clearb_actionPerformed(java.awt.event.ActionEvent event) {
	    System.out.println("clear");
        canvas.clearCanvas(); 
        canvas.repaint();  
    }
	void scribbleb_actionPerformed(java.awt.event.ActionEvent event) {
	    System.out.println("scribble");
	    setCurrentTool(new ScribbleTool(canvas));
    }
	void lineb_actionPerformed(java.awt.event.ActionEvent event) {
	    System.out.println("line");
	    setCurrentTool(new TwoEndsTool(new LineShape(canvas)));
    }
	void rectangleb_actionPerformed(java.awt.event.ActionEvent event) {
	    System.out.println("rectangle");
	    setCurrentTool(new TwoEndsTool(new RectShape(canvas)));
    }
	void ovalb_actionPerformed(java.awt.event.ActionEvent event) {
	    System.out.println("oval");
	    setCurrentTool(new TwoEndsTool(new OvalShape(canvas)));
    }
	void eraseb_actionPerformed(java.awt.event.ActionEvent event) {
	    System.out.println("erase.");
	    setCurrentTool(new EraseTool(canvas));
    }

    public void setCurrentTool(Tool tool){
        currentTool=tool;
    }
    public Tool getCurrentTool(){
        return currentTool;
    }
}

