package com.portfolio.security;

public class JwtAuthResponseDto {

    private String tokenDeAcceso;
    private String tipoDeToken = "Bearer";

    public JwtAuthResponseDto(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }   

    public String getTokenDeAcceso() {
        return tokenDeAcceso;
    }

    public void setTokenDeAcceso(String tokenDeAcceso) {
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public String getTipoDeToken() {
        return tipoDeToken;
    }

    public void setTipoDeToken(String tipoDeToken) {
        this.tipoDeToken = tipoDeToken;
    }
}
