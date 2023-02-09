import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            DB adapter = getDBAdapter();
            Connection connection = adapter.conectar();
            System.out.println("Resultado de conexion: " + (!connection.isClosed()));
            adapter.escribir(connection);
            adapter.leer(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DB getDBAdapter(){
        String dbType = ArchivoConfiguracion.getDBType();
        System.out.println("DBType => " + dbType);
        switch(dbType){
            case "MySQL":
                return new DBMySQL();
            case "SQLServer":
                return new DBSQL();
            default:
                throw new RuntimeException("No existe ese tipo de base de datos");
        }
    }
}



