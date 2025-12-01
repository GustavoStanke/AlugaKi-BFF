package com.AlugAKI_BFF.AlugAKI_BFF.Controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.StatusAluguel;
import com.AlugAKI_BFF.AlugAKI_BFF.Service.StatusAluguelService;

@RestController
@RequestMapping("/bff/statusaluguel")
@CrossOrigin(origins = "*")
public class StatusAluguelController {

    private final StatusAluguelService statusAluguelService;

    public StatusAluguelController(StatusAluguelService statusAluguelService) {
        this.statusAluguelService = statusAluguelService;
    }

    @GetMapping
    public List<StatusAluguel> listar() {
        return statusAluguelService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusAluguel> buscarPorId(@PathVariable int id) {
        StatusAluguel status = statusAluguelService.buscarPorId(id);
        if (status == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(status);
    }
}
