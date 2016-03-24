/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partage.modele;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Marie
 */
@Embeddable
public class SharedfilesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idFile")
    private int idFile;
    @Basic(optional = false)
    @Column(name = "associate")
    private String associate;
    @Basic(optional = false)
    @Column(name = "owner")
    private String owner;

    public SharedfilesPK() {
    }

    public SharedfilesPK(int idFile, String associate, String owner) {
        this.idFile = idFile;
        this.associate = associate;
        this.owner = owner;
    }

    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    public String getAssociate() {
        return associate;
    }

    public void setAssociate(String associate) {
        this.associate = associate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFile;
        hash += (associate != null ? associate.hashCode() : 0);
        hash += (owner != null ? owner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SharedfilesPK)) {
            return false;
        }
        SharedfilesPK other = (SharedfilesPK) object;
        if (this.idFile != other.idFile) {
            return false;
        }
        if ((this.associate == null && other.associate != null) || (this.associate != null && !this.associate.equals(other.associate))) {
            return false;
        }
        if ((this.owner == null && other.owner != null) || (this.owner != null && !this.owner.equals(other.owner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.partage.modele.SharedfilesPK[ idFile=" + idFile + ", associate=" + associate + ", owner=" + owner + " ]";
    }
    
}
