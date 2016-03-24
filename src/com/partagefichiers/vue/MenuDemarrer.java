/*
  Created on 14 f�vr. 2006
 */
package com.partagefichiers.vue;


import javax.swing.*;
import java.awt.event.*;

/**
  @author A. Toudeft
 */
public class MenuDemarrer extends UnMenu {

	JMenuItem miConnecter, miQuitter;
	/**

	 */
	public MenuDemarrer() {
		setText("Démarrer");
		setActionCommand("Demarrer");
		setMnemonic((int)'D');
		miConnecter = new UnMenuItem("Se connecter",'C',mil,true);
		miQuitter = new UnMenuItem("Quitter",'Q',mil,true);
		
		miConnecter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		miQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		
		add(miConnecter);
		addSeparator();
		add(miQuitter);
	}
}
