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
@Table(name = "tblnotif_u")
@NamedQueries({
@NamedQuery(name = "TblnotifU.findAll", query = "SELECT t FROM TblnotifU t"),
    @NamedQuery(name = "TblnotifU.findByIdNotiFU", query = "SELECT t FROM TblnotifU t WHERE t.idNotiFU = :idNotiFU"),
    @NamedQuery(name = "TblnotifU.findByIdAnunUserFr", query = "SELECT t FROM TblnotifU t WHERE t.idAnunUserFr = :id"),
    @NamedQuery(name = "TblnotifU.findByTipoNotiFU", query = "SELECT t FROM TblnotifU t WHERE t.tipoNotiFU = :tipoNotiFU"),
    @NamedQuery(name = "TblnotifU.findByMensagemNotiFU", query = "SELECT t FROM TblnotifU t WHERE t.mensagemNotiFU = :mensagemNotiFU")})
public class TblnotifU implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotiFU")
    private Integer idNotiFU;
    @Column(name = "TipoNotiFU")
    private String tipoNotiFU;
    @Basic(optional = false)
    @Column(name = "MensagemNotiFU")
    private String mensagemNotiFU;
    @JoinColumn(name = "idAnunUserFr", referencedColumnName = "idAnunUserFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunuserfr idAnunUserFr;

    public TblnotifU() {
    }

    public TblnotifU(Integer idNotiFU) {
        this.idNotiFU = idNotiFU;
    }

    public TblnotifU(Integer idNotiFU, String mensagemNotiFU) {
        this.idNotiFU = idNotiFU;
        this.mensagemNotiFU = mensagemNotiFU;
    }

    public Integer getIdNotiFU() {
        return idNotiFU;
    }

    public void setIdNotiFU(Integer idNotiFU) {
        this.idNotiFU = idNotiFU;
    }

    public String getTipoNotiFU() {
        return tipoNotiFU;
    }

    public void setTipoNotiFU(String tipoNotiFU) {
        this.tipoNotiFU = tipoNotiFU;
    }

    public String getMensagemNotiFU() {
        return mensagemNotiFU;
    }

    public void setMensagemNotiFU(String mensagemNotiFU) {
        this.mensagemNotiFU = mensagemNotiFU;
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
        hash += (idNotiFU != null ? idNotiFU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblnotifU)) {
            return false;
        }
        TblnotifU other = (TblnotifU) object;
        if ((this.idNotiFU == null && other.idNotiFU != null) || (this.idNotiFU != null && !this.idNotiFU.equals(other.idNotiFU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblnotifU[ idNotiFU=" + idNotiFU + " ]";
    }
    
}
