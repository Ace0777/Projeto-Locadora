package br.com.locadora.dao.imp;

import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.model.usuario.Funcionario;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioDAOTest {

    final FuncionarioDAO dao = new FuncionarioDAO();
    @org.junit.jupiter.api.Test
    void inserir() {
        try {
            dao.inserir(new Funcionario("aa","l","123",
                    "123",1,200, LocalDateTime.now(),LocalDateTime.now(),new Locadora(1)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void alterar() {
        try {
            dao.alterar(new Funcionario("iago","l","123",
                    "123",1,200, LocalDateTime.now(),LocalDateTime.now()));
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void buscar(){
        try {
            var busca = dao.buscar(1);
            System.out.println(busca);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void buscarPorNome(){
        try {
            var busca = dao.buscarPorNome("iago");
            System.out.println(busca);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void buscarTodos(){
        try {
            var busca = dao.buscarTodos();
            System.out.println(busca);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}