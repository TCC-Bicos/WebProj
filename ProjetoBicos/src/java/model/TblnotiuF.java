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
@Table(name = "tblnotiu_f")
@NamedQueries({
@NamedQuery(name = "TblnotiuF.findAll", query = "SELECT t FROM TblnotiuF t"),
    @NamedQuery(name = "TblnotiuF.findByIdNotiUF", query = "SELECT t FROM TblnotiuF t WHERE t.idNotiUF = :idNotiUF"),
    @NamedQuery(name = "TblnotiuF.findByIdAnunUserFr", query = "SELECT t FROM TblnotiuF t WHERE t.idAnunFrUser = :id"),
    @NamedQuery(name = "TblnotiuF.findByTipoNotiUF", query = "SELECT t FROM TblnotiuF t WHERE t.tipoNotiUF = :tipoNotiUF"),
    @NamedQuery(name = "TblnotiuF.findByMensagemNotiUF", query = "SELECT t FROM TblnotiuF t WHERE t.mensagemNotiUF = :mensagemNotiUF")})
public class TblnotiuF implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotiUF")
    private Integer idNotiUF;
    @Column(name = "TipoNotiUF")
    private String tipoNotiUF;
    @Basic(optional = false)
    @Column(name = "MensagemNotiUF")
    private String mensagemNotiUF;
    @JoinColumn(name = "idAnunFrUser", referencedColumnName = "idAnunFrUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblanunfruser idAnunFrUser;

    public TblnotiuF() {
    }

    public TblnotiuF(Integer idNotiUF) {
        this.idNotiUF = idNotiUF;
    }

    public TblnotiuF(Integer idNotiUF, String mensagemNotiUF) {
        this.idNotiUF = idNotiUF;
        this.mensagemNotiUF = mensagemNotiUF;
    }

    public Integer getIdNotiUF() {
        return idNotiUF;
    }

    public void setIdNotiUF(Integer idNotiUF) {
        this.idNotiUF = idNotiUF;
    }

    public String getTipoNotiUF() {
        return tipoNotiUF;
    }

    public void setTipoNotiUF(String tipoNotiUF) {
        this.tipoNotiUF = tipoNotiUF;
    }

    public String getMensagemNotiUF() {
        return mensagemNotiUF;
    }

    public void setMensagemNotiUF(String mensagemNotiUF) {
        this.mensagemNotiUF = mensagemNotiUF;
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
        hash += (idNotiUF != null ? idNotiUF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblnotiuF)) {
            return false;
        }
        TblnotiuF other = (TblnotiuF) object;
        if ((this.idNotiUF == null && other.idNotiUF != null) || (this.idNotiUF != null && !this.idNotiUF.equals(other.idNotiUF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TblnotiuF[ idNotiUF=" + idNotiUF + " ]";
    }
    
}
