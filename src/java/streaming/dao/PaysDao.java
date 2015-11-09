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
import streaming.entity.Pays;



/**
 *
 * @author ETY
 */
public class PaysDao {
    
    String strEM= "StreamingPU";
    
    public void insert(Pays f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();                  
    }
    
    public void update(Pays f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();                  
    }
    
    public void delete(long paysId){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            
            Query q = em.createQuery("DELETE FROM Pays p WHERE p.id=:critereid");
            q.setParameter("critereid", paysId);
            q.executeUpdate();
       
            em.getTransaction().commit();                  
    }
    
    public Pays find(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        Pays pays=em.find(Pays.class, id);
        em.getTransaction().commit();
        
        return pays;
    }
    
    
    public List<Pays> list(){
        
        List<Pays> listpays =new ArrayList<Pays>();
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("select f from Pays f");

	List<Pays> listepaysrecup=query.getResultList();
	for (Pays pays : listepaysrecup) {
		listpays.add(pays);
        }
        
        em.getTransaction().commit();

        return listpays;    
    }
    
    
}
