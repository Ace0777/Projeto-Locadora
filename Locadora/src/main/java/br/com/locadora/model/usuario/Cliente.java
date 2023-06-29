package br.com.locadora.model.usuario;

import br.com.locadora.model.locadora.Locadora;

import java.time.LocalDate;

public class Cliente extends Usuario {

    private String documento;

    private String telefone;

    private Locadora locadora;

    public Cliente(){

    }

    public Cliente(int id){
        super(null,null,null,null,id);
    }

    public Cliente(String nome, String login, String senha, String email, int id, String documento, String telefone, Locadora locadora) {
        super(nome, login, senha, email, id);
        this.documento = documento;
        this.telefone = telefone;
        this.locadora = locadora;
    }

    public Cliente(String nome, String login, String senha, String email, int id, String documento, String telefone) {
        super(nome, login, senha, email, id);
        this.documento = documento;
        this.telefone = telefone;
    }


    public Cliente(int id, String nome) {
        super(nome,null,null,null,id);
    }


    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
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
