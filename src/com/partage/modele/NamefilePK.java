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
public class NamefilePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "idFile")
    private int idFile;

    public NamefilePK() {
    }

    public NamefilePK(String fileName, int idFile) {
        this.fileName = fileName;
        this.idFile = idFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getIdFile() {
        return idFile;
    }

    public void setIdFile(int idFile) {
        this.idFile = idFile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileName != null ? fileName.hashCode() : 0);
        hash += (int) idFile;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NamefilePK)) {
            return false;
        }
        NamefilePK other = (NamefilePK) object;
        if ((this.fileName == null && other.fileName != null) || (this.fileName != null && !this.fileName.equals(other.fileName))) {
            return false;
        }
        if (this.idFile != other.idFile) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.partage.modele.NamefilePK[ fileName=" + fileName + ", idFile=" + idFile + " ]";
    }
    
}
