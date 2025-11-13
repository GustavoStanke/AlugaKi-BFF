package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Periodo;

@Service
public class PeriodoService {

    private final RestTemplate restTemplate;

    @Value("${api.periodo.url}")
    private String baseUrl;

    public PeriodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Periodo> listarPeriodos() {
        Periodo[] periodos = restTemplate.getForObject(baseUrl, Periodo[].class);
        if (periodos == null) return Collections.emptyList();
        return Arrays.asList(periodos);
    }

    public Periodo buscarPorId(int id) {
        try {
            return restTemplate.getForObject(baseUrl + "/" + id, Periodo.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null;
        }
    }
}
