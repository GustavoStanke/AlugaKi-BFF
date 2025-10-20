package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Usuario;

@Service
public class UsuarioService {

    private final RestTemplate restTemplate;

    @Value("${api.usuario.url}")
    private String baseUrl;

    public UsuarioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Usuario> listarUsuarios() {
        Usuario[] usuarios = restTemplate.getForObject(baseUrl, Usuario[].class);
        return Arrays.asList(usuarios);
    }

    public Usuario buscarPorId(int id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Usuario.class);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return restTemplate.postForObject(baseUrl, usuario, Usuario.class);
    }

    public void atualizarUsuario(int id, Usuario usuario) {
        restTemplate.put(baseUrl + "/" + id, usuario);
    }

    public void deletarUsuario(int id) {
        restTemplate.delete(baseUrl + "/" + id);
    }
}