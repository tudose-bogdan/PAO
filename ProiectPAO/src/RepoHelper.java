import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepoHelper {

    private static RepoHelper repoHelper = new RepoHelper();

    private RepoHelper(){}

    public static RepoHelper getRepoHelper(){
        return repoHelper;
    }

    public void executeSql(Connection connection, String sql) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
        //no return (not select queries)
    }

    public ResultSet executeQuerySql(Connection connection, String sql) throws SQLException{
        Statement stmt = connection.createStatement();

        return stmt.executeQuery(sql);


    }
}
