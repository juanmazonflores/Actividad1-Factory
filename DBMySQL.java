
import java.sql.Connection;
import java.sql.DriverManager;

public class DBMySQL implements DB {


    @Override
    public Connection conectar() {
        try {
            //Obtener 
            String user = ArchivoConfiguracion.getPropery("MySQL.user");
            String password = ArchivoConfiguracion.getPropery("MySQL.password");
            String host = ArchivoConfiguracion.getPropery("MySQL.host");
            String port = ArchivoConfiguracion.getPropery("MySQL.port");
            String db = ArchivoConfiguracion.getPropery("MySQL.db");

            //Cadena de conexion
            String url = "jdbc:mysql://${host}:${port}/${db}?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC&useSSL=FALSE"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            Connection connection = DriverManager.getConnection(url, user, password); 
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("MySQL connection error " + e.getMessage());
        }
        
    }

    @Override
    public void escribir() {
        
        
    }

    @Override
    public void leer() {
        
        
    }

}