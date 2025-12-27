package ui.ft.ccit.faculty.transaksi.pelanggan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pelanggan")
public class Pelanggan {

    @Id
    @Column(name = "id_pelanggan", length = 4)
    private String idPelanggan;

    @Column(name = "nama", length = 255, nullable = false)
    private String nama;

    @Column(name = "alamat", length = 255)
    private String alamat;

    @Column(name = "telepon", length = 20)
    private String telepon;

    protected Pelanggan() {
        // JPA
    }

    public Pelanggan(String idPelanggan, String nama, String alamat, String telepon) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
