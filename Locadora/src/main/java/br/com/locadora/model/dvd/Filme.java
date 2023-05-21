package br.com.locadora.model.dvd;

import java.time.Year;

public class Filme extends Dvd{

    public Filme() {

    }

    public Filme(String nome, Year dataLancamento) {
        super(nome, dataLancamento);
    }
}
