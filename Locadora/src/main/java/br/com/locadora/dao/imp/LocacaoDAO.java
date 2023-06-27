package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.EN.ETipoDisco;
import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.locacao.Locacao;
import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.model.usuario.Cliente;
import br.com.locadora.model.usuario.Funcionario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LocacaoDAO implements IGenericDAO<Locacao, Integer> {
    @Override
    public void inserir(Locacao obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.locacaos " +
                    "(idDisco, idFuncionario, idCliente, entrega, locacao, idLocadora) " +
                    "VALUES(?, ?, ?, ?, ?, ?); ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getDisco().getId());
            pst.setString(4, obj.getEntrega().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            pst.setString(5, obj.getLocacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            pst.setInt(2, obj.getFuncionario().getId());
            pst.setInt(3, obj.getCliente().getId());
            pst.setInt(6, obj.getLocadora().getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Locacao obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "UPDATE locadora.locacaos  " +
                    "SET entrega=?, locacao=? " +
                    "WHERE id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getEntrega().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
            pst.setString(2, obj.getLocacao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
            pst.setInt(3, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Locacao obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "DELETE FROM locadora.locacaos " +
                    "WHERE id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }

    }

    @Override
    public Locacao buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT l.*, d.*, f.*, j.*, lc.*  " +
                    "FROM locacaos l  " +
                    "INNER JOIN discos d on l.idDisco = d.id  " +
                    "INNER JOIN funcionarios f on l.idFuncionario = f.id  " +
                    "INNER JOIN clientes j on l.idCliente = j.id  " +
                    "WHERE id = ?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Locacao locacao = null;

            if (resultado.next()) {

                Funcionario funcionario = new Funcionario(resultado.getString(9),
                        resultado.getString(10),
                        resultado.getString(11),
                        resultado.getString(12),
                        resultado.getInt(13),
                        resultado.getDouble(14),
                        LocalDateTime.parse(resultado.getString(15),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                        LocalDateTime.parse(resultado.getString(16), DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                        null);

                Disco disco = new Disco(resultado.getInt(4),
                        resultado.getString(5),
                        resultado.getDouble(6),
                        LocalDateTime.parse(resultado.getString(7)),
                        ETipoDisco.valueOf(resultado.getString(8)));

                Cliente cliente = new Cliente(resultado.getString(20),
                        resultado.getString(21),
                        resultado.getString(22),
                        resultado.getString(23),
                        resultado.getInt(24),
                        resultado.getString(25),
                        resultado.getString(26),null);

                Locadora locadora = new Locadora(resultado.getInt(27),
                        resultado.getString(28),resultado.getString(29));

                locacao = new Locacao(resultado.getInt(1),LocalDateTime.parse(resultado.getString(2),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                        LocalDateTime.parse(resultado.getString(3),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),disco,funcionario,cliente,locadora);

            }

            return locacao;

        }finally {
            c.close();
        }
    }

    @Override
    public ArrayList<Locacao> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "SELECT l.*, d.*, f.*, j.*, lc.*  " +
                    "FROM locacaos l  " +
                    "INNER JOIN discos d on l.idDisco = d.id  " +
                    "INNER JOIN funcionarios f on l.idFuncionario = f.id  " +
                    "INNER JOIN clientes j on l.idCliente = j.id  ";


            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToLocacao(resultado);
        }finally {
            c.close();
        }

    }

    private static ArrayList<Locacao> getRegistroToLocacao(ResultSet resultado) throws SQLException {

        ArrayList<Locacao> lista = new ArrayList<>();

        while (resultado.next()){

            Funcionario funcionario = new Funcionario(resultado.getString(9),
                    resultado.getString(10),
                    resultado.getString(11),
                    resultado.getString(12),
                    resultado.getInt(13),
                    resultado.getDouble(14),
                    LocalDateTime.parse(resultado.getString(15),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    LocalDateTime.parse(resultado.getString(16), DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    null);

            Disco disco = new Disco(resultado.getInt(4),
                    resultado.getString(5),
                    resultado.getDouble(6),
                    LocalDateTime.parse(resultado.getString(7)),
                    ETipoDisco.valueOf(resultado.getString(8)));

            Cliente cliente = new Cliente(resultado.getString(20),
                    resultado.getString(21),
                    resultado.getString(22),
                    resultado.getString(23),
                    resultado.getInt(24),
                    resultado.getString(25),
                    resultado.getString(26),null);

            Locadora locadora = new Locadora(resultado.getInt(27),
                    resultado.getString(28),resultado.getString(29));

           Locacao locacao = new Locacao(resultado.getInt(1),LocalDateTime.parse(resultado.getString(2),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    LocalDateTime.parse(resultado.getString(3),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),disco,funcionario,cliente,locadora);

           lista.add(locacao);
        }

        return lista;

    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT count(*) " +
                    "FROM locadora.Locacao ;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1) ;
        }finally {
            c.close();
        }
    }

    public ArrayList<Locacao> buscarPorLocadora(Integer key) throws SQLException, ClassNotFoundException{

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql ="SELECT id, entrega, locacao  " +
                    "FROM locadora.locacaos  " +
                    "WHERE idLocadora = ?";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToLocacao(resultado);
        }finally {
            c.close();
        }
    }
}
