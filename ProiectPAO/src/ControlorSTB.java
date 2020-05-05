

public class ControlorSTB {
    private int numarDeAmenzi;
    private int statie;

    public ControlorSTB() {
        this.numarDeAmenzi = 0;
        this.statie = -1;
    }

    public ControlorSTB(int statie, int numarDeAmenzi) {
        this.numarDeAmenzi = numarDeAmenzi;
        this.statie = statie;
    }

    public int getNumarDeAmenzi() {
        return this.numarDeAmenzi;
    }

    public void setNumarDeAmenzi(int numarDeAmenzi) {
        this.numarDeAmenzi = numarDeAmenzi;
    }

    public int getAutobuz() {
        return this.statie;
    }

    public void setAutobuz(int statie) {
        this.statie = statie;
    }

    public String toString() {
        return this.statie + "," + this.numarDeAmenzi;
    }
}
