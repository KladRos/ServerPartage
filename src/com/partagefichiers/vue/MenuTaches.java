/*
 * Created on 14 f�vr. 2006
 */
package com.partagefichiers.vue;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * @author A. Toudeft
 */
public class MenuTaches extends UnMenu {

	JMenuItem miConfigurerServeur;
	/**
	 * 
	 */
	public MenuTaches() {
		setText("Tâches");
		setActionCommand("Tâches");
		setMnemonic((int)'T');
		miConfigurerServeur = new UnMenuItem("Configurer serveur",'S',mil,true);
		
		miConfigurerServeur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		add(miConfigurerServeur);
	}
}
