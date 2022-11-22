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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblticket")
@NamedQueries({
    @NamedQuery(name = "Tblticket.findAll", query = "SELECT t FROM Tblticket t"),
    @NamedQuery(name = "Tblticket.findByIdTicket", query = "SELECT t FROM Tblticket t WHERE t.idTicket = :idTicket"),
    @NamedQuery(name = "Tblticket.findByStatusTicket", query = "SELECT t FROM Tblticket t WHERE t.statusTicket = :statusTicket"),
    @NamedQuery(name = "Tblticket.findByBoletimOcorrencia", query = "SELECT t FROM Tblticket t WHERE t.boletimOcorrencia = :boletimOcorrencia"),
    @NamedQuery(name = "Tblticket.findByTipoTicket", query = "SELECT t FROM Tblticket t WHERE t.tipoTicket = :tipoTicket")})
public class Tblticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTicket")
    private Integer idTicket;
    @Basic(optional = false)
    @Column(name = "StatusTicket")
    private boolean statusTicket;
    @Basic(optional = false)
    @Column(name = "BoletimOcorrencia")
    private String boletimOcorrencia;
    @Basic(optional = false)
    @Column(name = "TipoTicket")
    private String tipoTicket;
    @JoinColumn(name = "idFunc", referencedColumnName = "idFunc")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblfuncionario idFunc;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblusuario idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTicket", fetch = FetchType.EAGER)
    private List<Tblchatticket> tblchatticketList;

    public Tblticket() {
    }

    public Tblticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Tblticket(Integer idTicket, boolean statusTicket, String boletimOcorrencia, String tipoTicket) {
        this.idTicket = idTicket;
        this.statusTicket = statusTicket;
        this.boletimOcorrencia = boletimOcorrencia;
        this.tipoTicket = tipoTicket;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public boolean getStatusTicket() {
        return statusTicket;
    }

    public void setStatusTicket(boolean statusTicket) {
        this.statusTicket = statusTicket;
    }

    public String getBoletimOcorrencia() {
        return boletimOcorrencia;
    }

    public void setBoletimOcorrencia(String boletimOcorrencia) {
        this.boletimOcorrencia = boletimOcorrencia;
    }

    public String getTipoTicket() {
        return tipoTicket;
    }

    public void setTipoTicket(String tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    public Tblfuncionario getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Tblfuncionario idFunc) {
        this.idFunc = idFunc;
    }

    public Tblusuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Tblusuario idUser) {
        this.idUser = idUser;
    }

    public List<Tblchatticket> getTblchatticketList() {
        return tblchatticketList;
    }

    public void setTblchatticketList(List<Tblchatticket> tblchatticketList) {
        this.tblchatticketList = tblchatticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblticket)) {
            return false;
        }
        Tblticket other = (Tblticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblticket[ idTicket=" + idTicket + " ]";
    }
    
}
