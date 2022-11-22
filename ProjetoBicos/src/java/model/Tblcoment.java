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
@Table(name = "tblcoment")
@NamedQueries({
    @NamedQuery(name = "Tblcoment.findAll", query = "SELECT t FROM Tblcoment t"),
    @NamedQuery(name = "Tblcoment.findByIdComent", query = "SELECT t FROM Tblcoment t WHERE t.idComent = :idComent"),
    @NamedQuery(name = "Tblcoment.findByMensagemComent", query = "SELECT t FROM Tblcoment t WHERE t.mensagemComent = :mensagemComent"),
    @NamedQuery(name = "Tblcoment.findByNotaComent", query = "SELECT t FROM Tblcoment t WHERE t.notaComent = :notaComent")})
public class Tblcoment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComent")
    private Integer idComent;
    @Column(name = "MensagemComent")
    private String mensagemComent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NotaComent")
    private Double notaComent;
    @JoinColumn(name = "idFr", referencedColumnName = "idFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblfreelancer idFr;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblusuario idUser;

    public Tblcoment() {
    }

    public Tblcoment(Integer idComent) {
        this.idComent = idComent;
    }

    public Integer getIdComent() {
        return idComent;
    }

    public void setIdComent(Integer idComent) {
        this.idComent = idComent;
    }

    public String getMensagemComent() {
        return mensagemComent;
    }

    public void setMensagemComent(String mensagemComent) {
        this.mensagemComent = mensagemComent;
    }

    public Double getNotaComent() {
        return notaComent;
    }

    public void setNotaComent(Double notaComent) {
        this.notaComent = notaComent;
    }

    public Tblfreelancer getIdFr() {
        return idFr;
    }

    public void setIdFr(Tblfreelancer idFr) {
        this.idFr = idFr;
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
        hash += (idComent != null ? idComent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcoment)) {
            return false;
        }
        Tblcoment other = (Tblcoment) object;
        if ((this.idComent == null && other.idComent != null) || (this.idComent != null && !this.idComent.equals(other.idComent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblcoment[ idComent=" + idComent + " ]";
    }
    
}
