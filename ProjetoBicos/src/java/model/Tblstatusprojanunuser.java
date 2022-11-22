/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblstatusprojanunuser")
@NamedQueries({
    @NamedQuery(name = "Tblstatusprojanunuser.findAll", query = "SELECT t FROM Tblstatusprojanunuser t"),
    @NamedQuery(name = "Tblstatusprojanunuser.findByIdStatusProjAnunUser", query = "SELECT t FROM Tblstatusprojanunuser t WHERE t.idStatusProjAnunUser = :idStatusProjAnunUser"),
    @NamedQuery(name = "Tblstatusprojanunuser.findByStatusProjAnunUser", query = "SELECT t FROM Tblstatusprojanunuser t WHERE t.statusProjAnunUser = :statusProjAnunUser"),
    @NamedQuery(name = "Tblstatusprojanunuser.findByDiasAtrasadosStatusProjAnunUser", query = "SELECT t FROM Tblstatusprojanunuser t WHERE t.diasAtrasadosStatusProjAnunUser = :diasAtrasadosStatusProjAnunUser")})
public class Tblstatusprojanunuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStatusProjAnunUser")
    private Integer idStatusProjAnunUser;
    @Column(name = "StatusProjAnunUser")
    private Boolean statusProjAnunUser;
    @Column(name = "DiasAtrasadosStatusProjAnunUser")
    private Integer diasAtrasadosStatusProjAnunUser;
    @JoinColumn(name = "idProjAnunUser", referencedColumnName = "idProjAnunUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblprojanunuser idProjAnunUser;

    public Tblstatusprojanunuser() {
    }

    public Tblstatusprojanunuser(Integer idStatusProjAnunUser) {
        this.idStatusProjAnunUser = idStatusProjAnunUser;
    }

    public Integer getIdStatusProjAnunUser() {
        return idStatusProjAnunUser;
    }

    public void setIdStatusProjAnunUser(Integer idStatusProjAnunUser) {
        this.idStatusProjAnunUser = idStatusProjAnunUser;
    }

    public Boolean getStatusProjAnunUser() {
        return statusProjAnunUser;
    }

    public void setStatusProjAnunUser(Boolean statusProjAnunUser) {
        this.statusProjAnunUser = statusProjAnunUser;
    }

    public Integer getDiasAtrasadosStatusProjAnunUser() {
        return diasAtrasadosStatusProjAnunUser;
    }

    public void setDiasAtrasadosStatusProjAnunUser(Integer diasAtrasadosStatusProjAnunUser) {
        this.diasAtrasadosStatusProjAnunUser = diasAtrasadosStatusProjAnunUser;
    }

    public Tblprojanunuser getIdProjAnunUser() {
        return idProjAnunUser;
    }

    public void setIdProjAnunUser(Tblprojanunuser idProjAnunUser) {
        this.idProjAnunUser = idProjAnunUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusProjAnunUser != null ? idStatusProjAnunUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblstatusprojanunuser)) {
            return false;
        }
        Tblstatusprojanunuser other = (Tblstatusprojanunuser) object;
        if ((this.idStatusProjAnunUser == null && other.idStatusProjAnunUser != null) || (this.idStatusProjAnunUser != null && !this.idStatusProjAnunUser.equals(other.idStatusProjAnunUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblstatusprojanunuser[ idStatusProjAnunUser=" + idStatusProjAnunUser + " ]";
    }
    
}
