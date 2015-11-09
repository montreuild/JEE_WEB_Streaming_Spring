/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import streaming.dao.FilmDAO;
import streaming.entity.Film;
import streaming.spring.SpringConfig;

/**
 *
 * @author ETY
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)

public class FilmDAOTest {

    @Autowired
    private FilmDAO dao;

    @Before
    @Transactional
    public void setUp() {

        //Supprimer tous les films
        dao.deleteAll();

        //Ajouter 2 films
        dao.save(new Film(1L, "rambo", "blama", 1985, 90));
        dao.save(new Film(2L, "rambo le come back", "bloum", 1987, 95));
    }

    @Test
    public void film1isRamboOk() {
        Assert.assertEquals("rambo", dao.findOne(1L).getTitre());
    }

}
