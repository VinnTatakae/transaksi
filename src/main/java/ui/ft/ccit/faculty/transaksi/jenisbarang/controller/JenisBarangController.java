package ui.ft.ccit.faculty.transaksi.jenisbarang.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.jenisbarang.view.JenisBarangService;

import java.util.List;

@RestController
@RequestMapping("/api/jenisbarang")
public class JenisBarangController {

    private final JenisBarangService service;

    public JenisBarangController(JenisBarangService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Mengambil semua jenis barang")
    public List<JenisBarang> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Mengambil satu jenis barang")
    public JenisBarang get(@PathVariable Byte id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Mencari jenis barang berdasarkan nama")
    public List<JenisBarang> search(@RequestParam String q) {
        return service.searchByNama(q);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Menambah jenis barang")
    public JenisBarang create(@RequestBody JenisBarang jenisBarang) {
        return service.save(jenisBarang);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update jenis barang")
    public JenisBarang update(@PathVariable Byte id,
                              @RequestBody JenisBarang jenisBarang) {
        return service.update(id, jenisBarang);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Hapus jenis barang")
    public void delete(@PathVariable Byte id) {
        service.delete(id);
    }
}
