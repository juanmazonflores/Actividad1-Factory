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
        String nombre;
        String direccion;
        String telefono;
        String observaciones;

        try {

            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery ("select * from telefonos");
            System.out.println("Los datos devueltos son:");
            while(rs.next()){
                nombre = rs.getString("nombre");
                direccion = rs.getString("dirección");
                telefono = rs.getString("teléfono");
                observaciones = rs.getString("observaciones");
                System.out.println(nombre + "\t" + direccion + "\t" + telefono  + "\t" + observaciones);
            }

        } catch (Exception e) {
            
        }
        
    }

    @Override
    public void escribir(Connection conexion) {
        
        try {
            Statement s = conexion.createStatement();
            String st_inserta ="INSERT INTO telefonos VALUES ('Maria Perez', 'Lopez','123123123','Es la administradora')" ;
            s.executeUpdate(st_inserta);
            System.out.println("Se han insertado los datos con exito");
        } catch (Exception e) {
            
        }
    }



}