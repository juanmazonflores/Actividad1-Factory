import java.sql.Connection;
import java.sql.DriverManager;

public class DBSQL extends DB {

    @Override
    public Connection conexion() {
        try {
            String user = ArchivoConfiguracion.getPropery("SQLServer.user");
            String password = ArchivoConfiguracion.getPropery("SQLServer.password");
            String host = ArchivoConfiguracion.getPropery("SQLServer.host");
            String port = ArchivoConfiguracion.getPropery("SQLServer.port");
            String db = ArchivoConfiguracion.getPropery("SQLServer.db");
            String url = "jdbc:sqlserver://${host}:${port};databaseName=${db};"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);
            
            Connection conexion = DriverManager.getConnection(url, user, password); 
            return conexion;
        } catch (Exception e) {
            throw new RuntimeException("Error de conexion" + e.getMessage());
        }
    }


}
