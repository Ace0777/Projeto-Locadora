package br.com.locadora.model.dvd;

import java.time.Year;

public class Dvd {
    private String nome;
    private Year dataLancamento;

    public Dvd(){

    }

    public Dvd(String nome, Year dataLancamento) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Year getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Year dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
