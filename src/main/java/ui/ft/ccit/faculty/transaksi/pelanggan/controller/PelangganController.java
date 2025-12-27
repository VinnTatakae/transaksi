package ui.ft.ccit.faculty.transaksi.pelanggan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import ui.ft.ccit.faculty.transaksi.pelanggan.model.Pelanggan;
import ui.ft.ccit.faculty.transaksi.pelanggan.view.PelangganService;

import java.util.List;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    private final PelangganService service;

    public PelangganController(PelangganService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Mengambil semua pelanggan")
    public List<Pelanggan> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Mengambil satu pelanggan")
    public Pelanggan get(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Mencari pelanggan berdasarkan nama")
    public List<Pelanggan> search(@RequestParam String q) {
        return service.searchByNama(q);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Menambah pelanggan")
    public Pelanggan create(@RequestBody Pelanggan pelanggan) {
        return service.save(pelanggan);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update pelanggan")
    public Pelanggan update(@PathVariable String id,
                            @RequestBody Pelanggan pelanggan) {
        return service.update(id, pelanggan);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Hapus pelanggan")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
