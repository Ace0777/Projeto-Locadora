package br.com.locadora.model.dvd;

import br.com.locadora.model.EN.EgeneroMusica;

import java.time.Year;

public class Musica extends Dvd{

    private EgeneroMusica generoMusica;
    public Musica() {

    }

    public Musica(String nome, int dataLancamento, EgeneroMusica generoMusica) {
        super(nome, dataLancamento);
        this.generoMusica = generoMusica;
    }

    public EgeneroMusica getGeneroMusica() {
        return generoMusica;
    }

    public void setGeneroMusica(EgeneroMusica generoMusica) {
        this.generoMusica = generoMusica;
    }
}
