package com.AlugAKI_BFF.AlugAKI_BFF.Controler;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Endereco;
import com.AlugAKI_BFF.AlugAKI_BFF.Service.EnderecoService;

@RestController
@RequestMapping("/bff/enderecos")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class EnderecoController {

    private final EnderecoService enderecoService; // <-- corrigido

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable int id) {
        return enderecoService.getEnderecoById(id).orElse(null);
    }

    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.createOrUpdateEndereco(endereco);
    }

    @PutMapping("/{id}")
    public void atualizarEndereco(@PathVariable int id, @RequestBody Endereco endereco) {
        endereco.setId(id);
        enderecoService.createOrUpdateEndereco(endereco);
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable int id) {
        enderecoService.deleteEndereco(id);
    }
}
