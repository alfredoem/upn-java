package com.mycompany.comercioxpressmaven;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author alfredo
 */
public class AddedData {


    public static void main(String[] args) {
       
        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory("com.mycompany_ComercioXpressMaven_jar_1.0-SNAPSHOTPU");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        Book book = new Book();
        book.setName("Crime and Punishment");
        entityManager.persist(book);
        
        Book book2 = new Book();
        book2.setName("The king Lear");
        entityManager.persist(book2);
        
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();     
        
    }
    
}
