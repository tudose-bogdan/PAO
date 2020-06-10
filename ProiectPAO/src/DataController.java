import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pao?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection databaseConnection;

    public static Connection getDatabaseConnection(){
        try{
            if(databaseConnection == null || databaseConnection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                databaseConnection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
                
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return databaseConnection;
    }

    public static void closeDatabaseConnection(){
        try{
            if(databaseConnection != null &&
            !databaseConnection.isClosed()){
                databaseConnection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
