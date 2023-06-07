package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.EN.ETipoDisco;
import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.usuario.Usuario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
            pst.setInt(5,obj.getId());

            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public void apagar(Usuario obj) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "DELETE FROM locadora.usuarios " +
                    "WHERE id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,obj.getId());

            pst.execute();
        }finally {
            c.close();
        }

    }

    @Override
    public Usuario buscar(Integer key) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT nome, login, senha, email, id " +
                    "FROM locadora.usuarios; " +
                    "WHERE id = ?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Usuario usuario = null;

            if(resultado.next()){
                usuario = new Usuario(resultado.getString(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getInt(5));
            }

            return usuario;

        }finally {
            c.close();
        }

    }

    @Override
    public ArrayList<Usuario> buscarTodos() throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT nome, login, senha, email, id " +
                    "FROM locadora.usuarios; ";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToUsuarios(resultado);

        }finally {
            c.close();
        }


    }

    private static ArrayList<Usuario> getRegistroToUsuarios(ResultSet resultado) throws SQLException {

        ArrayList<Usuario> lista = new ArrayList<>();

        while (resultado.next()){

            Usuario us = new Usuario(resultado.getString(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getInt(5));

            lista.add(us);
        }

        return lista;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT count(*) " +
                    "FROM locadora.usuarios ;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);

        }finally {
            c.close();
        }
    }
}
