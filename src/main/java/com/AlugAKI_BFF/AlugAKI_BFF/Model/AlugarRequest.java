package com.AlugAKI_BFF.AlugAKI_BFF.Model;

public class AlugarRequest {

    private Integer usuarioIdUsuario;

    public AlugarRequest() {}

    public AlugarRequest(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
}
