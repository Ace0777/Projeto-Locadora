package br.com.locadora.model.usuario;

import br.com.locadora.model.locadora.Locadora;

import java.time.LocalDateTime;

public class Funcionario extends Usuario {

    private double salario;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Locadora locadora;

    public Funcionario(){

    }

    public Funcionario(String nome, String login, String senha, String email, int id, double salario, LocalDateTime entrada, LocalDateTime saida, Locadora locadora) {
        super(nome, login, senha, email, id);
        this.salario = salario;
        this.entrada = entrada;
        this.saida = saida;
        this.locadora = locadora;
    }

    public Funcionario(String nome, String login, String senha, String email, int id, double salario, LocalDateTime entrada, LocalDateTime saida) {
        super(nome, login, senha, email, id);
        this.salario = salario;
        this.entrada = entrada;
        this.saida = saida;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
}
