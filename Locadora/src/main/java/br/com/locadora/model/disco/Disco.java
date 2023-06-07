package br.com.locadora.model.disco;

import br.com.locadora.model.EN.ETipoDisco;

import java.time.LocalDateTime;

public class Disco {
    private String nome;
    private int id;
    private Double valorDaLocacao;
    private LocalDateTime dataLancamento;

    private ETipoDisco tipoDisco;

    public Disco(){

    }

    public Disco( int id, String nome, Double valorDaLocacao, LocalDateTime dataLancamento, ETipoDisco tipoDisco) {
        this.nome = nome;
        this.id = id;
        this.valorDaLocacao = valorDaLocacao;
        this.dataLancamento = dataLancamento;
        this.tipoDisco = tipoDisco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValorDaLocacao() {
        return valorDaLocacao;
    }

    public void setValorDaLocacao(Double valorDaLocacao) {
        this.valorDaLocacao = valorDaLocacao;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public ETipoDisco getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(ETipoDisco tipoDisco) {
        this.tipoDisco = tipoDisco;
    }
}
