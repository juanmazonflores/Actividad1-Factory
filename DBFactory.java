public abstract class DBFactory {
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