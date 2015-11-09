/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.LienDao;
import streaming.entity.Lien;

/**
 *
 * @author ETY
 */
public class LienService {
    
    LienDao liendao = new LienDao();
    
    
    public void insert(Lien f){
        liendao.insert(f);
    }
    
    public void update(Lien f){
        liendao.update(f);
    }

    public void delete(long lienId){
        liendao.delete(lienId);
    }
    
    public Lien find(long id){
        return liendao.find(id);
    }
    
    public List<Lien> list(){
        return liendao.list();
    }

}
