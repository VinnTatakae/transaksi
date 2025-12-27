package ui.ft.ccit.faculty.transaksi.transaksi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import ui.ft.ccit.faculty.transaksi.barang.model.Barang;

@Entity
@Table(name = "detail_transaksi")
@IdClass(DetailTransaksiId.class)
public class DetailTransaksi {

    @Id
    @ManyToOne
    @JoinColumn(name = "kode_transaksi")
    @JsonBackReference
    private Transaksi transaksi;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @Column(nullable = false)
    private Integer jumlah;

    @Column(nullable = false)
    private Integer harga;

    @Column(nullable = false)
    private Double subtotal;

    // ===== GETTER SETTER =====

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
