package br.com.locadora.dao.imp;

import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.usuario.Funcionario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FuncionarioDAO implements IGenericDAO <Funcionario, Integer> {

    public void inserir(Funcionario obj) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.funcionarios\n" +
                    "(entrada, saida, salario)\n" +
                    "VALUES(?, ?, ? );\n; ";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(2,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
            pst.setDouble(3,obj.getSalario());

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
                    "SET idUsuario=, entrada='?', saida='?', salario=?, idLocadora=0 " +
                    "WHERE id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(2,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(3,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
            pst.setDouble(4,obj.getSalario());



            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public void apagar(Funcionario obj) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Funcionario buscar(Integer key) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Funcionario> buscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
