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
                    "(entrada, saida, salario, idLocadora,nome, login, senha) " +
                    "VALUES(?, ?, ?, ?, ?, ? , ?);  ";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(2,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setDouble(3,obj.getSalario());
            pst.setInt(4, obj.getLocadora().getId());
            pst.setString(5, obj.getNome());
            pst.setString(6,obj.getLogin());
            pst.setString(7,obj.getSenha());

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
                    "SET  entrada=?, saida=?, salario=?, nome=?, login=?, senha=? " +
                    "WHERE id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(2,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setDouble(3, obj.getSalario());
            pst.setString(4, obj.getNome());
            pst.setString(5,obj.getLogin());
            pst.setString(6,obj.getSenha());
            pst.setInt(7, obj.getId());

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
                    "WHERE id= ?;";

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
            String sql = "SELECT f.*   " +
                    "FROM funcionarios f  " +
                    "WHERE id = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            Funcionario funcionario = null;

            if (resultado.next()) {
                  funcionario = new Funcionario(
                        resultado.getString(6),
                          resultado.getString(7),
                          resultado.getString(8),
                        "",
                        resultado.getInt(1),
                        resultado.getDouble(4),
                        resultado.getTimestamp(2).toLocalDateTime(),
                        resultado.getTimestamp(3).toLocalDateTime());
            }

            return funcionario;
        }finally {
            c.close();
        }

    }

    public ArrayList<Funcionario> buscarPorNome(String key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT f.*  " +
                    "FROM funcionarios f  " +
                    "WHERE f.nome like ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, "%" + key + "%");

            ResultSet resultado = pst.executeQuery();

            return getRegistroToFuncionario(resultado);

        }finally {
            c.close();
        }
    }


    public ArrayList<Funcionario> buscarPorLoginSenha(String login,String senha) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "SELECT f.*  " +
                    "FROM funcionarios f  " +
                    "WHERE f.login = ?  and f.senha = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1,  login );
            pst.setString(2,  senha );

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
            String sql = "SELECT f.* " +
                    "FROM funcionarios f  ";

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
                    resultado.getString(7),
                    resultado.getString(8),
                    "",
                    resultado.getInt(1),
                    resultado.getDouble(4),
                    resultado.getTimestamp(2).toLocalDateTime(),
                    resultado.getTimestamp(3).toLocalDateTime());

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
