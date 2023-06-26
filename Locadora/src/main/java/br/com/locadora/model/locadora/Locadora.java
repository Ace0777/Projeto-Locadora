package br.com.locadora.model.locadora;

import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.locacao.Locacao;
import br.com.locadora.model.usuario.Cliente;
import br.com.locadora.model.usuario.Funcionario;

import java.util.ArrayList;

public class Locadora {

   private int id;

   private String nome;

   private String endereco;

   private ArrayList<Cliente> clientes;

   private ArrayList<Funcionario> funcionarios;

   private ArrayList<Disco> discos;

   private ArrayList<Locacao> locacaos;

    public Locadora(){

    }

    public Locadora(int id) {
        this.id = id;
    }

    public Locadora(int id, String nome,
                    String endereco,
                    ArrayList<Cliente> clientes, ArrayList<Funcionario> funcionarios,
                    ArrayList<Disco> discos, ArrayList<Locacao> locacaos) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.clientes = clientes;
        this.funcionarios = funcionarios;
        this.discos = discos;
        this.locacaos = locacaos;
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

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(ArrayList<Disco> discos) {
        this.discos = discos;
    }

    public ArrayList<Locacao> getLocacaos() {
        return locacaos;
    }

    public void setLocacaos(ArrayList<Locacao> locacaos) {
        this.locacaos = locacaos;
    }
}
