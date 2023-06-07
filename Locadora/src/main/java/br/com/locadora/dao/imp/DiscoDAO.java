package br.com.locadora.dao.imp;
import br.com.locadora.dao.IGenericDAO;
import br.com.locadora.model.EN.ETipoDisco;
import br.com.locadora.model.disco.Disco;
import br.com.locadora.util.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class DiscoDAO implements IGenericDAO<Disco,Integer> {

    public void inserir(Disco obj) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();

        try {
            String sql = "INSERT INTO locadora.discos" +
                    "(nome, valorDaLocacao, dataLancamento, tipoDisco)" +
                    "VALUES(?, ?, ?, ?);";
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
            String sql = "SELECT id, nome, valorDaLocacao, dataLancamento, tipoDisco " +
                    "FROM locadora.discos " +
                    "WHERE id=?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Disco disco = null;

            if (resultado.next()) {
                disco = new Disco(resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getDouble(3),
                        LocalDateTime.parse(resultado.getString(4)),
                        ETipoDisco.valueOf(resultado.getString(5))
                );
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
                    "WHERE id=?;";

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
                    "SET nome=?, valorDaLocacao=?, dataLancamento=?, tipoDisco=?" +
                    "WHERE id=?;";

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


    private static ArrayList<Disco> getRegistroToDiscos(ResultSet resultado) throws SQLException {

        ArrayList<Disco> lista = new ArrayList<>();

        while (resultado.next()){
            Disco ds = new Disco(resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getDouble(3),
                    LocalDateTime.parse(resultado.getString(4)),
                    ETipoDisco.valueOf(resultado.getString(5)));

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

}


