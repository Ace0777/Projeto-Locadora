package br.com.locadora.model.locacao;

import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.usuario.Cliente;
import br.com.locadora.model.usuario.Funcionario;

import java.time.LocalDateTime;

public class Locacao {
   private int id;
    private Disco disco;
    private Funcionario funcionario;
    private Cliente cliente;
   private LocalDateTime entrega;
    private LocalDateTime locacao;

    public Locacao(){

    }

    public Locacao(int id, Disco disco, Funcionario funcionario, Cliente cliente, LocalDateTime entrega, LocalDateTime locacao) {
        this.id = id;
        this.disco = disco;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.entrega = entrega;
        this.locacao = locacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getEntrega() {
        return entrega;
    }

    public void setEntrega(LocalDateTime entrega) {
        this.entrega = entrega;
    }

    public LocalDateTime getLocacao() {
        return locacao;
    }

    public void setLocacao(LocalDateTime locacao) {
        this.locacao = locacao;
    }


}
