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
            String sql = "INSERT INTO locadora.funcionarios\n" +
                    "(entrada, saida, salario, idLocadora)\n" +
                    "VALUES(?, ?, ?, ?, ?);\n ";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(2,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
            pst.setDouble(3,obj.getSalario());
            pst.setInt(4, obj.getLocadora().getId());

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
                    "SET = entrada=?, saida=?, salario=? " +
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
            String sql = "SELECT u.*, f.*, l.*  " +
                    "FROM funcionarios f" +
                    "INNER JOIN locadoras l on f.idLocadora = l.id" +
                    "WHERE id = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            Funcionario funcionario = null;

            if (resultado.next()) {
                funcionario =
            }
        }

    }

    @Override
    public ArrayList<Funcionario> buscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }


    private static ArrayList<Funcionario> getRegistroToFuncionario(ResultSet resultado) throws SQLException {

        ArrayList<Funcionario> lista = new ArrayList<>();

        while (resultado.next()){
            Funcionario av = new Funcionario(resultado.getString(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getInt(5),
                    resultado.getDouble(6),
                    LocalDateTime.parse(resultado.getString(7),DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    LocalDateTime.parse(resultado.getString(8), DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                    new Locadora(resultado.getInt(9),
                    resultado.getString(10),
                    resultado.getString(11))
            );
            lista.add(av);
        }

        return lista;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
