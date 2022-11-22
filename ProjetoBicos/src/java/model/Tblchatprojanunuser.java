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
@Table(name = "tblchatprojanunuser")
@NamedQueries({
    @NamedQuery(name = "Tblchatprojanunuser.findAll", query = "SELECT t FROM Tblchatprojanunuser t"),
    @NamedQuery(name = "Tblchatprojanunuser.findByIdTblChatProj", query = "SELECT t FROM Tblchatprojanunuser t WHERE t.idTblChatProj = :idTblChatProj"),
    @NamedQuery(name = "Tblchatprojanunuser.findByChatProjUserMsgTxt", query = "SELECT t FROM Tblchatprojanunuser t WHERE t.chatProjUserMsgTxt = :chatProjUserMsgTxt"),
    @NamedQuery(name = "Tblchatprojanunuser.findByChatProjUserMsgDH", query = "SELECT t FROM Tblchatprojanunuser t WHERE t.chatProjUserMsgDH = :chatProjUserMsgDH"),
    @NamedQuery(name = "Tblchatprojanunuser.findByChatProjUserImg", query = "SELECT t FROM Tblchatprojanunuser t WHERE t.chatProjUserImg = :chatProjUserImg")})
public class Tblchatprojanunuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTblChatProj")
    private Integer idTblChatProj;
    @Column(name = "ChatProjUserMsgTxt")
    private String chatProjUserMsgTxt;
    @Column(name = "ChatProjUserMsgDH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chatProjUserMsgDH;
    @Column(name = "ChatProjUserImg")
    private String chatProjUserImg;
    @JoinColumn(name = "idProjAnunUser", referencedColumnName = "idProjAnunUser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tblprojanunuser idProjAnunUser;

    public Tblchatprojanunuser() {
    }

    public Tblchatprojanunuser(Integer idTblChatProj) {
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

    public Date getChatProjUserMsgDH() {
        return chatProjUserMsgDH;
    }

    public void setChatProjUserMsgDH(Date chatProjUserMsgDH) {
        this.chatProjUserMsgDH = chatProjUserMsgDH;
    }

    public String getChatProjUserImg() {
        return chatProjUserImg;
    }

    public void setChatProjUserImg(String chatProjUserImg) {
        this.chatProjUserImg = chatProjUserImg;
    }

    public Tblprojanunuser getIdProjAnunUser() {
        return idProjAnunUser;
    }

    public void setIdProjAnunUser(Tblprojanunuser idProjAnunUser) {
        this.idProjAnunUser = idProjAnunUser;
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
        if (!(object instanceof Tblchatprojanunuser)) {
            return false;
        }
        Tblchatprojanunuser other = (Tblchatprojanunuser) object;
        if ((this.idTblChatProj == null && other.idTblChatProj != null) || (this.idTblChatProj != null && !this.idTblChatProj.equals(other.idTblChatProj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tblchatprojanunuser[ idTblChatProj=" + idTblChatProj + " ]";
    }
    
}
