package br.com.locadora.model.dvd;

import br.com.locadora.model.EN.EgeneroJogo;

import java.time.Year;

public class Jogo extends Dvd{

    private EgeneroJogo generojogo;
    public Jogo() {

    }

    public Jogo(String nome, int dataLancamento, EgeneroJogo generojogo) {
        super(nome, dataLancamento);
        this.generojogo = generojogo;
    }

    public EgeneroJogo getGenerojogo() {
        return generojogo;
    }

    public void setGenerojogo(EgeneroJogo generojogo) {
        this.generojogo = generojogo;
    }
}
