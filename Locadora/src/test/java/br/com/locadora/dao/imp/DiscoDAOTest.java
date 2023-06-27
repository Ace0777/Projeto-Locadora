package br.com.locadora.dao.imp;

import br.com.locadora.model.EN.ETipoDisco;
import br.com.locadora.model.disco.Disco;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DiscoDAOTest {

    final DiscoDAO dao = new DiscoDAO();
    @org.junit.jupiter.api.Test
    void inserir() {
        try {
            dao.inserir(new Disco(0,"Luis",2.3, LocalDateTime.now(), ETipoDisco.filme));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    void buscar() {
        try {
            dao.buscar(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @org.junit.jupiter.api.Test
    void buscarPorNome() {
        try {
            var resultdo = dao.buscarPorNome("luis");
            System.out.println(resultdo);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test

    void quantidade() {
        try {
            var resultdo = dao.quantidade();
            System.out.println(resultdo);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @org.junit.jupiter.api.Test
    void alterar() {
        try {
            dao.alterar(new Disco(1,"iago",300.0,LocalDateTime.now(),ETipoDisco.jogo));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}