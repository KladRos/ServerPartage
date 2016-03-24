/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partage.modele;

import java.io.Serializable;
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
@Entity
@Table(name = "sharedfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sharedfiles.findAll", query = "SELECT s FROM Sharedfiles s"),
    @NamedQuery(name = "Sharedfiles.findByIdFile", query = "SELECT s FROM Sharedfiles s WHERE s.sharedfilesPK.idFile = :idFile"),
    @NamedQuery(name = "Sharedfiles.findByAssociate", query = "SELECT s FROM Sharedfiles s WHERE s.sharedfilesPK.associate = :associate"),
    @NamedQuery(name = "Sharedfiles.findByOwner", query = "SELECT s FROM Sharedfiles s WHERE s.sharedfilesPK.owner = :owner")})
public class Sharedfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SharedfilesPK sharedfilesPK;

    public Sharedfiles() {
    }

    public Sharedfiles(SharedfilesPK sharedfilesPK) {
        this.sharedfilesPK = sharedfilesPK;
    }

    public Sharedfiles(int idFile, String associate, String owner) {
        this.sharedfilesPK = new SharedfilesPK(idFile, associate, owner);
    }

    public SharedfilesPK getSharedfilesPK() {
        return sharedfilesPK;
    }

    public void setSharedfilesPK(SharedfilesPK sharedfilesPK) {
        this.sharedfilesPK = sharedfilesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sharedfilesPK != null ? sharedfilesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sharedfiles)) {
            return false;
        }
        Sharedfiles other = (Sharedfiles) object;
        if ((this.sharedfilesPK == null && other.sharedfilesPK != null) || (this.sharedfilesPK != null && !this.sharedfilesPK.equals(other.sharedfilesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.partage.modele.Sharedfiles[ sharedfilesPK=" + sharedfilesPK + " ]";
    }
    
}
