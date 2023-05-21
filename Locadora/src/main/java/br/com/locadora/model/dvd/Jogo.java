package br.com.locadora.model.dvd;

import java.time.Year;

public class Jogo extends Dvd{
    public Jogo() {

    }

    public Jogo(String nome, Year dataLancamento) {
        super(nome, dataLancamento);
    }
}
