package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contacts;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactsDao {
    /*
        CRUD - Significado
        C = Create - INSERT
        R = Read   - SELECT
        U = Update - UPDATE
        D = Delete - DELETE
     */

    public void save(Contacts contacts){
        String sql = "INSERT INTO contacts(name, age, dateRegister) VALUES(?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criamos uma PreparedStatement, para executar um query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Adicionar os valores que são esperados pela query
            pstm.setString(1, contacts.getName());
            pstm.setInt(2, contacts.getAge());
            pstm.setDate(3, new Date(contacts.getDate_resgister().getTime()));

            //Executar a query
            pstm.execute();

            System.out.println("Contato salvo com sucesso!");


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //Fechar as conexões
            try {
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<Contacts> getContacts(){
        String sql = "SELECT * FROM contacts";

        List<Contacts> arrayContacts = new ArrayList<Contacts>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco. ***SELECT***
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Contacts tempContacts = new Contacts();
                //Recuperar ID
                tempContacts.setId(rset.getInt("id"));
                //Recuperar Nome
                tempContacts.setName(rset.getString("name"));
                //Recuperar Idade
                tempContacts.setAge(rset.getInt("age"));
                //Recuperar Data de Cadastro
                tempContacts.setDate_resgister(rset.getDate("dateRegister"));

                arrayContacts.add(tempContacts);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Fechar as conexões
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return arrayContacts;
    }

    public void update(Contacts contacts){
        String sql = "UPDATE contacts SET name = ?, age = ? , dateRegister = ?" + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criamos uma PreparedStatement, para executar um query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //Adicionar os valores para atualizar
            pstm.setString(1, contacts.getName());
            pstm.setInt(2, contacts.getAge());
            pstm.setDate(3, new Date(contacts.getDate_resgister().getTime()));

            //Qual o id do registro que deseja atualizar
            pstm.setInt(4, contacts.getId());

            //Executar a query
            pstm.execute();

            System.out.println("Contato atualizado com sucesso!");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //Fechar as conexões
            try {
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteById(int id){
        String sql = "DELETE FROM contacts WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criamos uma PreparedStatement, para executar um query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //ID do contato que deseja deletar
            pstm.setInt(1, id);

            //Executar a query
            pstm.execute();

            System.out.println("Contato deletado com sucesso!");

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //Fechar as conexões
            try {
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}