/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.SaisonDao;
import streaming.entity.Saison;

/**
 *
 * @author ETY
 */
public class SaisonService {
    
    SaisonDao saisondao = new SaisonDao();
    
    
    public void insert(Saison f){
        saisondao.insert(f);
    }
    
    public void update(Saison f){
        saisondao.update(f);
    }

    public void delete(long saisonId){
        saisondao.delete(saisonId);
    }
    
    public Saison find(long id){
        return saisondao.find(id);
    }
    
    public List<Saison> list(){
        return saisondao.list();
    }

}
