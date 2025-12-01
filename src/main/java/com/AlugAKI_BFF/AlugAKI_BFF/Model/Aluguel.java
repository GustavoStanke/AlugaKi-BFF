package com.AlugAKI_BFF.AlugAKI_BFF.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Aluguel {

    private Integer idAluguel;
    private Integer produtoIdProduto;
    private Integer usuarioIdUsuario; // opcional
    private LocalDateTime dataIni;
    private LocalDateTime dataFim;
    private BigDecimal valorTotal;
    private Integer statusAluguelIdStatus;

    public Aluguel() {}

    public Integer getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Integer getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(Integer produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    public Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public LocalDateTime getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDateTime dataIni) {
        this.dataIni = dataIni;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getStatusAluguelIdStatus() {
        return statusAluguelIdStatus;
    }

    public void setStatusAluguelIdStatus(Integer statusAluguelIdStatus) {
        this.statusAluguelIdStatus = statusAluguelIdStatus;
    }
}
