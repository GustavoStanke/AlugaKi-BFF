package com.AlugAKI_BFF.AlugAKI_BFF.Controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Aluguel;
import com.AlugAKI_BFF.AlugAKI_BFF.Model.AlugarRequest;
import com.AlugAKI_BFF.AlugAKI_BFF.Service.AluguelService;

@RestController
@RequestMapping("/bff/aluguel")
@CrossOrigin(origins = "*")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public List<Aluguel> listar() {
        return aluguelService.listarAlugueis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> buscarPorId(@PathVariable int id) {
        Aluguel aluguel = aluguelService.buscarPorId(id);
        if (aluguel == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(aluguel);
    }

    @GetMapping("/status/{statusId}")
    public List<Aluguel> listarPorStatus(@PathVariable int statusId) {
        return aluguelService.listarPorStatus(statusId);
    }

    @PostMapping
    public ResponseEntity<Aluguel> criar(@RequestBody Aluguel aluguel) {
        Aluguel criado = aluguelService.criarAluguel(aluguel);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Aluguel aluguel) {
        aluguelService.atualizarAluguel(id, aluguel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        aluguelService.deletarAluguel(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/alugar")
    public ResponseEntity<Aluguel> marcarComoAlugado(@PathVariable int id, @RequestBody(required = false) AlugarRequest request) {
        Integer usuarioId = request != null ? request.getUsuarioIdUsuario() : null;
        Aluguel atualizado = aluguelService.marcarComoAlugado(id, usuarioId);
        return ResponseEntity.ok(atualizado);
    }
}
