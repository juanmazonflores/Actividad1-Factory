import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

            Connection connection = DriverManager.getConnection(url, user, password); 
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("SQLServer connection error " + e.getMessage());
        }
        
    }

    @Override
    public void leer(Connection conexion) {
        try {
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from telefonos");
            while (rs.next())
            {
            System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getDate(3));
            }
        } catch (Exception e) {
            
        }
        
    }

    @Override
    public void escribir(Connection conexion) {
        
        try {
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("INSERT INTO telefonos VALUES ('Juan Perez', 'Zaragoza','976111222','Es el profesor')");
            while (rs.next())
            {
            System.out.println (rs.getInt (1) + " " + rs.getString (2)+ " " + rs.getDate(3));
            }
        } catch (Exception e) {
            
        }
    }



}