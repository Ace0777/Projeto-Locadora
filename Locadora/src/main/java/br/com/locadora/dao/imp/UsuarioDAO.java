package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.usuario.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO implements IGenericDAO<Usuario, Integer> {
    @Override
    public void inserir(Usuario obj) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void alterar(Usuario obj) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void apagar(Usuario obj) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Usuario buscar(Integer key) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Usuario> buscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
