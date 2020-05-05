
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IO {
    private static IO io = new IO();


    public static String csvFile = "stations.csv";
    public static String csvFile2 = "buses.csv";
    public static String csvFile3 = "control.csv";
    public static String csvFile4 = "ticket.csv";


    private IO() {
    }

    public static IO getInstance() {
        return io;
    }

    public static void writeCont(ControlorSTB c) throws IOException {
        FileWriter out = new FileWriter(csvFile3, true);
        out.append(c.toString());
        out.append("\n");
        out.flush();
        out.close();
    }

    public static void writeStations(String s, int g) throws IOException {
        FileWriter out = new FileWriter(csvFile, true);
        String o = s + "," + g;
        out.append(o);
        out.append("\n");
        out.flush();
        out.close();
    }

    public static void writeBuses(int autobuz, int numar_statie) throws IOException {
        FileWriter out = new FileWriter(csvFile2, true);
        String o = numar_statie + "," + autobuz;
        out.append(o);
        out.append("\n");
        out.flush();
        out.close();
    }

    public static void writeTickets(int cod) throws IOException {
        FileWriter out = new FileWriter(csvFile4, true);
        out.append(Integer.toString(cod));
        out.append("\n");
        out.flush();
        out.close();

    }

    public static void readTickets(InfoPoint I){
        BufferedReader br = null;
        String split = ",";
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile4));

            while((line = br.readLine()) != null) {
                String[] info = line.split(split);
                I.getStationById(Integer.parseInt(info[0])).activeazaTichete();
            }
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public static void readBuses(InfoPoint I) {
        BufferedReader br = null;
        String split = ",";
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile2));

            while((line = br.readLine()) != null) {
                String[] info = line.split(split);
                I.adaugaAutobuz(Integer.parseInt(info[1]), Integer.parseInt(info[0]));
            }
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public static List<Station> readStations() {
        BufferedReader br = null;
        String split = ",";
        String line = "";
        ArrayList l = new ArrayList();

        try {
            br = new BufferedReader(new FileReader(csvFile));

            while((line = br.readLine()) != null) {
                String[] info = line.split(split);
                l.add(new UrbanStation(info[0], Integer.parseInt(info[1])));
            }
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return l;
    }

    public static void readCont(InfoPoint I) {
        BufferedReader br = null;
        String split = ",";
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile3));

            while((line = br.readLine()) != null) {
                String[] info = line.split(split);
                I.getStationById(Integer.parseInt(info[0])).adaugaControlor(new ControlorSTB(Integer.parseInt(info[0]), Integer.parseInt(info[1])));
            }
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}
