import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            //Se obtiene del archivo de configuracion 
            //que tipo de base de datos se utilizara
            //ver dbconfig.properties
            String dbType = ArchivoConfiguracion.getDBType();
            System.out.println("DBType => " + dbType);
            switch(dbType){
                case "MySQL":
                    DB adapter= new DBMySQL();
                    Connection conexion = adapter.conexion();
                    adapter.escribir(conexion);
                    adapter.leer(conexion);
                    System.out.println("Resultado de conexion: " + (!conexion.isClosed()));
                    break;
                case "SQLServer":
                    DB adapter2= new DBSQL();
                    Connection conexion2 = adapter2.conexion();
                    System.out.println("Resultado de conexion: " + (!conexion2.isClosed()));
                    adapter2.escribir(conexion2);
                    adapter2.leer(conexion2);
                    break;
                default:
                    throw new RuntimeException("No existe ese tipo de base de datos");
            }    
                  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



