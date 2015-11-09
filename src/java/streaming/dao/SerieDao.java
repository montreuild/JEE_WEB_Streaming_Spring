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
import streaming.entity.Serie;



/**
 *
 * @author ETY
 */
public class SerieDao {
    
     String strEM= "StreamingPU";
    
    public void insert(Serie f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();                  
    }
    
    public void update(Serie f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();                  
    }
    
    public void delete(long serieId){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            Serie seriedelete=em.find(Serie.class,serieId);
            em.remove(seriedelete);
            em.getTransaction().commit();                  
    }
    
    public Serie find(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        Serie serie=em.find(Serie.class, id);
        em.getTransaction().commit();
        
        return serie;
    }
    
    
    public List<Serie> list(){
        
        List<Serie> listserie =new ArrayList<Serie>();
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("select f from Serie f");

	List<Serie> listeserierecup=query.getResultList();
	for (Serie serie : listeserierecup) {
		listserie.add(serie);
        }
        
        em.getTransaction().commit();

        return listserie;    
    }
    
    
}
