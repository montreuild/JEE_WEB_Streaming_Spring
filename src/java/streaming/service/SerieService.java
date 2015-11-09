/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.SerieDao;
import streaming.entity.Serie;

/**
 *
 * @author ETY
 */
public class SerieService {
    
    SerieDao seriedao = new SerieDao();
    
    
    public void insert(Serie f){
        seriedao.insert(f);
    }
    
    public void update(Serie f){
        seriedao.update(f);
    }

    public void delete(long serieId){
        seriedao.delete(serieId);
    }
    
    public Serie find(long id){
        return seriedao.find(id);
    }
    
    public List<Serie> list(){
        return seriedao.list();
    }

}
