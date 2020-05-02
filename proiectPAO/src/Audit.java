import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Audit {
    private static Audit logs = new Audit();

    private Audit(){};

    private static String fileToLog = "logs.csv";


    public static Audit getInstance()
    {
        return logs;
    }


    public static void logEvent(ActiuniLog l) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String t  = dateFormat.format(new Date());


        FileWriter out = new FileWriter(fileToLog,true);

        out.append(l.toString());
        out.append("  ");
        out.append(t);

        out.flush();
        out.close();


    }
}
