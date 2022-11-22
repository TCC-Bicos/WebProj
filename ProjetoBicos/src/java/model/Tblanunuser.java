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
@Table(name = "tblanunuser")
@NamedQueries({
@NamedQuery(name = "Tblanunuser.findAll", query = "SELECT t FROM Tblanunuser t"),
    @NamedQuery(name = "Tblanunuser.findByIdAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.idAnunUser = :id"),
    @NamedQuery(name = "Tblanunuser.findByIdUser", query = "SELECT t FROM Tblanunuser t WHERE t.idUser = :id"),
    @NamedQuery(name = "Tblanunuser.findByTituloAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.tituloAnunUser = :tituloAnunUser"),
    @NamedQuery(name = "Tblanunuser.findByDescAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.descAnunUser = :descAnunUser"),
    @NamedQuery(name = "Tblanunuser.findByPrecoAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.precoAnunUser = :precoAnunUser"),
    @NamedQuery(name = "Tblanunuser.findByRequisitosAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.requisitosAnunUser = :requisitosAnunUser"),
    @NamedQuery(name = "Tblanunuser.findByImgAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.imgAnunUser = :imgAnunUser"),
    @NamedQuery(name = "Tblanunuser.findByStatusAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.statusAnunUser = :statusAnunUser"),
    @NamedQuery(name = "Tblanunuser.findByDataAnunUser", query = "SELECT t FROM Tblanunuser t WHERE t.dataAnunUser = :dataAnunUser")})
public class Tblanunuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnunUser")
    private Integer idAnunUser;
    @Basic(optional = false)
    @Column(name = "TituloAnunUser")
    private String tituloAnunUser;
    @Basic(optional = false)
    @Column(name = "DescAnunUser")
    private String descAnunUser;
    @Basic(optional = false)
    @Column(name = "PrecoAnunUser")
    private double precoAnunUser;
    @Basic(optional = false)
    @Column(name = "RequisitosAnunUser")
    private String requisitosAnunUser;
    @Column(name = "ImgAnunUser")
    private String imgAnunUser;
    @Column(name = "StatusAnunUser")
    private Boolean statusAnunUser;
    @Column(name = "DataAnunUser")
    @Temporal(TemporalType.DATE)
    private Date dataAnunUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnunUser", fetch = FetchType.EAGER)
    private List<Tblanunuserfr> tblanunuserfrList;
    @JoinColumn(name = "NomeServ", referencedColumnName = "NomeServ")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tbltiposervico nomeServ;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblusuario idUser;

    public Tblanunuser() {
    }

    public Tblanunuser(Integer idAnunUser) {
        this.idAnunUser = idAnunUser;
    }

    public Tblanunuser(Integer idAnunUser, String tituloAnunUser, String descAnunUser, double precoAnunUser, String requisitosAnunUser) {
        this.idAnunUser = idAnunUser;
        this.tituloAnunUser = tituloAnunUser;
        this.descAnunUser = descAnunUser;
        this.precoAnunUser = precoAnunUser;
        this.requisitosAnunUser = requisitosAnunUser;
    }

    public Integer getIdAnunUser() {
        return idAnunUser;
    }

    public void setIdAnunUser(Integer idAnunUser) {
        this.idAnunUser = idAnunUser;
    }

    public String getTituloAnunUser() {
        return tituloAnunUser;
    }

    public void setTituloAnunUser(String tituloAnunUser) {
        this.tituloAnunUser = tituloAnunUser;
    }

    public String getDescAnunUser() {
        return descAnunUser;
    }

    public void setDescAnunUser(String descAnunUser) {
        this.descAnunUser = descAnunUser;
    }

    public double getPrecoAnunUser() {
        return precoAnunUser;
    }

    public void setPrecoAnunUser(double precoAnunUser) {
        this.precoAnunUser = precoAnunUser;
    }

    public String getRequisitosAnunUser() {
        return requisitosAnunUser;
    }

    public void setRequisitosAnunUser(String requisitosAnunUser) {
        this.requisitosAnunUser = requisitosAnunUser;
    }

    public String getImgAnunUser() {
        return imgAnunUser;
    }

    public void setImgAnunUser(String imgAnunUser) {
        this.imgAnunUser = imgAnunUser;
    }

    public Boolean getStatusAnunUser() {
        return statusAnunUser;
    }

    public void setStatusAnunUser(Boolean statusAnunUser) {
        this.statusAnunUser = statusAnunUser;
    }

    public Date getDataAnunUser() {
        return dataAnunUser;
    }

    public void setDataAnunUser(Date dataAnunUser) {
        this.dataAnunUser = dataAnunUser;
    }

    public List<Tblanunuserfr> getTblanunuserfrList() {
        return tblanunuserfrList;
    }

    public void setTblanunuserfrList(List<Tblanunuserfr> tblanunuserfrList) {
        this.tblanunuserfrList = tblanunuserfrList;
    }

    public Tbltiposervico getNomeServ() {
        return nomeServ;
    }

    public void setNomeServ(Tbltiposervico nomeServ) {
        this.nomeServ = nomeServ;
    }

    public Tblusuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Tblusuario idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnunUser != null ? idAnunUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblanunuser)) {
            return false;
        }
        Tblanunuser other = (Tblanunuser) object;
        if ((this.idAnunUser == null && other.idAnunUser != null) || (this.idAnunUser != null && !this.idAnunUser.equals(other.idAnunUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblanunuser[ idAnunUser=" + idAnunUser + " ]";
    }
    
}
