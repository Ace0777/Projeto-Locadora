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
            pst.setString(5, obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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
            pst.setString(2, obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
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
            String sql = "SELECT l.id AS locacaoId, l.entrega AS locacaoEntrega, l.saida AS locacaoSaida, " +
                    "       d.id AS discoId, d.valorDaLocacao AS discoPreco, d.nome AS discoNome, " +
                    "       f.id AS funcionarioId, f.nome AS funcionarioNome, j.id AS clienteId, j.nome AS clienteNome, " +
                    "       lc.id AS locadoraId, lc.nome AS nomeLocadora " +
                    "FROM locacaos AS l  " +
                    "INNER JOIN discos AS d ON l.idDisco = d.id   " +
                    "INNER JOIN funcionarios AS f ON l.idFuncionario = f.id   " +
                    "INNER JOIN clientes AS j ON l.idCliente = j.id   " +
                    "INNER JOIN locadoras AS lc ON l.idLocadora = lc.id  " +
                    "WHERE l.id = ? ; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Locacao locacao = null;

            if (resultado.next()) {

                var funcionario = new Funcionario(
                        resultado.getInt("funcionarioId"),
                        resultado.getString("funcionarioNome"));


                var disco = new Disco(
                        resultado.getInt("discoId"),
                        resultado.getDouble("discoPreco"),
                        resultado.getString("discoNome"));

                var cliente = new Cliente(
                        resultado.getInt("clienteId"),
                        resultado.getString("clienteNome"));

                var locadora = new Locadora(resultado.getInt("locadoraId"),
                        resultado.getString("nomeLocadora"));


                locacao = new Locacao(resultado.getInt("locacaoId"),resultado.getTimestamp("locacaoEntrega").toLocalDateTime(),
                        resultado.getTimestamp("locacaoSaida").toLocalDateTime(),disco,funcionario,cliente,locadora);

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
            String sql = "SELECT l.id AS locacaoId, l.entrega AS locacaoEntrega, l.saida AS locacaoSaida, " +
                    "       d.id AS discoId, d.valorDaLocacao AS discoPreco, d.nome AS discoNome, " +
                    "       f.id AS funcionarioId, f.nome AS funcionarioNome, j.id AS clienteId, j.nome AS clienteNome, " +
                    "       lc.id AS locadoraId, lc.nome AS nomeLocadora " +
                    "FROM locacaos AS l  " +
                    "INNER JOIN discos AS d ON l.idDisco = d.id   " +
                    "INNER JOIN funcionarios AS f ON l.idFuncionario = f.id   " +
                    "INNER JOIN clientes AS j ON l.idCliente = j.id   " +
                    "INNER JOIN locadoras AS lc ON l.idLocadora = lc.id   ";


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

            var funcionario = new Funcionario(
                    resultado.getInt("funcionarioId"),
                    resultado.getString("funcionarioNome"));


            var disco = new Disco(
                    resultado.getInt("discoId"),
                    resultado.getDouble("discoPreco"),
                    resultado.getString("discoNome"));

            var cliente = new Cliente(
                    resultado.getInt("clienteId"),
                    resultado.getString("clienteNome"));

            var locadora = new Locadora(resultado.getInt("locadoraId"),
                    resultado.getString("nomeLocadora"));


           var locacao = new Locacao(resultado.getInt("locacaoId"),resultado.getTimestamp("locacaoEntrega").toLocalDateTime(),
                    resultado.getTimestamp("locacaoSaida").toLocalDateTime(),disco,funcionario,cliente,locadora);

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
