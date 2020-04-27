import java.util.ArrayList;

public abstract class Station {

    static int numarStatii;
    protected String strada;
    protected int nr,sector;
    protected int indiceVec;
    public ArrayList<Integer> autobuze;

    public Station(){
        numarStatii += 1;
        strada = null;
        nr = numarStatii;
        sector = 0;
        indiceVec = 0;
        autobuze = new ArrayList<>();
    }

    public Station(String s,int se) {
        numarStatii += 1;
        strada = s;
        nr = numarStatii;
        sector = se;
        indiceVec = 0;
        autobuze = new ArrayList<>();
    }


    public void adaugaAutobuz(int cod){

        autobuze.add(cod);
    }

    public boolean contineAutobuz(int cod)
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

    public int getNr(){return nr;}
    abstract boolean type();


}
