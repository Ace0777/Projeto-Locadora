package br.com.locadora.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
        public static Connection getConnectionMysql() throws ClassNotFoundException, SQLException {
                String url = "jdbc:mysql://localhost:3306/locadora";
                String login = "root";
                String senha = "aluno";

                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url,login,senha);
        }

        public static void main(String[] args) {
                try {
                        Connection c = ConnectionFactory.getConnectionMysql();
                        System.out.println("Conectou no Banco");

                } catch (ClassNotFoundException e) {
                        System.out.println("Driver não encontrado!!!");
                } catch (SQLException e) {
                        System.out.println("Não conectou no banco "+e.getMessage());
                }catch (Exception e) {
                        System.out.println("erro Interno");
                }
        }
}
