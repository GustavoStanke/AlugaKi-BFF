package com.AlugAKI_BFF.AlugAKI_BFF.Model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String telefone;
    private int enderecoId;
    private boolean status;

    // === Construtor vazio (necessário para frameworks como Spring e Jackson) ===
    public usuario() {}

    // === Construtor completo ===
    public usuario(int id, String nome, String email, String senha, String cpfCnpj, String telefone, int enderecoId, boolean status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.enderecoId = enderecoId;
        this.status = status;
    }

    // === Getters e Setters ===
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // === Opcional: método toString() para depuração ===
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", enderecoId=" + enderecoId +
                ", status=" + status +
                '}';
    }
}
