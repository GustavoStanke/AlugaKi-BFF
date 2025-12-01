package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Aluguel;
import com.AlugAKI_BFF.AlugAKI_BFF.Model.AlugarRequest;

@Service
public class AluguelService {

    private final RestTemplate restTemplate;

    @Value("${api.aluguel.url}")
    private String baseUrl;

    public AluguelService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Aluguel> listarAlugueis() {
        Aluguel[] alugueis = restTemplate.getForObject(baseUrl, Aluguel[].class);
        if (alugueis == null) return Collections.emptyList();
        return Arrays.asList(alugueis);
    }

    public Aluguel buscarPorId(int id) {
        try {
            return restTemplate.getForObject(baseUrl + "/" + id, Aluguel.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null;
        }
    }

    public List<Aluguel> listarPorStatus(int statusId) {
        Aluguel[] alugueis = restTemplate.getForObject(baseUrl + "/status/" + statusId, Aluguel[].class);
        if (alugueis == null) return Collections.emptyList();
        return Arrays.asList(alugueis);
    }

    public Aluguel criarAluguel(Aluguel aluguel) {
        aluguel.setIdAluguel(null);
        return restTemplate.postForObject(baseUrl, aluguel, Aluguel.class);
    }

    public void atualizarAluguel(int id, Aluguel aluguel) {
        restTemplate.put(baseUrl + "/" + id, aluguel);
    }

    public void deletarAluguel(int id) {
        restTemplate.delete(baseUrl + "/" + id);
    }

    public Aluguel marcarComoAlugado(int id, Integer usuarioId) {
        AlugarRequest body = new AlugarRequest(usuarioId);
        return restTemplate.postForObject(baseUrl + "/" + id + "/alugar", body, Aluguel.class);
    }
}
