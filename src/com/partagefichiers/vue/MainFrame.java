/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partagefichiers.vue;

import com.partage.modele.Client;
import com.partage.modele.Documents;
import com.partage.modele.DocumentsPK;
import com.partage.modele.Transaction;
import com.partage.modele.User;
import com.partage.modele.FileDrop;
import com.partage.modele.Sharedfiles;
import com.partage.modele.UserPK;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author atoudeft
 */
public class MainFrame extends JFrame implements ActionListener {
    
    private JTextField userText;
    private JPasswordField passwordText;
    private JTextArea cheminFichier;
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
    private JButton bLogin = new JButton("Login");
      //Menus:
	JMenuBar mBar   = new JMenuBar();
	MenuDemarrer mDemarrer = new MenuDemarrer();
	MenuTaches mTaches   = new MenuTaches();
    //************************** INSCRIPTION ****************** //////////
    JPanel inscriptionPanel;
      JPanel IuserPanel  ;
    JPanel   IpassPanel ;
     JPanel  IbuttonPanel ;
     JButton creationButton = new JButton("Creer");
	//JPanel centerPanel;
//************************** Programme ****************** //////////
     JButton bTelecharger = new JButton("Telecharger");
     JButton bTeleverser = new JButton("Televerser");
     private Client m;
     
    public MainFrame() throws HeadlessException, IOException {
        super("partage Fichiers");
        //this.m = new Client();
        contentPane = new Container(); 
        contentPane = this.getContentPane();
        
        
        initialiseDefaut();
        
        contentPane.setLayout(new BorderLayout());
        
  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
//    
    public static void main(String args[]) {
        try {
            new MainFrame();
        } catch (HeadlessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
     private void changePanelInscription() {
        System.out.println("changePanelIns");
    inscriptionPanel = new JPanel();
    
              GridLayout layout = new GridLayout(0,1);  
              inscriptionPanel.setLayout(layout);

                IuserPanel = new JPanel();
                IpassPanel = new JPanel();
                IbuttonPanel = new JPanel();
	

		JLabel userLabel = new JLabel("          User");
		userLabel.setBounds(10, 10, 80, 25);
		IuserPanel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		IuserPanel.add(userText);
                

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		IpassPanel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		IpassPanel.add(passwordText);

                //*********BUTTON DE CREATION ****//////
		creationButton.setBounds(10, 80, 80, 25);
                creationButton.addActionListener(this);
		IbuttonPanel.add(creationButton);
		
		
                
                inscriptionPanel.add(IuserPanel);
                inscriptionPanel.add(IpassPanel);
                inscriptionPanel.add(IbuttonPanel);
		contentPane.add(inscriptionPanel);
		//******************************** transfert fich
                
	 
    
    //update(getGraphics());
}
     
     
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
              centerPanel.setLayout(layout);

		JLabel userLabel = new JLabel("          Usager");
		userLabel.setBounds(10, 10, 80, 25);
		userPanel.add(userLabel);

		userText = new JTextField(20);
                userText.setText("bob");
		userText.setBounds(100, 10, 160, 25);
		userPanel.add(userText);
                
                

		JLabel passwordLabel = new JLabel("Mot de Passe");
		passwordLabel.setBounds(10, 40, 80, 25);
		passPanel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
                passwordText.setText("bob");
		passPanel.add(passwordText);

		//**********BUTTON LOGIN**///////////
		bLogin.setBounds(10, 80, 80, 25);
		buttonPanel.add(bLogin);
                bLogin.addActionListener(this);
                
              
		

		bInscrire.setBounds(180, 80, 80, 25);
		buttonPanel.add(bInscrire);
                bInscrire.addActionListener(this);
                
                centerPanel.add(userPanel);
                centerPanel.add(passPanel);
                centerPanel.add(buttonPanel);
                
		contentPane.setLayout(new BorderLayout());
                contentPane.add(centerPanel);

                this.setSize(350,201);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(true);
                
       


    }     
     
 private void changePanelMain() {
         //**********PANEL qui englobe tout les panel********//  
     JPanel mainAPP = new JPanel();
     mainAPP.setLayout(new BorderLayout());
                //**********PANEL Du titre  (just pour faire un espace en haut)********//          
        JPanel panneauTitre = new JPanel();
          panneauTitre.setSize(800, 501);
        JLabel lTitre = new JLabel("Partage"); //HAHAHA
        panneauTitre.add(lTitre);            
//         
//       //**********PANEL DES DOSSIER********//  
//        JPanel panneauArbre = new JPanel();
//          JTree aDossier = new JTree();
//        panneauArbre.add(aDossier);
//         
//       //**********PANEL DES Contact********//  
//        // appeler une requete pour avoir la liste de tout les usager  et mettre dans contact
//        JPanel panneauUser = new JPanel();
//        String[] contact = {"Marwene", "Kismony", "Alex", "Bari", "Timounemoune","Ali","Khadija","Fred","Banane"};
//          JList listeUser = new JList(contact);
//          listeUser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // pour pouvoir selectioner plus que un nom
//        panneauUser.add(listeUser);
//            
//      

// effacer tous ce qui a entre   //**********PANEL DES DOSSIER********//   et   //**********PANEL des chemin de fichier********// dans le mainframe.java

 //**********PANEL DES DOSSIER********//  
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("Partage_FichierPU");
         EntityManager em = emf.createEntityManager();
         Query req = em.createNamedQuery("Documents.findAllPrive");
         req.setParameter("owner", userText.getText());
         
         List<Documents> listeDocPriv  = req.getResultList();  //chercher les document public
         System.out.println(listeDocPriv + " aaaaaaaaaaaaaa");
         
         Query req2 = em.createNamedQuery("Documents.findByStatut");
         req2.setParameter("statut", "pub");
         List<Documents> listeDocPub  = req2.getResultList();  //chercher les document public
         System.out.println(listeDocPub + " aaaaaaaaaaaaaa");
         
         List<Sharedfiles> listeDocPartager = em.createNamedQuery("Sharedfiles.findAll").getResultList();
         
         JPanel panneauArbre = new JPanel();
          
 
           DefaultMutableTreeNode fichiers = new DefaultMutableTreeNode("Documents");
           DefaultMutableTreeNode  docPartager = new DefaultMutableTreeNode("Partager");  
           DefaultMutableTreeNode docPublique = new DefaultMutableTreeNode("Publiquer");
            DefaultMutableTreeNode docPrivee = new DefaultMutableTreeNode("Privee");
           JTree aDossier = new JTree(fichiers);
           


            DefaultMutableTreeNode[] privee  = new DefaultMutableTreeNode[listeDocPriv.size()];
            DefaultMutableTreeNode[] publique  = new DefaultMutableTreeNode[listeDocPub.size()];
            DefaultMutableTreeNode[] partager  = new DefaultMutableTreeNode[listeDocPriv.size()];
          
          
            for (int i = 0; i < listeDocPriv.size(); i++ ){
                privee[i]  = new DefaultMutableTreeNode(listeDocPriv.get(i).getNameFile()); 
                docPrivee.add(privee[i]);
            }
            
            
//            for (int j = 0; j < listeDocPartager.size(); j++ ){ 
//                    if(listeDocPriv.get(i).getDocumentsPK().getIdFile() == listeDocPartager.get(j).getSharedfilesPK().getIdFile()){ // verifie si les ideede la list priver son des fichier partager dans listePartager
//                    partager[i]  = new DefaultMutableTreeNode(listeDocPriv.get(i).getNameFile()); 
//                  docPartager.add(partager[i]);   
//                }else{
//                   privee[i]  = new DefaultMutableTreeNode(listeDocPriv.get(i).getNameFile()); 
//                  docPrivee.add(privee[i]);  
//                }
//             }
            
            
             for (int i = 0; i < listeDocPub.size(); i++ ){
                publique[i]  = new DefaultMutableTreeNode(listeDocPub.get(i).getNameFile()); 
                  docPublique.add(publique[i]);
            }
           
             fichiers.add(docPrivee);
              fichiers.add(docPublique);
               fichiers.add(docPartager);
               panneauArbre.add(aDossier);
        
       //**********PANEL DES Contact********//  

                List<User> l = em.createNamedQuery("User.findAll").getResultList();
             //   System.out.println(l.size() + " fgafds");
        
   
        // appeler une requete pour avoir la liste de tout les usager  et mettre dans contact
        JPanel panneauUser = new JPanel();
        String[] contact = new String[l.size()];// = {"Marwene", "Kismony", "Alex", "Bari", "Timounemoune","Ali","Khadija","Fred","Banane"};
       for (int i = 0; i < l.size(); i++ ){
           contact[i] = l.get(i).getUserPK().getUsername();
       }
       JList listeUser = new JList(contact);
        listeUser.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // pour pouvoir selectioner plus que un nom
        panneauUser.add(listeUser);

        //**********PANEL des chemin de fichier********//  
        JPanel panneauChemin = new JPanel();
         //cheminFichier = new JTextArea(1,20);
           cheminFichier = new JTextArea("veuillez et glisser et lâcher un fichier ici");
        new FileDrop( System.out, cheminFichier, /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   
                cheminFichier.setText("");
                for( int i = 0; i < files.length; i++ )
                {   try
                    {   cheminFichier.append( files[i].getCanonicalPath() );//+ "\n" );
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        });  
         cheminFichier.setBounds(100, 40, 160, 25);
        panneauChemin.add(cheminFichier);
        //**********BUTTON upload download**///////////
            bTeleverser.setBounds(10, 80, 80, 25);
        panneauChemin.add(bTeleverser);
        bTeleverser.addActionListener(this);
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
        Object source = e.getSource();
        if (source == bInscrire) {  // AFFICHER FORMULAIRE D'INSCRIPTION
           contentPane.remove(centerPanel);
           contentPane.repaint();
            changePanelInscription();
            this.setSize(350,202);
            contentPane.doLayout();
            contentPane.repaint();
            
        }
        else
            if (source == bLogin) { // SI ON ON APPUIESUR LOGIN (Faire verification BD)
                /*boolean temp = true;*/
                //((AbstractButton) e.getSource()).removeActionListener(this);
                /*Transaction t = new Transaction(userText.getText(), String.valueOf(passwordText.getPassword()));
                if (t.getConnexion(userText.getText(), String.valueOf(passwordText.getPassword()) )){
                */
//                if (true){
//                    contentPane.remove(centerPanel);
//                    contentPane.repaint();
//                     changePanelMain();
//                    this.setSize(500,502);
//                    contentPane.doLayout();
//                    contentPane.repaint();
//                    System.out.println("contenu "+ userText.getText()+" pass "+ String.valueOf(passwordText.getPassword()));
//                }
                    //System.out.println("contenu "+ userText.getText()+" pass "+ String.valueOf(passwordText.getPassword()));
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Partage_FichierPU");
                EntityManager em = emf.createEntityManager();
                List l = em.createNamedQuery("User.findByUserPassword").setParameter("username", userText.getText()).setParameter("password", String.valueOf(passwordText.getPassword())).getResultList();
                System.out.println(l.size() + " fgafds");
                if (l.size() >= 0){
                //if (temp = true){
                    JOptionPane.showMessageDialog(null, "YEP");
                    contentPane.remove(centerPanel);
                    contentPane.repaint();
                     changePanelMain();
                    this.setSize(500,502);
                    contentPane.doLayout();
                    contentPane.repaint();
                    try {
                        m = new Client();
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "NOP");
                }
                
        }else 
            if (source == creationButton) { // Si on APPUI SUR CREER  (AJOUTER USER DANS BD)
            contentPane.remove(inscriptionPanel);
        // @NamedQuery(name = "User.findByUserPassword", query = "SELECT u FROM User u WHERE u.password = :password and u.username = :username"),

            contentPane.add(centerPanel);
            contentPane.repaint();
           //  initialiseDefaut(); on utilise pas sa pck les paneau  son deja cree
            this.setSize(350,200);
            contentPane.doLayout();
            contentPane.repaint();
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Partage_FichierPU");
            EntityManager em = emf.createEntityManager();
            
            UserPK uk = new UserPK(userText.getText());
            //System.out.println("contenu "+ userText.getText()+" pass "+ String.valueOf(passwordText.getPassword()));
            User u = new User(uk, String.valueOf(passwordText.getPassword()));
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }else if(source == bTeleverser){
            System.out.println("ok");
            System.out.println("ok12 "+cheminFichier.getText());
            File temp = new File(cheminFichier.getText().trim());
            try {
                m.sendFile(temp);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Partage_FichierPU");
            EntityManager em = emf.createEntityManager();
            
            DocumentsPK pk = new DocumentsPK(userText.getText());
            int extension = temp.getName().lastIndexOf('.');
            
                    //temp.getName().lastIndexOf("\\.")
            String nFile[] = temp.getName().split("\\.");
            int et = nFile.length;
            String ex= temp.getName().substring(extension+1);
            String tname = temp.getName().substring(0, extension);
//            for (int i=0; i < et-1;i++){
//                tname += nFile[i];
//            }
            
            Documents d = new Documents(pk,tname,"."+ex,"priv");
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
            //System.out.println("contenu "+ userText.getText()+" pass "+ String.valueOf(passwordText.getPassword()));            
        }

        //SwingUtilities.invokeLater(doRun);
    }
}
