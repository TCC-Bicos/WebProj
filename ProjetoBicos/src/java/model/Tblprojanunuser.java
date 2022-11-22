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
@Table(name = "tblprojanunuser")
@NamedQueries({
    @NamedQuery(name = "Tblprojanunuser.findAll", query = "SELECT t FROM Tblprojanunuser t"),
    @NamedQuery(name = "Tblprojanunuser.findByIdProjAnunUser", query = "SELECT t FROM Tblprojanunuser t WHERE t.idProjAnunUser = :idProjAnunUser"),
    @NamedQuery(name = "Tblprojanunuser.findByDataInicioProjAnunUser", query = "SELECT t FROM Tblprojanunuser t WHERE t.dataInicioProjAnunUser = :dataInicioProjAnunUser"),
    @NamedQuery(name = "Tblprojanunuser.findByDataFinalProjAnunUser", query = "SELECT t FROM Tblprojanunuser t WHERE t.dataFinalProjAnunUser = :dataFinalProjAnunUser")})
public class Tblprojanunuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProjAnunUser")
    private Integer idProjAnunUser;
    @Column(name = "DataInicioProjAnunUser")
    @Temporal(TemporalType.DATE)
    private Date dataInicioProjAnunUser;
    @Column(name = "DataFinalProjAnunUser")
    @Temporal(TemporalType.DATE)
    private Date dataFinalProjAnunUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjAnunUser", fetch = FetchType.EAGER)
    private List<Tblstatusprojanunuser> tblstatusprojanunuserList;
    @JoinColumn(name = "idAnunUserFr", referencedColumnName = "idAnunUserFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunuserfr idAnunUserFr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProjAnunUser", fetch = FetchType.EAGER)
    private List<Tblchatprojanunuser> tblchatprojanunuserList;

    public Tblprojanunuser() {
    }

    public Tblprojanunuser(Integer idProjAnunUser) {
        this.idProjAnunUser = idProjAnunUser;
    }

    public Integer getIdProjAnunUser() {
        return idProjAnunUser;
    }

    public void setIdProjAnunUser(Integer idProjAnunUser) {
        this.idProjAnunUser = idProjAnunUser;
    }

    public Date getDataInicioProjAnunUser() {
        return dataInicioProjAnunUser;
    }

    public void setDataInicioProjAnunUser(Date dataInicioProjAnunUser) {
        this.dataInicioProjAnunUser = dataInicioProjAnunUser;
    }

    public Date getDataFinalProjAnunUser() {
        return dataFinalProjAnunUser;
    }

    public void setDataFinalProjAnunUser(Date dataFinalProjAnunUser) {
        this.dataFinalProjAnunUser = dataFinalProjAnunUser;
    }

    public List<Tblstatusprojanunuser> getTblstatusprojanunuserList() {
        return tblstatusprojanunuserList;
    }

    public void setTblstatusprojanunuserList(List<Tblstatusprojanunuser> tblstatusprojanunuserList) {
        this.tblstatusprojanunuserList = tblstatusprojanunuserList;
    }

    public Tblanunuserfr getIdAnunUserFr() {
        return idAnunUserFr;
    }

    public void setIdAnunUserFr(Tblanunuserfr idAnunUserFr) {
        this.idAnunUserFr = idAnunUserFr;
    }

    public List<Tblchatprojanunuser> getTblchatprojanunuserList() {
        return tblchatprojanunuserList;
    }

    public void setTblchatprojanunuserList(List<Tblchatprojanunuser> tblchatprojanunuserList) {
        this.tblchatprojanunuserList = tblchatprojanunuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProjAnunUser != null ? idProjAnunUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblprojanunuser)) {
            return false;
        }
        Tblprojanunuser other = (Tblprojanunuser) object;
        if ((this.idProjAnunUser == null && other.idProjAnunUser != null) || (this.idProjAnunUser != null && !this.idProjAnunUser.equals(other.idProjAnunUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblprojanunuser[ idProjAnunUser=" + idProjAnunUser + " ]";
    }
    
}
