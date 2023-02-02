import java.sql.Connection;
import java.sql.DriverManager;

public class DBSQL implements DB {

    @Override
    public Connection conectar() {
        try {
            String user = ArchivoConfiguracion.getPropery("SQLServer.user");
            String password = ArchivoConfiguracion.getPropery("SQLServer.password");
            String host = ArchivoConfiguracion.getPropery("SQLServer.host");
            String port = ArchivoConfiguracion.getPropery("SQLServer.port");
            String db = ArchivoConfiguracion.getPropery("SQLServer.db");
            
            String url = "jdbc:sqlserver://${host}:${port};databaseName=${db};"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            Connection connection = DriverManager.getConnection(url, user, password); //connection to MySQL
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("SQLServer connection error " + e.getMessage());
        }
        
    }

    @Override
    public void escribir() {
        
        
    }

    @Override
    public void leer() {
        
        
    }

}