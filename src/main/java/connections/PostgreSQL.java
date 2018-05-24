package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL {

    private Connection conn = null;
    private static PostgreSQL conexion;

    public static PostgreSQL getInstance() throws SQLException, ClassNotFoundException{
        if (conexion == null) {
            conexion = new PostgreSQL();
        }
        return conexion;
    }

    private void createConnection() throws SQLException, ClassNotFoundException{
        String urlDatabase =  "postgres://avnadmin:nzdd85105tdbh7jz@pg-3e20d976-a301377-d55d.aivencloud.com:24554/defaultdb?sslmode=require";
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(urlDatabase,  "avnadmin", "nzdd85105tdbh7jz");
    }

    public Connection getConn(){
        return conn;
    }

}
