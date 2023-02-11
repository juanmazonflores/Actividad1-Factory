import java.sql.Connection;
import java.sql.DriverManager;

public class DBMySQL extends DB{

    public Connection conexion(){
        try {
            String user = ArchivoConfiguracion.getPropery("MySQL.user");
            String password = ArchivoConfiguracion.getPropery("MySQL.password");
            String host = ArchivoConfiguracion.getPropery("MySQL.host");
            String port = ArchivoConfiguracion.getPropery("MySQL.port");
            String db = ArchivoConfiguracion.getPropery("MySQL.db");  
            String url = "jdbc:mysql://${host}:${port}/${db}?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useSSL=FALSE"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);
            Connection conexion = DriverManager.getConnection(url, user, password); 
            return conexion;
        } catch (Exception e) {
            throw new RuntimeException("Error de conexion" + e.getMessage());
        }
    }

}

