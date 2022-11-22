/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblcargo")
@NamedQueries({
    @NamedQuery(name = "Tblcargo.findAll", query = "SELECT t FROM Tblcargo t"),
    @NamedQuery(name = "Tblcargo.findBySiglaCargo", query = "SELECT t FROM Tblcargo t WHERE t.siglaCargo = :siglaCargo"),
    @NamedQuery(name = "Tblcargo.findByNomeCargo", query = "SELECT t FROM Tblcargo t WHERE t.nomeCargo = :nomeCargo")})
public class Tblcargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SiglaCargo")
    private String siglaCargo;
    @Column(name = "NomeCargo")
    private String nomeCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siglaCargo", fetch = FetchType.EAGER)
    private List<Tblfuncionario> tblfuncionarioList;

    public Tblcargo() {
    }

    public Tblcargo(String siglaCargo) {
        this.siglaCargo = siglaCargo;
    }

    public String getSiglaCargo() {
        return siglaCargo;
    }

    public void setSiglaCargo(String siglaCargo) {
        this.siglaCargo = siglaCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public List<Tblfuncionario> getTblfuncionarioList() {
        return tblfuncionarioList;
    }

    public void setTblfuncionarioList(List<Tblfuncionario> tblfuncionarioList) {
        this.tblfuncionarioList = tblfuncionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siglaCargo != null ? siglaCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcargo)) {
            return false;
        }
        Tblcargo other = (Tblcargo) object;
        if ((this.siglaCargo == null && other.siglaCargo != null) || (this.siglaCargo != null && !this.siglaCargo.equals(other.siglaCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblcargo[ siglaCargo=" + siglaCargo + " ]";
    }
    
}
