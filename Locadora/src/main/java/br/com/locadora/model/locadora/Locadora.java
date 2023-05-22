package br.com.locadora.model.locadora;

import br.com.locadora.model.locacao.Locacao;
import br.com.locadora.model.usuario.Cliente;
import br.com.locadora.model.usuario.Funcionario;

import java.util.ArrayList;

public class Locadora {

   private int id;

   private String nome;

   private String endereco;

    public Locadora(){

    }
    public Locadora(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
