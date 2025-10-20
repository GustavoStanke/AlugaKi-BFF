package com.AlugAKI_BFF.AlugAKI_BFF.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.AlugAKI_BFF.AlugAKI_BFF.Model.Usuario;

@Service
public class UsuarioService {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:3000/usuarios";
    
    public UsuarioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Usuario> listarUsuarios() {
        Usuario[] usuarios = restTemplate.getForObject(BASE_URL, Usuario[].class);
        return Arrays.asList(usuarios);
    }

    public Usuario buscarPorId(int id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, Usuario.class);
    }

    public Usuario criarUsuario(Usuario usuario) {
        return restTemplate.postForObject(BASE_URL, usuario, Usuario.class);
    }

    public void atualizarUsuario(int id, Usuario usuario) {
        restTemplate.put(BASE_URL + "/" + id, usuario);
    }

    public void deletarUsuario(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}
