import java.sql.Connection;

public interface DBInterface{
    public Connection conexion();
    void escribir(Connection conexion);
    void leer(Connection conexion);
}
