package ui.ft.ccit.faculty.transaksi.karyawan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @Column(name = "id_karyawan", length = 4)
    private String idKaryawan;

    @Column(name = "nama", length = 255, nullable = false)
    private String nama;

    @Column(name = "telepon", length = 20)
    private String telepon;

    protected Karyawan() {
        // JPA
    }

    public Karyawan(String idKaryawan, String nama, String telepon) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.telepon = telepon;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
