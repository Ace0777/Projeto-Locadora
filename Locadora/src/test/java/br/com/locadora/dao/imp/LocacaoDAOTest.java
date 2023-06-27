package br.com.locadora.dao.imp;

import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.locacao.Locacao;
import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.model.usuario.Cliente;
import br.com.locadora.model.usuario.Funcionario;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LocacaoDAOTest {

    final LocacaoDAO dao = new LocacaoDAO();
    @org.junit.jupiter.api.Test
    void inserir() {
      try {
        dao.inserir(new Locacao(9,LocalDateTime.now(),LocalDateTime.now(),new Disco(1),
                new Funcionario(1),new Cliente(1),new Locadora(1)));
      } catch (SQLException e) {
          throw new RuntimeException(e);
      } catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      }
    }

    @org.junit.jupiter.api.Test
    void alterar(){
        try {
            dao.alterar(new Locacao(3,LocalDateTime.now(),LocalDateTime.now(),new Disco(1),
                    new Funcionario(1),new Cliente(1),new Locadora(1)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @org.junit.jupiter.api.Test
    void buscar(){
        try {
            dao.buscar(4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    void buscarTodos(){
        try {
            dao.buscarTodos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}