package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.model.usuario.Cliente;
import br.com.locadora.model.usuario.Funcionario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO implements IGenericDAO<Cliente, Integer> {
    @Override
    public void inserir(Cliente obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.clientes " +
                    "(documento, telefone, idLocadora, nome, login, senha) " +
                    "VALUES(?, ?, ?, ?, ?, ?); ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getDocumento());
            pst.setString(2,obj.getTelefone());
            pst.setInt(3, obj.getLocadora().getId());
            pst.setString(4, obj.getNome());
            pst.setString(5, obj.getLogin());
            pst.setString(6, obj.getSenha());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Cliente obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "UPDATE locadora.clientes " +
                    "SET documento= ? , telefone= ?, nome= ?, login=?, senha=? " +
                    "WHERE id= ?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,obj.getDocumento());
            pst.setString(2,obj.getTelefone());
            pst.setString(3,obj.getNome());
            pst.setString(4, obj.getLogin());
            pst.setString(5, obj.getSenha());
            pst.setInt(6, obj.getId());

            pst.execute();
        }finally {
            c.close();
        }

    }

    @Override
    public void apagar(Cliente obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "DELETE FROM locadora.clientes " +
                    "WHERE id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,obj.getId());

            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public Cliente buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT c.* " +
                    "FROM clientes c " +
                    "WHERE id = ? ;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            Cliente cliente = null;


            if (resultado.next()) {
               cliente = new Cliente(
                       resultado.getString(5),
                       resultado.getString(6),
                       resultado.getString(7),
                       "",
                       resultado.getInt(1),
                       resultado.getString(2),
                       resultado.getString(3));
            }

            return cliente;
        }finally {
            c.close();
        }
    }

    @Override
    public ArrayList<Cliente> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT * " +
                    "FROM locadora.clientes; ";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToCliente(resultado);

        }finally {
            c.close();
        }
    }

    public ArrayList<Cliente> buscarPorNome(String key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT c.* " +
                    "FROM clientes c " +
                    "WHERE nome like ? ;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, "%" + key + "%");

            ResultSet resultado = pst.executeQuery();

            return getRegistroToCliente(resultado);

        }finally {
            c.close();
        }
    }

    private static ArrayList<Cliente> getRegistroToCliente(ResultSet resultado) throws SQLException{

        ArrayList<Cliente> lista = new ArrayList<>();

        while (resultado.next()){

            Cliente cl = new Cliente(
                    resultado.getString(5),
                    resultado.getString(6),
                    resultado.getString(7),
                    "",
                    resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3));
            lista.add(cl);
        }

        return lista;

    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT count(*) " +
                    "FROM locadora.clientes ;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1) ;
        }finally {
            c.close();
        }

    }

    public ArrayList<Cliente> buscarPorLocadora(Integer key) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, documento, telefone  " +
                    "FROM cliente.discos " +
                    "WHERE idLocaodra = ?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToCliente(resultado);

        }finally {
            c.close();
        }
    }
}
