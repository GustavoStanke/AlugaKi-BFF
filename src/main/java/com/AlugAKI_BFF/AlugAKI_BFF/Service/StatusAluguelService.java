package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.StatusAluguel;

@Service
public class StatusAluguelService {

    private final RestTemplate restTemplate;

    @Value("${api.statusaluguel.url}")
    private String baseUrl;

    public StatusAluguelService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<StatusAluguel> listar() {
        StatusAluguel[] status = restTemplate.getForObject(baseUrl, StatusAluguel[].class);
        if (status == null) return Collections.emptyList();
        return Arrays.asList(status);
    }

    public StatusAluguel buscarPorId(int id) {
        try {
            return restTemplate.getForObject(baseUrl + "/" + id, StatusAluguel.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null;
        }
    }
}
