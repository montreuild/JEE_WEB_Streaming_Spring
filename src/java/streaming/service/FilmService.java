/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.FilmDao;
import streaming.entity.Film;

/**
 *
 * @author ETY
 */
public class FilmService {
    
    FilmDao filmdao = new FilmDao();
    
    
    public void insert(Film f){
        filmdao.insert(f);
    }
    
    public void update(Film f){
        filmdao.update(f);
    }

    public void delete(long filmId){
        filmdao.delete(filmId);
    }
    
    public Film find(long id){
        return filmdao.find(id);
    }
    
    public List<Film> list(){
        return filmdao.list();
    }

}
