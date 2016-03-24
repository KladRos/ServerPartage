/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partage.modele;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author user6
 */
public class  Transaction {
    public Transaction(String n,String p){
        Transaction.getConnexion("jim", "jim");
    }
    public static boolean getConnexion(String n,String p){
        //String name = JOptionPane.showInputDialog("veuillez entrer votre nom");
        //String pass = JOptionPane.showInputDialog("veuillez entrer votre nom");
        String name = JOptionPane.showInputDialog("veuillez entrer votre nom");
        String pass = JOptionPane.showInputDialog("veuillez entrer votre nom");
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Partage_FichierPU");
        EntityManager em = emf.createEntityManager();
        List l = em.createNamedQuery("User.findByUserPassword").setParameter("username", n).setParameter("password", p).getResultList();

        if (l.size() <= 0)
           return true;
        else
          return false;
    }
    public static void main(String args[])
	 {
             //Transaction t = new Transaction();
         }
}
