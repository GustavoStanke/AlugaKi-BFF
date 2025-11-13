package com.AlugAKI_BFF.AlugAKI_BFF.Controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Periodo;
import com.AlugAKI_BFF.AlugAKI_BFF.Service.PeriodoService;

@RestController
@RequestMapping("/bff/periodo")
@CrossOrigin(origins = "*")
public class PeriodoController {

    private final PeriodoService periodoService;

    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @GetMapping
    public List<Periodo> listarPeriodos() {
        return periodoService.listarPeriodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Periodo> buscarPorId(@PathVariable int id) {
        Periodo p = periodoService.buscarPorId(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }
}
