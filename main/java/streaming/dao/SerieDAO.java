package streaming.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.data.repository.CrudRepository;
import streaming.entity.Serie;

/**
 *
 * @author ETY
 */
public interface SerieDAO extends CrudRepository<Serie, Long>{
    
}
