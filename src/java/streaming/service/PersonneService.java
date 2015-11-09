/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.PersonneDao;
import streaming.entity.Personne;

/**
 *
 * @author ETY
 */
public class PersonneService {
    
    PersonneDao personnedao = new PersonneDao();
    
    
    public void insert(Personne f){
        personnedao.insert(f);
    }
    
    public void update(Personne f){
        personnedao.update(f);
    }

    public void delete(long personneId){
        personnedao.delete(personneId);
    }
    
    public Personne find(long id){
        return personnedao.find(id);
    }
    
    public List<Personne> list(){
        return personnedao.list();
    }

}
