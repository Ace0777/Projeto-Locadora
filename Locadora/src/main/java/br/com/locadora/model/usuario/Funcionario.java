package br.com.locadora.model.usuario;

public class Funcionario extends Usuario {

    private double salarioFixo, horasTrabalho;

    public Funcionario(){

    }

    public Funcionario(String nome, String login, String senha, String email, double salarioFixo, double horasTrabalho) {
        super(nome, login, senha, email);
        this.salarioFixo = salarioFixo;
        this.horasTrabalho = horasTrabalho;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getHorasTrabalho() {
        return horasTrabalho;
    }

    public void setHorasTrabalho(double horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }
}
