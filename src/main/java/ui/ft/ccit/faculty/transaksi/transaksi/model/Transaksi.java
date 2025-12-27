package ui.ft.ccit.faculty.transaksi.transaksi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Column(name = "tgl_transaksi", nullable = false)
    private LocalDateTime tglTransaksi;

    @Column(name = "id_pelanggan", length = 4, nullable = false)
    private String idPelanggan;

    @Column(name = "id_karyawan", length = 4, nullable = false)
    private String idKaryawan;

    @Column(name = "total", nullable = false)
    private Double total;

    // RELASI KE DETAIL TRANSAKSI
    @OneToMany(
        mappedBy = "transaksi",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<DetailTransaksi> detailTransaksi;

    // =====================
    // GETTER & SETTER
    // =====================

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public LocalDateTime getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(LocalDateTime tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<DetailTransaksi> getDetailTransaksi() {
        return detailTransaksi;
    }

    public void setDetailTransaksi(List<DetailTransaksi> detailTransaksi) {
        this.detailTransaksi = detailTransaksi;
    }
}
