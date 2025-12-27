package ui.ft.ccit.faculty.transaksi.pemasok.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.pemasok.view.PemasokService;

import java.util.List;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController {

    private final PemasokService service;

    public PemasokController(PemasokService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Mengambil semua pemasok")
    public List<Pemasok> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Mengambil satu pemasok")
    public Pemasok get(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Mencari pemasok berdasarkan nama")
    public List<Pemasok> search(@RequestParam String q) {
        return service.searchByNama(q);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Menambah pemasok")
    public Pemasok create(@RequestBody Pemasok pemasok) {
        return service.save(pemasok);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update pemasok")
    public Pemasok update(@PathVariable String id,
                          @RequestBody Pemasok pemasok) {
        return service.update(id, pemasok);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Hapus pemasok")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
