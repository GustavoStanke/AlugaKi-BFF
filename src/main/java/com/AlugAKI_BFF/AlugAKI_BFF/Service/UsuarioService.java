package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
        if (usuarios == null) return Collections.emptyList();
        return Arrays.asList(usuarios);
    }

    public Usuario buscarPorId(int id) {
        try {
            return restTemplate.getForObject(baseUrl + "/" + id, Usuario.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null;
        }
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setIdUsuario(null);
        return restTemplate.postForObject(baseUrl, usuario, Usuario.class);
    }

    public void atualizarUsuario(int id, Usuario usuario) {
        restTemplate.put(baseUrl + "/" + id, usuario);
    }

    public void deletarUsuario(int id) {
        restTemplate.delete(baseUrl + "/" + id);
    }

    public Usuario login(Object credenciais) {
        return restTemplate.postForObject(baseUrl + "/login", credenciais, Usuario.class);
    }

    public void redefinirSenha(Object payload) {
        restTemplate.postForLocation(baseUrl + "/redefinir-senha", payload);
    }
}
