import java.sql.*;
import java.util.ArrayList;

public class Database {

    class BusReturn{
        public int nr;
        public int station_id;
        BusReturn(int a, int b){
            this.nr = a;
            this. station_id = b;
        }
    }

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

    public ArrayList<BusReturn> loadBus() throws SQLException {

        ArrayList<BusReturn> b = new ArrayList<>();
        String query = "SELECT station_id, nr FROM autobuz";
        RepoHelper repoHelper = RepoHelper.getRepoHelper();
        Connection dbCon = DataController.getDatabaseConnection();
        ResultSet rs = repoHelper.executeQuerySql(dbCon,query);
        while(rs.next()){
            int n = rs.getInt("station_id");
            int n1 = rs.getInt("nr");
            b.add(new BusReturn(n1,n));

        }

        return b;



    }

    public ArrayList<Integer> loadControl() throws SQLException {
        ArrayList<Integer> returnList = new ArrayList<>();
        String query = "SELECT station_id, nr_am FROM control";
        RepoHelper repoHelper = RepoHelper.getRepoHelper();
        Connection dbCon = DataController.getDatabaseConnection();
        ResultSet rs = repoHelper.executeQuerySql(dbCon,query);
        while(rs.next()){
            int n = rs.getInt("station_id");
            int n1 = rs.getInt("nr_am");
            returnList.add(n);

        }
        return returnList;

    }

    public ArrayList<Station> loadStation() throws SQLException {
        ArrayList<Station> s = new ArrayList<>();

        String query = "SELECT nume, nr FROM statie";
        RepoHelper repoHelper = RepoHelper.getRepoHelper();
        Connection dbCon = DataController.getDatabaseConnection();
        ResultSet rs = repoHelper.executeQuerySql(dbCon,query);
        while(rs.next()){
            String n = rs.getString("nume");
            int n1 = rs.getInt("nr");
            UrbanStation st = new UrbanStation(n,n1);
            s.add(st);
        }
        return s;
    }

    public ArrayList<Integer> loadBilet() throws SQLException {
        ArrayList<Integer> returnList = new ArrayList<>();
        String query = "SELECT nr FROM bilet";
        RepoHelper repoHelper = RepoHelper.getRepoHelper();
        Connection dbCon = DataController.getDatabaseConnection();
        ResultSet rs = repoHelper.executeQuerySql(dbCon,query);
        while(rs.next()){

            int n1 = rs.getInt("nr");
            returnList.add(n1);
        }
        return returnList;

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
