/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblpagamentoprojuser")
@NamedQueries({
    @NamedQuery(name = "Tblpagamentoprojuser.findAll", query = "SELECT t FROM Tblpagamentoprojuser t"),
    @NamedQuery(name = "Tblpagamentoprojuser.findByIdPagamentoProjUser", query = "SELECT t FROM Tblpagamentoprojuser t WHERE t.idPagamentoProjUser = :idPagamentoProjUser"),
    @NamedQuery(name = "Tblpagamentoprojuser.findByValorPagamento", query = "SELECT t FROM Tblpagamentoprojuser t WHERE t.valorPagamento = :valorPagamento"),
    @NamedQuery(name = "Tblpagamentoprojuser.findByDataPagamento", query = "SELECT t FROM Tblpagamentoprojuser t WHERE t.dataPagamento = :dataPagamento")})
public class Tblpagamentoprojuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPagamentoProjUser")
    private Integer idPagamentoProjUser;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorPagamento")
    private Double valorPagamento;
    @Column(name = "DataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @JoinColumn(name = "idAnunUserFr", referencedColumnName = "idAnunUserFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunuserfr idAnunUserFr;

    public Tblpagamentoprojuser() {
    }

    public Tblpagamentoprojuser(Integer idPagamentoProjUser) {
        this.idPagamentoProjUser = idPagamentoProjUser;
    }

    public Integer getIdPagamentoProjUser() {
        return idPagamentoProjUser;
    }

    public void setIdPagamentoProjUser(Integer idPagamentoProjUser) {
        this.idPagamentoProjUser = idPagamentoProjUser;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Tblanunuserfr getIdAnunUserFr() {
        return idAnunUserFr;
    }

    public void setIdAnunUserFr(Tblanunuserfr idAnunUserFr) {
        this.idAnunUserFr = idAnunUserFr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamentoProjUser != null ? idPagamentoProjUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblpagamentoprojuser)) {
            return false;
        }
        Tblpagamentoprojuser other = (Tblpagamentoprojuser) object;
        if ((this.idPagamentoProjUser == null && other.idPagamentoProjUser != null) || (this.idPagamentoProjUser != null && !this.idPagamentoProjUser.equals(other.idPagamentoProjUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblpagamentoprojuser[ idPagamentoProjUser=" + idPagamentoProjUser + " ]";
    }
    
}
