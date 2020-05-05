

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoPoint {
    private List<Station> l = new ArrayList();

    public InfoPoint() {
    }

    public int nrStatii() {
        return this.l.size();
    }

    public void adaugaStatie(Station s) {
        this.l.add(s);
    }

    public void adaugaStatii(List<Station> li) {
        Iterator var2 = li.iterator();

        while(var2.hasNext()) {
            Station e = (Station)var2.next();
            this.l.add(e);
        }

    }

    public boolean adaugaAutobuz(int no, int no2) {
        Iterator var4 = this.l.iterator();

        Station s;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            s = (Station)var4.next();
        } while(s.getNr() != no2);

        s.adaugaAutobuz(no);
        return true;
    }

    public void afiseazaStatii() {
        Iterator var1 = this.l.iterator();

        while(var1.hasNext()) {
            Station s = (Station)var1.next();
            s.display();
        }

    }

    public void stergeStatieDupaNumar(int nr) {
        int i;
        for(i = 0; i < this.l.size() && ((Station)this.l.get(i)).getNr() != nr; ++i) {
        }

        this.l.remove(i);
    }

    public void stergeAutobuz(int no) {
        boolean index = false;
        Iterator var3 = this.l.iterator();

        while(true) {
            Station s;
            do {
                if (!var3.hasNext()) {
                    return;
                }

                s = (Station)var3.next();
            } while(!s.autobuze.contains(no));

            int i;
            for(i = 0; i < s.autobuze.size() && (Integer)s.autobuze.get(i) != no; ++i) {
            }

            s.autobuze.remove(i);
        }
    }

    public void cuCeAjung(int nr) {
        Iterator var2 = this.l.iterator();

        while(true) {
            Station s;
            do {
                if (!var2.hasNext()) {
                    System.out.println();
                    return;
                }

                s = (Station)var2.next();
            } while(s.getNr() != nr);

            Iterator var4 = s.autobuze.iterator();

            while(var4.hasNext()) {
                int a = (Integer)var4.next();
                System.out.print(a + " ");
            }
        }
    }

    public void prinCeStatiiX(int x) {
        Iterator var2 = this.l.iterator();

        while(var2.hasNext()) {
            Station s = (Station)var2.next();
            if (s.contineAutobuz(x)) {
                s.display();
            }
        }

    }

    public Station getStationById(int id) {
        Iterator var2 = this.l.iterator();

        Station s;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            s = (Station)var2.next();
        } while(s.getNr() != id);

        return s;
    }

    public void autobuzeComune(int x, int y) {
        Station s1 = this.getStationById(x);
        Station s2 = this.getStationById(y);
        Iterator var5 = s1.autobuze.iterator();

        while(var5.hasNext()) {
            int a = (Integer)var5.next();
            Iterator var7 = s2.autobuze.iterator();

            while(var7.hasNext()) {
                int b = (Integer)var7.next();
                if (a == b) {
                    System.out.print(a + " ");
                }
            }
        }

        System.out.println();
    }
}
