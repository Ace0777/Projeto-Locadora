package br.com.locadora.model.locadora;

import br.com.locadora.model.locacao.Locacao;

import java.util.ArrayList;

public class Locadora {
    private ArrayList<Locacao> locacaos;

    public Locadora(){

    }

    public Locadora(ArrayList<Locacao> locacaos) {
        this.locacaos = locacaos;
    }
}
