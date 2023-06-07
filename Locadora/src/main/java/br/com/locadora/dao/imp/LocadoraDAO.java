package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.model.usuario.Usuario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocadoraDAO implements IGenericDAO<Locadora, Integer> {

    @Override
    public void inserir(Locadora obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.locadoras" +
                    "(endereco, nome) " +
                    "VALUES(?, ?); ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getEndereco());
            pst.setString(2, obj.getNome());

            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public void alterar(Locadora obj) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "UPDATE locadora.locadoras " +
                    "SET endereco=?, nome=? " +
                    "WHERE id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getEndereco());
            pst.setString(2, obj.getNome());
            pst.setInt(3,obj.getId());

            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public void apagar(Locadora obj) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "DELETE FROM locadora.locadoras " +
                    "WHERE id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,obj.getId());

            pst.execute();

        }finally {
            c.close();
        }
    }

    @Override
    public Locadora buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, endereco, nome " +
                    "FROM locadora.locadoras;  " +
                    "WHERE id = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Locadora locadora = null;

            if (resultado.next()){
                locadora = new Locadora(resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3));
            }

            return locadora;

        }finally {
            c.close();
        }
    }

    @Override
    public ArrayList<Locadora> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, endereco, nome " +
                    "FROM locadora.locadoras;  ";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToLocadoras(resultado);

        }finally {
            c.close();
        }
    }

    private static ArrayList<Locadora> getRegistroToLocadoras(ResultSet resultado) throws SQLException {

        ArrayList<Locadora> lista = new ArrayList<>();

        while (resultado.next()){

            Locadora ls = new Locadora(resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3));


            lista.add(ls);
        }
        return lista;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT count(*) " +
                    "FROM locadora.locadoras;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);

        }finally {
            c.close();
        }
    }
}
