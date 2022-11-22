/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tbltiposervico")
@NamedQueries({
    @NamedQuery(name = "Tbltiposervico.findAll", query = "SELECT t FROM Tbltiposervico t"),
    @NamedQuery(name = "Tbltiposervico.findByNomeServ", query = "SELECT t FROM Tbltiposervico t WHERE t.nomeServ = :nomeServ"),
    @NamedQuery(name = "Tbltiposervico.findByCategoriaServ", query = "SELECT t FROM Tbltiposervico t WHERE t.categoriaServ = :categoriaServ")})
public class Tbltiposervico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeServ")
    private String nomeServ;
    @Column(name = "CategoriaServ")
    private String categoriaServ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomeServ", fetch = FetchType.EAGER)
    private List<Tblanunuser> tblanunuserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomeServ", fetch = FetchType.EAGER)
    private List<Tblanunfr> tblanunfrList;

    public Tbltiposervico() {
    }

    public Tbltiposervico(String nomeServ) {
        this.nomeServ = nomeServ;
    }

    public String getNomeServ() {
        return nomeServ;
    }

    public void setNomeServ(String nomeServ) {
        this.nomeServ = nomeServ;
    }

    public String getCategoriaServ() {
        return categoriaServ;
    }

    public void setCategoriaServ(String categoriaServ) {
        this.categoriaServ = categoriaServ;
    }

    public List<Tblanunuser> getTblanunuserList() {
        return tblanunuserList;
    }

    public void setTblanunuserList(List<Tblanunuser> tblanunuserList) {
        this.tblanunuserList = tblanunuserList;
    }

    public List<Tblanunfr> getTblanunfrList() {
        return tblanunfrList;
    }

    public void setTblanunfrList(List<Tblanunfr> tblanunfrList) {
        this.tblanunfrList = tblanunfrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeServ != null ? nomeServ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbltiposervico)) {
            return false;
        }
        Tbltiposervico other = (Tbltiposervico) object;
        if ((this.nomeServ == null && other.nomeServ != null) || (this.nomeServ != null && !this.nomeServ.equals(other.nomeServ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tbltiposervico[ nomeServ=" + nomeServ + " ]";
    }
    
}
