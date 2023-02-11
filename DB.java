import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DB implements DBInterface{
    private Connection conexion;

    abstract public Connection conexion();
    
    public void leer(Connection conexion){
        try {
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
        } catch (Exception e) {
            
        }
        
    }

    public void escribir(Connection Conexion){

        try {
            Statement s = conexion.createStatement();
            String st_inserta ="INSERT INTO telefonos VALUES ('Maria Perez', 'Lopez','123123123','Es la administradora')" ;
            s.executeUpdate(st_inserta);
            System.out.println("Se han insertado los datos con exito");
        } catch (Exception e) {
            
        }
    
    }

}
