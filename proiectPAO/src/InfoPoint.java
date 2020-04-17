import java.util.ArrayList;
import java.util.List;

public class InfoPoint {

    private List<Station> l = new ArrayList<Station>();


    public int nr_statii(){
        return l.size();
    }

    public void adauga_statie(Station s)
    {
        l.add(s);
    }

    public void adauga_statii(List<Station> li)
    {
        for (Station e:li)
        {
            l.add(e);
        }
    }

    public boolean adauga_autobuz(int no, int no2)
    {
    //param 1: codul autobuzului paran2: numarul statiei
        int cod_autobuz = no;

        for(Station s:l)
        {
            if( s.get_nr() == no2) {
                s.adauga_autobuz(no);
                return true;
            }

        }
        return false;

    }

    public void afiseaza_statii()
    {
        for(Station s:l)
            s.display();
    }

    public void sterge_statie_dupa_numar(int nr)
    {
        int i = 0;

        for(;i<l.size();i++)
        {
            if(l.get(i).get_nr() == nr)
                break;
        }

        l.remove(i);
    }

    public void sterge_autobuz(int no)
    {
        int index = 0;

        for(Station s:l)
        {
            if(s.autobuze.contains(no))
            {
                int  i = 0;
                for(;i<s.autobuze.size();i++)
                {
                    if(s.autobuze.get(i) == no)
                        break;
                }

                index = i;

                s.autobuze.remove(index);
            }
        }
    }

    public void cu_ce_ajung(int nr)
    {
        for(Station s:l)
        {
            if(s.get_nr() == nr)
            {
               for(int a:s.autobuze)
                   System.out.print(a + " ");
            }
        }
        System.out.println();
    }

    public void prin_ce_statii_x(int x)
    {
        for(Station s:l)
        {
            if(s.contine_autobuz(x))
                s.display();
        }
    }

    public Station get_station_by_id(int id)
    {
        for(Station s:l)
        {
            if(s.get_nr() ==id)
                return s;
        }
        return null;
    }
    public void autobuze_comune(int x, int y)
    {
        Station s1 = get_station_by_id(x);
        Station s2 = get_station_by_id(y);

        for(int a:s1.autobuze)
            for(int b:s2.autobuze)
            {
                if (a == b)
                    System.out.print(a + " ");
            }
        System.out.println();
    }






}
