package ui.ft.ccit.faculty.transaksi.transaksi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, String> {

    @Query("""
        SELECT DISTINCT t
        FROM Transaksi t
        LEFT JOIN FETCH t.detailTransaksi
    """)
    List<Transaksi> findAllWithDetail();
}
