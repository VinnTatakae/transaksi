package ui.ft.ccit.faculty.transaksi.karyawan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import ui.ft.ccit.faculty.transaksi.karyawan.model.Karyawan;
import ui.ft.ccit.faculty.transaksi.karyawan.view.KaryawanService;

import java.util.List;

@RestController
@RequestMapping("/api/karyawan")
public class KaryawanController {

    private final KaryawanService service;

    public KaryawanController(KaryawanService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Mengambil semua karyawan")
    public List<Karyawan> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Mengambil satu karyawan")
    public Karyawan get(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Mencari karyawan berdasarkan nama")
    public List<Karyawan> search(@RequestParam String q) {
        return service.searchByNama(q);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Menambah karyawan")
    public Karyawan create(@RequestBody Karyawan karyawan) {
        return service.save(karyawan);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update karyawan")
    public Karyawan update(@PathVariable String id,
                            @RequestBody Karyawan karyawan) {
        return service.update(id, karyawan);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Hapus karyawan")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
