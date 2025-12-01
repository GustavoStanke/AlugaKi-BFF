package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Produto;

@Service
public class ProdutoService {

    private final RestTemplate restTemplate;

    @Value("${api.produto.url}")
    private String baseUrl;

    public ProdutoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Produto> listarProdutos() {
        Produto[] produtos = restTemplate.getForObject(baseUrl, Produto[].class);
        if (produtos == null) return Collections.emptyList();
        return Arrays.asList(produtos);
    }

    public Produto buscarPorId(int id) {
        try {
            return restTemplate.getForObject(baseUrl + "/" + id, Produto.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null;
        }
    }

    public Produto criarProduto(Produto produto) {
        return restTemplate.postForObject(baseUrl, produto, Produto.class);
    }

    public void atualizarProduto(int id, Produto produto) {
        restTemplate.put(baseUrl + "/" + id, produto);
    }
}
