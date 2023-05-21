package br.com.locadora.model.usuario;

import java.time.LocalDate;

public class Cliente extends Usuario {

    private LocalDate dataNascimento;

    public Cliente(){

    }

    public Cliente(String nome, String login, String senha, String email, LocalDate dataNascimento) {
        super(nome, login, senha, email);
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
