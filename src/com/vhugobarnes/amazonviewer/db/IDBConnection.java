package com.vhugobarnes.amazonviewer.db;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public interface IDBConnection {

    default Connection connectToDB() throws Exception {

        File props = new File("src/com/vhugobarnes/amazonviewer/db/connection.prop");
        //Crea la conexión para el archivo de la BD.
        FileInputStream fis = new FileInputStream(props);
        Properties p = new Properties();

        p.load(fis);

        //Declaración de variables del archivo .prop
        String dname = (String) p.get("Dname");
        String url = (String) p.get("URL");
        String username = (String) p.get("Uname");
        String password = (String) p.get("password");

        Class.forName(dname);
        Connection connection = DriverManager.getConnection(url, username, password);

        if (connection != null){
            System.out.println("Se estableció la conexión");
        }

        return connection;
    }

}
