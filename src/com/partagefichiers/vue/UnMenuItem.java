/*
 * Created on 14 f�vr. 2006
 */
package com.partagefichiers.vue;


import javax.swing.JMenuItem;
import java.awt.event.*;

/**
 * @author A. Toudeft
 */
public class UnMenuItem extends JMenuItem {

	/**
	 * 
	 */
	public UnMenuItem(String s, char touche, ActionListener al, boolean b) {
		super(s,(int)touche);
		setActionCommand(s);
		setEnabled(b);
		addActionListener(al);
		// TODO Auto-generated constructor stub
	}
}
