/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partage.modele;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marie
 */
//SELECT * FROM `documents` WHERE statut = 'priv' and owner = 'bob'



/*select * from documents where idFile IN(SELECT idFile FROM `sharedfiles` WHERE associate = 'bob')
*/

//@NamedQuery(name = "Documents.findAllPatrtage", query = "SELECT d FROM Documents d WHERE d.documentsPK.idFile IN (SELECT s.SharedfilesPK.idFile FROM sharedfiles s WHERE s.SharedfilesPK.associate = :associate )" ),

@Entity
@Table(name = "documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d"),
    @NamedQuery(name = "Documents.findByIdFile", query = "SELECT d FROM Documents d WHERE d.documentsPK.idFile = :idFile"),
    @NamedQuery(name = "Documents.findByNameFile", query = "SELECT d FROM Documents d WHERE d.nameFile = :nameFile"),
    @NamedQuery(name = "Documents.findByType", query = "SELECT d FROM Documents d WHERE d.type = :type"),
    //@NamedQuery(name = "Documents.findAllPatrtage", query = "SELECT d FROM Documents d WHERE d.documentsPK.idFile IN (SELECT s.SharedfilesPK.idFile FROM sharedfiles s WHERE s.SharedfilesPK.associate = :associate )" ),
    @NamedQuery(name = "Documents.findAllPrive", query = "SELECT d FROM Documents d WHERE d.statut = 'priv' and d.documentsPK.owner = :owner "),
    @NamedQuery(name = "Documents.findAllPrive", query = "SELECT d FROM Documents d WHERE d.statut = 'priv' and d.documentsPK.owner = :owner "),
    @NamedQuery(name = "Documents.findByOwner", query = "SELECT d FROM Documents d WHERE d.documentsPK.owner = :owner"),
    @NamedQuery(name = "Documents.findMaxId", query = "SELECT d FROM Documents d WHERE d.documentsPK.owner = :owner"),
    @NamedQuery(name = "Documents.findByStatut", query = "SELECT d FROM Documents d WHERE d.statut = :statut")})
public class Documents implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentsPK documentsPK;
    @Basic(optional = false)
    @Column(name = "nameFile")
    private String nameFile;
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;

    public Documents() {
    }

    public Documents(DocumentsPK documentsPK) {
        this.documentsPK = documentsPK;
    }

    public Documents(DocumentsPK documentsPK, String nameFile, String type, String statut) {
        this.documentsPK = documentsPK;
        this.nameFile = nameFile;
        this.type = type;
        this.statut = statut;
    }

    public Documents(DocumentsPK documentsPK, String nameFile, String statut) {
        this.documentsPK = documentsPK;
        this.nameFile = nameFile;
        this.statut = statut;
    }

    public Documents(int idFile, String owner) {
        this.documentsPK = new DocumentsPK(idFile, owner);
    }

    public DocumentsPK getDocumentsPK() {
        return documentsPK;
    }

    public void setDocumentsPK(DocumentsPK documentsPK) {
        this.documentsPK = documentsPK;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentsPK != null ? documentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.documentsPK == null && other.documentsPK != null) || (this.documentsPK != null && !this.documentsPK.equals(other.documentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.partage.modele.Documents[ documentsPK=" + documentsPK + " ]";
    }
    
}
