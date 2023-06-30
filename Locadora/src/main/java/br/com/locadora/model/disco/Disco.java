package br.com.locadora.model.disco;

import br.com.locadora.model.EN.ETipoDisco;
import br.com.locadora.model.IN.TaxaDisco;
import br.com.locadora.model.locadora.Locadora;

import java.time.LocalDateTime;

public class Disco implements TaxaDisco {
    private String nome;
    private int id;
    private Double valorDaLocacao;
    private LocalDateTime dataLancamento;
    private Locadora locadora;
    private ETipoDisco tipoDisco;
    private boolean alugado;

    public Disco(){
        this.alugado = false;
    }

    public Disco(int id) {
        this.id = id;
        this.alugado = false;
    }

    public Disco(int id, String nome, Double valorDaLocacao, LocalDateTime dataLancamento, ETipoDisco tipoDisco) {
        this.nome = nome;
        this.id = id;
        this.valorDaLocacao = valorDaLocacao;
        this.dataLancamento = dataLancamento;
        this.tipoDisco = tipoDisco;
        this.alugado = false;
    }

    public Disco(int id, String nome, Double valorDaLocacao, LocalDateTime dataLancamento, ETipoDisco tipoDisco,Locadora locadora) {
        this.nome = nome;
        this.id = id;
        this.valorDaLocacao = valorDaLocacao;
        this.dataLancamento = dataLancamento;
        this.tipoDisco = tipoDisco;
        this.locadora = locadora;
        this.alugado = false;
    }

    public Disco(int id, double valorDaLocacao, String nome) {
        this.id = id;
        this.valorDaLocacao = valorDaLocacao;
        this.nome = nome;
        this.alugado = false;
    }


    public double TaxaTipoDisco(){
        if(tipoDisco == ETipoDisco.musica){
            return 2.75;
        } else if (tipoDisco == ETipoDisco.filme) {
           return  1.43;
        }else if (tipoDisco == ETipoDisco.jogo){
            return 3.77;
        }
        return 0;
    }

    public Boolean getAlugado() {
        return alugado;
    }

    public void setAlugado(Boolean alugado) {
        this.alugado = alugado;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
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
        return valorDaLocacao + TaxaTipoDisco();
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
