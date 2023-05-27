package br.com.locadora.dao.imp;

import br.com.locadora.model.disco.Disco;
import br.com.locadora.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class DiscoDAO {

    public void inserir(Disco obj) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.discos\n" +
                    "(nome, valorDaLocacao, dataLancamento, tipoDisco)\n" +
                    "VALUES(?, ?, ?, ?);\n";
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
}
