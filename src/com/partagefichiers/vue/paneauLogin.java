/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partagefichiers.vue;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author usager
 */
public class paneauLogin extends JPanel implements Observer {
  
                            //DECLARATIONS
    //listener
    ActionListener loginbutton = null;
//  Modele :
	//Client client;
//	Composants pour l'interface :
//	Panneaux:
	JPanel centerPanel;
        JPanel userPanel;
        JPanel passPanel;
        JPanel buttonPanel;
        JButton bInscrire = new JButton("S'inscrire");
		
// Composants:	
	JTextField			tSaisie;
	JTextField			taSalon;

      paneauLogin.loginPanelActionListener lpal = new paneauLogin.loginPanelActionListener(); // pour un eventuelleactionListener
        
public paneauLogin() {
		super();
//Panneaux et composants:	 	 
		centerPanel = new JPanel();
                userPanel = new JPanel();
                passPanel = new JPanel();
                buttonPanel = new JPanel();
		
              GridLayout layout = new GridLayout(0,1);  
              centerPanel.setLayout(layout);

		JLabel userLabel = new JLabel("          Usager");
		userLabel.setBounds(10, 10, 80, 25);
		userPanel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		userPanel.add(userText);
                
                

		JLabel passwordLabel = new JLabel("Mot de Passe");
		passwordLabel.setBounds(10, 40, 80, 25);
		passPanel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		passPanel.add(passwordText);

		JButton bLogin = new JButton("Login");
		bLogin.setBounds(10, 80, 80, 25);
		buttonPanel.add(bLogin);
              
		
		
                bInscrire.setActionCommand("connecter");
		bInscrire.setBounds(180, 80, 80, 25);
		buttonPanel.add(bInscrire);
                
                centerPanel.add(userPanel);
                centerPanel.add(passPanel);
                centerPanel.add(buttonPanel);
                
		add(centerPanel);
	 	setVisible(false);

	}
    
    @Override
    	public void update(Observable o, Object t) {
	    /*if (o instanceof Client)	
		{
			if (client == null)
			  client = (Client)o;
			  
			String s = ((Client)o).getEtat();
			
			if (t != null)
			{
				//taSalon.append("\n"+t);
			}
			else if (s.equals("RECH_SERVEUR"))
			{
				setVisible(true);
				//taSalon.append("\nRecherche d'un serveur...");
			}
			else if (s.equals("CONNECTION"))
			{
				//taSalon.append("\nConnection établie");
				//taSalon.append("\n------------------");
			}
			else if (s.equals("DECONNECTE"))
			{
				setVisible(false);
			}
		}*/
	}
	
        public void setLoginListener(ActionListener al)
	{
		loginbutton = al;
	}

	class loginPanelActionListener implements ActionListener
	  {
	    public void actionPerformed(ActionEvent evt)
		{
			if (loginbutton != null)
				loginbutton.actionPerformed(evt);
                        
                  if (evt.getSource() == bInscrire) {
                        javax.swing.JOptionPane.showMessageDialog(null,"sdasdsadasdasd");
                       
                        
                  }        
                        
                        
		}
	  }		

	
		
		
	  }
    
    
