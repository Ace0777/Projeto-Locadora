package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.locadora.Locadora;
import br.com.locadora.model.usuario.Funcionario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

public class FuncionarioDAO implements IGenericDAO <Funcionario, Integer> {

    public void inserir(Funcionario obj) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.funcionarios " +
                    "(entrada, saida, salario, idLocadora,nome) " +
                    "VALUES(?, ?, ?, ?, ?);  ";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(2,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
            pst.setDouble(3,obj.getSalario());
            pst.setInt(4, obj.getLocadora().getId());
            pst.setString(5, obj.getNome());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Funcionario obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "UPDATE locadora.funcionarios " +
                    "SET = entrada=?, saida=?, salario=?, nome=? " +
                    "WHERE id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(2,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setDouble(3, obj.getSalario());
            pst.setInt(4, obj.getId());

            pst.execute();
        }finally {
            c.close();
        }

    }

    @Override
    public void apagar(Funcionario obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "DELETE FROM locadora.funcionarios " +
                    "WHERE id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,obj.getId());

            pst.execute();
        }finally {
            c.close();
        }

    }

    @Override
    public Funcionario buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT f.*, l.*  " +
                    "FROM funcionarios f  " +
                    "INNER JOIN locadoras l on f.idLocadora = l.id  " +
                    "WHERE id = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            Funcionario funcionario = null;


            if (resultado.next()) {
                Funcionario fr = new Funcionario(
                        resultado.getString(6),
                        "",
                        "",
                        "",
                        resultado.getInt(1),
                        resultado.getDouble(4),
                        LocalDateTime.parse(resultado.getString(2),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                        LocalDateTime.parse(resultado.getString(3),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                        new Locadora(resultado.getInt(5)));
            }

            return funcionario;
        }finally {
            c.close();
        }

    }

    public ArrayList<Funcionario> buscarPorNome(String key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT f.*, l.*  " +
                    "FROM funcionarios f  " +
                    "INNER JOIN locadoras l on f.idLocadora = l.id  " +
                    "WHERE nome = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, "%" + key + "%");

            ResultSet resultado = pst.executeQuery();

            return getRegistroToFuncionario(resultado);

        }finally {
            c.close();
        }
    }



    @Override
    public ArrayList<Funcionario> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT f.*, l.*  " +
                    "FROM funcionarios f  " +
                    "INNER JOIN locadoras l on f.idLocadora = l.id  ";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToFuncionario(resultado);

        }finally {
            c.close();
        }
    }


    private static ArrayList<Funcionario> getRegistroToFuncionario(ResultSet resultado) throws SQLException {

        //passar index

        ArrayList<Funcionario> lista = new ArrayList<>();

        while (resultado.next()){
            Funcionario fr = new Funcionario(
                    resultado.getString(6),
                    "",
                    "",
                    "",
                    resultado.getInt(1),
                    resultado.getDouble(4),
                    LocalDateTime.parse(resultado.getString(2),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    LocalDateTime.parse(resultado.getString(3),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    new Locadora(resultado.getInt(5)));


            lista.add(fr);
        }

        return lista;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT count(*) \n" +
                    "FROM locadora.funcionarios ;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1) ;
        }finally {
            c.close();
        }

    }

    public ArrayList<Funcionario> buscarPorLocadora(Integer key) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT id, entrada, saida, salario, idLocadora, nome " +
                    "FROM locadora.funcionarios " +
                    "WHERE idLocadora = ?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            return getRegistroToFuncionario(resultado);

        }finally {
            c.close();
        }
    }
}
