/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblprojanunfr")
@NamedQueries({
    @NamedQuery(name = "Tblprojanunfr.findAll", query = "SELECT t FROM Tblprojanunfr t"),
    @NamedQuery(name = "Tblprojanunfr.findByIdProjAnunFr", query = "SELECT t FROM Tblprojanunfr t WHERE t.idProjAnunFr = :idProjAnunFr"),
    @NamedQuery(name = "Tblprojanunfr.findByDataInicioProjAnunFr", query = "SELECT t FROM Tblprojanunfr t WHERE t.dataInicioProjAnunFr = :dataInicioProjAnunFr"),
    @NamedQuery(name = "Tblprojanunfr.findByDataFinalProjAnunFr", query = "SELECT t FROM Tblprojanunfr t WHERE t.dataFinalProjAnunFr = :dataFinalProjAnunFr")})
public class Tblprojanunfr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProjAnunFr")
    private Integer idProjAnunFr;
    @Column(name = "DataInicioProjAnunFr")
    @Temporal(TemporalType.DATE)
    private Date dataInicioProjAnunFr;
    @Column(name = "DataFinalProjAnunFr")
    @Temporal(TemporalType.DATE)
    private Date dataFinalProjAnunFr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjAnunFr", fetch = FetchType.EAGER)
    private List<Tblchatprojanunfr> tblchatprojanunfrList;
    @JoinColumn(name = "idAnunFrUser", referencedColumnName = "idAnunFrUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunfruser idAnunFrUser;

    public Tblprojanunfr() {
    }

    public Tblprojanunfr(Integer idProjAnunFr) {
        this.idProjAnunFr = idProjAnunFr;
    }

    public Integer getIdProjAnunFr() {
        return idProjAnunFr;
    }

    public void setIdProjAnunFr(Integer idProjAnunFr) {
        this.idProjAnunFr = idProjAnunFr;
    }

    public Date getDataInicioProjAnunFr() {
        return dataInicioProjAnunFr;
    }

    public void setDataInicioProjAnunFr(Date dataInicioProjAnunFr) {
        this.dataInicioProjAnunFr = dataInicioProjAnunFr;
    }

    public Date getDataFinalProjAnunFr() {
        return dataFinalProjAnunFr;
    }

    public void setDataFinalProjAnunFr(Date dataFinalProjAnunFr) {
        this.dataFinalProjAnunFr = dataFinalProjAnunFr;
    }

    public List<Tblchatprojanunfr> getTblchatprojanunfrList() {
        return tblchatprojanunfrList;
    }

    public void setTblchatprojanunfrList(List<Tblchatprojanunfr> tblchatprojanunfrList) {
        this.tblchatprojanunfrList = tblchatprojanunfrList;
    }

    public Tblanunfruser getIdAnunFrUser() {
        return idAnunFrUser;
    }

    public void setIdAnunFrUser(Tblanunfruser idAnunFrUser) {
        this.idAnunFrUser = idAnunFrUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProjAnunFr != null ? idProjAnunFr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblprojanunfr)) {
            return false;
        }
        Tblprojanunfr other = (Tblprojanunfr) object;
        if ((this.idProjAnunFr == null && other.idProjAnunFr != null) || (this.idProjAnunFr != null && !this.idProjAnunFr.equals(other.idProjAnunFr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblprojanunfr[ idProjAnunFr=" + idProjAnunFr + " ]";
    }
    
}
