import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            DB adapter = DBFactory.getDBAdapter();
            Connection connection = adapter.conectar();
            System.out.println("Resultado de conexion: " + (!connection.isClosed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



