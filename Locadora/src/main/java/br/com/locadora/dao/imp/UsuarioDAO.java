package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.usuario.Usuario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UsuarioDAO implements IGenericDAO<Usuario, Integer> {
    @Override
    public void inserir(Usuario obj) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.usuarios " +
                    "(nome, login, senha, email) " +
                    "VALUES(?, ?, ?, ?);";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getLogin());
            pst.setString(3, obj.getSenha());
            pst.setString(4, obj.getEmail());


            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Usuario obj) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "UPDATE locadora.usuarios " +
                    "SET nome=?, login=?, senha=?, email=? " +
                    "WHERE id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getLogin());
            pst.setString(3, obj.getSenha());
            pst.setString(4, obj.getEmail());

            pst.execute();
        }finally {
            c.close();
        }
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
