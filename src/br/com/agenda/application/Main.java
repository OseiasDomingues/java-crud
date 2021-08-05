package br.com.agenda.application;

import br.com.agenda.dao.ContactsDao;
import br.com.agenda.model.Contacts;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ContactsDao contDao = new ContactsDao();

        Contacts newContacts = new Contacts();
        newContacts.setName("Sonic");
        newContacts.setAge(15);
        newContacts.setDate_resgister(new Date());

        //***CREATE CONTACTS***
        //contDao.save(newContacts);

        Contacts newContacts1 = new Contacts();
        newContacts1.setName("Luigi");
        newContacts1.setAge(35);
        newContacts1.setDate_resgister(new Date());
        newContacts1.setId(3); //PK do contato que deseja atualizar

        //***UPDATE CONTACTS***
        //contDao.update(newContacts1);

        //***DELETE CONTACTS***
        //contDao.deleteById(4);

        //Visualização dos resgistros do Banco de Dados
        for (Contacts c : contDao.getContacts()){
            System.out.println("Contato : " + c.getName());
        }


    }


}
