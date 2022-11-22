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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblsaldo")
@NamedQueries({
    @NamedQuery(name = "Tblsaldo.findAll", query = "SELECT t FROM Tblsaldo t"),
    @NamedQuery(name = "Tblsaldo.findByIdUser", query = "SELECT t FROM Tblsaldo t WHERE t.idUser = :idUser"),
    @NamedQuery(name = "Tblsaldo.findByQuantSaldo", query = "SELECT t FROM Tblsaldo t WHERE t.quantSaldo = :quantSaldo")})
public class Tblsaldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUser")
    private Integer idUser;
    @Basic(optional = false)
    @Column(name = "QuantSaldo")
    private double quantSaldo;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Tblusuario tblusuario;

    public Tblsaldo() {
    }

    public Tblsaldo(Integer idUser) {
        this.idUser = idUser;
    }

    public Tblsaldo(Integer idUser, double quantSaldo) {
        this.idUser = idUser;
        this.quantSaldo = quantSaldo;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public double getQuantSaldo() {
        return quantSaldo;
    }

    public void setQuantSaldo(double quantSaldo) {
        this.quantSaldo = quantSaldo;
    }

    public Tblusuario getTblusuario() {
        return tblusuario;
    }

    public void setTblusuario(Tblusuario tblusuario) {
        this.tblusuario = tblusuario;
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
        if (!(object instanceof Tblsaldo)) {
            return false;
        }
        Tblsaldo other = (Tblsaldo) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblsaldo[ idUser=" + idUser + " ]";
    }
    
}
