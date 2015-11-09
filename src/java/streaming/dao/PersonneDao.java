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
import streaming.entity.Personne;



/**
 *
 * @author ETY
 */
public class PersonneDao {
    
    String strEM= "StreamingPU";
    
    public void insert(Personne f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();                  
    }
    
    public void update(Personne f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();                  
    }
    
    public void delete(long personneId){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            
            Query q = em.createQuery("DELETE FROM Personne p WHERE p.id=:critereid");
            q.setParameter("critereid", personneId);
            q.executeUpdate();
       
            em.getTransaction().commit();                  
    }
    
    public Personne find(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        Personne personne=em.find(Personne.class, id);
        em.getTransaction().commit();
        
        return personne;
    }
    
    
    public List<Personne> list(){
        
        List<Personne> listpersonne =new ArrayList<Personne>();
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("select f from Personne f");

	List<Personne> listepersonnerecup=query.getResultList();
	for (Personne personne : listepersonnerecup) {
		listpersonne.add(personne);
        }
        
        em.getTransaction().commit();

        return listpersonne;    
    }
    
    
}
