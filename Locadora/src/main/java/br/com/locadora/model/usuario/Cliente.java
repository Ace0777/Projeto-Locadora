package br.com.locadora.model.usuario;

import java.time.LocalDate;

public class Cliente extends Usuario {

    private String documento;

    private String telefone;

    public Cliente(){

    }

    public Cliente(String nome, String login, String senha, String email, int id, String documento, String telefone) {
        super(nome, login, senha, email, id);
        this.documento = documento;
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
