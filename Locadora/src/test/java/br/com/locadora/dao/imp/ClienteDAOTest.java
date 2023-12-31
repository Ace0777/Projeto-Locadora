package br.com.locadora.dao.imp;

import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.model.usuario.Cliente;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDAOTest {


    final ClienteDAO dao = new ClienteDAO();
    @Test
    void inserir() {
        try {
            dao.inserir(new Cliente("teste15","luis","luis","luis",0,"luis","luis", new Locadora(1)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void alterar(){
        try {
            dao.alterar(new Cliente("narigudo","luis","luis","luis",2,"luis","123",new Locadora(1)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void buscarTodos(){
        try {
           var busca =  dao.buscarTodos();
            System.out.println(busca);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void buscarPorNome(){
        try {
            var busca =  dao.buscarPorNome("narigudo");
            System.out.println(busca);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}