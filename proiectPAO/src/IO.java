import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO {

    private static IO io = new IO();

    private IO(){};

    public static IO getInstance()
    {
        return io;
    }

    public static String csvFile = "stations.csv";
    public static String csvFile2 = "buses.csv";



    public static void writeStations(String s, int g) throws IOException {

        FileWriter out = new FileWriter(csvFile,true);

        String o = s + "," + g;
        out.append(o);
        out.append("\n");

        out.flush();
        out.close();
    }
    public static void writeBuses(int autobuz, int numar_statie) throws IOException {

        FileWriter out = new FileWriter(csvFile2,true);

        String o = numar_statie + "," + autobuz;
        out.append(o);
        out.append("\n");

        out.flush();
        out.close();

    }

    public static void readBuses(InfoPoint I) {
        BufferedReader br = null;
        String split = ",";
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csvFile2));

            while ((line = br.readLine()) != null) {

                String[] info = line.split(split);

                I.adaugaAutobuz(Integer.parseInt(info[1]), Integer.parseInt(info[0]));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static List<Station> readStations() {

        BufferedReader br = null;
        String split = ",";
        String line = "";
        List<Station> l = new ArrayList<Station>();

        try{

            br = new BufferedReader(new FileReader(csvFile));

            while((line = br.readLine()) != null){

                String[] info = line.split(split);

                l.add(new UrbanStation(info[0],Integer.parseInt(info[1])));


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return l;


    }



}
