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
@Table(name = "tblanunuserfr")
@NamedQueries({
@NamedQuery(name = "Tblanunuserfr.findAll", query = "SELECT t FROM Tblanunuserfr t"),
    @NamedQuery(name = "Tblanunuserfr.findByIdAnunUserFr", query = "SELECT t FROM Tblanunuserfr t WHERE t.idAnunUserFr = :idAnunUserFr"),
    @NamedQuery(name = "Tblanunuserfr.findByIdFr", query = "SELECT t FROM Tblanunuserfr t WHERE t.idFr = :idFr")})
public class Tblanunuserfr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnunUserFr")
    private Integer idAnunUserFr;
    @Column(name = "NomeAnunUser")
    private String nomeAnunUser;
    @Column(name = "DescAnunUser")
    private String descAnunUser;
    @JoinColumn(name = "idAnunUser", referencedColumnName = "idAnunUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunuser idAnunUser;
    @JoinColumn(name = "idFr", referencedColumnName = "idFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblfreelancer idFr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunUserFr", fetch = FetchType.EAGER)
    private List<Tblpagamentoprojuser> tblpagamentoprojuserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunUserFr", fetch = FetchType.EAGER)
    private List<TblnotifU> tblnotifUList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunUserFr", fetch = FetchType.EAGER)
    private List<Tblprojanunuser> tblprojanunuserList;

    public Tblanunuserfr() {
    }

    public Tblanunuserfr(Integer idAnunUserFr) {
        this.idAnunUserFr = idAnunUserFr;
    }

    public Integer getIdAnunUserFr() {
        return idAnunUserFr;
    }

    public void setIdAnunUserFr(Integer idAnunUserFr) {
        this.idAnunUserFr = idAnunUserFr;
    }

    public String getNomeAnunUser() {
        return nomeAnunUser;
    }

    public void setNomeAnunUser(String nomeAnunUser) {
        this.nomeAnunUser = nomeAnunUser;
    }

    public String getDescAnunUser() {
        return descAnunUser;
    }

    public void setDescAnunUser(String descAnunUser) {
        this.descAnunUser = descAnunUser;
    }

    public Tblanunuser getIdAnunUser() {
        return idAnunUser;
    }

    public void setIdAnunUser(Tblanunuser idAnunUser) {
        this.idAnunUser = idAnunUser;
    }

    public Tblfreelancer getIdFr() {
        return idFr;
    }

    public void setIdFr(Tblfreelancer idFr) {
        this.idFr = idFr;
    }

    public List<Tblpagamentoprojuser> getTblpagamentoprojuserList() {
        return tblpagamentoprojuserList;
    }

    public void setTblpagamentoprojuserList(List<Tblpagamentoprojuser> tblpagamentoprojuserList) {
        this.tblpagamentoprojuserList = tblpagamentoprojuserList;
    }

    public List<TblnotifU> getTblnotifUList() {
        return tblnotifUList;
    }

    public void setTblnotifUList(List<TblnotifU> tblnotifUList) {
        this.tblnotifUList = tblnotifUList;
    }

    public List<Tblprojanunuser> getTblprojanunuserList() {
        return tblprojanunuserList;
    }

    public void setTblprojanunuserList(List<Tblprojanunuser> tblprojanunuserList) {
        this.tblprojanunuserList = tblprojanunuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnunUserFr != null ? idAnunUserFr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblanunuserfr)) {
            return false;
        }
        Tblanunuserfr other = (Tblanunuserfr) object;
        if ((this.idAnunUserFr == null && other.idAnunUserFr != null) || (this.idAnunUserFr != null && !this.idAnunUserFr.equals(other.idAnunUserFr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblanunuserfr[ idAnunUserFr=" + idAnunUserFr + " ]";
    }
    
}
