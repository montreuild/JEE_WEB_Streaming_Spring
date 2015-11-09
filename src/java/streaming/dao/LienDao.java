/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import streaming.entity.Lien;

/**
 *
 * @author ETY
 */
public class LienDao {
    
    
    String strEM= "StreamingPU";
    
    public void insert(Lien l){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
 
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();                  
    }
 
    public void update(Lien l){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
 
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit(); 
        
    }
    
    public void delete(long lienId){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
 
            em.getTransaction().begin();
            Query q = em.createQuery("DELETE FROM Lien l where l.id=:critereid");
            q.setParameter("critereid", lienId);
            q.executeUpdate();
            em.getTransaction().commit(); 
        
    }
    
    public Lien find(long lienID){
        
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
 
            em.getTransaction().begin();
            Lien l= em.find(Lien.class,lienID);
            em.getTransaction().commit();
            return l;
    } 
      
    public List<Lien> list(){
        
            List<Lien> listlien=new ArrayList<Lien>();
        
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
 
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT l FROM Lien l");
            
            List<Lien> listlienrecup = q.getResultList();
            
            for(Lien lien : listlienrecup){
                listlien.add(lien);
            }
            em.getTransaction().commit();
            return listlien;
    } 
   
}
