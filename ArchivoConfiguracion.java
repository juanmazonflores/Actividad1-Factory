import java.io.InputStream;
import java.util.Properties;

public class ArchivoConfiguracion {

    private static Properties props;

    static {
        try {
            InputStream stream = ClassLoader.getSystemResourceAsStream("resources/dbconfig.properties");
            ArchivoConfiguracion.props = new Properties();
            props.load(stream);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar la configuracion");
        }
    }
    
    public static String getDBType(){
        return props.getProperty("dbtype");
    }
    
    public static String getPropery(String propName){
        return props.getProperty(propName);
    }
    
    
}