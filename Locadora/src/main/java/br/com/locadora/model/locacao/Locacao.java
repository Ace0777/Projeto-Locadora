package br.com.locadora.model.locacao;

import java.time.LocalDateTime;

public class Locacao {
   private int id;
    private int idDisco;
    private int idFuncionario;
    private int idCliente;
   private LocalDateTime entrega;
    private LocalDateTime locacao;

    public Locacao(){

    }

    public Locacao(int id, int idDisco, int idFuncionario, int idCliente, LocalDateTime entrega, LocalDateTime locacao) {
        this.id = id;
        this.idDisco = idDisco;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.entrega = entrega;
        this.locacao = locacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
