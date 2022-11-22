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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblanunfruser")
@NamedQueries({
    @NamedQuery(name = "Tblanunfruser.findAll", query = "SELECT t FROM Tblanunfruser t"),
    @NamedQuery(name = "Tblanunfruser.findByIdAnunFrUser", query = "SELECT t FROM Tblanunfruser t WHERE t.idAnunFrUser = :idAnunFrUser")})
public class Tblanunfruser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnunFrUser")
    private Integer idAnunFrUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunFrUser", fetch = FetchType.EAGER)
    private List<Tblpagamentoprojfr> tblpagamentoprojfrList;
    @JoinColumn(name = "idAnunFr", referencedColumnName = "idAnunFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunfr idAnunFr;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblusuario idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunFrUser", fetch = FetchType.EAGER)
    private List<TblnotiuF> tblnotiuFList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunFrUser", fetch = FetchType.EAGER)
    private List<Tblprojanunfr> tblprojanunfrList;

    public Tblanunfruser() {
    }

    public Tblanunfruser(Integer idAnunFrUser) {
        this.idAnunFrUser = idAnunFrUser;
    }

    public Integer getIdAnunFrUser() {
        return idAnunFrUser;
    }

    public void setIdAnunFrUser(Integer idAnunFrUser) {
        this.idAnunFrUser = idAnunFrUser;
    }

    public List<Tblpagamentoprojfr> getTblpagamentoprojfrList() {
        return tblpagamentoprojfrList;
    }

    public void setTblpagamentoprojfrList(List<Tblpagamentoprojfr> tblpagamentoprojfrList) {
        this.tblpagamentoprojfrList = tblpagamentoprojfrList;
    }

    public Tblanunfr getIdAnunFr() {
        return idAnunFr;
    }

    public void setIdAnunFr(Tblanunfr idAnunFr) {
        this.idAnunFr = idAnunFr;
    }

    public Tblusuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Tblusuario idUser) {
        this.idUser = idUser;
    }

    public List<TblnotiuF> getTblnotiuFList() {
        return tblnotiuFList;
    }

    public void setTblnotiuFList(List<TblnotiuF> tblnotiuFList) {
        this.tblnotiuFList = tblnotiuFList;
    }

    public List<Tblprojanunfr> getTblprojanunfrList() {
        return tblprojanunfrList;
    }

    public void setTblprojanunfrList(List<Tblprojanunfr> tblprojanunfrList) {
        this.tblprojanunfrList = tblprojanunfrList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnunFrUser != null ? idAnunFrUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblanunfruser)) {
            return false;
        }
        Tblanunfruser other = (Tblanunfruser) object;
        if ((this.idAnunFrUser == null && other.idAnunFrUser != null) || (this.idAnunFrUser != null && !this.idAnunFrUser.equals(other.idAnunFrUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblanunfruser[ idAnunFrUser=" + idAnunFrUser + " ]";
    }
    
}
