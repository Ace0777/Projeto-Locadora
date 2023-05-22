package br.com.locadora.model.usuario;

import java.time.LocalDateTime;

public class Funcionario extends Usuario {

    private double salario;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private int idLocadora;

    public Funcionario(){

    }

    public Funcionario(String nome, String login, String senha, String email, int id, double salario, LocalDateTime entrada, LocalDateTime saida, int idLocadora) {
        super(nome, login, senha, email, id);
        this.salario = salario;
        this.entrada = entrada;
        this.saida = saida;
        this.idLocadora = idLocadora;
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
}
