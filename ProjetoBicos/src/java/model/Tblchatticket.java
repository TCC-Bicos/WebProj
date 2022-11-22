/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Teruel
 */
@Entity
@Table(name = "tblchatticket")
@NamedQueries({
    @NamedQuery(name = "Tblchatticket.findAll", query = "SELECT t FROM Tblchatticket t"),
    @NamedQuery(name = "Tblchatticket.findByIdChatTicket", query = "SELECT t FROM Tblchatticket t WHERE t.idChatTicket = :idChatTicket"),
    @NamedQuery(name = "Tblchatticket.findByChatTicketMensagemTexto", query = "SELECT t FROM Tblchatticket t WHERE t.chatTicketMensagemTexto = :chatTicketMensagemTexto"),
    @NamedQuery(name = "Tblchatticket.findByChatTicketMensagemDataHora", query = "SELECT t FROM Tblchatticket t WHERE t.chatTicketMensagemDataHora = :chatTicketMensagemDataHora"),
    @NamedQuery(name = "Tblchatticket.findByChatTicketMensagemImagem", query = "SELECT t FROM Tblchatticket t WHERE t.chatTicketMensagemImagem = :chatTicketMensagemImagem")})
public class Tblchatticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idChatTicket")
    private Integer idChatTicket;
    @Column(name = "ChatTicketMensagemTexto")
    private String chatTicketMensagemTexto;
    @Column(name = "ChatTicketMensagemDataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chatTicketMensagemDataHora;
    @Column(name = "ChatTicketMensagemImagem")
    private String chatTicketMensagemImagem;
    @JoinColumn(name = "idTicket", referencedColumnName = "idTicket")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblticket idTicket;

    public Tblchatticket() {
    }

    public Tblchatticket(Integer idChatTicket) {
        this.idChatTicket = idChatTicket;
    }

    public Integer getIdChatTicket() {
        return idChatTicket;
    }

    public void setIdChatTicket(Integer idChatTicket) {
        this.idChatTicket = idChatTicket;
    }

    public String getChatTicketMensagemTexto() {
        return chatTicketMensagemTexto;
    }

    public void setChatTicketMensagemTexto(String chatTicketMensagemTexto) {
        this.chatTicketMensagemTexto = chatTicketMensagemTexto;
    }

    public Date getChatTicketMensagemDataHora() {
        return chatTicketMensagemDataHora;
    }

    public void setChatTicketMensagemDataHora(Date chatTicketMensagemDataHora) {
        this.chatTicketMensagemDataHora = chatTicketMensagemDataHora;
    }

    public String getChatTicketMensagemImagem() {
        return chatTicketMensagemImagem;
    }

    public void setChatTicketMensagemImagem(String chatTicketMensagemImagem) {
        this.chatTicketMensagemImagem = chatTicketMensagemImagem;
    }

    public Tblticket getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Tblticket idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChatTicket != null ? idChatTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblchatticket)) {
            return false;
        }
        Tblchatticket other = (Tblchatticket) object;
        if ((this.idChatTicket == null && other.idChatTicket != null) || (this.idChatTicket != null && !this.idChatTicket.equals(other.idChatTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblchatticket[ idChatTicket=" + idChatTicket + " ]";
    }
    
}
