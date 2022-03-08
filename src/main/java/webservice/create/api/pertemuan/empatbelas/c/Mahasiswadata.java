/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.create.api.pertemuan.empatbelas.c;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pascal
 */
@Entity
@Table(name = "mahasiswadata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mahasiswadata.findAll", query = "SELECT m FROM Mahasiswadata m"),
    @NamedQuery(name = "Mahasiswadata.findById", query = "SELECT m FROM Mahasiswadata m WHERE m.id = :id"),
    @NamedQuery(name = "Mahasiswadata.findByNama", query = "SELECT m FROM Mahasiswadata m WHERE m.nama = :nama"),
    @NamedQuery(name = "Mahasiswadata.findByNim", query = "SELECT m FROM Mahasiswadata m WHERE m.nim = :nim"),
    @NamedQuery(name = "Mahasiswadata.findByProgramstudi", query = "SELECT m FROM Mahasiswadata m WHERE m.programstudi = :programstudi"),
    @NamedQuery(name = "Mahasiswadata.findByUniversitas", query = "SELECT m FROM Mahasiswadata m WHERE m.universitas = :universitas")})
public class Mahasiswadata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "nim")
    private String nim;
    @Column(name = "programstudi")
    private String programstudi;
    @Column(name = "universitas")
    private String universitas;

    public Mahasiswadata() {
    }

    public Mahasiswadata(Integer id) {
        this.id = id;
    }

    Mahasiswadata(String nama, String nim, String programstudi, String universitas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProgramstudi() {
        return programstudi;
    }

    public void setProgramstudi(String programstudi) {
        this.programstudi = programstudi;
    }

    public String getUniversitas() {
        return universitas;
    }

    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mahasiswadata)) {
            return false;
        }
        Mahasiswadata other = (Mahasiswadata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webservice.create.api.pertemuan.empatbelas.c.Mahasiswadata[ id=" + id + " ]";
    }
    
}
