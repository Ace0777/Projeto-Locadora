package br.com.locadora.model.disco;

public class Dvd {
    private String nome;
    private int dataLancamento;

    public Dvd(){

    }

    public Dvd(String nome, int dataLancamento) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(int dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
