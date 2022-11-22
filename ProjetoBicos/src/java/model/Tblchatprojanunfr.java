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
@Table(name = "tblchatprojanunfr")
@NamedQueries({
    @NamedQuery(name = "Tblchatprojanunfr.findAll", query = "SELECT t FROM Tblchatprojanunfr t"),
    @NamedQuery(name = "Tblchatprojanunfr.findByIdTblChatProj", query = "SELECT t FROM Tblchatprojanunfr t WHERE t.idTblChatProj = :idTblChatProj"),
    @NamedQuery(name = "Tblchatprojanunfr.findByChatProjUserMsgTxt", query = "SELECT t FROM Tblchatprojanunfr t WHERE t.chatProjUserMsgTxt = :chatProjUserMsgTxt"),
    @NamedQuery(name = "Tblchatprojanunfr.findByChatProjFrMsgDH", query = "SELECT t FROM Tblchatprojanunfr t WHERE t.chatProjFrMsgDH = :chatProjFrMsgDH"),
    @NamedQuery(name = "Tblchatprojanunfr.findByChatProjFrImg", query = "SELECT t FROM Tblchatprojanunfr t WHERE t.chatProjFrImg = :chatProjFrImg")})
public class Tblchatprojanunfr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTblChatProj")
    private Integer idTblChatProj;
    @Column(name = "ChatProjUserMsgTxt")
    private String chatProjUserMsgTxt;
    @Column(name = "ChatProjFrMsgDH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chatProjFrMsgDH;
    @Column(name = "ChatProjFrImg")
    private String chatProjFrImg;
    @JoinColumn(name = "idProjAnunFr", referencedColumnName = "idProjAnunFr")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblprojanunfr idProjAnunFr;

    public Tblchatprojanunfr() {
    }

    public Tblchatprojanunfr(Integer idTblChatProj) {
        this.idTblChatProj = idTblChatProj;
    }

    public Integer getIdTblChatProj() {
        return idTblChatProj;
    }

    public void setIdTblChatProj(Integer idTblChatProj) {
        this.idTblChatProj = idTblChatProj;
    }

    public String getChatProjUserMsgTxt() {
        return chatProjUserMsgTxt;
    }

    public void setChatProjUserMsgTxt(String chatProjUserMsgTxt) {
        this.chatProjUserMsgTxt = chatProjUserMsgTxt;
    }

    public Date getChatProjFrMsgDH() {
        return chatProjFrMsgDH;
    }

    public void setChatProjFrMsgDH(Date chatProjFrMsgDH) {
        this.chatProjFrMsgDH = chatProjFrMsgDH;
    }

    public String getChatProjFrImg() {
        return chatProjFrImg;
    }

    public void setChatProjFrImg(String chatProjFrImg) {
        this.chatProjFrImg = chatProjFrImg;
    }

    public Tblprojanunfr getIdProjAnunFr() {
        return idProjAnunFr;
    }

    public void setIdProjAnunFr(Tblprojanunfr idProjAnunFr) {
        this.idProjAnunFr = idProjAnunFr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTblChatProj != null ? idTblChatProj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblchatprojanunfr)) {
            return false;
        }
        Tblchatprojanunfr other = (Tblchatprojanunfr) object;
        if ((this.idTblChatProj == null && other.idTblChatProj != null) || (this.idTblChatProj != null && !this.idTblChatProj.equals(other.idTblChatProj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblchatprojanunfr[ idTblChatProj=" + idTblChatProj + " ]";
    }
    
}
