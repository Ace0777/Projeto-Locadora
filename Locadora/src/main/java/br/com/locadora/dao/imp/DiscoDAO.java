package br.com.locadora.dao.imp;
import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.EN.ETipoDisco;
import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class DiscoDAO implements IGenericDAO<Disco,Integer> {

    public void inserir(Disco obj) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.discos " +
                    "(nome, valorDaLocacao, dataLancamento, tipoDisco, alugado)  " +
                    "VALUES(?, ?, ?, ?, false);";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getValorDaLocacao());
            pst.setString(3, obj.getDataLancamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            pst.setString(4, obj.getTipoDisco().toString());


            pst.execute();
        } finally {
            c.close();
        }
    }

    public Disco buscar(Integer key) throws SQLException, ClassNotFoundException{

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, nome, valorDaLocacao, dataLancamento, tipoDisco  " +
                    "FROM locadora.discos " +
                    "WHERE id = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Disco disco = null;

            if (resultado.next()) {

                disco = new Disco(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getDouble("valorDaLocacao"),
                        resultado.getTimestamp("dataLancamento").toLocalDateTime(),
                        ETipoDisco.valueOf(resultado.getString("tipoDisco")));
            }

            return disco;

        }finally {
            c.close();
        }
    }

    public void apagar(Disco obj) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "DELETE FROM locadora.discos " +
                    "WHERE id= ? ;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1,obj.getId());

            pst.execute();
        }finally {
            c.close();
        }
    }

    public void alterar (Disco obj) throws SQLException, ClassNotFoundException{

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "UPDATE locadora.discos " +
                    "SET nome=?, valorDaLocacao=?, dataLancamento=?, tipoDisco=? "+
                    "WHERE id=? ;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getValorDaLocacao());
            pst.setString(3, obj.getDataLancamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            pst.setString(4, obj.getTipoDisco().toString());
            pst.setInt(5,obj.getId());

            pst.execute();
        }finally {
            c.close();
        }
    }

    public ArrayList<Disco> buscarPorNome(String key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, nome, valorDaLocacao, dataLancamento, tipoDisco " +
                    "FROM locadora.discos " +
                    "WHERE nome LIKE ? ;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, "%" + key + "%");

            ResultSet resultado = pst.executeQuery();

            return getRegistroToDiscos(resultado);
        }finally {
            c.close();
        }
    }

    public double somaMensalidades() throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "SELECT sum(valorDaLocacao) FROM locadora.discos;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getDouble(1);
        } finally {
            c.close();
        }
    }
    public ArrayList<Disco> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, nome, valorDaLocacao, dataLancamento, tipoDisco " +
                    "FROM locadora.discos;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToDiscos(resultado);
        }finally {
            c.close();
        }
    }


    public ArrayList<Disco> buscarTodosDisponiveis() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, nome, valorDaLocacao, dataLancamento, tipoDisco " +
                    "FROM locadora.discos " +
                    "WHERE alugado = 0 ;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToDiscos(resultado);

        }finally {
            c.close();
        }
    }

    public void atualizarAlugados (Integer id, int alugado) throws SQLException, ClassNotFoundException{

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "UPDATE locadora.discos " +
                    "SET alugado=? "+
                    "WHERE id=? ;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,alugado);
            pst.setInt(2,id);

            pst.execute();
        }finally {
            c.close();
        }
    }


    public ArrayList<Disco> buscarTodosAlugados(int id) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, nome, valorDaLocacao, dataLancamento, tipoDisco " +
                    "FROM locadora.discos " +
                    "WHERE alugado = ? ;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1,id);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToDiscos(resultado);
        }finally {
            c.close();
        }
    }


    private static ArrayList<Disco> getRegistroToDiscos(ResultSet resultado) throws SQLException {


        ArrayList<Disco> lista = new ArrayList<>();

        while (resultado.next()){
            Disco ds = new Disco(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getDouble("valorDaLocacao"),
                    resultado.getTimestamp("dataLancamento").toLocalDateTime(),
                    ETipoDisco.valueOf(resultado.getString("tipoDisco")));

            lista.add(ds);
        }


        return lista;
    }

    public int quantidade() throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT count(*) " +
                    "FROM locadora.discos ;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1) ;
        }finally {
            c.close();
        }
    }

    public ArrayList<Disco> buscarPorLocadora(Integer key) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, nome, valorDaLocacao, dataLancamento, tipoDisco " +
                    "FROM locadora.discos " +
                    "WHERE idLocadora = ?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToDiscos(resultado);
        }finally {
            c.close();
        }
    }
}


