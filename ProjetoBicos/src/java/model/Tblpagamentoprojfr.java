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
@Table(name = "tblpagamentoprojfr")
@NamedQueries({
    @NamedQuery(name = "Tblpagamentoprojfr.findAll", query = "SELECT t FROM Tblpagamentoprojfr t"),
    @NamedQuery(name = "Tblpagamentoprojfr.findByIdPagamentoProjFr", query = "SELECT t FROM Tblpagamentoprojfr t WHERE t.idPagamentoProjFr = :idPagamentoProjFr"),
    @NamedQuery(name = "Tblpagamentoprojfr.findByValorPagamento", query = "SELECT t FROM Tblpagamentoprojfr t WHERE t.valorPagamento = :valorPagamento"),
    @NamedQuery(name = "Tblpagamentoprojfr.findByDataPagamento", query = "SELECT t FROM Tblpagamentoprojfr t WHERE t.dataPagamento = :dataPagamento")})
public class Tblpagamentoprojfr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPagamentoProjFr")
    private Integer idPagamentoProjFr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorPagamento")
    private Double valorPagamento;
    @Column(name = "DataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @JoinColumn(name = "idAnunFrUser", referencedColumnName = "idAnunFrUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunfruser idAnunFrUser;

    public Tblpagamentoprojfr() {
    }

    public Tblpagamentoprojfr(Integer idPagamentoProjFr) {
        this.idPagamentoProjFr = idPagamentoProjFr;
    }

    public Integer getIdPagamentoProjFr() {
        return idPagamentoProjFr;
    }

    public void setIdPagamentoProjFr(Integer idPagamentoProjFr) {
        this.idPagamentoProjFr = idPagamentoProjFr;
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

    public Tblanunfruser getIdAnunFrUser() {
        return idAnunFrUser;
    }

    public void setIdAnunFrUser(Tblanunfruser idAnunFrUser) {
        this.idAnunFrUser = idAnunFrUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamentoProjFr != null ? idPagamentoProjFr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblpagamentoprojfr)) {
            return false;
        }
        Tblpagamentoprojfr other = (Tblpagamentoprojfr) object;
        if ((this.idPagamentoProjFr == null && other.idPagamentoProjFr != null) || (this.idPagamentoProjFr != null && !this.idPagamentoProjFr.equals(other.idPagamentoProjFr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblpagamentoprojfr[ idPagamentoProjFr=" + idPagamentoProjFr + " ]";
    }
    
}
