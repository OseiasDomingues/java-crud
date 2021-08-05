package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //Nome do usuário do MySql
    private static final String USERNAME = "root";

    //Senha do usuário do MySql
    private static final String PASSWORD = "root";

    //Caminho do BD, porta de acesso, nome do bd
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";

    /*
     * Conexão com o banco de dados
     */

    public static Connection createConnectionToMySQL() throws Exception {
        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.jdbc.Driver");

        //Cria a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception{
        //Recuperar conexao com banco de dados
        Connection con = createConnectionToMySQL();

        //Testar se a conexão é null
        //Executara if apenas se ja tiver um conexão ativa, no caso irá fechar
        if (con!=null){
            System.out.println("Conexão obtida com sucesso!");
            con.close();
        }
    }

    }