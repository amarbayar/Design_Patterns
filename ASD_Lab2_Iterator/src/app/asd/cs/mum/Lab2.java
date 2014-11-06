package app.asd.cs.mum;

import java.util.Iterator;

import iface.asd.cs.mum.IIterator;
import impl.asd.cs.mum.*;

import javax.swing.*;


/**
 * A basic JFC 1.1 based application.    
 */
public class Lab2 extends javax.swing.JFrame
{
    private SwimmersList slist;
    private IIterator i;
    
	public Lab2()   
	{
		setTitle("Iterator Lab.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(660,310);
		setVisible(false);

		JButtonAllSwimmers.setText("All Swimmers");
		JButtonAllSwimmers.setActionCommand("All Swimmers");
		getContentPane().add(JButtonAllSwimmers);
		JButtonAllSwimmers.setBounds(14,26,190,24);

		JButtonAllBackward.setText("All Swimmers Backward");
		JButtonAllBackward.setActionCommand("All Swimmers Backward");
		getContentPane().add(JButtonAllBackward);
		JButtonAllBackward.setBounds(210,24,180,26);

		JButtonAllAbove12.setText("All Swimmers Above 12");
		JButtonAllAbove12.setActionCommand("All Swimmers above 12");
		getContentPane().add(JButtonAllAbove12);
		JButtonAllAbove12.setBounds(408,24,180,24);

		JScrollPane1.setOpaque(true);
		getContentPane().add(JScrollPane1);

		JScrollPane1.setBounds(12,60,190,204);
		JScrollPane1.getViewport().add(JTextArea1);
		JTextArea1.setBounds(0,0,188,206);

		getContentPane().add(JScrollPane2);
		JScrollPane2.setBounds(216,60,182,204);
		JScrollPane2.getViewport().add(JTextArea2);
		JTextArea2.setBounds(0,0,180,200);

		getContentPane().add(JScrollPane3);
		JScrollPane3.setBounds(408,60,177,204);
		JScrollPane3.getViewport().add(JTextArea3);
		JTextArea3.setBounds(0,0,176,200);

        FillData();

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButtonAllSwimmers.addActionListener(lSymAction);
		JButtonAllBackward.addActionListener(lSymAction);
		JButtonAllAbove12.addActionListener(lSymAction);
	}

	static public void main(String args[])
	{
		try {
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
			//Create a new instance of our application's frame, and make it visible.
			(new Lab2()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	javax.swing.JButton JButtonAllSwimmers = new javax.swing.JButton();
	javax.swing.JButton JButtonAllBackward = new javax.swing.JButton();
	javax.swing.JButton JButtonAllAbove12  = new javax.swing.JButton();
	javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextArea1 = new javax.swing.JTextArea();
	javax.swing.JScrollPane JScrollPane2 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextArea2 = new javax.swing.JTextArea();
	javax.swing.JScrollPane JScrollPane3 = new javax.swing.JScrollPane();
	javax.swing.JTextArea JTextArea3 = new javax.swing.JTextArea();


       
    public void FillData(){
        slist = new SwimmersList();
        
        Swimmer pswim = new Swimmer ("Amanda", "McCarthy","WCA",12,28.10);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Jamie", "Falco","HNHS",12,29.80);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Meaghan", "O'Donnell","EDST",12,30.00);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Greer", "Gibbs","CDEV",11,30.04);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Rhiannon", "Jeffrey","WYW",12,30.04);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Sophie", "Connolly","HNHS",11,30.11);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Dana", "Helyer","EDST",12,30.20);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Lindsay", "Marotto","CDEV",11,30.22);
        slist.addSwimmer(pswim);
        pswim = new Swimmer ("Sarah", "Treichel","WCA",12,30.34);
        slist.addSwimmer(pswim);
        
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
			if (object == Lab2.this)
				JFrame1_windowClosing(event);
		}
	}

	void JFrame1_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		JFrame1_windowClosing_Interaction1(event);
	}

	void JFrame1_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
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
			if (object == JButtonAllSwimmers)
				JButtonAllSwimmers_actionPerformed(event);
			else if (object == JButtonAllBackward)
				JButtonAllBackward_actionPerformed(event);
			else if (object == JButtonAllAbove12)
				JButtonAllAbove12_actionPerformed(event);
			
		}
	}

	void JButtonAllSwimmers_actionPerformed(java.awt.event.ActionEvent event)
	{
		i = new RegularSwimmers(slist);
		Iterator itr = i.iterate();
		while(itr.hasNext()){
			Swimmer swimmer = (Swimmer)itr.next();
			JTextArea1.append(swimmer.getFname() + " " + swimmer.getLname() + " \n");
		}
	}

	void JButtonAllBackward_actionPerformed(java.awt.event.ActionEvent event)
	{
		i = new ReverseSwimmers(slist);
		Iterator itr = i.iterate();
		while(itr.hasNext()){
			Swimmer swimmer = (Swimmer)itr.next();
			JTextArea2.append(swimmer.getFname() + " " + swimmer.getLname() + " \n");
		}
	}

	void JButtonAllAbove12_actionPerformed(java.awt.event.ActionEvent event)
	{
		i = new SelectiveSwimmers(slist);
		Iterator itr = i.iterate();
		while(itr.hasNext()){
			Swimmer swimmer = (Swimmer)itr.next();
			JTextArea3.append(swimmer.getFname() + " " + swimmer.getLname() + " \n");
		}
	}
}
