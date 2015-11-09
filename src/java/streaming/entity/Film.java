/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ETY
 */
@Entity
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titre;

    private String synopsis;

    private Integer annee;

    private Integer duree;

    @OneToMany(mappedBy = "film")
    private List<Lien> liens = new ArrayList<Lien>();

    @JoinTable(name = "films_pays")
    @ManyToMany
    private List<Pays> listepays = new ArrayList<Pays>();

    @JoinTable(name = "films_realisateurs")
    @ManyToMany
    private List<Personne> listerealisateurs = new ArrayList<Personne>();

    @JoinTable(name = "films_acteurs")
    @ManyToMany
    private List<Personne> listeacteurs = new ArrayList<Personne>();

    public Film() {
    }
        
    public Film(Long id, String titre,String synopsis, Integer annee, Integer duree) {
        this.id = id;
        this.titre = titre;
        this.synopsis=synopsis;
        this.annee = annee;
        this.duree = duree;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public List<Lien> getLiens() {
        return liens;
    }

    public void setLiens(List<Lien> liens) {
        this.liens = liens;
    }

    public List<Pays> getListepays() {
        return listepays;
    }

    public void setListepays(List<Pays> listepays) {
        this.listepays = listepays;
    }

    public List<Personne> getListerealisateurs() {
        return listerealisateurs;
    }

    public void setListerealisateurs(List<Personne> listerealisateurs) {
        this.listerealisateurs = listerealisateurs;
    }

    public List<Personne> getListeacteurs() {
        return listeacteurs;
    }

    public void setListeacteurs(List<Personne> listeacteurs) {
        this.listeacteurs = listeacteurs;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Film[ id=" + id + " ]";
    }

}
