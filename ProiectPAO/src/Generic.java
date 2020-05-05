import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Generic {
    public static <E>  void print(E[] arr){

        for(E a:arr)
            System.out.println(a.toString());
    }

    public <T extends Station> ArrayList<T> sortStations(ArrayList<T> a) {
        Collections.sort(a , new SortbynrC());

        Collections.sort(a, new SortByName());

        Collections.sort(a,new SortBynrA());

        return a;
    }


    }

class SortbynrC implements Comparator<Station>{
    public int compare(Station a, Station b) {
        return a.controlori.size() - b.controlori.size();
    }
}

class SortBynrA implements Comparator<Station>{
    public int compare(Station a, Station b){
        return a.autobuze.size() - b.autobuze.size();
    }
}

class SortByName implements Comparator<Station>{
    public int compare(Station a, Station b){
        return a.getStrada().compareTo(b.getStrada());
    }
}