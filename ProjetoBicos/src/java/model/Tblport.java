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
@Table(name = "tblport")
@NamedQueries({
    @NamedQuery(name = "Tblport.findAll", query = "SELECT t FROM Tblport t"),
    @NamedQuery(name = "Tblport.findByIdPort", query = "SELECT t FROM Tblport t WHERE t.idPort = :idPort"),
    @NamedQuery(name = "Tblport.findByImagem1", query = "SELECT t FROM Tblport t WHERE t.imagem1 = :imagem1"),
    @NamedQuery(name = "Tblport.findByImagem2", query = "SELECT t FROM Tblport t WHERE t.imagem2 = :imagem2"),
    @NamedQuery(name = "Tblport.findByImagem3", query = "SELECT t FROM Tblport t WHERE t.imagem3 = :imagem3"),
    @NamedQuery(name = "Tblport.findByDesc1", query = "SELECT t FROM Tblport t WHERE t.desc1 = :desc1"),
    @NamedQuery(name = "Tblport.findByDesc2", query = "SELECT t FROM Tblport t WHERE t.desc2 = :desc2"),
    @NamedQuery(name = "Tblport.findByDesc3", query = "SELECT t FROM Tblport t WHERE t.desc3 = :desc3")})
public class Tblport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPort")
    private Integer idPort;
    @Column(name = "Imagem1")
    private String imagem1;
    @Column(name = "Imagem2")
    private String imagem2;
    @Column(name = "Imagem3")
    private String imagem3;
    @Column(name = "Desc1")
    private String desc1;
    @Column(name = "Desc2")
    private String desc2;
    @Column(name = "Desc3")
    private String desc3;
    @JoinColumn(name = "idFr", referencedColumnName = "idFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblfreelancer idFr;

    public Tblport() {
    }

    public Tblport(Integer idPort) {
        this.idPort = idPort;
    }

    public Integer getIdPort() {
        return idPort;
    }

    public void setIdPort(Integer idPort) {
        this.idPort = idPort;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3;
    }

    public Tblfreelancer getIdFr() {
        return idFr;
    }

    public void setIdFr(Tblfreelancer idFr) {
        this.idFr = idFr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPort != null ? idPort.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblport)) {
            return false;
        }
        Tblport other = (Tblport) object;
        if ((this.idPort == null && other.idPort != null) || (this.idPort != null && !this.idPort.equals(other.idPort))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblport[ idPort=" + idPort + " ]";
    }
    
}
