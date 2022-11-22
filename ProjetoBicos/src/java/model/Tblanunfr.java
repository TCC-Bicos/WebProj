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
@Table(name = "tblanunfr")
@NamedQueries({
@NamedQuery(name = "Tblanunfr.findAll", query = "SELECT t FROM Tblanunfr t"),
    @NamedQuery(name = "Tblanunfr.findByIdAnunFr", query = "SELECT t FROM Tblanunfr t WHERE t.idAnunFr = :id"),
    @NamedQuery(name = "Tblanunfr.findByIdFr", query = "SELECT t FROM Tblanunfr t WHERE t.idFr = :id"),
    @NamedQuery(name = "Tblanunfr.findByTituloAnunFr", query = "SELECT t FROM Tblanunfr t WHERE t.tituloAnunFr LIKE :tituloAnunFr"),
    @NamedQuery(name = "Tblanunfr.findByDescAnunFr", query = "SELECT t FROM Tblanunfr t WHERE t.descAnunFr = :descAnunFr"),
    @NamedQuery(name = "Tblanunfr.findByPrecoAnunFr", query = "SELECT t FROM Tblanunfr t WHERE t.precoAnunFr = :precoAnunFr"),
    @NamedQuery(name = "Tblanunfr.findByImgAnunFr", query = "SELECT t FROM Tblanunfr t WHERE t.imgAnunFr = :imgAnunFr"),
    @NamedQuery(name = "Tblanunfr.findByStatusAnunFr", query = "SELECT t FROM Tblanunfr t WHERE t.statusAnunFr = :statusAnunFr"),
    @NamedQuery(name = "Tblanunfr.findByDataAnunFr", query = "SELECT t FROM Tblanunfr t WHERE t.dataAnunFr = :dataAnunFr")})
public class Tblanunfr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnunFr")
    private Integer idAnunFr;
    @Column(name = "TituloAnunFr")
    private String tituloAnunFr;
    @Column(name = "DescAnunFr")
    private String descAnunFr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrecoAnunFr")
    private Double precoAnunFr;
    @Column(name = "ImgAnunFr")
    private String imgAnunFr;
    @Column(name = "StatusAnunFr")
    private Boolean statusAnunFr;
    @Column(name = "DataAnunFr")
    @Temporal(TemporalType.DATE)
    private Date dataAnunFr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunFr", fetch = FetchType.EAGER)
    private List<Tblanunfruser> tblanunfruserList;
    @JoinColumn(name = "idFr", referencedColumnName = "idFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblfreelancer idFr;
    @JoinColumn(name = "NomeServ", referencedColumnName = "NomeServ")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tbltiposervico nomeServ;

    public Tblanunfr() {
    }

    public Tblanunfr(Integer idAnunFr) {
        this.idAnunFr = idAnunFr;
    }

    public Integer getIdAnunFr() {
        return idAnunFr;
    }

    public void setIdAnunFr(Integer idAnunFr) {
        this.idAnunFr = idAnunFr;
    }

    public String getTituloAnunFr() {
        return tituloAnunFr;
    }

    public void setTituloAnunFr(String tituloAnunFr) {
        this.tituloAnunFr = tituloAnunFr;
    }

    public String getDescAnunFr() {
        return descAnunFr;
    }

    public void setDescAnunFr(String descAnunFr) {
        this.descAnunFr = descAnunFr;
    }

    public Double getPrecoAnunFr() {
        return precoAnunFr;
    }

    public void setPrecoAnunFr(Double precoAnunFr) {
        this.precoAnunFr = precoAnunFr;
    }

    public String getImgAnunFr() {
        return imgAnunFr;
    }

    public void setImgAnunFr(String imgAnunFr) {
        this.imgAnunFr = imgAnunFr;
    }

    public Boolean getStatusAnunFr() {
        return statusAnunFr;
    }

    public void setStatusAnunFr(Boolean statusAnunFr) {
        this.statusAnunFr = statusAnunFr;
    }

    public Date getDataAnunFr() {
        return dataAnunFr;
    }

    public void setDataAnunFr(Date dataAnunFr) {
        this.dataAnunFr = dataAnunFr;
    }

    public List<Tblanunfruser> getTblanunfruserList() {
        return tblanunfruserList;
    }

    public void setTblanunfruserList(List<Tblanunfruser> tblanunfruserList) {
        this.tblanunfruserList = tblanunfruserList;
    }

    public Tblfreelancer getIdFr() {
        return idFr;
    }

    public void setIdFr(Tblfreelancer idFr) {
        this.idFr = idFr;
    }

    public Tbltiposervico getNomeServ() {
        return nomeServ;
    }

    public void setNomeServ(Tbltiposervico nomeServ) {
        this.nomeServ = nomeServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnunFr != null ? idAnunFr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblanunfr)) {
            return false;
        }
        Tblanunfr other = (Tblanunfr) object;
        if ((this.idAnunFr == null && other.idAnunFr != null) || (this.idAnunFr != null && !this.idAnunFr.equals(other.idAnunFr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblanunfr[ idAnunFr=" + idAnunFr + " ]";
    }
    
}
