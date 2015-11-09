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
import streaming.entity.Saison;



/**
 *
 * @author ETY
 */
public class SaisonDao {
    
    String strEM= "StreamingPU";
    
    public void insert(Saison f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();                  
    }
    
    public void update(Saison f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();                  
    }
    
    public void delete(long saisonId){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            
            Query q = em.createQuery("DELETE FROM Saison s WHERE s.id=:critereid");
            q.setParameter("critereid", saisonId);
            q.executeUpdate();
       
            em.getTransaction().commit();                  
    }
    
    public Saison find(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        Saison saison=em.find(Saison.class, id);
        em.getTransaction().commit();
        
        return saison;
    }
    
    
    public List<Saison> list(){
        
        List<Saison> listsaison =new ArrayList<Saison>();
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("select f from Saison f");

	List<Saison> listesaisonrecup=query.getResultList();
	for (Saison saison : listesaisonrecup) {
		listsaison.add(saison);
        }
        
        em.getTransaction().commit();

        return listsaison;    
    }
    
    
}
