package ui.ft.ccit.faculty.transaksi.transaksi.view;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ui.ft.ccit.faculty.transaksi.DataNotFoundException;
import ui.ft.ccit.faculty.transaksi.barang.model.Barang;
import ui.ft.ccit.faculty.transaksi.barang.model.BarangRepository;
import ui.ft.ccit.faculty.transaksi.transaksi.model.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransaksiService {

    private final TransaksiRepository transaksiRepository;
    private final BarangRepository barangRepository;

    public TransaksiService(
            TransaksiRepository transaksiRepository,
            BarangRepository barangRepository
    ) {
        this.transaksiRepository = transaksiRepository;
        this.barangRepository = barangRepository;
    }

    // =====================
    // GET ALL (FETCH DETAIL)
    // =====================
    public List<Transaksi> getAll() {
        return transaksiRepository.findAllWithDetail();
    }

    // =====================
    // GET BY ID
    // =====================
    public Transaksi getById(String kodeTransaksi) {
        return transaksiRepository.findById(kodeTransaksi)
                .orElseThrow(() ->
                        new DataNotFoundException(
                                "Transaksi",
                                kodeTransaksi
                        )
                );
    }

        // =====================
        // CREATE
        // =====================
        public Transaksi create(Transaksi transaksi) {

        if (transaksi.getDetailTransaksi() == null
                || transaksi.getDetailTransaksi().isEmpty()) {
                throw new IllegalArgumentException(
                        "Detail transaksi wajib diisi"
                );
        }

        // set tanggal transaksi
        transaksi.setTglTransaksi(LocalDateTime.now());

        // inisialisasi total transaksi
        double total = 0.0;

        for (DetailTransaksi detail : transaksi.getDetailTransaksi()) {

                // relasi balik
                detail.setTransaksi(transaksi);

                Barang barang = barangRepository.findById(
                        detail.getBarang().getIdBarang()
                ).orElseThrow(() ->
                        new DataNotFoundException(
                                "Barang",
                                detail.getBarang().getIdBarang()
                        )
                );

                // validasi stok
                if (barang.getStok() < detail.getJumlah()) {
                throw new IllegalStateException(
                        "Stok barang " + barang.getNama() + " tidak mencukupi"
                );
                }

                // hitung subtotal
                double subtotal = barang.getHarga() * detail.getJumlah();

                detail.setHarga(barang.getHarga().intValue());
                detail.setSubtotal(subtotal);

                // akumulasi total transaksi
                total += subtotal;

                // kurangi stok
                barang.setStok(
                        (short) (barang.getStok() - detail.getJumlah())
                );
        }

        // set total transaksi
        transaksi.setTotal(total);

        return transaksiRepository.save(transaksi);
        }

        // =====================
        // DELETE
        // =====================
        public void delete(String kodeTransaksi) {
                if (!transaksiRepository.existsById(kodeTransaksi)) {
                throw new DataNotFoundException(
                        "Transaksi",
                        kodeTransaksi
                );
                }
                transaksiRepository.deleteById(kodeTransaksi);
        }
}
