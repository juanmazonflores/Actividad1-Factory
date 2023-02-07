//Definir estructura que tendran las otras clases

import java.sql.Connection;

public interface DB{
    public Connection conectar();
    void escribir(Connection conexion);
    void leer(Connection conexion);
}

