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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblusuario")
@NamedQueries({
@NamedQuery(name = "Tblusuario.findAll", query = "SELECT t FROM Tblusuario t"),
    @NamedQuery(name = "Tblusuario.findByIdUser", query = "SELECT t FROM Tblusuario t WHERE t.idUser = :idUser"),
    @NamedQuery(name = "Tblusuario.findByNomeUser", query = "SELECT t FROM Tblusuario t WHERE t.nomeUser = :nomeUser"),
    @NamedQuery(name = "Tblusuario.findByCPFUser", query = "SELECT t FROM Tblusuario t WHERE t.cPFUser = :cPFUser"),
    @NamedQuery(name = "Tblusuario.findByEmailUser", query = "SELECT t FROM Tblusuario t WHERE t.emailUser = :email"),
    @NamedQuery(name = "Tblusuario.findByEmailLogin", query = "SELECT t FROM Tblusuario t WHERE t.emailUser = :email AND t.senhaUser = :senha"),
    @NamedQuery(name = "Tblusuario.findByEmailNome", query = "SELECT t FROM Tblusuario t WHERE t.nomeUser = :nome AND t.emailUser = :email"), 
    @NamedQuery(name = "Tblusuario.findByTelUser", query = "SELECT t FROM Tblusuario t WHERE t.telUser = :telUser"),
    @NamedQuery(name = "Tblusuario.findByDataNascUser", query = "SELECT t FROM Tblusuario t WHERE t.dataNascUser = :dataNascUser"),
    @NamedQuery(name = "Tblusuario.findByGeneroUser", query = "SELECT t FROM Tblusuario t WHERE t.generoUser = :generoUser"),
    @NamedQuery(name = "Tblusuario.findBySenhaUser", query = "SELECT t FROM Tblusuario t WHERE t.senhaUser = :senhaUser"),
    @NamedQuery(name = "Tblusuario.findByImgUser", query = "SELECT t FROM Tblusuario t WHERE t.imgUser = :imgUser")})
public class Tblusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "NomeUser")
    private String nomeUser;
    @Column(name = "CPFUser")
    private String cPFUser;
    @Column(name = "EmailUser")
    private String emailUser;
    @Column(name = "TelUser")
    private String telUser;
    @Column(name = "DataNascUser")
    @Temporal(TemporalType.DATE)
    private Date dataNascUser;
    @Column(name = "GeneroUser")
    private String generoUser;
    @Column(name = "SenhaUser")
    private String senhaUser;
    @Column(name = "ImgUser")
    private String imgUser;
    @Column(name = "DescUser")
    private String descUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.EAGER)
    private List<Tblanunfruser> tblanunfruserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.EAGER)
    private List<Tblanunuser> tblanunuserList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblusuario", fetch = FetchType.EAGER)
    private Tblsaldo tblsaldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.EAGER)
    private List<Tblticket> tblticketList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.EAGER)
    private List<Tblcoment> tblcomentList;

    public Tblusuario() {
    }

    public Tblusuario(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getCPFUser() {
        return cPFUser;
    }

    public void setCPFUser(String cPFUser) {
        this.cPFUser = cPFUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getTelUser() {
        return telUser;
    }

    public void setTelUser(String telUser) {
        this.telUser = telUser;
    }

    public Date getDataNascUser() {
        return dataNascUser;
    }

    public void setDataNascUser(Date dataNascUser) {
        this.dataNascUser = dataNascUser;
    }

    public String getGeneroUser() {
        return generoUser;
    }

    public void setGeneroUser(String generoUser) {
        this.generoUser = generoUser;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public String getDescUser() {
        return descUser;
    }

    public void setDescUser(String descUser) {
        this.descUser = descUser;
    }

    public List<Tblanunfruser> getTblanunfruserList() {
        return tblanunfruserList;
    }

    public void setTblanunfruserList(List<Tblanunfruser> tblanunfruserList) {
        this.tblanunfruserList = tblanunfruserList;
    }

    public List<Tblanunuser> getTblanunuserList() {
        return tblanunuserList;
    }

    public void setTblanunuserList(List<Tblanunuser> tblanunuserList) {
        this.tblanunuserList = tblanunuserList;
    }

    public Tblsaldo getTblsaldo() {
        return tblsaldo;
    }

    public void setTblsaldo(Tblsaldo tblsaldo) {
        this.tblsaldo = tblsaldo;
    }

    public List<Tblticket> getTblticketList() {
        return tblticketList;
    }

    public void setTblticketList(List<Tblticket> tblticketList) {
        this.tblticketList = tblticketList;
    }

    public List<Tblcoment> getTblcomentList() {
        return tblcomentList;
    }

    public void setTblcomentList(List<Tblcoment> tblcomentList) {
        this.tblcomentList = tblcomentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblusuario)) {
            return false;
        }
        Tblusuario other = (Tblusuario) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblusuario[ idUser=" + idUser + " ]";
    }
    
}
