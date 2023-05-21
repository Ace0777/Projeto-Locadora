package br.com.locadora.model.dvd;

import java.time.Year;

public class Musica extends Dvd{
    public Musica() {

    }

    public Musica(String nome, Year dataLancamento) {
        super(nome, dataLancamento);
    }
}
