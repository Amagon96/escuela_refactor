package connections;

import org.junit.Test;

import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionTest {
    @Test
    public void connectionSingletonTest(){
        try {
            PostgreSQL con = PostgreSQL.getInstance();
        }catch (ClassNotFoundException | SQLException ex){
            Logger.getAnonymousLogger().warning("La conexión es invalida.");
        }
    }
}
