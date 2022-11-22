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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblfreelancer")
@NamedQueries({
@NamedQuery(name = "Tblfreelancer.findAll", query = "SELECT t FROM Tblfreelancer t"),
    @NamedQuery(name = "Tblfreelancer.findByIdFr", query = "SELECT t FROM Tblfreelancer t WHERE t.idFr = :idFr"),
    @NamedQuery(name = "Tblfreelancer.findByCompetenciasFr", query = "SELECT t FROM Tblfreelancer t WHERE t.competenciasFr = :competenciasFr"),
    @NamedQuery(name = "Tblfreelancer.findByEspecialidadesFr", query = "SELECT t FROM Tblfreelancer t WHERE t.especialidadesFr = :especialidadesFr"),
    @NamedQuery(name = "Tblfreelancer.findByNomeFr", query = "SELECT t FROM Tblfreelancer t WHERE t.nomeFr = :nomeFr"),
    @NamedQuery(name = "Tblfreelancer.findByCPFFr", query = "SELECT t FROM Tblfreelancer t WHERE t.cPFFr = :cPFFr"),
    @NamedQuery(name = "Tblfreelancer.findByEmailFr", query = "SELECT t FROM Tblfreelancer t WHERE t.emailFr = :emailFr"),
    @NamedQuery(name = "Tblfreelancer.findByEmailLogin", query = "SELECT t FROM Tblfreelancer t WHERE t.emailFr = :email AND t.senharFr = :senha"),
    @NamedQuery(name = "Tblfreelancer.findByEmailNome", query = "SELECT t FROM Tblfreelancer t WHERE t.nomeFr = :nome AND t.emailFr = :email"),
    @NamedQuery(name = "Tblfreelancer.findByTelFr", query = "SELECT t FROM Tblfreelancer t WHERE t.telFr = :telFr"),
    @NamedQuery(name = "Tblfreelancer.findByDataNascFr", query = "SELECT t FROM Tblfreelancer t WHERE t.dataNascFr = :dataNascFr"),
    @NamedQuery(name = "Tblfreelancer.findByGeneroFr", query = "SELECT t FROM Tblfreelancer t WHERE t.generoFr = :generoFr"),
    @NamedQuery(name = "Tblfreelancer.findBySenharFr", query = "SELECT t FROM Tblfreelancer t WHERE t.senharFr = :senharFr"),
    @NamedQuery(name = "Tblfreelancer.findByImgFr", query = "SELECT t FROM Tblfreelancer t WHERE t.imgFr = :imgFr"),
    @NamedQuery(name = "Tblfreelancer.findByDescFr", query = "SELECT t FROM Tblfreelancer t WHERE t.descFr = :descFr")})
public class Tblfreelancer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFr")
    private Integer idFr;
    @Column(name = "CompetenciasFr")
    private String competenciasFr;
    @Column(name = "EspecialidadesFr")
    private String especialidadesFr;
    @Column(name = "NomeFr")
    private String nomeFr;
    @Column(name = "CPFFr")
    private String cPFFr;
    @Column(name = "EmailFr")
    private String emailFr;
    @Column(name = "TelFr")
    private String telFr;
    @Column(name = "DataNascFr")
    @Temporal(TemporalType.DATE)
    private Date dataNascFr;
    @Column(name = "GeneroFr")
    private String generoFr;
    @Column(name = "SenharFr")
    private String senharFr;
    @Column(name = "ImgFr")
    private String imgFr;
    @Column(name = "DescFr")
    private String descFr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFr", fetch = FetchType.EAGER)
    private List<Tblanunuserfr> tblanunuserfrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFr", fetch = FetchType.EAGER)
    private List<Tblport> tblportList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFr", fetch = FetchType.EAGER)
    private List<Tblanunfr> tblanunfrList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFr", fetch = FetchType.EAGER)
    private List<Tblcoment> tblcomentList;

    public Tblfreelancer() {
    }

    public Tblfreelancer(Integer idFr) {
        this.idFr = idFr;
    }

    public Integer getIdFr() {
        return idFr;
    }

    public void setIdFr(Integer idFr) {
        this.idFr = idFr;
    }

    public String getCompetenciasFr() {
        return competenciasFr;
    }

    public void setCompetenciasFr(String competenciasFr) {
        this.competenciasFr = competenciasFr;
    }

    public String getEspecialidadesFr() {
        return especialidadesFr;
    }

    public void setEspecialidadesFr(String especialidadesFr) {
        this.especialidadesFr = especialidadesFr;
    }

    public String getNomeFr() {
        return nomeFr;
    }

    public void setNomeFr(String nomeFr) {
        this.nomeFr = nomeFr;
    }

    public String getCPFFr() {
        return cPFFr;
    }

    public void setCPFFr(String cPFFr) {
        this.cPFFr = cPFFr;
    }

    public String getEmailFr() {
        return emailFr;
    }

    public void setEmailFr(String emailFr) {
        this.emailFr = emailFr;
    }

    public String getTelFr() {
        return telFr;
    }

    public void setTelFr(String telFr) {
        this.telFr = telFr;
    }

    public Date getDataNascFr() {
        return dataNascFr;
    }

    public void setDataNascFr(Date dataNascFr) {
        this.dataNascFr = dataNascFr;
    }

    public String getGeneroFr() {
        return generoFr;
    }

    public void setGeneroFr(String generoFr) {
        this.generoFr = generoFr;
    }

    public String getSenharFr() {
        return senharFr;
    }

    public void setSenharFr(String senharFr) {
        this.senharFr = senharFr;
    }

    public String getImgFr() {
        return imgFr;
    }

    public void setImgFr(String imgFr) {
        this.imgFr = imgFr;
    }

    public String getDescFr() {
        return descFr;
    }

    public void setDescFr(String descFr) {
        this.descFr = descFr;
    }

    public List<Tblanunuserfr> getTblanunuserfrList() {
        return tblanunuserfrList;
    }

    public void setTblanunuserfrList(List<Tblanunuserfr> tblanunuserfrList) {
        this.tblanunuserfrList = tblanunuserfrList;
    }

    public List<Tblport> getTblportList() {
        return tblportList;
    }

    public void setTblportList(List<Tblport> tblportList) {
        this.tblportList = tblportList;
    }

    public List<Tblanunfr> getTblanunfrList() {
        return tblanunfrList;
    }

    public void setTblanunfrList(List<Tblanunfr> tblanunfrList) {
        this.tblanunfrList = tblanunfrList;
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
        hash += (idFr != null ? idFr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblfreelancer)) {
            return false;
        }
        Tblfreelancer other = (Tblfreelancer) object;
        if ((this.idFr == null && other.idFr != null) || (this.idFr != null && !this.idFr.equals(other.idFr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblfreelancer[ idFr=" + idFr + " ]";
    }
    
}
