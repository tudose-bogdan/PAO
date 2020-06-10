import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    public void setUp() throws SQLException {
     String createBuses = "CREATE TABLE IF NOT EXISTS autobuz" +
             "(id int PRIMARY KEY AUTO_INCREMENT, station_id int, nr int)";
     String createControl = "CREATE TABLE IF NOT EXISTS control" +
             "(id int PRIMARY KEY AUTO_INCREMENT, station_id int, nr_am int)";
     String createStation = "CREATE TABLE IF NOT EXISTS statie" +
             "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(35), nr int)";
     String createTicket = "CREATE TABLE IF NOT EXISTS bilet" +
             "(id int PRIMARY KEY AUTO_INCREMENT, nr int)";

        Connection dbCon = DataController.getDatabaseConnection();
        RepoHelper repoHelper = RepoHelper.getRepoHelper();

        repoHelper.executeSql(dbCon,createBuses);
        repoHelper.executeSql(dbCon,createControl);
        repoHelper.executeSql(dbCon,createStation);
        repoHelper.executeSql(dbCon,createTicket);
    }

    public void addBus(int a, int b) throws SQLException {
        String add = "INSERT INTO autobuz(station_id,nr) VALUES(" +
                Integer.toString(a) + "," + Integer.toString(b) + ")";

        Connection dbCon = DataController.getDatabaseConnection();
        RepoHelper repoHelper = RepoHelper.getRepoHelper();

        repoHelper.executeSql(dbCon,add);
    }

    public void addControl(int a, int b) throws SQLException {

        String add = "INSERT INTO control(station_id,nr_am) VALUES(" +
                Integer.toString(a) + "," + Integer.toString(b) + ")";

        Connection dbCon = DataController.getDatabaseConnection();
        RepoHelper repoHelper = RepoHelper.getRepoHelper();

        repoHelper.executeSql(dbCon,add);
    }

    public void addStation(String a, int b) throws SQLException {

        Connection dbCon = DataController.getDatabaseConnection();

        String add = "INSERT INTO statie(nume,nr)" + " VALUES(?, ?)";

        PreparedStatement prepstmt = dbCon.prepareStatement(add);

        prepstmt.setString(1,a);
        prepstmt.setInt(2,b);


        prepstmt.execute();

        //RepoHelper repoHelper = RepoHelper.getRepoHelper();

       // repoHelper.executeSql(dbCon,add);
    }

    public void addTicket(int a) throws SQLException {
        String add = "INSERT INTO bilet(nr) VALUES(" + Integer.toString(a) +
                ")";
        Connection dbCon = DataController.getDatabaseConnection();
        RepoHelper repoHelper = RepoHelper.getRepoHelper();

        repoHelper.executeSql(dbCon,add);
    }



}
