package br.com.locadora.model.locacao;

import br.com.locadora.model.dvd.Dvd;
import br.com.locadora.model.dvd.Filme;
import br.com.locadora.model.dvd.Musica;

import java.io.File;
import java.time.LocalDateTime;

public class Locacao {

    //ticket de locacao
    private LocalDateTime entrada;
    private LocalDateTime saida;

    private Dvd dvd;
    private Filme filme;
    private Musica musica;

    public Locacao(LocalDateTime entrada, LocalDateTime saida, Dvd dvd, Filme filme, Musica musica) {
        this.entrada = entrada;
        this.saida = saida;
        this.dvd = dvd;
        this.filme = filme;
        this.musica = musica;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }
}
