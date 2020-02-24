/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import entities.Address;
import entities.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jobe
 */
public class Tester {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    public static void main(String[] args) {
        
        Persistence.generateSchema("pu", null);

                
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin(); 
        
            Customer c1 = new Customer("Jønke", "Jørgensen");
            Address a1 = new Address("Bredgade 45", "København K");
            Address a2 = new Address("Østerbrogade 23", "København Ø");
            c1.addAdresses(a1);
            c1.addAdresses(a2);
            em.persist(c1);
            
            
        
        em.getTransaction().commit();
    
    }

}
