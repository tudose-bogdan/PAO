
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Station {
    static int numarStatii;
    protected String strada;
    protected int nr;
    protected int sector;
    protected int indiceVec;
    public ArrayList<Integer> autobuze;
    public ArrayList<ControlorSTB> controlori;
    private TicketStation ts;

    public Station() {
        ++numarStatii;
        this.strada = null;
        this.nr = numarStatii;
        this.sector = 0;
        this.indiceVec = 0;
        this.autobuze = new ArrayList();
        this.controlori = new ArrayList();
        this.ts = new TicketStation();

    }

    public Station(String s, int se) {
        ++numarStatii;
        this.strada = s;
        this.nr = numarStatii;
        this.sector = se;
        this.indiceVec = 0;
        this.autobuze = new ArrayList();
        this.controlori = new ArrayList();
        this.ts = new TicketStation();

    }

    public void adaugaAutobuz(int cod) {
        this.autobuze.add(cod);
    }

    public boolean contineAutobuz(int cod) {
        boolean contains = this.autobuze.contains(cod);
        return contains;
    }

    public void display() {
        System.out.print("strada: " + this.strada + " sector: " + this.sector + " nr: " + this.nr + "\n");
        System.out.print("autobuze: ");
        Iterator var1 = this.autobuze.iterator();

        while(var1.hasNext()) {
            int i = (Integer)var1.next();
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Numar controlori: " + this.controlori.size());
        System.out.println("Casa de tichete: " + esteCasaDeTichete());
        System.out.println();
    }

    public static void increment() {
        ++numarStatii;
    }

    public void adaugaControlor(ControlorSTB controlor) {
        this.controlori.add(controlor);
    }

    public void activeazaTichete(){
        this.ts = new TicketStation(this.nr);

    }

    public boolean esteCasaDeTichete(){

        return ts.getExista();

    }



    public int getNr() {
        return this.nr;
    }
    public String getStrada(){return this.strada;}

    abstract boolean type();
}
