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
@Table(name = "tblfuncionario")
@NamedQueries({
    @NamedQuery(name = "Tblfuncionario.findAll", query = "SELECT t FROM Tblfuncionario t"),
    @NamedQuery(name = "Tblfuncionario.findByIdFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.idFunc = :idFunc"),
    @NamedQuery(name = "Tblfuncionario.findByNomeFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.nomeFunc = :nomeFunc"),
    @NamedQuery(name = "Tblfuncionario.findByCPFFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.cPFFunc = :cPFFunc"),
    @NamedQuery(name = "Tblfuncionario.findByEmailFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.emailFunc = :emailFunc"),
    @NamedQuery(name = "Tblfuncionario.findByTelFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.telFunc = :telFunc"),
    @NamedQuery(name = "Tblfuncionario.findByDataNascFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.dataNascFunc = :dataNascFunc"),
    @NamedQuery(name = "Tblfuncionario.findByGeneroFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.generoFunc = :generoFunc"),
    @NamedQuery(name = "Tblfuncionario.findBySenhaFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.senhaFunc = :senhaFunc"),
    @NamedQuery(name = "Tblfuncionario.findByImgFunc", query = "SELECT t FROM Tblfuncionario t WHERE t.imgFunc = :imgFunc")})
public class Tblfuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFunc")
    private Integer idFunc;
    @Basic(optional = false)
    @Column(name = "NomeFunc")
    private String nomeFunc;
    @Basic(optional = false)
    @Column(name = "CPFFunc")
    private String cPFFunc;
    @Basic(optional = false)
    @Column(name = "EmailFunc")
    private String emailFunc;
    @Basic(optional = false)
    @Column(name = "TelFunc")
    private String telFunc;
    @Basic(optional = false)
    @Column(name = "DataNascFunc")
    @Temporal(TemporalType.DATE)
    private Date dataNascFunc;
    @Basic(optional = false)
    @Column(name = "GeneroFunc")
    private String generoFunc;
    @Basic(optional = false)
    @Column(name = "SenhaFunc")
    private String senhaFunc;
    @Basic(optional = false)
    @Column(name = "ImgFunc")
    private String imgFunc;
    @JoinColumn(name = "SiglaCargo", referencedColumnName = "SiglaCargo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblcargo siglaCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFunc", fetch = FetchType.EAGER)
    private List<Tblticket> tblticketList;

    public Tblfuncionario() {
    }

    public Tblfuncionario(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public Tblfuncionario(Integer idFunc, String nomeFunc, String cPFFunc, String emailFunc, String telFunc, Date dataNascFunc, String generoFunc, String senhaFunc, String imgFunc) {
        this.idFunc = idFunc;
        this.nomeFunc = nomeFunc;
        this.cPFFunc = cPFFunc;
        this.emailFunc = emailFunc;
        this.telFunc = telFunc;
        this.dataNascFunc = dataNascFunc;
        this.generoFunc = generoFunc;
        this.senhaFunc = senhaFunc;
        this.imgFunc = imgFunc;
    }

    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getCPFFunc() {
        return cPFFunc;
    }

    public void setCPFFunc(String cPFFunc) {
        this.cPFFunc = cPFFunc;
    }

    public String getEmailFunc() {
        return emailFunc;
    }

    public void setEmailFunc(String emailFunc) {
        this.emailFunc = emailFunc;
    }

    public String getTelFunc() {
        return telFunc;
    }

    public void setTelFunc(String telFunc) {
        this.telFunc = telFunc;
    }

    public Date getDataNascFunc() {
        return dataNascFunc;
    }

    public void setDataNascFunc(Date dataNascFunc) {
        this.dataNascFunc = dataNascFunc;
    }

    public String getGeneroFunc() {
        return generoFunc;
    }

    public void setGeneroFunc(String generoFunc) {
        this.generoFunc = generoFunc;
    }

    public String getSenhaFunc() {
        return senhaFunc;
    }

    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }

    public String getImgFunc() {
        return imgFunc;
    }

    public void setImgFunc(String imgFunc) {
        this.imgFunc = imgFunc;
    }

    public Tblcargo getSiglaCargo() {
        return siglaCargo;
    }

    public void setSiglaCargo(Tblcargo siglaCargo) {
        this.siglaCargo = siglaCargo;
    }

    public List<Tblticket> getTblticketList() {
        return tblticketList;
    }

    public void setTblticketList(List<Tblticket> tblticketList) {
        this.tblticketList = tblticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFunc != null ? idFunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblfuncionario)) {
            return false;
        }
        Tblfuncionario other = (Tblfuncionario) object;
        if ((this.idFunc == null && other.idFunc != null) || (this.idFunc != null && !this.idFunc.equals(other.idFunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblfuncionario[ idFunc=" + idFunc + " ]";
    }
    
}
