package ui.ft.ccit.faculty.transaksi.transaksi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ui.ft.ccit.faculty.transaksi.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.transaksi.view.TransaksiService;

import java.util.List;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    private final TransaksiService service;

    public TransaksiController(TransaksiService service) {
        this.service = service;
    }

    // =====================
    // GET ALL
    // =====================
    @GetMapping
    @Operation(summary = "Mengambil semua transaksi")
    public List<Transaksi> list() {
        return service.getAll();
    }

    // =====================
    // GET BY KODE TRANSAKSI
    // =====================
    @GetMapping("/{kodeTransaksi}")
    @Operation(summary = "Mengambil transaksi berdasarkan kode transaksi")
    public Transaksi get(@PathVariable String kodeTransaksi) {
        return service.getById(kodeTransaksi);
    }

    // =====================
    // CREATE
    // =====================
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Membuat transaksi baru")
    public Transaksi create(@RequestBody Transaksi transaksi) {
        return service.create(transaksi);
    }

    // =====================
    // DELETE
    // =====================
    @DeleteMapping("/{kodeTransaksi}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Menghapus transaksi")
    public void delete(@PathVariable String kodeTransaksi) {
        service.delete(kodeTransaksi);
    }
}
