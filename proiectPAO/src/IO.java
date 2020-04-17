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

    public static String csvFile = "test.csv";


    public static void write(String s, int g) throws IOException {

        FileWriter out = new FileWriter(csvFile,true);

        String o = s + "," + g;
        out.append(o);
        out.append("\n");


        out.flush();
        out.close();
    }

    public static List<Station> read() {

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
