package br.com.locadora.dao.imp;

import br.com.locadora.model.disco.Disco;
import br.com.locadora.model.usuario.Funcionario;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class FuncionarioDAO {

    public void inserir(Funcionario obj) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.funcionarios\n" +
                    "(idUsuario, entrada, saida, salario, idLocadora)\n" +
                    "VALUES(default, ?, ?, ?, ?);\n";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(2,obj.getEntrada().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(3,obj.getSaida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss ")));
            pst.setDouble(4,obj.getSalario());

            pst.execute();
        } finally {
            c.close();
        }
    }
}
