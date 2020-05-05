

public class TicketStation{
    private int numarStatie;
    private boolean exista;

    public TicketStation() {
        numarStatie = 0;
        exista = false;
    }

    public TicketStation(int numar){
        numarStatie = numar;
        exista = true;
    }

    public boolean getExista(){
        return this.exista;
    }
}
