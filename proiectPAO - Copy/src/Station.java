import java.util.ArrayList;

public abstract class Station {

    static int numar_statii;
    protected String strada;
    protected int nr,sector;
    protected int indice_vec;
    public ArrayList<Integer> autobuze;

    public Station(){
        numar_statii += 1;
        strada = null;
        nr = numar_statii;
        sector = 0;
        indice_vec = 0;
        autobuze = new ArrayList<>();
    }

    public Station(String s,int se) {
        numar_statii += 1;
        strada = s;
        nr = numar_statii;
        sector = se;
        indice_vec = 0;
        autobuze = new ArrayList<>();
    }


    public void adauga_autobuz(int cod){

        autobuze.add(cod);
    }

    public boolean contine_autobuz(int cod)
    {
        boolean contains = autobuze.contains(cod);
        return contains;
    }

    public void display()
    {
        System.out.print("strada: " + strada +  " sector: "  + sector + " nr: " + nr + "\n");
        System.out.print("autobuze: ");
        for(int i:autobuze)
            System.out.print(i + " ");
        System.out.println();


    }

    public int get_nr(){return nr;}
    abstract boolean type();


}
