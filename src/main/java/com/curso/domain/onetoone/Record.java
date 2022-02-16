package com.curso.domain.onetoone;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RECORD")
@NamedQueries({
    @NamedQuery(name = "Record.findAll", query = "SELECT r FROM Record r")})
public class Record implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECID")
    private Integer recid;
    
    @Column(name = "RECORD_NAME")
    private String recordName;
    
  
    public Record() {
    }

    public Record(Integer recid) {
        this.recid = recid;
    }

    public Record(Integer recid, String recordName) {
        this.recid = recid;
        this.recordName = recordName;
    }

    public Integer getRecid() {
        return recid;
    }

    public void setRecid(Integer recid) {
        this.recid = recid;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recid != null ? recid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Record)) {
            return false;
        }
        Record other = (Record) object;
        if ((this.recid == null && other.recid != null) || (this.recid != null && !this.recid.equals(other.recid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.programia.demos.entidades.Record[ recid=" + recid + " ]";
    }
    
}
