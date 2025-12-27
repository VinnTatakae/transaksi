package ui.ft.ccit.faculty.transaksi.transaksi.model;

import java.io.Serializable;
import java.util.Objects;

public class DetailTransaksiId implements Serializable {

    private String transaksi;
    private String barang;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetailTransaksiId)) return false;
        DetailTransaksiId that = (DetailTransaksiId) o;
        return Objects.equals(transaksi, that.transaksi) &&
               Objects.equals(barang, that.barang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaksi, barang);
    }
}
