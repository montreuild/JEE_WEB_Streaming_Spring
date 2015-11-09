/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.PaysDao;
import streaming.entity.Pays;

/**
 *
 * @author ETY
 */
public class PaysService {
    
    PaysDao paysdao = new PaysDao();
    
    
    public void insert(Pays f){
        paysdao.insert(f);
    }
    
    public void update(Pays f){
        paysdao.update(f);
    }

    public void delete(long paysId){
        paysdao.delete(paysId);
    }
    
    public Pays find(long id){
        return paysdao.find(id);
    }
    
    public List<Pays> list(){
        return paysdao.list();
    }

}
