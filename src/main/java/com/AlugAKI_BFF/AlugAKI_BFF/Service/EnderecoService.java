package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Endereco;

@Service
public class EnderecoService {

    private final RestTemplate restTemplate;

    @Value("${api.endereco.url}")
    private String baseUrl;

    public EnderecoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Endereco> getAllEnderecos() {
        Endereco[] enderecos = restTemplate.getForObject(baseUrl, Endereco[].class);
        return Arrays.asList(enderecos);
    }

    public java.util.Optional<Endereco> getEnderecoById(int id) {
        try {
            Endereco endereco = restTemplate.getForObject(baseUrl + "/" + id, Endereco.class);
            return java.util.Optional.ofNullable(endereco);
        } catch (org.springframework.web.client.HttpClientErrorException.NotFound e) {
            return java.util.Optional.empty();
        }
    }

    public Endereco createOrUpdateEndereco(Endereco endereco) {
        if (endereco.getId() == 0) {
            return restTemplate.postForObject(baseUrl, endereco, Endereco.class);
        } else {
            restTemplate.put(baseUrl + "/" + endereco.getId(), endereco);
            return endereco;
        }
    }

    public void deleteEndereco(int id) {
        restTemplate.delete(baseUrl + "/" + id);
    }
}