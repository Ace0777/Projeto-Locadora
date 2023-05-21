package br.com.locadora.model.dvd;

import br.com.locadora.model.EN.EgeneroFilme;

import java.time.Year;

public class Filme extends Dvd{

    private EgeneroFilme generoFilme;

    public Filme() {

    }

    public Filme(String nome, int dataLancamento, EgeneroFilme generoFilme) {
        super(nome, dataLancamento);
        this.generoFilme = generoFilme;
    }

    public EgeneroFilme getGeneroFilme() {
        return generoFilme;
    }

    public void setGeneroFilme(EgeneroFilme generoFilme) {
        this.generoFilme = generoFilme;
    }
}
