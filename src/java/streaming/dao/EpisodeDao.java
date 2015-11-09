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
import streaming.entity.Episode;



/**
 *
 * @author ETY
 */
public class EpisodeDao {
    
    String strEM= "StreamingPU";
    
    public void insert(Episode f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();                  
    }
    
    public void update(Episode f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();                  
    }
    
    public void delete(long episodeId){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            
            Query q = em.createQuery("DELETE FROM Episode e WHERE e.id=:critereid");
            q.setParameter("critereid", episodeId);
            q.executeUpdate();
       
            em.getTransaction().commit();                  
    }
    
    public Episode find(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        Episode episode=em.find(Episode.class, id);
        em.getTransaction().commit();
        
        return episode;
    }
    
    
    public List<Episode> list(){
        
        List<Episode> listepisode =new ArrayList<Episode>();
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("select f from Episode f");

	List<Episode> listeepisoderecup=query.getResultList();
	for (Episode episode : listeepisoderecup) {
		listepisode.add(episode);
        }
        
        em.getTransaction().commit();

        return listepisode;    
    }
    
    
}
