import java.util.ArrayList;
import java.util.List;

public class InfoPoint {

    private List<Station> l = new ArrayList<Station>();


    public int nrStatii(){
        return l.size();
    }

    public void adaugaStatie(Station s)
    {
        l.add(s);
    }

    public void adaugaStatii(List<Station> li)
    {
        for (Station e:li)
        {
            l.add(e);
        }
    }

    public boolean adaugaAutobuz(int no, int no2)
    {
    //param 1: codul autobuzului paran2: numarul statiei
        int cod_autobuz = no;

        for(Station s:l)
        {
            if( s.getNr() == no2) {
                s.adaugaAutobuz(no);
                return true;
            }

        }
        return false;

    }

    public void afiseazaStatii()
    {
        for(Station s:l)
            s.display();
    }

    public void stergeStatieDupaNumar(int nr)
    {
        int i = 0;

        for(;i<l.size();i++)
        {
            if(l.get(i).getNr() == nr)
                break;
        }

        l.remove(i);
    }

    public void stergeAutobuz(int no)
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

    public void cuCeAjung(int nr)
    {
        for(Station s:l)
        {
            if(s.getNr() == nr)
            {
               for(int a:s.autobuze)
                   System.out.print(a + " ");
            }
        }
        System.out.println();
    }

    public void prinCeStatiiX(int x)
    {
        for(Station s:l)
        {
            if(s.contineAutobuz(x))
                s.display();
        }
    }

    public Station getStationById(int id)
    {
        for(Station s:l)
        {
            if(s.getNr() ==id)
                return s;
        }
        return null;
    }
    public void autobuzeComune(int x, int y)
    {
        Station s1 = getStationById(x);
        Station s2 = getStationById(y);

        for(int a:s1.autobuze)
            for(int b:s2.autobuze)
            {
                if (a == b)
                    System.out.print(a + " ");
            }
        System.out.println();
    }






}
