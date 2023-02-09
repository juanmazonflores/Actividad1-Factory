
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
            String url = "jdbc:mysql://${host}:${port}/${db}?zeroDateTimeBehavior=convertToNull&allowPublicKeyRetrieval=true&serverTimezone=UTC&useSSL=FALSE"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            Connection connection = DriverManager.getConnection(url, user, password); 
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("MySQL connection error " + e.getMessage());
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
            System.out.println("Los datos devueltos");
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
            String st_inserta ="INSERT INTO telefonos VALUES ('Rene Uribe', 'Lopez','143323123','Es el alumno')" ;
            s.executeUpdate(st_inserta);
            System.out.println("Se han insertado los datos con exito");

        } catch (Exception e) {
            
        }
        
    }

}