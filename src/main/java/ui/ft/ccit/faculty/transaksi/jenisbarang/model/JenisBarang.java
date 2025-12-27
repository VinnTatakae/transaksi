package ui.ft.ccit.faculty.transaksi.jenisbarang.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jenis_barang")
public class JenisBarang {

    @Id
    @Column(name = "id_jenis_brg")
    private Byte idJenisBarang;

    @Column(name = "nama", length = 100, nullable = false)
    private String nama;

    protected JenisBarang() {
        // for JPA
    }

    public JenisBarang(Byte idJenisBarang, String nama) {
        this.idJenisBarang = idJenisBarang;
        this.nama = nama;
    }

    public Byte getIdJenisBarang() {
        return idJenisBarang;
    }

    public void setIdJenisBarang(Byte idJenisBarang) {
        this.idJenisBarang = idJenisBarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
