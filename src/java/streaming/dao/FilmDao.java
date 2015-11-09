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
import streaming.entity.Film;



/**
 *
 * @author ETY
 */
public class FilmDao {
    
    String strEM= "StreamingPU";
    
    public void insert(Film f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();                  
    }
    
    public void update(Film f){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();                  
    }
    
    public void delete(long filmId){
            
            EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
            
            em.getTransaction().begin();
            
            Query q = em.createQuery("DELETE FROM Film f WHERE f.id=:critereid");
            q.setParameter("critereid", filmId);
            q.executeUpdate();
       
            em.getTransaction().commit();                  
    }
    
    public Film find(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        Film film=em.find(Film.class, id);
        em.getTransaction().commit();
        
        return film;
    }
    
    
    public List<Film> list(){
        
        List<Film> listfilm =new ArrayList<Film>();
        
        EntityManager em = Persistence.createEntityManagerFactory(strEM).createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("select f from Film f");

	List<Film> listefilmrecup=query.getResultList();
	for (Film film : listefilmrecup) {
		listfilm.add(film);
        }
        
        em.getTransaction().commit();

        return listfilm;    
    }
    
    
}
