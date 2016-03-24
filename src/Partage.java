/* solution complete prise : http://www.fobec.com/java/1012/programmer-soi-meme-jeu-demineur.html*/
/*jai changer tout les nom de variable*/
/*jai changer les nom de methode*/
/*jai ajouter les commentaire pour  ke tu sache kelle methode fait quoi */
/*jai modifier un peut la methode mettreNumero*/
/*jai changer le menu, il fau just implementer dans action performed  EX: e.getsource()  == itemMeilleur */
/*je nest pas verifier la methode DoCheck*/

import com.partagefichiers.vue.MenuDemarrer;
import com.partagefichiers.vue.MenuTaches;
import static com.sun.java.accessibility.util.AWTEventMonitor.removeActionListener;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.event.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.util.List;
 
public class Partage extends JFrame implements ActionListener,MouseListener {
    private JTextField userText;
    private JPasswordField passwordText;
                            //DECLARATIONS
    Container contentPane;
    //listener
    ActionListener loginbutton = null;
    //Gestionnaire des �v�nements de menu:
	ActionListener mml = null ;
//  Modele :
	//Client client;
//	Composants pour l'interface :
//	Panneaux:
    //***************************      LOGIN******************////////////
    JPanel centerPanel;
        JPanel userPanel;
        JPanel passPanel;
        JPanel buttonPanel;
        JButton bInscrire = new JButton("S'inscrire");
        JButton bLogin = new JButton("Login");
      //Menus:
	JMenuBar mBar   = new JMenuBar();
	MenuDemarrer mDemarrer = new MenuDemarrer();
	MenuTaches mTaches   = new MenuTaches();
    //************************** INSCRIPTION ****************** //////////
    JPanel inscriptionPanel;
      JPanel IuserPanel;
    JPanel   IpassPanel;
     JPanel  IbuttonPanel ;
     JButton creationButton = new JButton("Creer");
	//JPanel centerPanel;
//************************** Programme ****************** //////////
     JButton bTelecharger = new JButton("Telecharger");
     JButton bTeleverser = new JButton("Televerser");
      
		
// Composants:	
	JTextField			tSaisie;
	JTextField			taSalon;
    public Partage() {
       contentPane = this.getContentPane();
       initialiseDefaut();	 	 
		
    }
    
    
    
   


 
    
 // initialiser le jeu avec les parametre par default  10, 10 avec  10 mines   
      public void initialiseDefaut() {
                centerPanel = new JPanel();
                userPanel = new JPanel();
                passPanel = new JPanel();
                buttonPanel = new JPanel();
                
                mBar.add(mDemarrer);
		mBar.add(mTaches);
		

		setJMenuBar(mBar);

		mDemarrer.setMenuListener(mml);
		mTaches.setMenuListener(mml);

              GridLayout layout = new GridLayout(0,1);  
              centerPanel.setBackground(Color.red);
              userPanel.setBackground(Color.blue);
              passPanel.setBackground(Color.yellow);
              buttonPanel.setBackground(Color.green);
              
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

		//**********BUTTON LOGIN**///////////
		bLogin.setBounds(10, 80, 80, 25);
		buttonPanel.add(bLogin);
                bLogin.addActionListener(this);
                
              
		
		
                bInscrire.setActionCommand("connecter");
		bInscrire.setBounds(180, 80, 80, 25);
		buttonPanel.add(bInscrire);
                bInscrire.addActionListener(this);
                
                centerPanel.add(userPanel);
                centerPanel.add(passPanel);
                centerPanel.add(buttonPanel);
                
		contentPane.setLayout(new BorderLayout());
                contentPane.add(centerPanel);

                this.setSize(350,200);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(true);
                
       


    }
    

    public static void main(String[] args) {
        new Partage();      
    }
 
  
    private void changePanelInscription() {
        System.out.println("changePanelIns");
    inscriptionPanel = new JPanel();
    
                //panel.setVisible(false);
            
    
               

                IuserPanel = new JPanel();
                IpassPanel = new JPanel();
                IbuttonPanel = new JPanel();
	
              GridLayout layout = new GridLayout(0,1);  
              inscriptionPanel.setLayout(layout);

		JLabel userLabel = new JLabel("          User");
		userLabel.setBounds(10, 10, 80, 25);
		userPanel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		userPanel.add(userText);
                

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		passPanel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		passPanel.add(passwordText);

                //*********BUTTON DE CREATION ****//////
		creationButton.setBounds(10, 80, 80, 25);
                creationButton.addActionListener(loginbutton);
		buttonPanel.add(creationButton);
		
		
                
                inscriptionPanel.add(userPanel);
                inscriptionPanel.add(passPanel);
                inscriptionPanel.add(buttonPanel);
		contentPane.add(inscriptionPanel);
		
	 	contentPane.setSize(500,501);
                contentPane.doLayout();
                contentPane.repaint();
    
    //update(getGraphics());
}
    
 private void changePanelMain() {
         //**********PANEL qui englobe tout les panel********//  
     JPanel mainAPP = new JPanel();
     mainAPP.setLayout(new BorderLayout());
                //**********PANEL Du titre  (just pour faire un espace en haut)********//          
        JPanel panneauTitre = new JPanel();
          panneauTitre.setSize(800, 500);
        JLabel lTitre = new JLabel("Sak ap fet pam lan");
        panneauTitre.add(lTitre);            
         
       //**********PANEL DES DOSSIER********//  
        JPanel panneauArbre = new JPanel();
          JTree aDossier = new JTree();
        panneauArbre.add(aDossier);
         
       //**********PANEL DES Contact********//  
        // appeler une requete pour avoir la liste de tout les usager  et mettre dans contact
        JPanel panneauUser = new JPanel();
        String[] contact = {"Marwene", "Kismony", "Alex", "Bari", "Timounemoune","Ali","Khadija","Fred","Banane"};
          JList listeUser = new JList(contact);
          listeUser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // pour pouvoir selectioner plus que un nom
        panneauUser.add(listeUser);
            
      
        //**********PANEL des chemin de fichier********//  
        JPanel panneauChemin = new JPanel();
        JPasswordField passwordText = new JPasswordField(20);
            passwordText.setBounds(100, 40, 160, 25);
        panneauChemin.add(passwordText);
        //**********BUTTON upload download**///////////
            bTeleverser.setBounds(10, 80, 80, 25);
        panneauChemin.add(bTeleverser);
          
            bTelecharger.setBounds(10, 80, 80, 25);
        panneauChemin.add(bTelecharger);
          

        mainAPP.add(panneauTitre,NORTH);
        mainAPP.add(panneauUser,WEST);   
        mainAPP.add(aDossier,CENTER);    
        mainAPP.add(panneauChemin,SOUTH);
        this.add(mainAPP);
	this.setSize(800,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bInscrire) {
            
            
             ((AbstractButton) e.getSource()).removeActionListener(this); // enelever l'actionListerner pCCQ erreur 
              contentPane.remove(centerPanel);
                
                changePanelInscription();
                System.out.print("yo dwag");
        }
         if (e.getSource() == creationButton) {
              ((AbstractButton) e.getSource()).removeActionListener(this); // enelever l'actionListerner pCCQ erreur 
             // aller rentrer les info dans la BD UPDATE
                initialiseDefaut(); // va remettre la page de login
        }
          if (e.getSource() == bLogin) {
              ((AbstractButton) e.getSource()).removeActionListener(this); // enelever l'actionListerner pCCQ erreur
              EntityManagerFactory emf = Persistence.createEntityManagerFactory("Partage_FichierPU");
                EntityManager em = emf.createEntityManager();
                List l = em.createNamedQuery("User.findByUserPassword").setParameter("username", userText.getText()).setParameter("password", String.valueOf(passwordText.getPassword())).getResultList();
                System.out.println(l.size() + " fgafds");
                if (l.size() <= 0){
                //if (temp = true){
                    
                }else{
                    JOptionPane.showMessageDialog(null, "NOP");
                }
             // aller rentrer les info dans la BD UPDATE
                             System.out.print("yo dwag");
                changePanelMain(); // va remettre la page de login
        }
         if (e.equals("Configurer serveur")) //CODE A MOUMS
		  	 {
		  	 	JPanel p1 = new JPanel(new GridLayout(2,1));
		  	 	JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT)),
		  	 		   p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		  	 	/*JTextField t1 = new JTextField(cl.getAdrServeur(),10);
		  	 	p2.add(new JLabel("Adresse du serveur : "));
		  	 	p2.add(t1);
		  	 	JTextField t2 = new JTextField(String.valueOf(cl.getPortServeur()),10);
		  	 	p3.add(new JLabel("Port du serveur : "));
		  	 	p3.add(t2);
		  	 	p1.add(p2);
		  	 	p1.add(p3);*/
		  	 	int r = JOptionPane.showConfirmDialog(this, p1, "Configurer serveur", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		  	 	if (r==JOptionPane.YES_OPTION)
		  	 	{
		  	 	  //cl.setAdrServeur(t1.getText());
		  	 	 // cl.setPortServeur(Integer.parseInt(t2.getText()));
		  	 	}
		  	 }
         
         
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
