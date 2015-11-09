/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.EpisodeDao;
import streaming.entity.Episode;

/**
 *
 * @author ETY
 */
public class EpisodeService {
    
    EpisodeDao episodedao = new EpisodeDao();
    
    
    public void insert(Episode f){
        episodedao.insert(f);
    }
    
    public void update(Episode f){
        episodedao.update(f);
    }

    public void delete(long episodeId){
        episodedao.delete(episodeId);
    }
    
    public Episode find(long id){
        return episodedao.find(id);
    }
    
    public List<Episode> list(){
        return episodedao.list();
    }

}
