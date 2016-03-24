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
@Table(name = "namefile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Namefile.findAll", query = "SELECT n FROM Namefile n"),
    @NamedQuery(name = "Namefile.findByFileName", query = "SELECT n FROM Namefile n WHERE n.namefilePK.fileName = :fileName"),
    @NamedQuery(name = "Namefile.findByIdFile", query = "SELECT n FROM Namefile n WHERE n.namefilePK.idFile = :idFile")})
public class Namefile implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NamefilePK namefilePK;

    public Namefile() {
    }

    public Namefile(NamefilePK namefilePK) {
        this.namefilePK = namefilePK;
    }

    public Namefile(String fileName, int idFile) {
        this.namefilePK = new NamefilePK(fileName, idFile);
    }

    public NamefilePK getNamefilePK() {
        return namefilePK;
    }

    public void setNamefilePK(NamefilePK namefilePK) {
        this.namefilePK = namefilePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (namefilePK != null ? namefilePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Namefile)) {
            return false;
        }
        Namefile other = (Namefile) object;
        if ((this.namefilePK == null && other.namefilePK != null) || (this.namefilePK != null && !this.namefilePK.equals(other.namefilePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.partage.modele.Namefile[ namefilePK=" + namefilePK + " ]";
    }
    
}
